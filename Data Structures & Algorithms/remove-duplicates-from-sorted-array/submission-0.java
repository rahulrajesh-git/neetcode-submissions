class Solution {
    public int removeDuplicates(int[] nums) {
        int idx=0;

        for(int i=0;i<nums.length;i++){
            int cur=nums[i];
            while(i<nums.length-1&&nums[i]==nums[i+1]){
                i++;
            }
            nums[idx++]=cur;
        }
        return idx;
    }
}