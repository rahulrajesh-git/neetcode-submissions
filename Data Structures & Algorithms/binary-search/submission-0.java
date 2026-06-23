class Solution {
    public int search(int[] nums, int target) {
        int l=0,right=nums.length-1;

        while(l<=right){
            int mid=l+(right-l)/2;

            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]<target){
                l=mid+1;
            }else{
                right=mid-1;
            }
        }
        return -1;
    }
}
