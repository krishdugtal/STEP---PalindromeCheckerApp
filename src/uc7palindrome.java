import java.util.Deque;
import java.util.LinkedList;

public class uc7palindrome {

    public static boolean isPalindrome(String input) {
        // Create Deque
        Deque<Character> deque = new LinkedList<>();

        // Insert characters into deque
        for (char ch : input.toCharArray()) {
            deque.addLast(ch);   // Insert at rear
        }

        // Compare front and rear elements
        while (deque.size() > 1) {
            char front = deque.removeFirst();  // Remove from front
            char rear = deque.removeLast();    // Remove from rear

            if (front != rear) {
                return false;  // Not a palindrome
            }
        }

        return true;  // Palindrome
    }

    public static void main(String[] args) {
        String str = "madam";

        if (isPalindrome(str)) {
            System.out.println(str + " is a Palindrome.");
        } else {
            System.out.println(str + " is NOT a Palindrome.");
        }
    }
}

