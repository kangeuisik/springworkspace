package test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Consumer;

public class TestMain2 {
	public static void main(String[] args) {
		
		List<String> list = new ArrayList<String>();
		list.add("홍길동");
		list.add("이순신");
		list.add("손흥민");
		list.add("황희찬");
		
		Consumer<String> c = t -> System.out.println(t); //랍다식
		
		
		list.forEach(t -> System.out.println(t));
		System.out.println("===========================================");
		Iterator<String> it =list.iterator();
		while(it.hasNext()) { // 한번반복하면 더이상 반복안함
			System.out.println(it.next());
		}
	}
		
}
