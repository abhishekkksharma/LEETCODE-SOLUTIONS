class Solution {
    public int getLucky(String s, int k) {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            int val = s.charAt(i) - 'a' + 1;
            sb.append(val);
        }
        String numStr = sb.toString();
        while (k-- > 0) {
            int sum = 0;
            for (int i = 0; i < numStr.length(); i++) {
                sum += numStr.charAt(i) - '0';
            }
            numStr = String.valueOf(sum);
        }
        
        return Integer.parseInt(numStr);
    }
}
