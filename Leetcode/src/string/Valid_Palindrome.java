package string;

public class Valid_Palindrome {
	//Solution 2:
	public boolean isPalindrome2(String s) {
		if (s == null || s.length() == 0) {
			return true;
		}
		int front = 0;
		int end = s.length() - 1;
		while (front < end) {
			while (front < s.length() && !isValid(s.charAt(front))) {
				front++;
			}
			// for empty string
			if (front == s.length()) {
				return true;
			}
			while (end >= 0 && !isValid(s.charAt(end))) {
				end--;
			}
			// compare char
			if (Character.toLowerCase(s.charAt(front)) != Character.toLowerCase(s.charAt(end))) {
				break;
			} else {
				front++;
				end--;
			}
		}
		return end <= front;
	}
	
	private boolean isValid(char c) {
		return Character.isLetter(c) || Character.isDigit(c);
	}
	
	// Solution 1:
	public boolean isPalindrome(String s) {
        if (s == null) {return false;}
        if (s.length() < 2) {return true;}
        char[] charArray = s.toCharArray();
        int len = s.length();
        
        int i = 0, j = len - 1;
        while (i < j) {
        	
        	char left = charArray[i];
        	char right = charArray[j];
        	while (i < len - 1 && !isAlpha(left) && !isNum(left)) {
        		System.out.println(i);
        		i++;
        		left = charArray[i];
        	}
        	while (j > 0 && !isAlpha(right) && !isNum(right)) {
        		System.out.println(j);
        		j--;
        		right = charArray[j];
        	}
        	if (i >= j) {
        		break;
        	}
        	left = charArray[i];
        	right = charArray[j];
        	if (!isSame(left, right)) {
        		return false;
        	}
        	i++;
        	j--;
        }
        return true;
    }
	public boolean isAlpha(char c) {
		if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z') {
			return true;
		} else {
			return false;
		}
	}
	public boolean isNum(char c) {
		if (c >= '0' && c <= '9') {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isSame(char a, char b) {
		if (isNum(a) && isNum(b)) {
			return a== b;
		} else if (String.valueOf(a).equalsIgnoreCase(String.valueOf(b))) {
			return true;
		} else {
			return false;
		}
	}
	public static void main(String[] agrs) {
		Valid_Palindrome v = new Valid_Palindrome();
		boolean f = v.isPalindrome("aA");
		System.out.println(f);
	}
}
