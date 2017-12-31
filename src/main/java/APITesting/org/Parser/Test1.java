package APITesting.org.Parser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Test1 {

	private static final String filePath="C:\\Users\\Murali\\Desktop\\sample.json";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			// read the json file
		   
			FileReader reader;
			try {
				reader = new FileReader(filePath);
				JSONParser jsonParser = new JSONParser();
				JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
				
				 String profille=(String)jsonObject.get("name");
				 System.out.println(profille);
				 //String id=(String)jsonObject.get("id");
				// Integer result = Integer.valueOf(id);
				 //System.out.println(result);
				 Collection<Object> code=jsonObject.values();
				 for(Object i:code)
					 System.out.println(i);
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		

	}

}
