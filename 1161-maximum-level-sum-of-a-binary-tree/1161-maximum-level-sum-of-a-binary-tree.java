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
    public int maxLevelSum(TreeNode root) {
        int result =0;
        if(root ==null){
            return result;
        }
        TreeNode curr = root;
        List<Integer> answer =new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        int max = Integer.MIN_VALUE;
        int maxlevel = 1, current = 1;
        
        while(!queue.isEmpty()){
            int level=queue.size();
            result =0;
            for(int i=0; i< level; i++){
                curr = queue.poll();
                result += curr.val;

                if(curr.left != null){
                    queue.offer(curr.left);
                }
                if(curr.right != null){
                    queue.offer(curr.right);
                }
            }
            if(result>max){
                max = result;
                maxlevel = current;
            }
            current++;
        }
        
        return maxlevel;
    }
}