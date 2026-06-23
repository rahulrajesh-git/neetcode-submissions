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
    int preidx=0;///
    Map<Integer,Integer> inmap=new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0;i<inorder.length;i++){
            inmap.put(inorder[i],i);
        }  

        return build(preorder,0,inorder.length-1);
    }

    private TreeNode build(int[] preorder,int inleft,int inright){
        if(inleft>inright){
            return null;
        }

        int rootval=preorder[preidx++];
        TreeNode root=new TreeNode(rootval);

        int idx=inmap.get(rootval);

        root.left=build(preorder,inleft,idx-1);

        root.right=build(preorder,idx+1,inright);

        return root;
    }
}
