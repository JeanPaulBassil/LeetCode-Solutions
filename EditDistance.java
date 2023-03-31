import java.util.LinkedList;
public class EditDistance {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
            }
        }

        LinkedList<String> steps = new LinkedList<>();
        int i = m, j = n;
        while (i > 0 || j > 0) {
            if (i > 0 && j > 0 && dp[i][j] == dp[i - 1][j - 1] && word1.charAt(i - 1) == word2.charAt(j - 1)) {
                i--;
                j--;
            } else if (i > 0 && dp[i][j] == dp[i - 1][j] + 1) {
                steps.addFirst("remove '" + word1.charAt(i - 1) + "'");
                i--;
            } else if (j > 0 && dp[i][j] == dp[i][j - 1] + 1) {
                steps.addFirst("insert '" + word2.charAt(j - 1) + "'");
                j--;
            } else {
                steps.addFirst("replace '" + word1.charAt(i - 1) + "' with '" + word2.charAt(j - 1) + "'");
                i--;
                j--;
            }
        }

        System.out.println("Steps:");
        for (String step : steps) {
            System.out.println(step);
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        EditDistance solution = new EditDistance();
        String word1 = "horse";
        String word2 = "ros";
        System.out.println("Input: word1 = \"" + word1 + "\", word2 = \"" + word2 + "\"");
        System.out.println("Output: " + solution.minDistance(word1, word2));

        word1 = "intention";
        word2 = "execution";
        System.out.println("Input: word1 = \"" + word1 + "\", word2 = \"" + word2 + "\"");
        System.out.println("Output: " + solution.minDistance(word1, word2));
    }
}
