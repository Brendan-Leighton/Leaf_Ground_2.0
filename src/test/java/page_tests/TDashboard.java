package page_tests;

import java.time.Duration;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TDashboard extends BaseTest {

	/**
	 * Priority of -1 to run before all other tests
	 * 
	 * Make sure page loads. This page has multiple possible urls.
	 */
	@Test(priority = -1)
	public void PageLoads() {
		boolean isUrlCorrect = false;
		String currentUrl = driver.getCurrentUrl();

		for (String url : dashboardPage.getPageUrls()) {
			if (currentUrl.equals(url)) {
				isUrlCorrect = true;
				break;
			}
		}

		Assert.assertTrue(isUrlCorrect);
	}

	/**
	 * Priority of 0 for a component container
	 * 
	 * The top-bar is located where the navbar typically is located.
	 * As this is a dashboard, the main navbar is on the left side instead of the
	 * top.
	 */
	@Test(priority = 0)
	public void TopBarIsVisible() {
		WebElement topBar = dashboardPage.getTopBar();
		boolean isVisible = false;

		try {
			new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(topBar));
			isVisible = true;
		} catch (TimeoutException ignore) {
		}

		Assert.assertTrue(isVisible);
	}

	@Test
	public void BreadcrumbBarContainsCorrectText() {
		WebElement breadcrumbBar = dashboardPage.getBreadcrumbBar();
		Assert.assertTrue(breadcrumbBar.getText().contains("Dashboard"));
	}
}
