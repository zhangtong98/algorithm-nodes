package com.zhang.leetCode.easy;

import java.util.Stack;

/**
     给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
     有效字符串需满足：
     左括号必须用相同类型的右括号闭合。
     左括号必须以正确的顺序闭合。
     注意空字符串可被认为是有效字符串。
     示例 1:
     输入: "()"
     输出: true
     示例 2:
     输入: "()[]{}"
     输出: true
     示例 3:
     输入: "(]"
     输出: false
     示例 4:
     输入: "([)]"
     输出: false
     示例 5:
     输入: "{[]}"
     输出: true
 */
public class IsValid {

    public static void main(String[] args) {
        String s = "(([]){})";
        System.out.println(isValidV3(s));
    }

    public static boolean isValidV3(String s){
        if (s.length() % 2 == 1) return false;
        if (s.length() == 0) return true;
        char[] cs = new char[s.length()];
        int top = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{'){
                cs[top++] = c;
                continue;
            }
            if (top<1) return false;
            switch (c){
                case ')':
                    if (cs[--top] != '(') return false;
                    break;
                case ']':
                    if (cs[--top] != '[') return false;
                    break;
                case '}':
                    if (cs[--top] != '{') return false;
                    break;
            }
        }
        return top == 0;
    }

    public static boolean isValidV2(String s){
        if (s.length() % 2 == 1) return false;

        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ')' && s.charAt(i) != '}' && s.charAt(i) != ']') {
                stack.push(s.charAt(i));
            } else if (s.charAt(i) == ')'){
                if (stack.isEmpty() || !(stack.peek() == '('))
                    return false;
                stack.pop();
            }else if (s.charAt(i) == ']'){
                if (stack.isEmpty() || !(stack.peek() == '['))
                    return false;
                stack.pop();
            }else if (s.charAt(i) == '}'){
                if (stack.isEmpty() || !(stack.peek() == '{'))
                    return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    public static boolean isValid(String s) {
        if (s.length() % 2 == 1) return false;
        while (s.contains("()") || s.contains("[]") || s.contains("{}")){
            s = s.replaceAll("\\(\\)","");
            s = s.replaceAll("\\{\\}","");
            s = s.replaceAll("\\[\\]","");
        }
        return s.isEmpty();
    }
}
