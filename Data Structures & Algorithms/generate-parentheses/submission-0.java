class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res=new ArrayList<>();

        backtrack(res,new StringBuilder(),0,0,n);
        return res;
    }

    private void backtrack(List<String> res,StringBuilder sb,int open,int closed,int n){
        if(sb.length()==2*n){// 2*n
            res.add(sb.toString());
        }

        if(open<n){
            sb.append("(");
            backtrack(res,sb,open+1,closed,n);
            sb.deleteCharAt(sb.length()-1);
        }

        if(closed<open){
            sb.append(")");
            backtrack(res,sb,open,closed+1,n);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
