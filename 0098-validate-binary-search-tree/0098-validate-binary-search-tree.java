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
    //if res of inorder traversal is in sorted order -> Tree is a BST
    static boolean inorder(TreeNode root, long [] prev){
        
        if(root == null){
            return true;
        }
        if(!inorder(root.left, prev)){
            return false;
        }
        if(prev[0] >= root.val){
            return false;
        }
        prev[0] = root.val;
        return inorder(root.right, prev);
    }
    public boolean isValidBST(TreeNode root) {
        long [] prev = {Long.MIN_VALUE};
        
        return inorder(root, prev);
    }
}