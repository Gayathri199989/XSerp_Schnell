package utility;

public class Utils {
	public static String getTestCaseName(String sTestCase)throws Exception{

		String value = sTestCase;

		try{

			int posi = value.indexOf("@");

			value = value.substring(0, posi);

			posi = value.lastIndexOf(".");

			value = value.substring(posi + 1);

			return value;

				}catch (Exception e){

			System.err.println("Error in getting TestCase name : "+e.getMessage());

			throw (e);

					}

			}
}
