package kr.or.ddit.basic;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		HashMap<String, String> map = new HashMap<>();
		
		
		map.put("name", "jun");
		map.put("addr", "daejeon");
		map.put("tel", "123");
		
		System.out.println("map -> " + map);
		
		
		Set<String> keySet = map.keySet();
		
		
		Iterator<String > keyIt = keySet.iterator();
		
		while(keyIt.hasNext()){
			String key = keyIt.next();
			String value = map.get(key);
			System.out.println(key + " : " + value);
		}
		
		for(String key :keySet){
			
			System.out.println(key + " : " + map.get(key));
			
		}
		
		
		Set<Map.Entry<String, String>> mapSet = map.entrySet();
		
		Iterator<Map.Entry<String, String>> entryIt = mapSet.iterator();
		
		while(entryIt.hasNext()){
			Map.Entry<String, String> entry = entryIt.next();
			System.out.println("key : " + entry.getKey() + " value : " + entry.getValue());
		}
		
		
	}

}
