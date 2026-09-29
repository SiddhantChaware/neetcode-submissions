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
    public void dfs(TreeNode root,List<Integer> lst){
        if(root == null) return;

        dfs(root.left,lst);
        lst.add(root.val);
        dfs(root.right,lst);
    }

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> lst = new ArrayList<>();
        dfs(root,lst);
        return lst.get(k-1);    
    }
}
