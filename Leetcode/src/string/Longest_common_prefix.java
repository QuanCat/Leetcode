package string;

public class Longest_common_prefix {
	public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
        	return "";
        }

        int len = findShortestStr(strs);
        String result = "";
        boolean flag = true;
        for (int i = 0; i < len; i++) {
        	char tmp = strs[0].charAt(i);
        	
        	result += tmp;
        	for (String word: strs) {
        		//System.out.println(word);
        		if (word.charAt(i) != tmp) {
        			result = result.substring(0, i);
        			flag = false;
        			return result;
        		}
        	}
        }
        if (flag) {
        	return result;
        }
        return "";
        
    }
	
	public int findShortestStr(String[] strs) {
		int len = strs[0].length();
		for (int i = 0; i < strs.length; i++) {
			if (strs[i].length() < len) {
				len = strs[i].length();
			}
		}
		return len;
	}
	
	public static void main(String[] args) {
		Longest_common_prefix l = new Longest_common_prefix();
		String[] strs = new String[2];
		strs[0] = "ab";
		strs[1] = "abc";
		/*strs[0] = "qwer";
		strs[1] = "qwty";
		strs[2] = "qwey";*/
		String result = l.longestCommonPrefix(strs);
		System.out.println(result);
	}
}
