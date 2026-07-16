class Solution {
    class Pair{
        String s;
        int level;
        Pair(String s,int level){
            this.s=s;
            this.level=level;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set=new HashSet<>();        
        for(String s:wordList){
            set.add(s);
        }
        if(!set.contains(endWord)) return 0;
        Queue<Pair> q= new LinkedList<>();
        q.add(new Pair(beginWord,1));
        while(!q.isEmpty()){
            String s=q.peek().s;
            int level=q.peek().level;
            q.poll();
            if(s.equals(endWord)) return level;
            for(int i=0;i<s.length();i++){
                for(char ch='a';ch<='z';ch++){
                    String newS = s.substring(0, i) + ch + s.substring(i + 1);
                    if(set.contains(newS)){
                        set.remove(newS);
                        q.add(new Pair(newS,level+1));
                    }
                }
            }
        }
        return 0;
    }
}