package Assignment2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.NoSuchElementException;

public class TreeEx6 {

    static class ListPhoneBook extends TreeEx5.ListPhoneBook {

        void readAll(String fileName) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(fileName));
                String line;
                long timeStart = System.nanoTime();
                while ((line = reader.readLine()) != null) {
                    String[] elements = line.split(",");
                    insert(elements[0], Long.parseLong(elements[1]));
                }
                long timeElapsed = System.nanoTime() - timeStart;
                System.out.println("Insert took " + (timeElapsed / 1000000) + " milliseconds");
            } catch (IOException e) {
                System.out.println("Failed to read file!");
            }
        }

    }

    static class BinarySearchTreePhoneBook extends TreeEx5.BinarySearchTreePhoneBook {
        void readAll(String fileName) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(fileName));
                String line;
                long timeStart = System.nanoTime();
                while ((line = reader.readLine()) != null) {
                    String[] elements = line.split(",");
                    insert(elements[0], Long.parseLong(elements[1]));
                }
                long timeElapsed = System.nanoTime() - timeStart;
                System.out.println("Insert took " + (timeElapsed / 1000000) + " milliseconds");
            } catch (IOException e) {
                System.out.println("Failed to read file!");
            }
        }
    }

    static boolean findAll(String fileName, TreeEx5.PhoneBook phoneBook) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            long timeStart = System.nanoTime();
            int countElements = 0;
            while ((line = reader.readLine()) != null) {
                if (phoneBook.find(line) == -1) return false;
                countElements++;
            }
            long timeElapsed = System.nanoTime() - timeStart;
            if (countElements != 1000) {
                System.out.println("Didn't count 1000 elements!");
            } else {
                System.out.println("Find was called 1000 times");
            }
            System.out.println("Search took " + (timeElapsed / 1000000) + " milliseconds");
        } catch (IOException e) {
            System.out.println("Failed to read file!");
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("========== LIST PHONE BOOK ==========");
        ListPhoneBook listPhoneBook = new ListPhoneBook();
        listPhoneBook.readAll("data.csv");
        if (listPhoneBook.size() != 1000000) {
            throw new IllegalArgumentException("Did not insert the right amount of elements into the list!");
        } else {
            System.out.println("The size of the phone book is 1000000");
        }
        if (!findAll("search.txt", listPhoneBook)) {
            throw new NoSuchElementException("At least one element was not found!");
        }

        System.out.println("========== BST PHONE BOOK ==========");
        BinarySearchTreePhoneBook bstPhoneBook = new BinarySearchTreePhoneBook();
        bstPhoneBook.readAll("data.csv");
        if (bstPhoneBook.size() != 1000000) {
            throw new IllegalArgumentException("Did not insert the right amount of elements into the list!");
        } else {
            System.out.println("The size of the phone book is 1000000");
        }
        if (!findAll("search.txt", bstPhoneBook)) {
            throw new NoSuchElementException("At least one element was not found!");
        }

        /*
        Insert is faster in the list implementation because all insertions occur in O(1) time, while in the BST
        implementation, each insertion occurs in O(log(n)) time.
         */
    }

}
