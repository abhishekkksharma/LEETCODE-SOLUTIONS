class Solution {
    public int maxDifference(String s) {
        int n = s.length();
        int[] freq = new int[26];
        for(int i=0; i<n; i++){
            freq[s.charAt(i)-'a']++;
        }
        int maxOdd = 0;
        int minEven = Integer.MAX_VALUE;

        for (int count : freq) {
            if (count > 0) {
                if (count % 2 == 1) {
                    maxOdd = Math.max(maxOdd, count);
                } else {
                    minEven = Math.min(minEven, count);
                }
            }
        }
        return maxOdd - minEven;
    }
}