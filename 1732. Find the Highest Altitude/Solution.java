class Solution {
    public int largestAltitude(int[] gain) {
        int n = gain.length;
        int temp=0;
        int highest=0;
        for(int i=0;i<n;i++){
            temp+=gain[i];
            if(temp>highest) highest=temp;
        }
        return highest;
    }
}