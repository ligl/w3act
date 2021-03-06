package controllers;

import java.util.List;
import java.util.Set;

import jsmessages.JsMessages;
import org.apache.commons.lang3.StringUtils;

import models.CommunicationLog;
import models.ContactPerson;
import models.CrawlPermission;
import models.FieldUrl;
import models.License;
import models.MailTemplate;
import models.Target;
import models.Taxonomy;
import models.User;
import play.Logger;
import play.data.DynamicForm;
import play.data.Form;
import play.libs.Json;
import play.libs.Scala;
import play.mvc.BodyParser;
import play.mvc.Result;
import play.mvc.Security;
import uk.bl.Const;
import uk.bl.api.FormHelper;
import uk.bl.api.Utils;
import uk.bl.exception.ActException;
import uk.bl.scope.EmailHelper;
import views.html.licence.licences;
import views.html.licence.ukwalicence;
import views.html.licence.ukwalicenceresult;
import com.avaje.ebean.Ebean;
import com.avaje.ebean.ExpressionList;
import com.fasterxml.jackson.databind.JsonNode;

/**
 * Support for adding owner licence.
 */
public class LicenseController extends AbstractController {

    /**
     * Display the licence form.
     */
	@Security.Authenticated(SecuredController.class)
    public static Result index() {
		return view(License.findAllLicenses().get(0).id);
    }
    
	@Security.Authenticated(SecuredController.class)
    public static Result view(Long id) {
    	License license = License.findById(id);
		Logger.info("License: "+license);
    	if (license != null) {
    		if (request().accepts("text/html")) {
    			User user = User.findByEmail(request().username());
    			CrawlPermission cp = new CrawlPermission();
    			cp.contactPerson = new ContactPerson();
    			cp.setLicense(license);
    			cp.target = new Target();
    			return ok(ukwalicence.render(cp, false));
    		} else {
    			return ok(Json.toJson(license));
    		}
    	} else {
    		return notFound("There is no License with ID "+id);
    	}
    }

    /**
     * Returns JavaScript containing i18n messages for the license view
     * @return Response
     */
    public static Result messagesJs(){
        // See https://github.com/julienrf/play-jsmessages
        JsMessages jsMessages = JsMessages.filtering (play.Play.application(), new play.libs.F.Function<String, Boolean>(){
            @Override
            public Boolean apply(String key) {
                return key.startsWith("license.") || key.startsWith("form.");
            }
        });

        return ok(jsMessages.generateAll(Scala.Option("window.Messages").get())).as("application/javascript");
    }

    /**
     * This method presents licence form for selected premission request
     * that is identified by the given permission URL. 
     * @param permissionUrl
     * @return
     * @throws ActException 
     */
    public static Result form(String token) throws ActException {
    	CrawlPermission crawlPermission = CrawlPermission.showByToken(token);
    	
    	if (crawlPermission == null) {
    		throw new ActException("CrawlPermission Not Found found for token: " + token);
    	}

    	// Only allow unset permissions to be edited:
    	boolean enabled = true;
    	if( crawlPermission.isCompleted() )
    		enabled = false;

		return ok(
            ukwalicence.render(crawlPermission, enabled)
        );
    }
    
    /**
     * This method presents licence form view for selected premission request
     * that is identified by the given permission URL. All fields are disabled. 
     * @param permissionUrl
     * @return
     * @throws ActException 
     */
	@Security.Authenticated(SecuredController.class)
    public static Result formview(String token) throws ActException {
    	CrawlPermission crawlPermission = CrawlPermission.showByToken(token);
    	if (crawlPermission == null) {
    		throw new ActException("CrawlPermission Not Found found for token: " + token);
    	}
    	
		return ok(
			ukwalicence.render(crawlPermission, false)
        );
    }
    
	@Security.Authenticated(SecuredController.class)
    public static String getCurrentDate() {
    	return Utils.INSTANCE.getCurrentDate();
    }
    
    /**
     * Send acknowledgment to the site owner
     * @param ownerEmail
     * @param permission The crawl permission that comprises outputs the data entered into the licence form
     */
	@Security.Authenticated(SecuredController.class)
    public static void sendAcknowledgementToSiteOwner(String ownerEmail, CrawlPermission permission) {
		MailTemplate mailTemplate = permission.acknowledgementMailTemplate != null ? permission.acknowledgementMailTemplate :
				MailTemplate.findByName(Const.ACKNOWLEDGEMENT);

		if( mailTemplate == null ) {
    		Logger.error("NO Acknowledgement template found!");
    		return;
    	}
    	Logger.debug("sendAcknowledgementToSiteOwner mailTemplate: " + mailTemplate);
    	String messageSubject = mailTemplate.subject;
//    	Logger.debug("sendAcknowledgementToSiteOwner text: " + mailTemplate.text);
    	String messageBody = mailTemplate.readTemplate();
//    	String messageBody = mailTemplate.text;
//		StringBuilder sb = new StringBuilder();
//		sb.append(Const.CSV_LINE_END);
//		sb.append(Const.LICENCE_ACK + Const.TWO_POINTS + permission.license + Const.CSV_LINE_END);
//		sb.append(Const.CSV_LINE_END);
//		sb.append(Const.WEBSITE_TITLE_ACK + Const.TWO_POINTS + permission.name + Const.CSV_LINE_END);
//		sb.append(Const.CSV_LINE_END);
//		sb.append(Const.WEB_ADDRESS_ACK + Const.TWO_POINTS + permission.target.title + Const.CSV_LINE_END);
//		sb.append(Const.CSV_LINE_END);
//		sb.append(Const.NAME_ACK + Const.TWO_POINTS + permission.contactPerson.name + Const.CSV_LINE_END);
//		sb.append(Const.CSV_LINE_END);
//		sb.append(Const.POSITION_ACK + Const.TWO_POINTS + permission.contactPerson.position + Const.CSV_LINE_END);
//		sb.append(Const.CSV_LINE_END);
//		sb.append(Const.EMAIL_ACK + Const.TWO_POINTS + permission.contactPerson.email + Const.CSV_LINE_END);
//		sb.append(Const.CSV_LINE_END);
//		sb.append(Const.CONTACT_ORGANISATION_ACK + Const.TWO_POINTS + permission.contactPerson.contactOrganisation + Const.CSV_LINE_END);
//		sb.append(Const.CSV_LINE_END);
//		sb.append(Const.TEL_ACK + Const.TWO_POINTS + permission.contactPerson.phone + Const.CSV_LINE_END);
//		sb.append(Const.CSV_LINE_END);
//		sb.append(Const.POSTAL_ADDRESS_ACK + Const.TWO_POINTS + permission.contactPerson.postalAddress + Const.CSV_LINE_END);
//		sb.append(Const.CSV_LINE_END);
//		sb.append(Const.DESCRIPTION_ACK + Const.TWO_POINTS + permission.anyOtherInformation + Const.CSV_LINE_END);
//		sb.append(Const.CSV_LINE_END);
//		sb.append(Const.THIRD_PARTY_ACK + Const.TWO_POINTS + Utils.INSTANCE.showBooleanAsString(permission.thirdPartyContent) + Const.CSV_LINE_END);
//		sb.append(Const.CSV_LINE_END);
//		sb.append(Const.AGREE_ACK + Const.TWO_POINTS + Utils.INSTANCE.showBooleanAsString(permission.agree) + Const.CSV_LINE_END);
//		sb.append(Const.CSV_LINE_END);
//		sb.append(Const.DATE_ACK + Const.TWO_POINTS + permission.createdAt + Const.CSV_LINE_END);
//		sb.append(Const.CSV_LINE_END);
//		sb.append(Const.PUBLICITY_ACK + Const.TWO_POINTS + Utils.INSTANCE.showBooleanAsString(permission.publish) + Const.CSV_LINE_END);
//		sb.append(Const.CSV_LINE_END);
		
//		String targetUrl = routes.TargetController.view(permission.target.id).absoluteURL(request()).toString();

		String targetUrls = permission.target.fieldUrl();
		
    	messageBody = CrawlPermission.
            	replaceStringInText(
            			messageBody
						, Const.PLACE_HOLDER_DELIMITER + mailTemplate.placeHolders + Const.PLACE_HOLDER_DELIMITER
						, targetUrls);
    	Logger.debug("sendAcknowledgementToSiteOwner messageBody: " + messageBody);
    	
        EmailHelper.sendMessage(ownerEmail, messageSubject, messageBody);                	
    }
    
    /**
     * This method submits owner settings for UKWA licence.
     * @return
     * @throws ActException 
     */
    public static Result submit() throws ActException {
    	Result res = null;
        Logger.debug("Licence controller submit()");
        
        DynamicForm requestData = Form.form().bindFromRequest();
    	
    	String action = requestData.get("action");
    	
    	try {
	    	if (StringUtils.isNotEmpty(action)) {
	        
		        if (action.equals("submit")) {
		        	String token = requestData.get("token");
		        	CrawlPermission permission = CrawlPermission.findByToken(token);
		        	
		        	// Reject this action if permissions already submitted:
		        	if( permission.isCompleted() ) {
		    			flash("message", "This form has already been completed!");
		    			
		    			return ok(
		    		            ukwalicence.render(permission, false)
		    		        );
		        	}
		        	
		        	// Update the CrawlPermission
		        	Logger.debug("save UKWA licence - name: " + getFormParam(Const.NAME));
		    		Logger.debug("agree: " + getFormParam(Const.AGREE));
		            boolean isAgreed = Utils.INSTANCE.getNormalizeBooleanString(getFormParam(Const.AGREE));
		            
		            boolean noThirdPartyContent = false;
		            if (getFormParam(Const.CONTENT) != null) {
		        		Logger.debug("content: " + getFormParam(Const.CONTENT));
		            	Long noThirdPartyContentValue = Long.valueOf(getFormParam(Const.CONTENT));
		                if (noThirdPartyContentValue == 1L) {
		                	noThirdPartyContent = true;
		            	}
		            } 
		            boolean mayPublish = false;
		            if (getFormParam(Const.PUBLISH) != null) {
		        		Logger.debug("mayPublish: " + getFormParam(Const.PUBLISH));
		            	Long mayPublishValue = Long.valueOf(getFormParam(Const.PUBLISH));
		                if (mayPublishValue == 1L) {
		                	mayPublish = true;
		            	}
		            } 
		            
		        	Logger.debug("flags isAgreed: " + isAgreed + ", noThirdPartyContent: " + noThirdPartyContent + ", mayPublish: " + mayPublish);
		        	
		        	// we already have target
		        	
	            	Logger.debug("found crawl permission: " + permission);
	                if (getFormParam(Const.NAME) != null) {
	                    permission.name = getFormParam(Const.NAME);
	                }
	                if (getFormParam(Const.CONTACT_PERSON) != null) {
	                    permission.contactPerson.name = getFormParam(Const.CONTACT_PERSON);
	                }
	                if (getFormParam(Const.DESCRIPTION) != null) {
	                    permission.anyOtherInformation = getFormParam(Const.DESCRIPTION);
	                }
	                
                    String email = getFormParam(Const.EMAIL);
                	String ownerName = getFormParam(Const.CONTACT_PERSON);
                    
                    if (StringUtils.isNotBlank(email)) {

	                    ContactPerson contactPerson = ContactPerson.findByEmail(email);

	                	if (contactPerson != null) {
	                    	Logger.debug("found contact person: " + contactPerson);
	    	                if (StringUtils.isNotBlank(ownerName)) {
	    	                	contactPerson.name = ownerName;
	    	                }	                    
	                        if (getFormParam(Const.POSITION) != null) {
	                            contactPerson.position = getFormParam(Const.POSITION);
	                        }
	                        if (getFormParam(Const.POSTAL_ADDRESS) != null) {
	                            contactPerson.postalAddress = getFormParam(Const.POSTAL_ADDRESS);
	                        }
	                        if (getFormParam(Const.CONTACT_ORGANISATION) != null) {
	                            contactPerson.contactOrganisation = getFormParam(Const.CONTACT_ORGANISATION);
	                        }
	                        if (getFormParam(Const.PHONE) != null) {
	                            contactPerson.phone = getFormParam(Const.PHONE);
	                        }
	                    	// update existing contact person
	                        contactPerson.update();
	            	        Logger.debug("update contact person: " + contactPerson.toString());
	                	} else {
	                    	// create new contact person
	                		contactPerson = new ContactPerson();
	                		
	                		contactPerson.name = ownerName;
	                        if (getFormParam(Const.POSITION) != null) {
	                        	contactPerson.position = getFormParam(Const.POSITION);
	                        }
	                        if (getFormParam(Const.EMAIL) != null) {
	                        	contactPerson.email = getFormParam(Const.EMAIL);
	                        }
	                        if (getFormParam(Const.POSTAL_ADDRESS) != null) {
	                        	contactPerson.postalAddress = getFormParam(Const.POSTAL_ADDRESS);
	                        }
	                        if (getFormParam(Const.CONTACT_ORGANISATION) != null) {
	                        	contactPerson.contactOrganisation = getFormParam(Const.CONTACT_ORGANISATION);
	                        }
	                        if (getFormParam(Const.PHONE) != null) {
	                        	contactPerson.phone = getFormParam(Const.PHONE);
	                        }
	                        contactPerson.save();
	            	        Logger.debug("save contact person: " + contactPerson.toString());
	                    }
	                    permission.contactPerson = contactPerson;
	                }
	                if (isAgreed) {
	//                        if (isAgreed && noThirdPartyContent && mayPublish) {
	                	permission.status = Const.CrawlPermissionStatus.GRANTED.name();
	                	permission.grantedAt=Utils.INSTANCE.getCurrentTimeStamp();
	                	 Logger.debug("granted date: " + permission.grantedAt);
	                } else {
	                	permission.status = Const.CrawlPermissionStatus.REFUSED.name();
	                }
	                permission.agree = isAgreed;
	                permission.thirdPartyContent = noThirdPartyContent;
	                permission.publish = mayPublish;
	                
	                // Perform any validation before saving:
		        	if (StringUtils.isBlank(getFormParam(Const.TARGET)) 
		        			|| StringUtils.isBlank(getFormParam(Const.NAME))
		        			|| StringUtils.isBlank(getFormParam(Const.POSITION))
		        			|| StringUtils.isBlank(getFormParam(Const.CONTACT_PERSON))
		        			|| StringUtils.isBlank(getFormParam(Const.EMAIL))) {
		    			Logger.debug("One of the required fields is empty. Please fill out all required fields marked by red star in the form.");
		    			flash("message", "Please fill out all required fields marked by red star in the form");
		    			
		    			return ok(
		    		            ukwalicence.render(permission, true)
		    		        );
		        	}  
		    		if (!isAgreed || StringUtils.isBlank(getFormParam(Const.CONTENT)) 
		        			|| StringUtils.isBlank(getFormParam(Const.PUBLISH))) {
		    			Logger.debug("The form cannot be submitted without checking the 'I/We agree' box, or without answering the questions about 'Third-Party Content' and 'Publicity for the Web Archive'. Please check your input and try again.");
		    			flash("message", "The form cannot be submitted without checking the 'I/We agree' box, or without answering the questions about 'Third-Party Content' and 'Publicity for the Web Archive'. Please check your input and try again.");
		    			return ok(
		    		            ukwalicence.render(permission, true)
		    		        );
		    		}


	                // All good, sending email and recording result:	                
	    	        CommunicationLog log = CommunicationLog.logHistory(Const.PERMISSION + " " + permission.status, permission, permission.user, Const.UPDATE);
	    	        log.save();
	    	        CrawlPermissionController.updateAllByTarget(permission.id, permission.target.id, permission.status);
	    	    	Logger.debug("before sendAcknowledgementToSiteOwner mailTemplate: " + getFormParam(Const.EMAIL));
	    	        if (getFormParam(Const.EMAIL) != null) {
	    	        	sendAcknowledgementToSiteOwner(getFormParam(Const.EMAIL), permission);
	    	        }
	    	        
	                if (getFormParam(Const.LICENCE) != null) {
	                	String licenceName = getFormParam(Const.LICENCE);
	                	License license = License.findByName(licenceName);
	                	if( license == null ) {
	                		Logger.error("No suitable license found - inventing one");
	                		license = new License();
	                		license.name = "INVENTED LICENCE";
	                	}
	                	permission.setLicense( license );
	                	Logger.debug("Got license " + license);
	                	
	                	Target target = permission.target;
	                	// Only add this license if it's not already associated:
	                	if( ! target.licenses.contains(license)) {
	                		Logger.debug("Adding " + license);
	                		target.licenses.add(license);
	                	}
	                	target.licenseStatus = permission.status;
	                	Logger.debug("Updating Target "+target.id + " with licenseStatus "+ target.licenseStatus);
	                	target.update();	                    	
	                } else {
	                	Logger.error("No LICENCE found in form!");
	                }
	                Logger.debug("About to update crawl permission: "+permission);
	                permission.update();
	                Ebean.update(permission);
	    	        Logger.debug("updated crawl permission.");
			        res = redirect(routes.LicenseController.result());
		        }
	        } 
        } catch (Exception e) {
        	Logger.error("Update target for licence failed. ");
        	e.printStackTrace();
        	throw new ActException(e);
        }
	    	
        return res;
    }	   
	
    /**
     * Display the result of the licence form submission.
     */
    public static Result result() {
		return ok(
            ukwalicenceresult.render()
        );
    }
    
    /**
     * Display the person.
     */
	@Security.Authenticated(SecuredController.class)
    public static Result indexFilter() {
    	User user = User.findByEmail(request().username());
        List<License> licenses = License.findAllLicenses();
        String searchStr = "";
        Logger.debug("user: " + user);
        Logger.debug("licenses: " + licenses);
        Logger.debug("searchStr: " + searchStr);
        return ok(licences.render("Licences", user, licenses, searchStr));
    }
    
    /**
     * This method enables searching for given URL and redirection in order to add new entry
     * if required.
     * @return
     */
	@Security.Authenticated(SecuredController.class)
    public static Result filter() {
    	Result res = null;
    	Logger.debug("LicenseController.filter()");
        String search = getFormParam(Const.SEARCH);
        String name = getFormParam(Const.NAME);

        List<License> licenses = processFilterLicences(name);

        Logger.debug("search: " + search + ", name: " + name);
        if (search != null) {
            res = ok(
            		licences.render(
                        "Licences", User.findByEmail(request().username()), licenses, name
                    )
                );
        }
        return res;
    }	   
    
    /**
     * This method applyies filters to the list of crawl persons.
     * @param filterUrl
     * @param status
     * @return
     */
	@Security.Authenticated(SecuredController.class)
    public static List<License> processFilterLicences(String filterUrl) {
//    	Logger.debug("process filter filterUrl: " + filterUrl);
    	ExpressionList<License> exp = License.find.where();
    	if (StringUtils.isNotBlank(filterUrl)) {
    		exp = exp.contains("name", filterUrl);    		
    	}
    	List<License> res = exp.query().findList();
        return res;
    }        

	@Security.Authenticated(SecuredController.class)
    @BodyParser.Of(BodyParser.Json.class)
    public static Result filterByJson(String name) {
        JsonNode jsonData = null;
        if (name != null) {
	        List<Taxonomy> licences = Taxonomy.filterByName(name);
	        jsonData = Json.toJson(licences);
        }
        return ok(jsonData);
    }
    
    
}

