package dp;

public class InterleavingString {
	public boolean isInterleave(String s1, String s2, String s3) {
		if (s1 == null || s2 == null || s3 == null) {
			return false;
		}
		if (s1.length() + s2.length() != s3.length()) {
			return false;
		}

		boolean[][] interleave = new boolean[s1.length() + 1][s2.length() + 1];
		interleave[0][0] = true;
		for (int i = 1; i <= s1.length(); i++) {
			interleave[i][0] = s1.substring(0, i).equals(s3.substring(0, i));
		}
		for (int i = 1; i <= s2.length(); i++) {
			interleave[0][i] = s2.substring(0, i).equals(s3.substring(0, i));
		}

		for (int i = 1; i <= s1.length(); i++) {
			for (int j = 1; j <= s2.length(); j++) {
				interleave[i][j] = false;
				if (s1.charAt(i - 1) == s3.charAt(i + j - 1)) {
					interleave[i][j] = interleave[i][j] || interleave[i - 1][j];
				}
				if (s2.charAt(j - 1) == s3.charAt(i + j - 1)) {
					interleave[i][j] = interleave[i][j] || interleave[i][j - 1];
				}
			}
		}

		return interleave[s1.length()][s2.length()];
	}

}
