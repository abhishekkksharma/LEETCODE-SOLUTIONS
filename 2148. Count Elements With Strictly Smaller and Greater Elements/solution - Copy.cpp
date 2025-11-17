class Solution {
public:
    int countElements(vector<int>& nums) {
        sort(nums.begin(),nums.end());
        int min=nums[0];
        int max=nums[nums.size()-1];
        int count=0;
        for(int i=0;i<nums.size();i++){
            if(nums[i]<max && nums[i]>min) count++;
        }
        return count;
    }
};