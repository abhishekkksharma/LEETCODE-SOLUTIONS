class Solution {
    public int strStr(String haystack, String needle) {
        if(!haystack.contains(needle)) return -1;
        if(needle.length()==0) return 0;
        int n =needle.length();
        for(int i=0;i<=(haystack.length()-n);i++){
            if(haystack.charAt(i)==needle.charAt(0)){
                if(haystack.substring(i,i+n).equals(needle)) return i;
            }
        }
        return -1;
    }
}