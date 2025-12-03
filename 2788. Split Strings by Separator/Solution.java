class Solution {
    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> list = new ArrayList<>();
        for(int i=0;i<words.size();i++){
            String[] w = words.get(i).split("["+separator+"]");
            for(int j=0;j<w.length;j++){
                if(w[j].length()>0){
                    list.add(w[j]);
                }
            }
        }
        return list;
    }
}