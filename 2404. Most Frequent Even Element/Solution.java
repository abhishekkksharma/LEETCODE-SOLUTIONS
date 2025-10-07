class Solution {
    public int mostFrequentEven(int[] nums) {
        int maxfreq = 0;
        int maxNum = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 != 0) continue;

            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] == nums[j]) count++;
            }

            if (count > maxfreq || (count == maxfreq && nums[i] < maxNum) || maxNum == -1) {
                maxfreq = count;
                maxNum = nums[i];
            }
        }

        return maxNum;
    }
}
