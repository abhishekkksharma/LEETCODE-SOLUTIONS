class Solution {
private: 
    bool checkPalindrome(string s){
        int left = 0, right = s.size()-1;
        while(left<=right){
            if(s[left]!=s[right]) return false;
            left++;
            right--;
        }
        return true;
    }
public:

    string firstPalindrome(vector<string>& words) {
        for(string word : words){
            if(checkPalindrome(word)) return word;
        }
        return "";
    }
};