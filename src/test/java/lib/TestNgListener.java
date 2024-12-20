package lib;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNgListener implements ITestListener {
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
		System.out.println("STARTED TEST: " + result);
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
		System.out.println("PASSED TEST: " + result);
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
		System.out.println("FAILED TEST: " + result);
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
		System.out.println("SKIPPED TEST: " + result);
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
		System.out.println("FAILED TEST WITHIN SUCCESS PERCENTAGE: " + result);
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
		System.out.println("FAILED TEST WITH TIMEOUT: " + result);
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
		System.out.println("STARTING TESTS: " + context);
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
		System.out.println("FINISHED TESTS: " + context);
		ITestListener.super.onFinish(context);
	}
}
