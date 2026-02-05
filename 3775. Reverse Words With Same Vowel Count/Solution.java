class Solution {
    public String reverseWords(String s) {
        String[] words = s.trim().split(" ");
        int first=countVowels(words[0]);
        for(int i=1;i<words.length;i++){
            if(countVowels(words[i])==first){
                words[i]=new StringBuilder(words[i]).reverse().toString();
            }
        }
        return String.join(" ",words);
    }
    private int countVowels(String str){
        int count=0;
        String vowels="aeiou";
        for(char ch: str.toCharArray()){
            if(vowels.indexOf(ch)!=-1) count++;
        }
        return count;
    }
}