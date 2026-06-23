class Solution {
    public int maxProfit(int[] prices) {
        Map<String,Integer> dp=new HashMap<>();
        return dfs(0,true,prices,dp);
    }

    private int dfs(int i,boolean buying,int[] prices,Map<String,Integer> dp){
        if(i>=prices.length){
            return 0;
        }

        String key=i+"-"+buying;///
        if(dp.containsKey(key)){    /// optimization
            return dp.get(key);   
        }

        
        int res;
        int cooldown=dfs(i+1,buying,prices,dp);

        if(buying){
            int buy=dfs(i+1,false,prices,dp)-prices[i];
            res=Math.max(buy,cooldown);
        }else{
            int sell=dfs(i+2,true,prices,dp)+prices[i];
            res=Math.max(sell,cooldown);
        }

        dp.put(key,res);
        return res;///
    }
}
