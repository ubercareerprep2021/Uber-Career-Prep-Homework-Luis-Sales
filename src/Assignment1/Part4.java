package Assignment1;

import java.util.Stack;

public class Part4 {

    static class MyNode {
        int val;
        MyNode next;

        MyNode(int val) {
            this.val = val;
        }
    }

    static class MyLinkedList {
        private MyNode start;
        private MyNode end;
        private int size;

        MyLinkedList() {
            start = new MyNode(-1);
            end = start;
            size = 0;
        }

        void push(MyNode node) {
            end.next = node;
            end = end.next;
            size++;
        }

        MyNode pop() {
            if (size <= 0) return null;
            size--;
            if (start.next == end) {
                MyNode returnNode = end;
                end = start;
                start.next = null;
                return returnNode;
            } else {
                MyNode temp = start;
                while (temp.next != end) {
                    temp = temp.next;
                }
                MyNode returnNode = temp.next;
                temp.next = null;
                end = temp;
                return returnNode;
            }
        }

        int size() {
            return size;
        }

        void insert(int index, MyNode node) {
            if (size == 0 || index == size) {
                push(node);
            } else if (index == 0) {
                MyNode bkp = start.next;
                start.next = node;
                node.next = bkp;
            } else if (index > size || index < 0) {
                return;
            } else {
                MyNode temp = start.next;
                for (int i = 0; i < index-1; i++) {
                    temp = temp.next;
                }
                MyNode bkp = temp.next;
                temp.next = node;
                node.next = bkp;
            }
            size++;
        }

        void remove(int index) {
            if (size == 0 || index >= size || index < 0) return;
            if (index == 0) {
                start.next = start.next.next;
            } else {
                MyNode temp = start.next;
                for (int i = 0; i < index-1; i++) {
                    temp = temp.next;
                }
                temp.next = temp.next.next;
            }
            size--;
        }

        MyNode elementAt(int index) {
            if (size == 0 || index >= size || index < 0) return null;
            if (index == 0) return start.next;
            MyNode temp = start.next;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            return temp;
        }

        void printList() {
            MyNode temp = start.next;
            StringBuilder sb = new StringBuilder();
            while (temp != null) {
                sb.append(temp.val).append(" -> ");
                temp = temp.next;
            }
            System.out.println(sb.toString());
        }

        boolean hasCycle() {
            MyNode fast = start.next;
            MyNode slow = fast;

            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
                if (fast == slow) return true;
            }
            return false;
        }

        boolean isPalindrome() {
            if (size <= 1) return true;
            Stack<MyNode> stack = new Stack<>();
            MyNode temp = start.next;
            while (temp != null) {
                stack.push(temp);
                temp = temp.next;
            }

            temp = start;
            for (int i = 0; i < size/2; i++) {
                MyNode current = stack.pop();
                temp = temp.next;
                if (temp.val != current.val) return false;
            }
            return true;
        }

    }

    static boolean testPushBackAddsOneNode() {
        MyLinkedList list = new MyLinkedList();
        int oldSize = list.size();
        list.push(new MyNode(1));
        return list.size() - oldSize == 1;
    }

    static boolean testPopBackRemovesCorrectNode() {
        MyLinkedList list = new MyLinkedList();
        list.push(new MyNode(1));
        list.push(new MyNode(2));
        list.push(new MyNode(3));

        return list.pop().val == 3;
    }

    static boolean testEraseRemovesCorrectNode() {
        MyLinkedList list = new MyLinkedList();
        list.push(new MyNode(1));
        list.push(new MyNode(2));
        list.push(new MyNode(3));
        list.push(new MyNode(4));

        list.remove(0);
        list.remove(1);

        return list.elementAt(0).val == 2;
    }

    static boolean testEraseDoesNothingIfNoNode() {
        MyLinkedList list = new MyLinkedList();
        list.remove(0);

        return list.size() == 0;
    }

    static boolean testElementAtReturnNode() {
        MyLinkedList list = new MyLinkedList();
        list.push(new MyNode(1));
        list.push(new MyNode(2));
        list.push(new MyNode(3));
        list.push(new MyNode(4));

        if (list.elementAt(0).val != 1) return false;
        if (list.elementAt(1).val != 2) return false;
        if (list.elementAt(2).val != 3) return false;
        if (list.elementAt(3).val != 4) return false;

        return true;
    }

    static boolean testElementAtReturnsNoNodeIfIndexDoesNotExist() {
        MyLinkedList list = new MyLinkedList();
        list.push(new MyNode(1));
        list.push(new MyNode(2));
        list.push(new MyNode(3));
        list.push(new MyNode(4));

        if (list.elementAt(-1) != null) return false;
        if (list.elementAt(list.size()) != null) return false;

        return true;
    }

    static boolean checkIsPalindromeWhenPalindrome() {
        MyLinkedList list = new MyLinkedList();
        list.push(new MyNode(1));
        list.push(new MyNode(2));
        list.push(new MyNode(2));
        list.push(new MyNode(1));

        return list.isPalindrome();
    }

    static boolean checkIsPalindromeWhenNotPalindrome() {
        MyLinkedList list = new MyLinkedList();
        list.push(new MyNode(1));
        list.push(new MyNode(2));
        list.push(new MyNode(3));
        list.push(new MyNode(4));
        list.push(new MyNode(1));

        return !list.isPalindrome();
    }

    static boolean testSizeReturnsCorrectSize() {
        MyLinkedList list = new MyLinkedList();
        if (list.size() != 0) return false;

        list.push(new MyNode(1));
        if (list.size() != 1) return false;

        list.push(new MyNode(2));
        if (list.size() != 2) return false;

        list.push(new MyNode(3));
        if (list.size() != 3) return false;

        list.push(new MyNode(4));
        if (list.size() != 4) return false;

        return true;
    }

    public static void main(String[] args) {
        System.out.println(testPushBackAddsOneNode());
        System.out.println(testPopBackRemovesCorrectNode());
        System.out.println(testEraseRemovesCorrectNode());
        System.out.println(testEraseDoesNothingIfNoNode());
        System.out.println(testElementAtReturnNode());
        System.out.println(testElementAtReturnsNoNodeIfIndexDoesNotExist());
        System.out.println(testSizeReturnsCorrectSize());
        System.out.println(checkIsPalindromeWhenPalindrome());
        System.out.println(checkIsPalindromeWhenNotPalindrome());
    }

}
