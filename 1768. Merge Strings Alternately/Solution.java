class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int a = 0, b = 0;

        while (a < word1.length() || b < word2.length()) {
            if (a < word1.length()) sb.append(word1.charAt(a++));
            if (b < word2.length()) sb.append(word2.charAt(b++));
        }

        return sb.toString();
    }
}
