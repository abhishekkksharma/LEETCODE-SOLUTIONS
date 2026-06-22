class Solution {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> res=new ArrayList<>();
        helper(0,0,n,"",res);
        return res;
    }
    private void helper(int left, int right, int n, String s,ArrayList<String> res){
        if(s.length()==n*2){
            res.add(s);
            return;
        }
        if(left<n){
            helper(left+1,right,n,s+"(",res);
        }
        if(right<left){
            helper(left,right+1,n,s+")",res);
        } 
    }
}