
public class Payload {
	
	public static String getPayload(String fname, String lname) {
		String payload="{\r\n"
	            + "    \"name\": \""+fname+"\",\r\n"
	            + "    \"job\": \""+lname+"\"\r\n"
	            + "}";
		return payload;
	}

}
