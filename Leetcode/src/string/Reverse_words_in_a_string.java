package string;
/*
 * tricky part: the last append(" ") needs to be deleted if this is the last word
 */
public class Reverse_words_in_a_string {
	public static String reverseWords1(String s) {
		if (s == null || s.length() == 0) {
			return "";
		}
		String[] arrayStr = s.split(" ");
		int length = arrayStr.length;

	    StringBuffer newStr = new StringBuffer();
		for (int i = length - 1; i >= 0; i--) {
			if (!arrayStr[i].trim().equals("")) {
				newStr.append(arrayStr[i].trim()).append(" ");
			}
			
		}
		// the last " "(space) needs to be deleted
		return newStr.length() == 0 ? "": newStr.substring(0, newStr.length() - 1);

    }
	
	public static void main(String[] args) {
		String str = reverseWords1(" a b");
		System.out.println(str);
	}
}
