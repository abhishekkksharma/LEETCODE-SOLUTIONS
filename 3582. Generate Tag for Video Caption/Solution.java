class Solution {
    public String generateTag(String caption) {
        caption = caption.trim(); 
        if (caption.isEmpty()) return "#";

        StringBuilder sb = new StringBuilder("#");
        boolean capitalizeNext = false;

        for (int i = 0; i < caption.length(); i++) {
            char ch = caption.charAt(i);

            if (ch == ' ') {
                capitalizeNext = true;
                continue;
            }

            if (capitalizeNext) {
                sb.append(Character.toUpperCase(ch));
                capitalizeNext = false;
            } else {
                sb.append(Character.toLowerCase(ch));
            }
            if(sb.length()==100) break;
        }

        return sb.toString();
    }
}
