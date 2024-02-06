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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        if(root==null){
            return answer;
        }
        TreeNode curr=root;
        Queue<TreeNode> graph = new LinkedList<>();
        graph.offer(root);
        
        while(!graph.isEmpty()){
            int level = graph.size();
            for(int i=0; i<level; i++){
                curr = graph.poll();
                if(i== level-1){
                    answer.add(curr.val);
                }
                if(curr.left != null){
                    graph.offer(curr.left);
                }
                if(curr.right!= null){
                    graph.offer(curr.right);
                }
                
            }
        }
            return answer;
        
    }
}