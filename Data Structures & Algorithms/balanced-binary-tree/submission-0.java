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
    public boolean isBalanced(TreeNode root) {
        return dfssearch(root)!=-1;
    }

    private int dfssearch(TreeNode root){
        if(root==null){
            return 0;
        }

        int lh=dfssearch(root.left);
        if(lh==-1) return -1;//optimization
        int rh=dfssearch(root.right);
        if(rh==-1) return -1;//optimization

        
        if(Math.abs(lh-rh)>1) return -1;

        return 1+Math.max(lh,rh);

    }
}
