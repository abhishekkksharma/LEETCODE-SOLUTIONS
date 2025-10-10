class Solution {
    public boolean judgeCircle(String moves) {
       int verticalShift = 0;
       int horizontalShift = 0;
       for(int i=0;i<moves.length();i++){
        char ch = moves.charAt(i);
        if(ch=='U') verticalShift++;
        if(ch=='D') verticalShift--;
        if(ch=='L') horizontalShift++;
        if(ch=='R') horizontalShift--;
       } 
       return horizontalShift==0 && verticalShift==0;
    }
}