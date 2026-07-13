class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        ArrayList<Integer> ans=new ArrayList<>();
        String s="123456789";
        String l=String.valueOf(low);
        String h=String.valueOf(high);
        for(int i=l.length();i<=h.length();i++){
            for(int start=0;start<=9-i;start++){
                int num=Integer.parseInt(s.substring(start,start+i));
                if(num>=low && num<=high){
                    ans.add(num);
                }
            }
        }
        return ans;
    }
}