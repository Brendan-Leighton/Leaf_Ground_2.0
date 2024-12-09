package page_tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TDashboard extends BaseTest {

	@Test
	public void BreadcrumbBarContainsCorrectText() {
		WebElement breadcrumbBar = dashboardPage.getBreadcrumbBar();
		Assert.assertTrue(breadcrumbBar.getText().contains("Dashboard"));
	}
}
