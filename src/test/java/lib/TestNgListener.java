package lib;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 * TestNG Listener class to log test results
 */
public class TestNgListener implements ITestListener {

	String indent = "\t";
	String testListStyle = "> ";
	String testPropertyListStyle = "\t- ";
	String startTestsMarker = "\n**********\n";
	String finishTestsMarker = "\n**********\n";
	StringBuilder testOutput = new StringBuilder();

	/**
	 * Print a formated list item for a test property. A test property could be the
	 * test's status, filename for a screenshot, etc.
	 * 
	 * @param text the text to print
	 */
	private void printTestPropertyListItem(String text) {
		System.out.println(this.testPropertyListStyle + text);
	}

	/**
	 * Print the status of the test result. Converts the status integer to a string.
	 * 
	 * @param result ITestResult object
	 */
	private void printResultStatus(ITestResult result) {
		this.printTestPropertyListItem("status: " + this.getStatusAsString(result.getStatus()));
	}

	/**
	 * Get the status of the test result as a string.
	 * 
	 * @param status The status integer
	 * @return The status as a string
	 * @example getStatusAsString(ITestResult.getStatus());
	 */
	private String getStatusAsString(int status) {
		String statusAsString;

		// Convert the status integer to a string
		switch (status) {
			case -1:
				statusAsString = "CREATED";
				break;
			case 1:
				statusAsString = "SUCCESS";
				break;
			case 2:
				statusAsString = "FAILURE";
				break;
			case 3:
				statusAsString = "SKIP";
				break;
			case 4:
				statusAsString = "SUCCESS_PERCENTAGE_FAILURE";
				break;
			case 16:
				statusAsString = "STARTED";
				break;
			default:
				statusAsString = "UNKNOWN";
				break;
		}

		return statusAsString;
	}

	/**
	 * Handle taking a screenshot of the current page. Take screenshot and log
	 * filename it was saved as.
	 * 
	 * @param filename
	 */
	private void handleScreenshot(ITestResult result) {
		this.printTestPropertyListItem(
				Drivers.screenshot(
						result.getName(), this.getStatusAsString(
								result.getStatus())));
	}

	/**
	 * Invoked each time before a test will be invoked. The <code>ITestResult</code>
	 * is only partially
	 * filled with the references to class, method, start millis and status.
	 *
	 * @param result the partially filled <code>ITestResult</code>
	 * @see ITestResult#STARTED
	 */
	@Override
	public void onTestStart(ITestResult result) {
		// page_tests.TDashboard.PageLoads -> remove the "page_tests." part
		String qualifiedName = result.getMethod().getQualifiedName().substring(11);
		System.out.println(this.testListStyle + qualifiedName);
		ITestListener.super.onTestStart(result);
	}

	/**
	 * Invoked each time a test succeeds.
	 *
	 * @param result <code>ITestResult</code> containing information about the run
	 *               test
	 * @see ITestResult#SUCCESS
	 */
	@Override
	public void onTestSuccess(ITestResult result) {
		this.printResultStatus(result);
		ITestListener.super.onTestSuccess(result);
	}

	/**
	 * Invoked each time a test fails.
	 *
	 * @param result <code>ITestResult</code> containing information about the run
	 *               test
	 * @see ITestResult#FAILURE
	 */
	@Override
	public void onTestFailure(ITestResult result) {
		this.handleScreenshot(result);
		this.printResultStatus(result);
		ITestListener.super.onTestFailure(result);
	}

	/**
	 * Invoked each time a test is skipped.
	 *
	 * @param result <code>ITestResult</code> containing information about the run
	 *               test
	 * @see ITestResult#SKIP
	 */
	@Override
	public void onTestSkipped(ITestResult result) {
		this.handleScreenshot(result);
		this.printResultStatus(result);
		ITestListener.super.onTestSkipped(result);
	}

	/**
	 * Invoked each time a method fails but has been annotated with
	 * successPercentage and this failure
	 * still keeps it within the success percentage requested.
	 *
	 * @param result <code>ITestResult</code> containing information about the run
	 *               test
	 * @see ITestResult#SUCCESS_PERCENTAGE_FAILURE
	 */
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		this.handleScreenshot(result);
		this.printResultStatus(result);
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	/**
	 * Invoked each time a test fails due to a timeout.
	 *
	 * @param result <code>ITestResult</code> containing information about the run
	 *               test
	 */
	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		this.handleScreenshot(result);
		this.printResultStatus(result);
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	/**
	 * Invoked before running all the test methods belonging to the classes inside
	 * the &lt;test&gt; tag
	 * and calling all their Configuration methods.
	 *
	 * @param context The test context
	 */
	@Override
	public void onStart(ITestContext context) {
		System.out.println(this.startTestsMarker + "STARTING TESTS: " + context);
		ITestListener.super.onStart(context);
	}

	/**
	 * Invoked after all the test methods belonging to the classes inside the
	 * &lt;test&gt; tag have run
	 * and all their Configuration methods have been called.
	 *
	 * @param context The test context
	 */
	@Override
	public void onFinish(ITestContext context) {
		System.out.println("FINISHED TESTS: " + context + this.finishTestsMarker);
		ITestListener.super.onFinish(context);
	}
}
