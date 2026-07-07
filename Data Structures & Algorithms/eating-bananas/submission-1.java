class Solution {
    public int minEatingSpeed(int[] piles, int h) {
       int l=1;
       int r=0;//should update to max

       //to find max **
       for(int pile:piles){
        r=Math.max(r,pile);
       } 

       int res=r;

       while(l<=r){
        int k=(l+r)/2;

        int totaltime=0;//
        for(int i=0;i<piles.length;i++){
            totaltime+=Math.ceil((double)piles[i]/k);///double** full line
        }
        if(totaltime<=h){//<=h = and h**
            res=k;
            r=k-1;
        }else{
            l=k+1;
        }
       }

       return res;
    }
}
