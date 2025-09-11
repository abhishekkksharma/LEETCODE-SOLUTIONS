class Solution {
    public int maxFreqSum(String s) {
        int[] freq = new int[26]; // frequency of each letter
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        
        String vowels = "aeiou";
        int maxVowel = 0;
        int maxConsonant = 0;
        
        for (int i = 0; i < 26; i++) {
            if (freq[i] == 0) continue;
            char c = (char) ('a' + i);
            if (vowels.indexOf(c) != -1) {
                maxVowel = Math.max(maxVowel, freq[i]);
            } else {
                maxConsonant = Math.max(maxConsonant, freq[i]);
            }
        }
        
        return maxVowel + maxConsonant;
    }
}
