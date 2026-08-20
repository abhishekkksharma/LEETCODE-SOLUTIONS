class Solution {
    public int[] resultArray(int[] nums) {
        ArrayList<Integer> l1=new ArrayList<>();
        ArrayList<Integer> l2=new ArrayList<>();
        l1.add(nums[0]);
        l2.add(nums[1]);
        int i=2;
        while(i<nums.length){
            if(l1.get(l1.size()-1)>l2.get(l2.size()-1)){
                l1.add(nums[i]);
            }else{
                l2.add(nums[i]);
            }
            i++;
        }
        int j=0;
        for(int k=0;k<l1.size();k++){
            nums[j++]=l1.get(k);
        }
        for(int k=0;k<l2.size();k++){
            nums[j++]=l2.get(k);
        }
        return nums;
    }
}