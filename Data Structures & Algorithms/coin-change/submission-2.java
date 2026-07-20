class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) dp[i] = Integer.MAX_VALUE;

        for (int i = 0; i <= amount; i++) {
            if (dp[i] == Integer.MAX_VALUE) continue;
            for (int j = 0; j < coins.length; j++) {
                long total = (long) i + coins[j];
                if (total > amount) continue;
                dp[(int) total] = Math.min(dp[(int) total], dp[i] + 1);
            }
        }

        if (dp[amount] == Integer.MAX_VALUE) return -1;
        else return dp[amount];
    }
}
