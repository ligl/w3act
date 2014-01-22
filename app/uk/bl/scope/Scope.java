package uk.bl.scope;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;

import models.Target;
import play.Logger;
import uk.bl.Const;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.model.CityResponse;

import uk.bl.wa.whois.JRubyWhois;
import uk.bl.wa.whois.WhoisResult;

/**
 * This class implements scope rule engine.
 * A Target is in scope if any of the following statements is true:
 *
 *   Legal Deposit
 *   =============
 *   1. Manual rules settings in Target edit page
 *      1.1. The Target is known to be hosted in the UK (manual boolean field).
 *      1.2. The Target features an page that specified a UK postal address 
 *      	 (a manual boolean field plus a text field to hold a specific URL that contains the address).
 *      1.3. The Target is known to be a UK publication, according to correspondence with a curator 
 *      	 (a manual boolean field plus a text field to hold details of the correspondence).
 *      1.4. The Target is known to be a UK publication, in the professional judgement of a curator 
 *      	 (a manual boolean field plus a text field to hold the justification).
 *      1.5. If no LD criteria met - checking result for scope is negativeTarget
 *      	 (a manual boolean field).
 *      
 *   2. By permission
 *      The Target is one for which we have a license that gives us permission to crawl the site 
 *      (and make it available), even if the Target does not fall under any Legal Deposit criteria.
 *
 *   3. All URLs for this Target meet at least one of the following automated criteria:
 *      3.1 The authority of the URI (i.e. the hostname) end with '.uk'.
 *      3.2 The IP address associated with the URI is geo-located in the UK 
 *          (using this GeoIP2 database, in a manner similar to our H3 GeoIP module).
 *          
 */
public class Scope {

	public static final String UK_DOMAIN       = ".uk";
	public static final String GEO_IP_SERVICE  = "GeoLite2-City.mmdb";
	public static final String UK_COUNTRY_CODE = "GB";
	public static final String HTTP            = "http://";
	public static final String HTTPS           = "https://";
	public static final String WWW             = "www.";
	public static final String END_STR         = "/";

	/**
	 * This method queries geo IP from database
	 * @param ip - The host IP
	 * @return true if in UK domain
	 */
	public static boolean queryDb(String ip) {
		boolean res = false;
		// A File object pointing to your GeoIP2 or GeoLite2 database
		File database = new File(GEO_IP_SERVICE);
	
		try {
			// This creates the DatabaseReader object, which should be reused across
			// lookups.
			DatabaseReader reader = new DatabaseReader.Builder(database).build();
		
			// Find city by given IP
			CityResponse response = reader.city(InetAddress.getByName(ip));
			Logger.info(response.getCountry().getIsoCode()); 
			Logger.info(response.getCountry().getName()); 
			// Check country code in city response
			if (response.getCountry().getIsoCode().equals(UK_COUNTRY_CODE)) {
				res = true;
			}
		} catch (Exception e) {
			Logger.warn("GeoIP error. " + e);
		}
		return res;
	}
	
	/**
	 * This method normalizes passed URL that it is appropriate for IP calculation.
	 * @param url The passed URL
	 * @return normalized URL
	 */
	public static String normalizeUrl(String url) {
		String res = url;
		if (res != null && res.length() > 0) {
	        if (!res.contains(WWW)) {
	        	res = WWW + res;
	        }
	        if (!res.contains(HTTP)) {
		        if (!res.contains(HTTPS)) {
		        	res = HTTP + res;
		        }
	        }
	        if (!res.endsWith(END_STR)) {
	        	res = res + END_STR;
	        }
		}
        Logger.info("normalized URL: " + res);
		return res;
	}

	/**
	 * This method comprises rule engine for checking if a given URL is in scope.
	 * @return true if in scope
	 */
	public static boolean check(String url, String nidUrl) {
        boolean res = false;
        Logger.info("check url: " + url + ", nid: " + nidUrl);
        url = normalizeUrl(url);
        /**
         *  Rule 1: check manual scope settings because they have more severity. If one of the fields:
         *
         *  Rule 1.1: "field_uk_domain"
         *  Rule 1.2: "field_uk_postal_address"
         *  Rule 1.3: "field_via_correspondence"
         *  Rule 1.4: "field_professional_judgement"
         *  
         *  is true - checking result is positive.
         *  
         *  Rule 1.5: if the field "field_no_ld_criteria_met" is true - checking result is negative
         * 
         */
        // read Target fields with manual entries and match to the given NID URL (Rules 1.1 - 1.5)
        if (nidUrl != null && nidUrl.length() > 0) {
        	try {
	        	JRubyWhois whoIs = new JRubyWhois();
	        	WhoisResult whoIsRes = whoIs.lookup(getDomainFromUrl(url));
//	        	WhoisResult whoIsRes = whoIs.lookup(getDomainFromUrl("marksandspencer.com"));
	        	res = whoIsRes.isUKRegistrant();
        	} catch (Exception e) {
        		Logger.info("whois lookup message: " + e.getMessage());
        	}
        	Logger.info("whois res: " + res);        	
        	if (!res) {
        		res = Target.checkManualScope(nidUrl);
        	}
        }

    	// Rule 2: by permission
        if (!res && nidUrl != null && nidUrl.length() > 0) {
        	res = Target.checkLicense(nidUrl);
        }

        // Rule 3.1: check domain name
        if (!res && url != null && url.length() > 0) {
	        if (url.contains(UK_DOMAIN)) {
	        	res = true;
	        }
        }
        
        // Rule 3.2: check geo IP
        if (!res) {
        	res = checkGeoIp(url);
        }
        return res;
	}
	
	/**
	 * This method extracts host from the given URL and checks geo IP using database.
	 * @param url
	 * @return true if in UK domain
	 */
	public static boolean checkGeoIp(String url) {
		boolean res = false;
		String ip = getIpFromUrl(url);
		res = queryDb(ip);
		return res;
	}
	
	/**
	 * This method converts URL to IP address.
	 * @param url
	 * @return IP address as a string
	 */
	public static String getIpFromUrl(String url) {
		String ip = "";
		InetAddress address;
		try {
			address = InetAddress.getByName(new URL(url).getHost());
			ip = address.getHostAddress();
		} catch (UnknownHostException e) {
			Logger.info("ip calculation unknown host error for url=" + url + ". " + e.getMessage());
		} catch (MalformedURLException e) {
			Logger.info("ip calculation error for url=" + url + ". " + e.getMessage());
		}
        return ip;
	}
	
	/**
	 * This method extracts domain name from the given URL.
	 * @param url
	 * @return
	 */
	public static String getDomainFromUrl(String url) {
		String domain = "";
		try {
//			Logger.info("get host: " + new URL(url).getHost());
			domain = new URL(url).getHost().replace(WWW, "");
			Logger.info("whois lookup for domain: " + domain);
		} catch (Exception e) {
			Logger.info("domain calculation error for url=" + url + ". " + e.getMessage());
			domain = url;
		}
        return domain;
	}
	
}

