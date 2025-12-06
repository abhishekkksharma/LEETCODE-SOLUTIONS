class Solution {
    public long sumAndMultiply(int n) {
        if (n == 0) return 0;         
        StringBuilder sb = new StringBuilder();
        int sum = 0;
        while (n > 0) {
            int rem = n % 10;
            if (rem != 0) {
                sb.append(rem);
                sum += rem;
            }
            n /= 10;
        }
        sb.reverse();
        long x = (sb.length() == 0) ? 0 : Long.parseLong(sb.toString());
        return x * sum;
    }
}
