class Solution {
    //cgpt
    public int minCostClimbingStairs(int[] cost) {
        int first = 0, second = 0;

        for(int i = cost.length - 1; i >= 0; i--){
            int curr = cost[i] + Math.min(first, second);
            second = first;
            first = curr;
        }

        return Math.min(first, second);
    }
}