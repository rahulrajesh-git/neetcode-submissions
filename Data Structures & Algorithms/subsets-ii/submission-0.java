class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> subset=new ArrayList<>();

        backtrack(nums,0,subset,res);
        return res;
    }

    public void backtrack(int[] nums,int i,List<Integer> subset,List<List<Integer>> res){
        if(i==nums.length){
            res.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[i]);
        backtrack(nums,i+1,subset,res);

        subset.remove(subset.size()-1);
        int idx=i+1;

        while(idx<nums.length&&nums[idx]==nums[idx-1]){
            idx++;
        }

        
        backtrack(nums,idx,subset,res);
    }
}
