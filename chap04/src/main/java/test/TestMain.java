package test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class TestMain {
	public static void main(String[] args) {
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("일번", 1);
		map.put("이번", 2);
		map.put("삼번", 3);
		map.put("사번", 4);
		
		Set<String> keySet = map.keySet();
		System.out.println(keySet); // 첫번째 파라미터

		Collection<Integer> values = map.values();
		System.out.println(values); //두번쨰 파라미터
		
		Set<Entry<String,Integer>> entrySet = map.entrySet();
		System.out.println(entrySet); //묶어놈
	}
}
