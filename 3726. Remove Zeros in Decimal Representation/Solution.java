class Solution {
    public long removeZeros(long n) {
        String temp = Long.toString(n);
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<temp.length();i++){
            if(temp.charAt(i)!='0') sb.append(temp.charAt(i));
        }
        return Long.parseLong(sb.toString());
    }
}