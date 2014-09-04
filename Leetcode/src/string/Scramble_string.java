package string;

//Recursive method
//How to do this in linear time?

public class Scramble_string {
	public static boolean isScramble(String s1, String s2) {
		//if exactly the same
		if (s1 == s2) {return true;}
		int size = s1.length();
		int value1 = 0;
		int value2 = 0;
		//compare if s1 and s2 contains the same chars
		for (int i = 0; i < size; i++) {
			value1 += (s1.charAt(i)) - 'a';
			value2 += (s1.charAt(i) - 'a');
		}
		if (value1 != value2) {
			return false;
		}
		//check scrambles
		/*	
		 * s1[0,i], s2[0,i]; s1[i, size], s2[i, size]
	       s1[0,i], s2[size-i, size]; s1[i, size], s2[0, size-i]
		*/
		for (int i = 1; i < size; i++) {
			if (isScramble(s1.substring(0, i), s2.substring(0, i)) && 
					isScramble(s1.substring(i, size), s2.substring(i, size))) {
				return true;
			}
			//here
			if (isScramble(s1.substring(0, i), s2.substring(size - i, size)) && 
					isScramble(s1.substring(i, size), s2.substring(0, size - i))) {
				return true;
			}
		}
        return false;
    }
	
	public static void main(String[] args) {
		boolean flag = isScramble("great", "rgeat");
		System.out.println(flag);
		//System.out.println("apple".substring(1, 4)); //ppl (]
		
		/*String str1 = "qwerty";
		String str2 = "qwerty";
		for (int i = 0; i < str1.length(); i++) {
			System.out.println(str1.charAt(i) - 'a');
			System.out.println(str2.charAt(i) - 'a');
		}*/
		
	}
}
