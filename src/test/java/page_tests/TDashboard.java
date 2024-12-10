package page_tests;

import org.openqa.selenium.WebElement;
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

	@Test
	public void BreadcrumbBarContainsCorrectText() {
		WebElement breadcrumbBar = dashboardPage.getBreadcrumbBar();
		Assert.assertTrue(breadcrumbBar.getText().contains("Dashboard"));
	}
}
