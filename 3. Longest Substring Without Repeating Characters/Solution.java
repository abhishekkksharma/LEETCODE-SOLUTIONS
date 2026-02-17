class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;

        for(int i = 0; i < s.length(); i++){
            int j = i;
            int[] freq = new int[128];
            int count = 0;

            while(j < s.length()){
                if(freq[s.charAt(j)] > 0){   
                    break;
                }
                freq[s.charAt(j)]++;        
                count++;
                max = Math.max(count, max);
                j++;
            }
        }
        return max;
    }
}
