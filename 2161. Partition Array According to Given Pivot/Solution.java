class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n=nums.length;
        int[] ans=new int[n];
        int left=0, right=n-1;
        int i=0,j=n-1;

        // int k=0;
        // for(int i=0;i<n;i++){
        //     if(nums[i]<pivot) ans[k++]=nums[i];
        // }
        // for(int i=0;i<n;i++){
        //     if(nums[i]==pivot) ans[k++]=nums[i];
        // }
        // for(int i=0;i<n;i++){
        //     if(nums[i]>pivot) ans[k++]=nums[i];
        // }
        while(i<n){
            if(nums[i]<pivot){
                ans[left++]=nums[i];
            }
            if(nums[j]>pivot){
                ans[right--]=nums[j];
            }
            i++;
            j--;
        }
        while(left<=right){
            ans[left++]=pivot;
        }
        return ans;
    }
}