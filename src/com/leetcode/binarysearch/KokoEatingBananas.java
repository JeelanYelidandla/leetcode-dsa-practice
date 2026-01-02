package com.leetcode.binarysearch;

// this one available in jeelan.yelidandla account in chatgpt
public class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int H) {
        int max = 0;
        long total = 0L;
        for (int p : piles) {
            if (p > max) max = p;
            total += p;
        }

        // Optional tighter lower bound: at least ceil(total / H)
        int left = (int) Math.max(1L, (total + H - 1) / H);
        int right = max;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canFinish(piles, H, mid)) {
                right = mid; // mid is feasible, try smaller
            } else {
                left = mid + 1; // mid too slow, increase
            }
        }
        return left;
    }

    private boolean canFinish(int[] piles, int H, int speed) {
        long hours = 0L;
        for (int p : piles) {
            // Use long to avoid overflow when adding
            hours += (p + (long) speed - 1) / speed; // ceil(p / speed)
            if (hours > H) return false; // early exit
        }
        return hours <= H;
    }
}
