class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res=new ArrayList<>();
        backtrackdfs(0,nums,target,new ArrayList<>(),res);//new ArrayList<>()
        return res;
    }

    private void backtrackdfs(int index,int[] nums,int target,List<Integer> curr,List<List<Integer>> res){
        if(target==0){
            res.add(new ArrayList<>(curr));//new ArrayList<>(curr)
            return;
        }

        if(index==nums.length||target<0){
            return;
        }

        curr.add(nums[index]);//
        backtrackdfs(index,nums,target-nums[index],curr,res);//target-nums[index]
        curr.remove(curr.size()-1);//

        backtrackdfs(index+1,nums,target,curr,res);
    }
}
