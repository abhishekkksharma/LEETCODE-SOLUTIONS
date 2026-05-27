class Solution {
    public int numberOfSpecialChars(String word) {
        int[] lowwer=new int[26];
        int[] upper=new int[26];
        for(int i=0;i<26;i++){
            lowwer[i]=-1;
            upper[i]=-1;
        }
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            if(ch>='a' && ch<='z'){
                lowwer[ch-'a']=i;
            }else{
                int idx=ch-'A';
                if(upper[idx]==-1) upper[idx]=i;
            }
        }
        int count=0;
        for(int i=0;i<26;i++){
            if(lowwer[i]!=-1 && upper[i]!=-1 && lowwer[i]<upper[i]){
                count++;
            }
        }
        return count;
    }
}