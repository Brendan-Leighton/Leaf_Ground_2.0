package page_object_models;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PDashboard extends BasePage {

	// private List<String> urls = new ArrayList<String>();
	private String[] urls = {
			"https://www.leafground.com/",
			"https://www.leafground.com/dashboard.xhtml"
	};

	public PDashboard(WebDriver driver) {
		super(driver);
	}

	/**
	 * Returns a list of urls where this page can be found at.
	 * This page has 2 possible urls.
	 * 
	 * @return String representation of urls
	 */
	public String[] getPageUrls() {
		return urls;
	}

	/** By locator for the top-bar component */
	private final By top_bar = By.cssSelector(".layout-topbar");

	/**
	 * Get the top-bar component
	 * 
	 * @return the top-bar's WebElement
	 */
	public WebElement getTopBar() {
		return find(top_bar);
	}

	/** By locator for the breadcrumb-bar component */
	private final By breadcrumb_bar = By.cssSelector(".route-bar-breadcrumb");

	/**
	 * Get the Breadcrumb Bar component
	 * 
	 * @return the WebElement containing breadcrumbs with icons and text
	 */
	public WebElement getBreadcrumbBar() {
		return find(breadcrumb_bar);
	}

}
