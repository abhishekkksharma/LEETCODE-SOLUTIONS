class Solution {
    public boolean areOccurrencesEqual(String s) {
        int[] freq = new int[26];
        for(int i=0;i<s.length();i++){
            freq[s.charAt(i)-'a']++;
        }
        int temp = freq[s.charAt(0)-'a'];
        for(int num : freq){
            if(num!=0 && num!=temp) return false;
        }
        return true;
    }
}