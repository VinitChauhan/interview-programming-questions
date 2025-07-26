package org.example.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParenthesesSequence {
    public static void main(String[] args) {
        String str = "{[()]}";
//        System.out.println("Is valid sequence : " + isValid(str));
        System.out.println("Is valid sequence : " + isValidWithCase(str));
    }

    private static boolean isValidWithCase(String str) {
        if (str.length() == 0 || str.length() % 2 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            switch (c) {
                case '(':
                case '[':
                case '{':
                    stack.push(c);
                    break;
                case ')':
                    if (stack.isEmpty() || stack.pop() != '(')
                        return false;
                    break;
                case ']':
                    if (stack.isEmpty() || stack.pop() != '[')
                        return false;
                    break;
                case '}':
                    if (stack.isEmpty() || stack.pop() != '{')
                        return false;
                    break;
                default:
                    return false;
            }
        }
        return stack.isEmpty();
    }




    private static boolean isValid(String str) {
        if (str.length() == 0 || str.length() % 2 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> mapping = new HashMap<>();
        mapping.put(')', '(');
        mapping.put(']', '[');
        mapping.put('}', '{');

        for (char c : str.toCharArray()) {
            if (mapping.containsKey(c)) {
                if (stack.isEmpty() || stack.pop() != mapping.get(c)) {
                    return false;
                }
            } else {
                stack.push(c);
            }

        }
        return stack.isEmpty();
    }
}
