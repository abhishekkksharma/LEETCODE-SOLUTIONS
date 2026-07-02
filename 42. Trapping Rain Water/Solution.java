class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int[] preffix = new int[n];
        int[] suffix = new int[n];
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            max=Math.max(max,height[i]);
            preffix[i]=max;
        }
        max=Integer.MIN_VALUE;
        for(int i=n-1;i>=0;i--){
            max=Math.max(max,height[i]);
            suffix[i]=max;
        }
        int count=0;

        for(int i=0;i<n;i++){
            int min=Math.min(preffix[i],suffix[i]);
            count+=min-height[i];
        }
        return count;
    }
}