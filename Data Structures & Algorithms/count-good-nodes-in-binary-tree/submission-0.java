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
    public int goodNodes(TreeNode root) {
        return dfs(root,root.val);
    }

    public int dfs(TreeNode node,int maxsofar){
        if(node==null){
            return 0;
        }

        int cnt=0;

        if(node.val>=maxsofar){
            cnt=1;
        }

        maxsofar=Math.max(maxsofar,node.val);
        cnt+=dfs(node.left,maxsofar);
        cnt+=dfs(node.right,maxsofar);

        return cnt;
    }
}
