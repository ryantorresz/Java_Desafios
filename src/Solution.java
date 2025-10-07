import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> resultado = new ArrayList<>();
        ajudanteInorder(root, resultado);
        return resultado;
    }

    private void ajudanteInorder(TreeNode no, List<Integer> resultado) {
        if (no == null) {
            return;
        }

        ajudanteInorder(no.left, resultado);

        resultado.add(no.val);

        ajudanteInorder(no.right, resultado);
    }

    public static void main(String[] args) {
        Solution solver = new Solution();

        TreeNode root1 = new TreeNode(1);
        root1.right = new TreeNode(2);
        root1.right.left = new TreeNode(3);

        List<Integer> resultado1 = solver.inorderTraversal(root1);
        System.out.println(resultado1);

        System.out.println("-------------------------");


        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        root2.left.left = new TreeNode(4);
        root2.left.right = new TreeNode(5);
        root2.right.right = new TreeNode(8);
        root2.left.right.left = new TreeNode(6);
        root2.left.right.right = new TreeNode(7);
        root2.right.right.left = new TreeNode(9);

        List<Integer> resultado2 = solver.inorderTraversal(root2);
        System.out.println(resultado2);
    }
}