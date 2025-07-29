class Solution {
public:
    int findNumbers(vector<int>& nums) {
        int evendigits=0;
        for(int n : nums){
            int count=0;
            if(n==0) count=1;
            while(n>0){
                count++;
                n/=10;
            }
            if(count%2==0){
                evendigits++;
            }
        }
        return evendigits;
    }
};