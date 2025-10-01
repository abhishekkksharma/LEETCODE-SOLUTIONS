class Solution {
    public String getEncryptedString(String s, int k) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        if(k>=n) k=k%n;
        for(int i=k;i<n;i++){
            sb.append(s.charAt(i));
        }
        for(int i=0;i<k;i++){
            sb.append(s.charAt(i));
        }
        return sb+"";
    }
}