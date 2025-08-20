class Solution {
public:
    int findFinalValue(vector<int>& nums, int original) {
        for(int i=0;i<nums.size();i++){
            for(int num : nums){
                if(num==original) original*=2;
            }
        }
        return original;
    }
};