class Solution {
    public int calculate(String s) {
        int curr=0;
        int res=0;
        int sign=1;
        Stack<Integer> st = new Stack<>();
        for(char ch : s.toCharArray()){
            if(Character.isDigit(ch)){
                curr=curr*10+(ch-'0');
            }else if(ch=='-'){
                res+=curr*sign;
                sign=-1;
                curr=0;
            }else if(ch=='+'){
                res+=curr*sign;
                sign=1;
                curr=0;
            }else if(ch=='('){
                st.push(res);
                st.push(sign);
                sign=1;
                res=0;
                curr=0;
            }else if(ch==')'){
                res+=curr*sign;
                curr=0;
                res*=st.pop();
                res+=st.pop();
            }
        }
        res+=sign*curr;
        return res;
    }
    
}