class Solution {
public:
    bool isPalindrome(int x) {
        if (x<0 || (x!=0 && x%10==0)) {
            return false;
        }
        int rev = 0, rem;
        while (x>rev) {
            rem = x%10;
            rev = rev*10 + rem;
            x /=10;
        }
        return x==rev || x==rev/10;
    }
};