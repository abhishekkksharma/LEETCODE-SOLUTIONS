class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n=nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for(int key:map.keySet()){
            if(map.get(key)>(n/3)) list.add(key);
        }
        return list;
    }
}