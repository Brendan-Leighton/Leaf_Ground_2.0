package page_tests;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;

import page_object_models.BasePage;
import page_object_models.PDashboard;

public class BaseTest {

	protected WebDriver driver;
	protected BasePage basePage;
	protected PDashboard dashboardPage;

	private final String url = "https://www.leafground.com/";
	private final int window_width = 800;
	private final int window_height = 600;

	@BeforeTest
	public void setUp() {
		driver = new ChromeDriver();
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
