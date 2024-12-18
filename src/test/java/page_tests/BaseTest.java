package page_tests;

import java.util.List;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;

import page_object_models.BasePage;
import page_object_models.PDashboard;

public class BaseTest {

	protected WebDriver driver;
	protected BasePage basePage;
	protected PDashboard dashboardPage;

	private final String url = "https://www.leafground.com/";
	private final int window_width = (int) (1920 * 0.75);
	private final int window_height = (int) (1080 * 0.75);

	@BeforeTest
	public void setUp() {

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
