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

public class Codec {

    // Encodes a tree to a single string.
    public void dfsS(TreeNode root,StringBuilder sb){
        if(root == null){
            sb.append("N,");
            return;
        }
        
        sb.append(String.valueOf(root.val)).append(",");
        dfsS(root.left,sb);
        dfsS(root.right,sb);
    }

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfsS(root,sb);
        return sb.toString(); 
    }

    public TreeNode dfsD(Queue<String> queue){
        String val = queue.poll();
        if(val.equals("N")) return null;

        int node = Integer.parseInt(val);
        TreeNode root = new TreeNode(node);

        root.left = dfsD(queue);
        root.right = dfsD(queue);

        return root;
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] value = data.split(",");
        Queue<String> queue = new LinkedList(Arrays.asList(value));

        return dfsD(queue);
    }
}
