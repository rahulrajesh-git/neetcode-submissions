class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();

        Arrays.sort(nums);//

        for(int i=0;i<nums.length;i++){
            int left=i+1;//       we keep current element same and scan from next element
            int right=nums.length-1;

            if(i>0 && nums[i]==nums[i-1]){//prevents same answers
                continue;
            }

            while(left<right){
                int sum=nums[i]+nums[left]+nums[right];//nums[i]  is current element left is next and right is last

                if(sum==0){
                    res.add(Arrays.asList(nums[i],nums[left],nums[right]));//
                    left++;//
                    right--;//
                    while(left<right && nums[left]==nums[left-1]){
                        left++;
                    }
                    while(left<right && nums[right]==nums[right+1]){
                        right--;
                    }
                }
                    else if(sum<0){
                        left++;
                    }
                    else{
                        right--;
                    }
                }
        }
        return res;
    }
}
