class Solution {
    public String longestCommonPrefix(String[] strs) {

        String prefix = "";

        for (int i = 0; i < strs[0].length(); i++) {

            char ch = strs[0].charAt(i);

            for (String s : strs) {

                if (i == s.length() || s.charAt(i) != ch) {
                    return prefix;
                }
            }

            prefix += ch;
        }

        return prefix;
    }
}