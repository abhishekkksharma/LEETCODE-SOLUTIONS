class Solution {
    public String processStr(String s) {
        StringBuilder sb = new StringBuilder();
        for(char ch : s.toCharArray()){
            if(ch>='a' && ch<='z'){
                sb.append(ch);
            }else if(ch=='#'){
                String temp = sb.toString();
                sb.append(temp);
            }else if(ch=='%'){
                sb.reverse();
            }else if(ch=='*' && !sb.isEmpty()){
                sb.deleteCharAt(sb.length()-1);
            }
        }
        return sb.toString();
    }
}