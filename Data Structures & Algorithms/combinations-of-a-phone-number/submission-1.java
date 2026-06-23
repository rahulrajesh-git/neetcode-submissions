class Solution {
    List<String> res=new ArrayList<>();
    String[] digitstochar= {"","","abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};// String[]

    public List<String> letterCombinations(String digits) {
       if(digits.isEmpty()){
        return res;
       }

       backtrack(0,"",digits);
       return res;
    }

    private void backtrack(int i,String curstring,String digits){//
        if(curstring.length()==digits.length()){
            res.add(curstring);
            return;
        }

        String chars=digitstochar[digits.charAt(i)-'0'];//
        for (char c:chars.toCharArray()){//toCharArray()
            backtrack(i+1,curstring+c,digits);//
        }
    }
}
