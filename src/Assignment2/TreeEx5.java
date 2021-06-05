package Assignment2;

import java.util.*;

public class TreeEx5 {

    public interface PhoneBook {
        int size();
        void insert(String name, long phoneNumber);
        long find(String name);
    }

    public static class StringBST {
        PhoneBookNode root;

        public void insert(String name, long phoneNumber) {
            if (root == null) {
                root = new PhoneBookNode(name, phoneNumber);
                return;
            }
            insertHelper(name, phoneNumber, root);
        }

        private void insertHelper(String name, long phoneNumber, PhoneBookNode currentNode) {
            if (currentNode == null) return;

            int comp = name.compareTo(currentNode.name);
            if (comp < 0) {
                if (currentNode.left == null) {
                    currentNode.left = new PhoneBookNode(name, phoneNumber);
                    return;
                }
                insertHelper(name, phoneNumber, currentNode.left);
            } else {
                if (currentNode.right == null) {
                    currentNode.right = new PhoneBookNode(name, phoneNumber);
                    return;
                }
                insertHelper(name, phoneNumber, currentNode.right);
            }
        }

        public long find(String name) {
            if (root == null) return -1;
            return findHelper(name, root);
        }

        private long findHelper(String name, PhoneBookNode currentNode) {
            if (currentNode == null) return -1;

            int comp = name.compareTo(currentNode.name);
            if (comp == 0) return currentNode.phoneNumber;
            if (comp < 0) {
                if (currentNode.left == null) return -1;
                return findHelper(name, currentNode.left);
            } else {
                if (currentNode.right == null) return -1;
                return findHelper(name, currentNode.right);
            }
        }
    }

    public static class PhoneBookNode {
        String name;
        long phoneNumber;
        PhoneBookNode left, right;

        PhoneBookNode(String val, long phoneNumber) {
            this.name = val;
            this.phoneNumber = phoneNumber;
        }
    }

    public static class ListPhoneBook implements PhoneBook{
        private ArrayList<PhoneBookNode> list = new ArrayList<>();

        @Override
        public int size() {
            return list.size();
        }

        @Override
        public void insert(String name, long phoneNumber) {
            PhoneBookNode newNode = new PhoneBookNode(name, phoneNumber);
            list.add(newNode);
        }

        @Override
        public long find(String name) {
            for (PhoneBookNode node : list) {
                if (node.name.equals(name)) {
                    return node.phoneNumber;
                }
            }
            return -1;
        }
    }

    public static class BinarySearchTreePhoneBook implements PhoneBook {

        StringBST bst = new StringBST();
        int size = 0;

        @Override
        public int size() {
            return size;
        }

        @Override
        public void insert(String name, long phoneNumber) {
            size++;
            bst.insert(name, phoneNumber);
        }

        @Override
        public long find(String name) {
            return bst.find(name);
        }
    }

    public static void main(String[] args) {
        BinarySearchTreePhoneBook bstPhoneBook = new BinarySearchTreePhoneBook();

        bstPhoneBook.insert("daswas", 22222);
        bstPhoneBook.insert("fdscx", 11111);
        bstPhoneBook.insert("dsfer", 33333);
        bstPhoneBook.insert("fgews", 0);
        bstPhoneBook.insert("fgb", 77777);
        bstPhoneBook.insert("qesf", 66666);
        bstPhoneBook.insert("abcd", 88888);

        System.out.println(bstPhoneBook.find("DEF"));
        System.out.println(bstPhoneBook.find("fgb"));
        System.out.println(bstPhoneBook.find("Fgb"));

        ListPhoneBook listPhoneBook = new ListPhoneBook();

        listPhoneBook.insert("daswas", 22222);
        listPhoneBook.insert("fdscx", 11111);
        listPhoneBook.insert("dsfer", 33333);
        listPhoneBook.insert("fgews", 0);
        listPhoneBook.insert("fgb", 77777);
        listPhoneBook.insert("qesf", 66666);
        listPhoneBook.insert("abcd", 88888);

        System.out.println(listPhoneBook.find("DEF"));
        System.out.println(listPhoneBook.find("fgb"));
        System.out.println(listPhoneBook.find("Fgb"));
    }

}
