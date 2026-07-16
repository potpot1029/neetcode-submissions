class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int left = 1, right = n;

        int curMin = nums[0];
        while (left < right) {
            int mid = (left + right) / 2;

            System.out.printf("mid=%d, nums[mid]=%d\n", mid, nums[mid]);
            if (nums[0] < nums[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left % n];
    }
}
