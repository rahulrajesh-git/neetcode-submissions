class Solution {
    public String longestCommonPrefix(String[] strs) {
        for(int i=0;i<strs[0].length();i++){//iterate through index of first string
            for(String s:strs){
                if(i==s.length()||s.charAt(i)!=strs[0].charAt(i)){//we compare with 1st string only
                    return s.substring(0,i);
                }
            }
           
        }
         return strs[0];
    }
}