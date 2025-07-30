class Solution {
public:
    bool checkDivisibility(int n) {
        int temp=n;
        int sumOfDigits = 0;
        int product=1;
        while(temp>0){
            int remainder = temp%10;
            sumOfDigits+=remainder;
            product*=remainder;
            temp/=10;
        }
        int total = sumOfDigits + product;
        return (n%total==0);
    }
};