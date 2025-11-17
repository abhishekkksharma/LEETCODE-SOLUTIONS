class Solution {
    public int percentageLetter(String s, char letter) {
        int n = s.length();
        int letterSize=0;
        for(int i=0;i<n;i++){
            if(s.charAt(i)==letter) letterSize++;
        }
        int percentage = (int) ((letterSize * 100.0) / n);
        return percentage;
    }
}