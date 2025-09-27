class Solution {
    public String reverse(String str){
        StringBuilder sb = new StringBuilder("");
        for(int i=str.length()-1;i>=0;i--){
            sb.append(str.charAt(i));
        }
        return sb+"";
    }
    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+"); 
        StringBuilder sb = new StringBuilder("");
        for(int i=0;i<words.length;i++){
            sb.append(reverse(words[i]));
            if (i < words.length-1) sb.append(" ");
        }
        return sb.toString();
    }
} 