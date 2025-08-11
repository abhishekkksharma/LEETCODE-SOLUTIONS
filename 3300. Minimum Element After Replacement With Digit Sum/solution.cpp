class Solution {
private:
    int sumOfDigits(int n){
        if(n<10) return n;
        return n%10 + sumOfDigits(n/10);
    }
public:
    int minElement(vector<int>& nums) {
        int min = INT_MAX;
        for(int num : nums){
            num = sumOfDigits(num);
            if(num<min) min = num;
        }
        return min;
    }
};