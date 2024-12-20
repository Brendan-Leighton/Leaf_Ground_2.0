package page_tests;

import java.util.List;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.log4testng.Logger;

import page_object_models.BasePage;
import page_object_models.PDashboard;

@Listeners({ lib.TestNgListener.class })
public class BaseTest {
	protected Logger logger = Logger.getLogger(BaseTest.class);

	protected WebDriver driver;
	protected BasePage basePage;
	protected PDashboard dashboardPage;

	private final String url = "https://www.leafground.com/";
	private final int window_width = (int) (1920 * 0.75);
	private final int window_height = (int) (1080 * 0.75);

	@BeforeTest
	public void setUp() {

		// Logger messages
		logger.trace("trace message"); // Not printed to console
		logger.debug("debug message"); // Not printed to console
		logger.info("info message");
		logger.warn("warn message");
		logger.error("error message");
		logger.fatal("fatal message");

		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("excludeSwitches", List.of("enable-automation"));
		driver = new ChromeDriver(options);
		driver.manage().window().setSize(new Dimension(window_width, window_height));
		driver.get(url);

		basePage = new BasePage(driver);
		dashboardPage = new PDashboard(driver);
	}

	@AfterClass
	public void tearDown() {
		// driver.quit();
	}
}
