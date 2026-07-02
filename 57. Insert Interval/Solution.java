class Solution {
    public int[][] insert(int[][] intervals, int[] newintervals) {
        int i=0;
        int n=intervals.length;
        ArrayList<int[]> list = new ArrayList<>();

        while(i<n && intervals[i][1] < newintervals[0]){
            list.add(intervals[i]);
            i++;
        }

        while(i<n && intervals[i][0]<=newintervals[1]){
            newintervals[0]=Math.min(newintervals[0],intervals[i][0]);
            newintervals[1]=Math.max(newintervals[1],intervals[i][1]);
            i++;
        }
        list.add(newintervals);
        while(i<n ){
            list.add(intervals[i]);
            i++;
        }
        return list.toArray(new int[list.size()][]);

    }
}