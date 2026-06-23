class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        backtrack(nums,0,res);
        return res;
    }

    public void backtrack(int[] nums,int idx,List<List<Integer>> res){
        if(idx==nums.length){
            List<Integer> temp=new ArrayList<>();
            for(int num:nums){
                temp.add(num);
            }
            res.add(temp);
            return;//
        }

        for(int i=idx;i<nums.length;i++){
            swap(nums,idx,i);
            backtrack(nums,idx+1,res);//idx+1
            swap(nums,idx,i);
        }
    }

    public void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
