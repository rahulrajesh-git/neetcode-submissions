class Solution {
    public int maxProfit(int[] prices) {
        int left=0,right=1;
        int maxprofit=0;

        while(right<prices.length){
            if(prices[left]<prices[right]){
                int profit=prices[right]-prices[left];
                maxprofit=Math.max(profit,maxprofit);
            }
            else{
                left=right;
            }
            right++;
        }
        return maxprofit;
    }
}
