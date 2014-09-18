package string;

import java.util.HashMap;

public class Find_words_in_dictionary {
	//compare with dictionary by word
	public boolean dictionaryContains(String word) {
		
		String[] dict = {"mobile", "samsung", "sam", "sung", "man", "mango",
				"icecream", "and", "go", "i", "like", "ice", "cream"};
		int size = dict.length;
		for (int i = 0; i < size; i++) {
			if (dict[i].compareTo(word) == 0) {
				return true;
			}
		}
		return false;
	}
	// Break the str into words
	@SuppressWarnings("unchecked")
	public boolean breakWords(String str) {
		if (str == null || str.length() == 0) {
			return true;
		}
		boolean wb[] = new boolean[str.length()];
		@SuppressWarnings("rawtypes")
		// compare str[0, i) and str[i, j)
		HashMap map = new HashMap();
		for (int i = 1; i < str.length(); i++) {
			if (wb[i - 1] == false && dictionaryContains(str.substring(0, i))) {
				wb[i - 1] = true;
				map.put(str.substring(0, i), 1);
				System.out.println("aaaa " + str.substring(0, i));
			}
			for (int j = i; j <= str.length(); j++) {
				if (wb[j - 1] == false && dictionaryContains(str.substring(i, j))) {
					wb[j - 1] = true;
					map.put(str.substring(i, j), 1);
					System.out.println("bbbb " + str.substring(i, j));
				}
			}
		}
		// check if wb[] contains false
		for (int i = 0; i < str.length(); i++) {
			if (wb[i]) {
				return true;
			}
		}
		return false;
		
	}
	
	public static void main(String[] args) {
		Find_words_in_dictionary f = new Find_words_in_dictionary();
		boolean flag = f.breakWords("likesamsungmancreamice");
		System.out.println(flag);
		System.out.println("test=" + "qwertyu".substring(0, 1));
		System.out.println("test=" + "qwertyu".substring(3, 7));
		
	}
}
