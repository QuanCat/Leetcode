package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Anagrams {
	public List<String> anagrams(String[] strs) {
		ArrayList<String> result = new ArrayList<String>();
		if (strs == null || strs.length == 0) {
			return result;
		}
        HashMap<String, ArrayList<String>> map = 
        		new HashMap<String, ArrayList<String>>();
        for (String str: strs) {
        	String newStr = sortChar(str);
        	if (!map.containsKey(newStr)) {
        		map.put(newStr, new ArrayList<String>());
        	}
        	ArrayList<String> anagrams = map.get(newStr);
        	anagrams.add(str);
        }
        
        for (String key: map.keySet()) {
        	ArrayList<String> anagrams = map.get(key);
        	if (anagrams.size() > 1) {
        		// or it will return [""], but expected []
        		result.addAll(anagrams);
        	}
        	
        }
        return result;
        
    }
	// Sort each str
	public String sortChar(String str) {
		char[] chr = str.toCharArray();
		java.util.Arrays.sort(chr);
		return new String(chr);
	}
	
	public static void main(String[] args) {
		String[] strs = {""};
		Anagrams a = new Anagrams();
		System.out.println(a.anagrams(strs));
	}
}
