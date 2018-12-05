import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;

public class Main {

    public static class Solution {
        public boolean backspaceCompare(String S, String T) {
            if (S.length() < T.length()) {
                return backspaceCompare(T, S);
            }
            Stack<Character> stack1 = new Stack<>();
            Stack<Character> stack2 = new Stack<>();
            for (int i = 0; i < S.length(); i++) {
                helper(stack1, S, i);
                helper(stack2, T, i);
            }
            while (!stack1.isEmpty() && !stack2.isEmpty()) {
                if (!stack1.pop().equals(stack2.pop())) {
                    return false;
                }
            }
            return stack1.isEmpty() && stack2.isEmpty();
        }

        private void helper(Stack<Character> stack, String s, int i) {
            if (i >= s.length()) {
                return;
            }
            char c = s.charAt(i);
            if (c == '#') {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(c);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        double s = solution.mincostToHireWorkers(new int[] {
                3,1,10,10,1
        }, new int[] {
                4,8,2,2,7
        },3);

        System.out.println(s);
    }
}
