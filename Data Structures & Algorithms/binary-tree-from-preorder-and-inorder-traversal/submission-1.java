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
    public TreeNode newTree(int[] preorder,int preStart,int preEnd,int[] inorder,
                        int inStart,int inEnd,Map<Integer,Integer> inMap){
            if(inStart > inEnd || preStart > preEnd){
                return null;
            }

            TreeNode root = new TreeNode(preorder[preStart]);
            int element = inMap.get(root.val);
            int leftside = element - inStart;

            root.left = newTree(preorder,preStart+1,preStart+leftside,inorder,
            inStart,element-1,inMap);

            root.right = newTree(preorder,preStart+leftside+1,preEnd,inorder,
            element+1,inEnd,inMap);

            return root;

                        }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> inMap = new HashMap<>();
        for(int i = 0;i < inorder.length;i++){
            inMap.put(inorder[i],i);
        }

        return newTree(preorder,0,preorder.length-1,inorder,0,inorder.length-1,inMap);
    }
}
