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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if(root1==null && root2== null){
            return true;
        }
        if(root1==null || root2== null){
            return false;
        }
        List<Integer> leaf1 = new ArrayList<>();
        List<Integer> leaf2 = new ArrayList<>();
        
        dfs(root1, leaf1);
        dfs(root2, leaf2);

        return leaf1.equals(leaf2);
    }
    public void dfs(TreeNode root1,List<Integer> leaf1){
        if(root1 == null){
            return ;
        }
        if(root1.left ==null && root1.right ==null){
            leaf1.add(root1.val);
            
        }
        dfs(root1.left, leaf1);
        dfs(root1.right, leaf1);
        
        
    }
}