class Solution {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        int[] freq1 = new int[101];
        int[] freq2 = new int[101];
        int[] freq3 = new int[101];
        for(int num : nums1) freq1[num]=1;
        for(int num : nums2) freq2[num]=1;
        for(int num : nums3) freq3[num]=1;
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<101;i++){
            if(freq1[i] + freq2[i] +freq3[i]>1) list.add(i);
        }
        return list;
    }
}