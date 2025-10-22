class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class MaximumDepth {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = maxDepth(root.left);

        int rightDepth = maxDepth(root.right);

        return Math.max(leftDepth, rightDepth) + 1;
    }

    public static void main(String[] args) {
        MaximumDepth solver = new MaximumDepth();

        TreeNode root1 = new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20,
                        new TreeNode(15),
                        new TreeNode(7)));
        int depth1 = solver.maxDepth(root1);
        System.out.println("Example 1 Input: [3,9,20,null,null,15,7]");
        System.out.println("Output: " + depth1);
        System.out.println("-------------------------");


        TreeNode root2 = new TreeNode(1,
                null,
                new TreeNode(2));
        int depth2 = solver.maxDepth(root2);
        System.out.println("Example 2 Input: [1,null,2]");
        System.out.println("Output: " + depth2);
        System.out.println("-------------------------");

        TreeNode root3 = null;
        int depth3 = solver.maxDepth(root3);
        System.out.println("Example 3 Input: []");
        System.out.println("Output: " + depth3);
    }
}