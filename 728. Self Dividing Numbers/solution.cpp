class Solution {
public:
    int checkNum(int n){
        int temp=n;
        while(temp>0){
            int remainder = temp%10;
            if(remainder == 0 || n%remainder!=0) return false;
            temp/=10;
        }
        return true;
    }
    vector<int> selfDividingNumbers(int left, int right) {
        vector<int> result;
        for(int i=left;i<=right;i++){
            int temp=i;
            if(checkNum(i)) result.push_back(i);
        }
        return result;
    }
};