class Solution {
    public int myAtoi(String s) {
        if (s == null) return 0;

        s = s.trim();
        if (s.length() == 0) return 0;

        char[] arr = s.toCharArray();
        boolean isNeg = false;
        int start = 0;
        if (arr[0] == '-' || arr[0] == '+') {
            isNeg = arr[0] == '-';
            start = 1;
        }
        long num=0;
        for (int i = start; i < arr.length; i++) {
            if (!Character.isDigit(arr[i])) break;

            num = num * 10 + (arr[i] - '0');
            if (!isNeg && num > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;

            if (isNeg && -num < Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
        }
        return isNeg? (int)-num:(int)num;
    }
}