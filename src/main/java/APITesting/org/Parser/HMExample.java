package APITesting.org.Parser;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

public class HMExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, Double> HM=new HashMap<String, Double>();
		HM.put("a", new Double(10.10));
		HM.put("b", new Double(20.20));
		HM.put("c", new Double(30.30));
		
		for(String str:HM.keySet())
		{
			System.out.println(str);
		}
		
		for(Double db1:HM.values())
		{
			System.out.println(db1);
		}
		
		Set<String> s=HM.keySet();
		Iterator itr=s.iterator();
				
		while(itr.hasNext())
		{
			String keys=(String) itr.next();
			System.out.println(keys+":"+HM.get(keys));
		}
		
		

	}

}
