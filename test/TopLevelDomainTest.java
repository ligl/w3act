import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import models.FieldUrl;
import models.Target;

import org.junit.Before;
import org.junit.Test;

import uk.bl.exception.WhoisException;
import uk.bl.scope.Scope;

public class TopLevelDomainTest {

	public static final String UK_DOMAIN       = ".uk";
	public static final String LONDON_DOMAIN   = ".london";
	public static final String SCOT_DOMAIN     = ".scot";
	
	Target target = null;
	List<FieldUrl> fieldUrls;
	
	@Before
	public void setUp() throws Exception {
		target = new Target();
		fieldUrls = new ArrayList<FieldUrl>();
		fieldUrls.add(new FieldUrl("http://www.gov.uk"));
		fieldUrls.add(new FieldUrl("http://www.google.scot"));
		target.fieldUrls = fieldUrls;
	}

	@Test
	public void test() throws MalformedURLException, WhoisException, URISyntaxException {
		Boolean pass = Scope.INSTANCE.isTopLevelDomain(target);
		System.out.println("fieldUrls with valid top level domains: " + target.fieldUrls + " - " + pass);
		assertTrue(pass);
		FieldUrl newFieldUrl = new FieldUrl("http://www.gov.com");
		target.fieldUrls.add(newFieldUrl);
		Boolean fail = Scope.INSTANCE.isTopLevelDomain(target);
		System.out.println("fieldUrls with invalid top level domains (.com): " + target.fieldUrls + " - " + fail);
		assertFalse(fail);
	}
}