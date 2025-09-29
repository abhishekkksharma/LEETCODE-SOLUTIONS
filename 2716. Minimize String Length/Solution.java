class Solution {
    public int minimizedStringLength(String s) {
        int[] freq = new int[26];
        for(int i=0;i<s.length();i++){
            int ch  = s.charAt(i) -'a';
            freq[ch]++;
        }
        int count = 0;
        for(int num : freq){
            if(num>0) count++;
        }
        return count;
    }
}