package Assignment2.trees;

public class TreeEx4 {

    public static class BinarySearchTree {
        private TreeNode root;

        BinarySearchTree(int rootVal) {
            root = new TreeNode(rootVal);
        }

        public void insert(int key) {
            TreeNode temp = root;
            while (true) {
                if (temp.data >= key) {
                    if (temp.left != null) temp = temp.left;
                    else {
                        temp.left = new TreeNode(key);
                        return;
                    }
                } else {
                    if (temp.right != null) temp = temp.right;
                    else {
                        temp.right = new TreeNode(key);
                        return;
                    }
                }
            }
        }

        public boolean find(int key) {
            TreeNode temp = root;
            while (true) {
                if (temp.data == key) return true;
                if (temp.data > key) {
                    if (temp.left != null) temp = temp.left;
                    else return false;
                } else {
                    if (temp.right != null) temp = temp.right;
                    else return false;
                }
            }
        }
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree(10);
        tree.insert(5);
        tree.insert(15);
        tree.insert(7);
        tree.insert(3);
        System.out.println(tree.find(3));
        System.out.println(tree.find(4));
        System.out.println(tree.find(6));
        System.out.println(tree.find(15));
    }

}
