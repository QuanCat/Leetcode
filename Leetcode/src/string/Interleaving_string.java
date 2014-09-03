package string;

// 没法考虑两个字符串的组合顺序问题。当处理{"aa", "ab", "aaba"}的时候，就不行了
// Merge sort
public class Interleaving_string {
	public static boolean isInterleave(String s1, String s2, String s3) {
        
        if (s3.length() != s2.length() + s1.length()) {
        	return false;
        }
        int index = 0; //s3
        int n = 0;     //s1
        int m = 0;     //s2
        while(n < s1.length() && m < s2.length()) {
        	if (s3.charAt(index) == s1.charAt(n)) {
        		n++;
        	} else if (s3.charAt(index) == s2.charAt(m)) {
        		m++;
        	} else {
        		return false;
        	}
        	index++;
        }
        while (n < s1.length()) {
        	if (s3.charAt(index) == s1.charAt(n)) {
        		n++;
        	} else {
        		return false;
        	}
        	index++;
        }
        while (m < s2.length()) {
        	if (s3.charAt(index) == s2.charAt(m)) {
        		m++;
        	} else {
        		return false;
        	}
        	index++;
        }
 
        return true;

    }
	public static void main(String[] args) {
		boolean flag = isInterleave("aa", "ab", "aaba");
		System.out.println(flag);
		//String s = "";
		//System.out.println(s.length());
		
		
	}
}
