package page_object_models;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PDashboard extends BasePage {

	private final String url_1 = "https://www.leafground.com/";
	private final String url_2 = "https://www.leafground.com/dashboard.xhtml";
	private ArrayList<String> urls;

	public PDashboard(WebDriver driver) {
		super(driver);

		urls.add(url_1);
		urls.add(url_2);
	}

	// Locators

	/**
	 * Breadcrumb Bar
	 */
	private final By breadcrumb_bar = By.cssSelector(".route-bar-breadcrumb");

	public ArrayList<String> getPageUrls() {
		return urls;
	}

	public WebElement getBreadcrumbBar() {
		return find(breadcrumb_bar);
	}

}
