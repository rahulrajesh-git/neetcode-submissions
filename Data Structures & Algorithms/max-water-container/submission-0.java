class Solution {
    public int maxArea(int[] heights) {
        int left=0;
        int right=heights.length-1;
        int res=0,container;
        while(left<right){
            container=(right-left)*Math.min(heights[left],heights[right]);
            res=Math.max(res,container);

            if(heights[left]<heights[right]){
                left++;
            }
            else{
                right--;
            }

        }

        return res;
    }
}
