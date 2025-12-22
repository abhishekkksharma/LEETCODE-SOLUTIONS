class Solution {
    public boolean squareIsWhite(String coordinates) {
        int x = coordinates.charAt(0)-'0';
        int y = coordinates.charAt(1)-'0';
        return (x+y)%2!=0;
    }
}