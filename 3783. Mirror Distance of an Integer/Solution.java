class Solution {
    public int mirrorDistance(int n) {
        StringBuilder sb = new StringBuilder(Integer.toString(n)).reverse();
        // sb.append(Integer.toString(n));
        // sb.reverse();
        return Math.abs(Integer.parseInt(sb.toString())-n);
    }
}