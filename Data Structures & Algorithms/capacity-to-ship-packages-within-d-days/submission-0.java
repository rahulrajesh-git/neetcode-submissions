class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int l=0,r=0;

        for(int i=0;i<weights.length;i++){
            l=Math.max(l,weights[i]);
        }
        
        for(int i=0;i<weights.length;i++){
            r+=weights[i];
        }

        int res=r;

        while(l<=r){
            int capacity=(l+r)/2;

            if (canship(capacity,weights,days)){
                res=Math.min(res,capacity);////
                r=capacity-1;
            }else{
                l=capacity+1;
            }
        }

        return res;
    }

    private boolean canship(int capacity,int[] weights,int days){
        int ships=1;//not 0
        int curcapacity=capacity;

        for(int w:weights){
            
            if(curcapacity-w<0){
                ships++;
                curcapacity=capacity;//
            }
            curcapacity-=w;
        }
        return (ships<=days);
    }
}