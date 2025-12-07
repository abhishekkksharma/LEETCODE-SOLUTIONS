class Solution {
    public int[] divisibilityArray(String word, int m) {
        int n = word.length();
        int[] arr = new int[n];
        long rem = 0;

        for (int i = 0; i < n; i++) {
            int digit = word.charAt(i) - '0';
            rem = (rem * 10 + digit) % m;

            if (rem == 0) arr[i] = 1;
            else arr[i] = 0;
        }

        return arr;
    }
}
