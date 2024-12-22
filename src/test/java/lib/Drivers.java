package lib;

import java.io.File;
import java.nio.file.Files;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * Singleton class to manage the WebDriver instance
 */
public class Drivers {

	/** The instance of this Drivers class */
	private static Drivers self;
	/** The WebDriver instance */
	private static WebDriver driver;
	/** The homepage URL for the app being tested */
	private final String url = "https://www.leafground.com/";
	/** Width of the browser window used by tests */
	private final int window_width = (int) (1920 * 0.75);
	/** Height of the browser window used by tests */
	private final int window_height = (int) (1080 * 0.75);

	/**
	 * Private constructor to initialize the WebDriver instance
	 */
	private Drivers() {
		driver = new ChromeDriver(this.setupOptions());
		driver.manage().window().setSize(new Dimension(this.window_width, this.window_height));
	}

	/**
	 * Setup the ChromeOptions for the WebDriver
	 * 
	 * @return the ChromeOptions instance
	 */
	private ChromeOptions setupOptions() {
		ChromeOptions options = new ChromeOptions();
		// Disable the "Chrome is being controlled by automated test software" infobar
		options.setExperimentalOption("excludeSwitches", List.of("enable-automation"));
		return options;
	}

	/**
	 * Get the current WebDriver instance
	 * 
	 * @return the WebDriver instance
	 */
	public static WebDriver getDriver() {
		if (self == null)
			self = new Drivers();
		return driver;
	}

	/**
	 * Close the current browser window
	 */
	public static void quit() {
		driver.quit();
	}

	/**
	 * Take a screenshot of the current page
	 * 
	 * @param filename the name of the file to save the screenshot as
	 * @param status   the status of the test when the screenshot was taken
	 * @example Drivers.screenshot("myScreenshot", "FAIL");
	 */
	public static String screenshot(String filename, String status) {
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String fileName = status + "Screenshot_" + filename + new Date() + ".png";

		try {
			// Save the screenshot by copying to another file, allowing us to name it
			Files.copy(screenshot.toPath(),
					new File(
							System.getProperty("user.dir") + "/src/test/results/" + filename)
							.toPath());
		} catch (Exception e) {
			System.out.println(
					"Failed to take screenshot:\n\tMessage: "
							+ e.getMessage()
							+ "\n\tCause: "
							+ e.getCause()
							+ "\n\tClass: "
							+ e.getClass());
		}

		return fileName;
	}
}
