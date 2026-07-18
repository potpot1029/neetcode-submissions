class Solution {
    public boolean isPalindrome(String s) {
        char[] chars = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase().toCharArray();
        int n = chars.length;

        int left = 0, right = n-1;

        while (left < right) {
            if (chars[left] != chars[right]) return false;
            left++; right--;
        }
        return true;
    }
}
