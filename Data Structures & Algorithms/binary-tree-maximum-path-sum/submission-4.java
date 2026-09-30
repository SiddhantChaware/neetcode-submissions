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
    int maximum = Integer.MIN_VALUE;
    public int solve(TreeNode root){
        if(root == null) return 0;
        int l = solve(root.left);
        int r = solve(root.right);

        int dono_side_sum = l + r + root.val;
        int ek_side_sum = Math.max(l,r) + root.val;
        int sirf_root_sum = root.val;

        int best_local_ans = Math.max(dono_side_sum,Math.max(ek_side_sum,sirf_root_sum));
        maximum = Math.max(maximum,best_local_ans);

        return Math.max(sirf_root_sum,ek_side_sum);
    }

    public int maxPathSum(TreeNode root) {
        if(root == null) return 0;
        solve(root);
        return maximum;    
    }
}
