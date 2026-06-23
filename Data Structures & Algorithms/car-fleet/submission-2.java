class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int [][] pair=new int[position.length][2];
        for(int i=0;i<position.length;i++){
            pair[i][0]=position[i];
            pair[i][1]=speed[i];
        }
         Arrays.sort(pair,(a,b)->Integer.compare(b[0],a[0]));///(a,b)

        Stack<Double> stack=new Stack<>();

         for(int[] p:pair){
            double currtime=(double) (target-p[0])/p[1];

            stack.push(currtime);

            if(stack.size()>=2&&stack.peek()<=stack.get(stack.size()-2)){////   if curtime less ten before ..the car reaches early than before.. so it joins the same fleet
                stack.pop();
            }

         }

         return stack.size();
    }
}
