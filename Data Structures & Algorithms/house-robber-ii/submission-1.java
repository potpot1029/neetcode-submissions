class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp1 = new int[n], dp2 = new int[n];

        if (n == 1) return nums[0];

        dp1[1] = nums[0];
        for (int i = 1; i < n-1; i++) {
            dp1[i+1] = Math.max(dp1[i], dp1[i-1] + nums[i]);
        }
        
        dp2[n-2] = nums[n-1];
        for (int i = n-2; i > 0; i--) {
            dp2[i-1] = Math.max(dp2[i], dp2[i+1] + nums[i]);
        }

        return Math.max(dp1[n-1], dp2[0]);
    }
}
