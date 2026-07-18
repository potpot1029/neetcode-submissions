class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int n = nums.length;
        for (int i = 0; i < n-2; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i+1, right = n-1;
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum + nums[i] == 0) {
                    result.add(List.of(nums[i], nums[left], nums[right]));
                    left++; right--;

                    while (left < right && nums[left] == nums[left-1]) {
                        left++;
                    }
                } else if (sum > -nums[i]) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return result;
    }
}
