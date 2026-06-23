/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    // bell shaped
     int maxsum=Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
       dfs(root);
       return maxsum;
    }

    private int dfs(TreeNode node){
        if(node==null){
            return 0;
        }

        int left=Math.max(0,dfs(node.left));  //avoid negative values instead take 0
        int right=Math.max(0,dfs(node.right));

        int currentpath=node.val+left+right;
        maxsum=Math.max(maxsum,currentpath);

        return node.val+Math.max(left,right);///to move left or right 

//Because:A path going upward cannot split.

//parent can only extend one direction.
    }

}
