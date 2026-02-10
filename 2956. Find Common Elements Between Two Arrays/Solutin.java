class Solution {
    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        boolean[] seen1 = new boolean[101];
        boolean[] seen2 = new boolean[101];

        // mark presence
        for (int n : nums1) seen1[n] = true;
        for (int n : nums2) seen2[n] = true;

        int count1 = 0; 
        int count2 = 0; 

        for (int n : nums1) {
            if (seen2[n]) count1++;
        }
        for (int n : nums2) {
            if (seen1[n]) count2++;
        }

        return new int[]{count1, count2};
    }
}
