package page_object_models;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PDashboard extends BasePage {

	private final String url_1 = "https://www.leafground.com/";
	private final String url_2 = "https://www.leafground.com/dashboard.xhtml";
	private List<String> urls = new ArrayList<String>();

	public PDashboard(WebDriver driver) {
		super(driver);

		urls.add(url_1);
		urls.add(url_2);
	}

	/**
	 * Returns a list of urls as Strings
	 * 
	 * @return urls as String
	 */
	public List<String> getPageUrls() {
		return urls;
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
