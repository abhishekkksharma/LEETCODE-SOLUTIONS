class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums,0,nums.length-1);
        return nums;
    }
    private void mergeSort(int[] arr,int left,int right){
        if(left>=right) return;
        int mid = left+(right-left)/2;
        mergeSort(arr,left, mid);
        mergeSort(arr,mid+1, right);
        merge(arr,left,mid,right);
    }
    private void merge(int[] arr,int left,int mid,int right){
        int i=left;
        int j=mid+1;
        int[] res = new int[right-left+1];
        int k=0;
        while(i<=mid && j<=right){
            res[k++]=arr[i]<arr[j]?arr[i++]:arr[j++];
        }
        while(i<=mid){
            res[k++]=arr[i++];
        }
        while(j<=right){
            res[k++]=arr[j++];
        }
        for(int temp=0;temp<res.length;temp++){
            arr[left+temp]=res[temp];
        }
    }
}