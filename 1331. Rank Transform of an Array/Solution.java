class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] dup=Arrays.copyOf(arr,arr.length);
        Arrays.sort(dup);
        HashMap<Integer,Integer> map=new HashMap<>();
        int k=1;
        for(int i=0;i<dup.length;i++){
            if(!map.containsKey(dup[i]))
                map.put(dup[i],k++);
        }
        for(int i=0;i<arr.length;i++){
            arr[i]=map.get(arr[i]);
        }
        return arr;
    }
}