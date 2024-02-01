/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    int count = 0;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode res = dfs(root, p, q);
        return count == 2 ? res : null;
    }
    
    private TreeNode dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return root;
        TreeNode l = dfs(root.left, p, q);
        TreeNode r = dfs(root.right, p, q);
        if (root == p || root == q) {
            count++; 
            return root;
        }
        if(l==null && r==null){
            return null;
        }
        if(l!=null && r!=null){
            return root;
        }
        if(l==null){
            return r;
        }else{
            return l;
        }
        
    }
    
}