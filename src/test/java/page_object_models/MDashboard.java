package page_object_models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MDashboard extends BasePage {

	public MDashboard(WebDriver driver) {
		super(driver);
	}

	private final By breadcrumb_bar = By.cssSelector(".route-bar-breadcrumb");

	public WebElement getBreadcrumbBar() {
		return find(breadcrumb_bar);
	}

}
