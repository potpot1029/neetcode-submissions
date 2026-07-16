class Solution {
  public String longestPalindrome(String s) {
    int n = s.length();

    boolean[][] dp = new boolean[n][n];
    for (int i = 0; i < n; i++) dp[i][i] = true;

    int maxI = 0, maxJ = 0;
    for (int len = 2; len <= n; len++) {
      for (int i = 0; i + len - 1 < n; i++) {
        dp[i][i + len - 1] = s.charAt(i) == s.charAt(i + len - 1);
        if (i + len - 2 >= i + 1) dp[i][i + len - 1] &= dp[i + 1][i + len - 2];
        if (dp[i][i + len - 1]) {
          maxI = i;
          maxJ = i + len - 1;
        }
      }
    }
    return s.substring(maxI, maxJ + 1);
  }
}
