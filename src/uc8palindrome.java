import java.util.Scanner;

public class uc8palindrome {

    static class Node {
        char data;
        Node next;

        Node(char data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node createLinkedList(String str) {
        Node head = null, tail = null;

        for (char ch : str.toCharArray()) {
            Node newNode = new Node(ch);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }

        }
        return head;
    }

    static Node reverse(Node head) {
        Node prev = null, curr = head, next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    static boolean isPalindrome(Node head) {
        if (head == null || head.next == null)
            return true;

        Node slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node secondHalf = reverse(slow.next);

        Node firstHalf = head;
        Node temp = secondHalf;
        boolean result = true;

        while (temp != null) {
            if (firstHalf.data != temp.data) {
                result = false;
                break;
            }
            firstHalf = firstHalf.next;
            temp = temp.next;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Palindrome Checker App");
        System.out.print("Enter a string: ");
        String input = sc.nextLine().toLowerCase();

        Node head = createLinkedList(input);

        if (isPalindrome(head))
            System.out.println("The given string is a Palindrome.");
        else
            System.out.println("The given string is NOT a Palindrome.");

        sc.close();
    }
}