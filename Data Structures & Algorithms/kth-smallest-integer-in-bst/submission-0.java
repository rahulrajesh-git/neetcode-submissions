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

    int cnt=0,res=-1;

    public int kthSmallest(TreeNode root, int k) {
        inorder(root,k);
        return res;
    }

    private void inorder(TreeNode node,int k){ //void
        if(node==null){
            return;
        }

        inorder(node.left,k);

        cnt++;

        if(cnt==k){
            res=node.val;
            return;
        }

        inorder(node.right,k);
    }
}
