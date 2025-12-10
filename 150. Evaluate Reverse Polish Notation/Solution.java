class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<tokens.length;i++){
            String t=tokens[i];
            if(!(t.equals("+") || t.equals("-") ||t.equals("*") ||t.equals("/") )){
                st.push(Integer.parseInt(t));
            }
            else{
                int a=st.pop();
                int b=st.pop();
                switch(t){
                    case "+" : st.push(b+a);break;
                    case "-" : st.push(b-a);break;
                    case "*" : st.push(b*a);break;
                    case "/" : st.push(b/a);break;
                }
            }
        }
        return st.pop();
    }
}