package Test;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {

	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(JUnitTesting.class);

		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
		System.out.println("Total Failure Count : " + result.getFailureCount());
		System.out.println("Total Run Count : " + result.getRunCount());
		System.out.println("Were all tests successfull ? : " + result.wasSuccessful());
	}

}
