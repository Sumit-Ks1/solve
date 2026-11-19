import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;


public class LongestValidParentheses {

    public static int longestValidParentheses(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        int best = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);                       // new base
                } else {
                    best = Math.max(best, i - stack.peek());
                }
            }
        }
        return best;
    }

    public static void main(String[] args) {
        String[] inputs = {"(()", ")()())", "", "()(())", "())((())", "(((("};
        int[] expected = {2, 4, 0, 6, 4, 0};

        for (int i = 0; i < inputs.length; i++) {
            int result = longestValidParentheses(inputs[i]);
            String status = result == expected[i] ? "PASS" : "FAIL";
            System.out.println(status + "  Input: \"" + inputs[i] + "\"  Output: "
                    + result + "  Expected: " + expected[i]);
        }

        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter a parentheses string (or press Enter to skip): ");
        if (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (!line.isEmpty()) {
                System.out.println("Longest valid parentheses length: "
                        + longestValidParentheses(line));
            }
        }
        sc.close();
    }
}