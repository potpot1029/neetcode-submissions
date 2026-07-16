class Solution {
  public int minEatingSpeed(int[] piles, int h) {
    int n = piles.length;
    int left = 1, right = 1;
    for (int i = 0; i < n; i++) right = Math.max(right, piles[i]);

    while (left < right) {
        int mid = (left + right) / 2;

        boolean ok = false;
        int hoursRequired = 0;
        for (int i = 0; i < n; i++) {
            hoursRequired += Math.ceil((double) piles[i] / mid);
        }
        ok = hoursRequired <= h;

        if (ok) {
            right = mid;
        } else {
            left = mid + 1;
        }

    }

    return left;
  }
}
