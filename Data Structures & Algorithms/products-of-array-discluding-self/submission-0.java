class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] temp=new int[nums.length];

        for(int i=0;i<nums.length;i++){
            int num=1;
            for(int j=0;j<nums.length;j++){
                if(j==i){
                    continue;
                }
                num*=nums[j];
            }
            temp[i]=num;
        }
        return temp;
    }
}  
