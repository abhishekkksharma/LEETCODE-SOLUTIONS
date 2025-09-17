class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int size = nums.length;
        int[] result = new int[size];

        for (int i = 0; i < size; i++) {
            int count = 0;
            for (int j = 0; j < size; j++) {
                if (nums[j] < nums[i]) {
                    count++;
                }
            }
            result[i] = count;
        }
        return result;
    }
}
