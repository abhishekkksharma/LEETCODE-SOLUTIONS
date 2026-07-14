class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        Queue<Integer> q=new LinkedList<>();
        ArrayList<Integer> topo=new ArrayList<>();
        int[] indegree=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<prerequisites.length;i++){
            int u=prerequisites[i][0];
            int v=prerequisites[i][1];
            indegree[v]++;
            adj.get(u).add(v);
        }
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0) q.offer(i);
        }
        while(!q.isEmpty()){
            int curr=q.poll();
            topo.add(curr);
            for(int i:adj.get(curr)){
                indegree[i]--;
                if(indegree[i]==0) q.offer(i);
            }
        }
        return topo.size()==numCourses;
    }
}