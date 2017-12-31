package APITesting.org.Parser;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import org.json.simple.JSONObject;


public class practice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		Map<String, Object> data = new HashMap<String, Object>();
	    data.put( "name", "Mars" );
	    data.put( "age", 32 );
	    data.put( "city", "NY" );
	    String[] types = {"street_number"};
	    data.put("Type", types);
	    JSONObject json = new JSONObject();
	    json.putAll( data );
	    System.out.printf( "JSON: %s", json.toString() );

		
	}
	
}
		
		



