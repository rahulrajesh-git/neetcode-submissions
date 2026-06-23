class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;

        int[] lis=new int[n];
        Arrays.fill(lis,1);

        for(int i=n-1;i>=0;i--){
            for(int j=i+1;j<n;j++){//<n
                if(nums[i]<nums[j]){
                    lis[i]=Math.max(lis[i],1+lis[j]);
                }
            }
        }

        int max=0;
        for(int val:lis){
            max=Math.max(max,val);
        }

        return max;
    }
}
