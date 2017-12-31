package APITesting.org.Parser;

import java.util.TreeMap;

public class CountWordsinText {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String org="this is murali & murali is stupid & test is this";
		String str[]=org.split("[ \n\t\r,.;!?(){}]");
		TreeMap<String,Integer> map=new TreeMap<String, Integer>();
		for(int i=0;i<str.length;i++)
		{
			String key=str[i].toLowerCase();
			
			if(str[i].length()>1)
			{
				if(map.get(key)==null)
				{
					map.put(key,1);
				}
				else 
				{
					int values=map.get(key).intValue();
					values++;
					map.put(key, values);
					
				}
			}
		}
		
		System.out.println(map);
		System.out.println(map.ceilingKey("stupid"));
		System.out.println(map.firstKey());
		System.out.println(map.floorKey("murali"));
		

	}

}
