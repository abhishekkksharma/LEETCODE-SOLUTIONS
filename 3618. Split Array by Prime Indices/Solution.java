class Solution {
    public long splitArray(int[] nums) {
        long primeSum = 0;
        long nonPrimeSum = 0;

        for (int i = 0; i < nums.length; i++) {
            if (isPrime(i)) {
                primeSum += nums[i];
            } else {
                nonPrimeSum += nums[i];
            }
        }
        return Math.abs(primeSum - nonPrimeSum);
    }

    private boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;

        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
