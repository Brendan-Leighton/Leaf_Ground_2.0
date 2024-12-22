package page_tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.log4testng.Logger;

import lib.Drivers;
import page_object_models.BasePage;
import page_object_models.PDashboard;

@Listeners({ lib.TestNgListener.class })
public class BaseTest {
	protected Logger logger = Logger.getLogger(BaseTest.class);

	protected BasePage basePage;
	protected PDashboard dashboardPage;

	private final String url = "https://www.leafground.com/";

	@BeforeTest
	public void setUp() {

		// Logger messages
		// logger.trace("trace message"); // Not printed to console
		// logger.debug("debug message"); // Not printed to console
		// logger.info("info message");
		// logger.warn("warn message");
		// logger.error("error message");
		// logger.fatal("fatal message");

		Drivers.getDriver().get(url);

		basePage = new BasePage(Drivers.getDriver());
		dashboardPage = new PDashboard(Drivers.getDriver());
	}

	@AfterClass
	public void tearDown() {
		// Drivers.getDriver().quit();
	}
}
