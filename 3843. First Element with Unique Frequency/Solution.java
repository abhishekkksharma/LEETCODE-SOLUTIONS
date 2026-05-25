class Solution {
    public int firstUniqueFreq(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int num:nums){
            int freq = map.getOrDefault(num,0);
            map.put(num,freq+1);
        }
        HashMap<Integer,Integer> map2 = new HashMap<>();
        for(int freq:map.values()){
            map2.put(freq, map2.getOrDefault(freq,0)+1);
        }
        for(int num:nums){
            if(map2.get(map.get(num))==1) return num;
        }
        return -1;
    }
}