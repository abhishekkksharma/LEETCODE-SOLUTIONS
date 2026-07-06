class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]==b[0] ? Integer.compare(b[1],a[1]) : 
        Integer.compare(a[0],b[0]));


        int ans = intervals.length;
        int maxEnd = 0;

        for (int[] cur : intervals) {
            if (cur[1] <= maxEnd) {
                ans--;
            } else {
                maxEnd = cur[1];
            }
        }

        return ans;
    }
}