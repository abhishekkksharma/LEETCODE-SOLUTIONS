class Solution {
public:
    int minOperations(vector<int>& nums, int k) {
        long long sum = 0;
        for (int n : nums) sum += n;
        return sum % k;
    }
};
