package dp;

public class EditDistance {
	public int minDistance(String word1, String word2) {
		if (word1 == null || word2 == null) {
			return -1;
		}

		int[][] distance = new int[word1.length() + 1][word2.length() + 1];

		// Initialize
		for (int i = 0; i <= word1.length(); i++) {
			distance[i][0] = i;
		}
		for (int j = 0; j <= word2.length(); j++) {
			distance[0][j] = j;
		}
		// go dp
		for (int i = 1; i <= word1.length(); i++) {
			for (int j = 1; j <= word2.length(); j++) {
				distance[i][j] = Math.min(distance[i - 1][j],
						distance[i][j - 1]) + 1;
				distance[i][j] = Math
						.min(distance[i][j],
								distance[i - 1][j - 1]
										+ (word1.charAt(i - 1) == word2
												.charAt(j - 1) ? 0 : 1));
			}
		}

		return distance[word1.length()][word2.length()];
	}

}
