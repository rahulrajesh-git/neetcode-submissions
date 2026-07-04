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

 ///here we connect the left subtree and then connect right subtree at the rightmost node of left subtree
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null){
            return null;
        }
        if(root.val==key){
            return helper(root);
        }
        TreeNode dummy=root;

        while(root!=null){
            if(root.val>key){//>
                if(root.left!=null&&root.left.val==key){
                    root.left=helper(root.left);
                    break;
                }else{
                    root=root.left;
                }
            }else{
                if(root.right!=null&&root.right.val==key){
                    root.right=helper(root.right);
                    break;
                }else{
                    root=root.right;
                }
            }
        }
        return dummy;
    }

    private TreeNode helper(TreeNode root){
        if(root.left==null){
            return root.right;
        }else if(root.right==null){
            return root.left;
        }else{
            TreeNode rightnode=root.right;
            TreeNode lastright=findrightmost(root.left);///.left
            lastright.right=rightnode;
            return root.left;
        }
    }

    private TreeNode findrightmost(TreeNode root){
        if(root.right==null){
            return root;
        }

        return findrightmost(root.right);
    }
}