class Solution {
    public int secondHighest(String s) {
        int largest = -1;
        int secondLarge = -1;
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >= '0' && ch <= '9') { 
                int num = ch - '0';
                
                if (num > largest) {
                    secondLarge = largest;
                    largest = num;
                } else if (num > secondLarge && num < largest) {
                    secondLarge = num;
                }
            }
        }
        
        return secondLarge;
    }
}
