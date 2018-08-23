import java.util.Stack;

/**
 * @program: Stack
 * @description:
 * @author: fqivy
 * @create: 2018-07-24 14:09
 */
public class Solution {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            //如果是左边括号就压栈
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                //如果不是左括号，且stack为空，则返回false
                if (stack.isEmpty()) {
                    return false;
                }
                char topChar = stack.pop();
                //如果是右边括号且不匹配，返回false
                if (c == ')' && topChar != '(') {
                    return false;
                }
                if (c == ']' && topChar != '[') {
                    return false;
                }
                if (c == '}' && topChar != '{') {
                    return false;
                }
            }
        }
        //如果循环结束，stack不为空，不匹配，返回false，stack为空，则刚好匹配，返回true
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isValid("(){}[]"));
        System.out.println(new Solution().isValid("(]"));
    }
}