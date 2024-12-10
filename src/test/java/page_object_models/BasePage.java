package page_object_models;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	public WebDriverWait wait;

	public BasePage(WebDriver driver) {
		BasePage.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}

	/**
	 * Find an element
	 *
	 * @param locator
	 * @return found element
	 */
	protected WebElement find(By locator) {
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
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
