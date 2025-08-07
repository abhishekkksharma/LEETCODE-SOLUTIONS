class Solution {
public:
    int countDigits(int num) {
        if(num>0 && num<10) return 1;
        int temp = num;
        int count=0;
        while(num>0){
            int remainder = num%10;
            if(remainder != 0 && temp % remainder == 0) count++;
            num/=10;
        }
        return count;
    }
};