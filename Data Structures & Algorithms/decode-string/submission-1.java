class Solution {
    public String decodeString(String s) {
        Stack<Integer> countstack=new Stack<>();
        Stack<StringBuilder> stringstack=new Stack<>();

        StringBuilder cur=new StringBuilder();
        int num=0;

        for(char ch:s.toCharArray()){
            if(Character.isDigit(ch)){
                num= num * 10 + (ch - '0');
            }else if(ch=='['){
                countstack.push(num);
                stringstack.push(cur);

                cur=new StringBuilder();
                num=0;
            }else if(ch==']'){
                int repeat=countstack.pop();
                StringBuilder prev=stringstack.pop();

                for(int i=0;i<repeat;i++){
                    prev.append(cur);//
                }

                cur=prev;
            }else{
                cur.append(ch);
            }
        }

        return cur.toString();
    }
}