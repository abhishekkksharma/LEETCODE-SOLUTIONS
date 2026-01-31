class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        helper(nums,0,result, new ArrayList<>());
        return result;
    }
    private void helper(int[] nums,int index,  List<List<Integer>> result,List<Integer> subset){
        if(index==nums.length){
            result.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[index]);
        helper(nums,index+1,result,subset);
        subset.remove(subset.size()-1);
        helper(nums,index+1,result,subset);
    }
}