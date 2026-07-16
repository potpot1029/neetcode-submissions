class Solution {
    public int getSum(int a, int b) {
        while ((a & b) != 0) {
            int tmp = (a & b) << 1;
            b = a ^ b;
            a = tmp;
        }
        return a | b;
    }
}
