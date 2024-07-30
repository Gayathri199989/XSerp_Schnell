package utility;

import java.util.logging.Logger;

public class Log {
	// Initialize Log4j logs

		 private static Logger Log = Logger.getLogger(Log.class.getName());//

	 // This is to print log for the beginning of the test case, as we usually run so many test cases as a test suite

	 public void startTestCase(String sTestCaseName){

		Log.info("****************************************************************************************");

		Log.info("$$$$$$$$$$$$$$$$$$$$$  "+sTestCaseName+ " test case execution started $$$$$$$$$$$$$$$$$$$$$$$$$");

		}

		//This is to print log for the ending of the test case

	 public void endTestCase(String sTestCaseName){

		Log.info("XXXXXXXXXXXXXXXXXXXXXXX "+sTestCaseName+ " test case execution completed XXXXXXXXXXXXXXXXXXXXXX");

		Log.info("****************************************************************************************");
		}

		// Need to create these methods, so that they can be called

	 public static void info(String message) {

			Log.info(message);

			}

	 public static void warn(String message) {

	    Log.warning(message);

		}




}

