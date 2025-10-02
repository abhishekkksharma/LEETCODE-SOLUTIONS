class Solution {
    public boolean strongPasswordCheckerII(String password) {
        if (password.length() < 8) return false;

        boolean hasLower = false;
        boolean hasUpper = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        String specials = "!@#$%^&*()-+";

        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);

            if (ch >= 'a' && ch <= 'z') hasLower = true;
            else if (ch >= 'A' && ch <= 'Z') hasUpper = true;
            else if (ch >= '0' && ch <= '9') hasDigit = true;
            else if (specials.indexOf(ch) != -1) hasSpecial = true;

            if (i > 0 && ch == password.charAt(i - 1)) {
                return false;
            }
        }
        return hasLower && hasUpper && hasDigit && hasSpecial;
    }
}
