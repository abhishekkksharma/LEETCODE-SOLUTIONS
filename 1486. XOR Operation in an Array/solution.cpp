class Solution {
public:
    int xorOperation(int n, int start) {
        int wholeXor=0;
        for(int i=0;i<n;i++){
            wholeXor^=(start + 2 * i);
        }
        return wholeXor;
    }
};