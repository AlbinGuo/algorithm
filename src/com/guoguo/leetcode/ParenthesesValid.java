package com.guoguo.leetcode;

import java.util.Stack;

/**
 * 【括号有效性】 ： Leetcode-cn.com - #20
 * @Desc Parentheses Valid
 * @Result. {[()]} -> true
 * @Author guoguo
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 */
public class ParenthesesValid {

    public static boolean isValid(String s){
        // Stack替换为ArrayStack也可以达到效果
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '{' || c == '[' || c == '('){
                stack.push(c);
            }else {
                // 匹配右括号时，校验栈是否为空
                if(stack.isEmpty()) return false;
                // 获取栈顶元素
                char topChar = stack.pop();
                if(c == ')' && topChar != '(') return false;
                if(c == ']' && topChar != '[') return false;
                if(c == '}' && topChar != '{') return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "[()]";
        System.out.println(ParenthesesValid.isValid(s));
    }
}
