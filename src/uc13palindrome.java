import java.util.*;

public class uc13palindrome {

    public static boolean iterativePalindrome(String input) {
        String s = input.replaceAll("\\s+", "").toLowerCase();
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static boolean stackPalindrome(String input) {
        String s = input.replaceAll("\\s+", "").toLowerCase();
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            stack.push(c);
        }

        for (char c : s.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }
        return true;
    }

    public static boolean dequePalindrome(String input) {
        String s = input.replaceAll("\\s+", "").toLowerCase();
        Deque<Character> deque = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            deque.addLast(c);
        }

        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Palindrome Checker App");
        System.out.println("UC13: Performance Comparison");
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        long start, end;

        start = System.nanoTime();
        boolean r1 = iterativePalindrome(input);
        end = System.nanoTime();
        long time1 = end - start;

        start = System.nanoTime();
        boolean r2 = stackPalindrome(input);
        end = System.nanoTime();
        long time2 = end - start;

        start = System.nanoTime();
        boolean r3 = dequePalindrome(input);
        end = System.nanoTime();
        long time3 = end - start;

        System.out.println("\nResults:");
        System.out.println("Iterative Result : " + r1 + " | Time: " + time1 + " ns");
        System.out.println("Stack Result     : " + r2 + " | Time: " + time2 + " ns");
        System.out.println("Deque Result     : " + r3 + " | Time: " + time3 + " ns");

        sc.close();
    }
}