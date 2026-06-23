class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minlen=Integer.MAX_VALUE;
        int n=nums.length;

        if(n==1){
            if(nums[0]>=target){
                return 1;
            }else{
                return 0;
            }
            
        }

        for(int l=0;l<n-1;l++){
             if(nums[l]>=target){
                return 1;
            }
            int sum=nums[l];
           
            for(int r=l+1;r<n;r++){
                sum+=nums[r];
                if(sum>=target){
                    minlen=Math.min(minlen,r-l+1);
                }
            }
            if(nums[n-1]==target){
                return 1;
            }
        }
        return minlen==Integer.MAX_VALUE?0:minlen;
    }
}