#include <numeric> // for std::gcd

class Solution {
public:
    int gcdOfOddEvenSums(int n) {
        int oddSum = 0, evenSum = 0;
        
        for (int i = 1, oddCount = 0, evenCount = 0; oddCount < n || evenCount < n; i++) {
            if (i % 2 == 0 && evenCount < n) {
                evenSum += i;
                evenCount++;
            } else if (i % 2 == 1 && oddCount < n) {
                oddSum += i;
                oddCount++;
            }
        }

        return std::gcd(oddSum, evenSum);
    }
};
