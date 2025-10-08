class Solution {
    public String greatestLetter(String s) {
        int[] freqsmall = new int[26];
        int[] freqCapital = new int[26];
        for(int i=0;i<s.length();i++){
            int ch = s.charAt(i);
            if(ch>='a' && ch<='z'){
                freqsmall[ch-'a']++;
            }
            else{
                freqCapital[ch-'A']++;
            }
        }
        for(int i=26-1;i>=0;i--){
            if(freqsmall[i]!=0 && freqCapital[i]!=0){
                return (char) ('A' + i) + "";
            } 
        }
        return "";
    }
}