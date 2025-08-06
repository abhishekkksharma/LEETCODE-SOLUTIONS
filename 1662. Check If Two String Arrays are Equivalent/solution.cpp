class Solution {
public:
    bool arrayStringsAreEqual(vector<string>& word1, vector<string>& word2) {
        string first,second;
        for(string w : word1 ) first+=w;
        for(string w : word2 ) second+=w;
        return first==second;
        
    }
};