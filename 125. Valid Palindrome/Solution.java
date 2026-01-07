class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for(char ch : s.toCharArray()){
            if(Character.isLetterOrDigit(ch)){
                sb.append(Character.toLowerCase(ch));
            }
        }
        int start=0;
        int last=sb.length()-1;
        while(start<=last){
            if(sb.charAt(start)!=sb.charAt(last)) return false;
            start++;
            last--;
        }
        return true;
    }
}