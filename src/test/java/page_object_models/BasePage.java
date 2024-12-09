package page_object_models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * The base Page Object Model.
 *
 * <p>
 * Simply extend and enjoy.
 * </p>
 *
 * <p>
 * <strong>Example:</strong> public class LoginPage extends BasePage {
 * ...enjoyment }
 * </p>
 */
public class BasePage {

	public static WebDriver driver;

	/**
	 * Set the web driver used by this page object model
	 *
	 * @param driver
	 */
	public void setDriver(WebDriver driver) {
		BasePage.driver = driver;
	}

	/**
	 * Find an element
	 *
	 * @param locator
	 * @return found element
	 */
	protected WebElement find(By locator) {
		return driver.findElement(locator);
	}

	/**
	 * Sets the text in an input element
	 *
	 * @param locator
	 * @param text
	 */
	protected void setText(By locator, String text) {
		find(locator).clear();
		find(locator).sendKeys(text);
	}

	/**
	 * Click on an element
	 *
	 * @param locator
	 */
	protected void click(By locator) {
		find(locator).click();
	}
}
