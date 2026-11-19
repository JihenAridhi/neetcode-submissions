class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = piles[0];
        for (int i = 1; i < piles.length; i++)
            max = Math.max(max, piles[i]);

        int start = 1;
        int end = max;
        int k = end;
        while (start <= end) {
            int mid = (start + end) / 2;
            int h1 = h;
            int i = 0;
            while (h1 > 0 && i < piles.length) {
                h1 -= (int) Math.ceil((double) piles[i] / mid);
                i++;
            }
            if (h1<0 || i<piles.length)
                start = mid + 1;
            else {
                k = mid;
                end = mid - 1;
            }
        }

        return k;
    }
}
