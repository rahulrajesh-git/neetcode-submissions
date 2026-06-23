class Solution {  //stack decreasing order
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res=new int[temperatures.length];

        Stack<int[]> stack=new Stack<>();///temp,idx

        for(int i=0;i<temperatures.length;i++){
            //int[] pair= stack.peek();//
            int t=temperatures[i];
            while(!stack.isEmpty()&& t>stack.peek()[0]){///[0]
                int[] pair=stack.peek();
                res[pair[1]]=i-pair[1];
                stack.pop();
            }
            stack.push(new int[]{t,i});
        }
        return res;
    }
}
