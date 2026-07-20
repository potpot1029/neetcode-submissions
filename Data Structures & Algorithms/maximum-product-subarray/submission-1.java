class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[] dpMax = new int[n], dpMin = new int[n];
        dpMax[0] = dpMin[0] = nums[0];

        int ans = nums[0];
        for (int i = 1; i < n; i++) {
            int maxProd = nums[i] * dpMax[i-1];
            int minProd = nums[i] * dpMin[i-1];
            dpMax[i] = Math.max(maxProd, Math.max(minProd, nums[i]));
            dpMin[i] = Math.min(maxProd, Math.min(minProd, nums[i]));
            ans = Math.max(ans, dpMax[i]);
        }

        return ans;
    }
}
