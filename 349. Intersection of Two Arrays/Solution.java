class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        boolean[] seen1 = new boolean[1001];
        boolean[] seen2 = new boolean[1001];
        for (int num : nums1) {
            seen1[num] = true;
        }
        for (int num : nums2) {
            seen2[num] = true;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 1001; i++) {
            if (seen1[i] && seen2[i]) {
                list.add(i);
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
