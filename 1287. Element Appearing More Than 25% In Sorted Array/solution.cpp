class Solution {
public:
    int findSpecialInteger(vector<int>& arr) {
        int n = arr.size();
        int step = n / 4;
        for (int i = 0; i + step < n; i++) {
            if (arr[i] == arr[i + step]) {
                return arr[i];
            }
        }
        return -1;
    }
};
