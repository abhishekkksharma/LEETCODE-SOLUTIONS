class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] arr = new int[2];
        arr[0]=firstOcc(nums,target);
        arr[1]=lastOcc(nums,target);
        return arr;
    }
    private int firstOcc(int[] nums, int target){
        int start=0;
        int end = nums.length-1;
        int idx=-1;
        while(start<=end){
            int mid = start+(end-start)/2;
            if(nums[mid]>=target) end=mid-1;
            else start=mid+1;
            if(nums[mid]==target) idx=mid;
        }
        return idx;
    }
    private int lastOcc(int[] nums, int target){
        int start=0;
        int end = nums.length-1;
        int idx=-1;
        while(start<=end){
            int mid = start+(end-start)/2;
            if(nums[mid]<=target) start=mid+1;
            else end=mid-1;
            if(nums[mid]==target) idx=mid;
        }
        return idx;
    }
}