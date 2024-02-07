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
    public int pathSum(TreeNode root, int targetSum) {
        return pathSumHelper(root, targetSum, new HashMap<>(), 0);
    }

    private int pathSumHelper(TreeNode node, long targetSum, Map<Long, Integer> pathCount, long currentSum) {
        if (node == null) {
            return 0;
        }

        currentSum += node.val;
        int totalPaths = pathCount.getOrDefault(currentSum - targetSum, 0);

        if (currentSum == targetSum) {
            totalPaths++;
        }

        pathCount.put(currentSum, pathCount.getOrDefault(currentSum, 0) + 1);

        totalPaths += pathSumHelper(node.left, targetSum, pathCount, currentSum);
        totalPaths += pathSumHelper(node.right, targetSum, pathCount, currentSum);

        pathCount.put(currentSum, pathCount.get(currentSum) - 1);

        return totalPaths;
    }
}