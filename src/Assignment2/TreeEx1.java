package Assignment2;

public class TreeEx1 {

    static void preOrderPrint(TreeNode node) {
        if (node == null) return;
        System.out.print(node.data + " ");
        preOrderPrint(node.left);
        preOrderPrint(node.right);
    }

    static void printTree(Tree tree) {
        preOrderPrint(tree.root);
    }

    public static void main(String[] args) {
        Tree tree = new Tree(new TreeNode(1));
        tree.root.left = new TreeNode(7);
        tree.root.right = new TreeNode(17);
        tree.root.right.left = new TreeNode(6);
        tree.root.right.right = new TreeNode(3);
        printTree(tree);
    }

}
