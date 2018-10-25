import java.util.Stack;

class Solution {
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
                continue;
            }

            if (stack.empty())
                return false;

            switch (c) {
                case ')':
                    if (stack.pop() == '(')
                        continue;
                    return false;
                case ']':
                    if (stack.pop() == '[')
                        continue;
                    return false;
                case '}':
                    if (stack.pop() == '{')
                        continue;
                    return false;
            }
        }

        if (stack.empty())
            return true;

        return false;
    }
}