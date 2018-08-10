package com.moodmax.StackQueue;

import java.util.Stack;

public class ReverseStack {

    // 将栈stack的栈底元素返回并移除
    public static int getAndRemoveLastElement(Stack<Integer> stack) {
        int result = stack.pop();
        if(stack.isEmpty()) {
            return result;
        } else {
            int last = getAndRemoveLastElement(stack);
            stack.push(result);
            return last;
        }
    }

    public static void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int i = getAndRemoveLastElement(stack);
        reverse(stack);
        stack.push(i);
    }

    //test sample
    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(5);
        s.push(4);
        s.push(3);
        s.push(2);
        s.push(1);

        reverse(s);

        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
    }
}
