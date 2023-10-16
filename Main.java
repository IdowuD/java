package assignment;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.ArrayList;
import java.util.Iterator;

public class Main {
	public static String searchByNameOrGender(ArrayList<Student> students, String searchString) {
		ArrayList<String> searchResult = new ArrayList<String>();
		for(int i = 0; i < students.size(); i++) {
			if(students.get(i).getFirstName().equalsIgnoreCase(searchString) || students.get(i).getGender().equalsIgnoreCase(searchString)) {
				searchResult.add(students.get(i).toString());
			}
		}
		if(searchResult.size() != 0) {
			return searchResult.toString();
		}
		return "No data could be found.";
	}
	
	public static void main(String[] args){
		
		ArrayList<Student> students = new ArrayList<Student>();
		Client client = Client.create();
		WebResource webResource = client.resource("https://hccs-advancejava.s3.amazonaws.com/student.json");
		
		ClientResponse clientResponse = webResource.accept("application/json").get(ClientResponse.class);
		if(clientResponse.getStatus() != 200) {
			throw new RuntimeException(clientResponse.toString());
		}
		
		try {
			JSONArray jsonArray = (JSONArray) new JSONParser().parse(clientResponse.getEntity(String.class));
			@SuppressWarnings("unchecked")
			Iterator<Object> iterator = jsonArray.iterator();
			
			String fName;
			String gender;
			String email;
			String gpa;
			
			while(iterator.hasNext()) {
				JSONObject jsonObject = (JSONObject) iterator.next();
				fName = (String)jsonObject.get("first_name");
				gender = (String)jsonObject.get("gender");
				email = (String)jsonObject.get("email");
				gpa = (String)jsonObject.get("gpa");
				
				students.add(new Student(fName, gender, email, gpa));
			}
			
			System.out.println(searchByNameOrGender(students, "female"));
		}catch(ParseException ex) {
			System.out.println("Unable to parse JSON");
		}
		
    }

}
