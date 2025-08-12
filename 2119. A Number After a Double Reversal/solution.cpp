class Solution {
public:
    bool isSameAfterReversals(int num) {
        int temp = num;
        if(num<10) return true;
        int reversed=0;
        int doublereversed = 0;
        while(num>0){
            int remainder = num%10;
            reversed = reversed*10 + remainder;
            num/=10;
        }
        while(reversed>0){
            int remainder = reversed%10;
            doublereversed = doublereversed*10 + remainder;
            reversed/=10;
        }
        return doublereversed==temp;
    }
};