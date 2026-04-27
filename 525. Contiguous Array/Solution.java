class Solution {
    public int findMaxLength(int[] nums) {
        int prefixSum=0;
        int max=0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            prefixSum+= nums[i]==1 ? 1:-1;
            if(map.containsKey(prefixSum)){
                max=Math.max(max,i-map.get(prefixSum));
            }else if (prefixSum==0){
                max=i+1;
            }else{
                map.put(prefixSum,i);
            }
        }
        return max;
    }
}