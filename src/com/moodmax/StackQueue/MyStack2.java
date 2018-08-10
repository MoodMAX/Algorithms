package com.moodmax.StackQueue;

import java.util.Stack;

public class MyStack2 {

    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public MyStack2() {
        this.stackData = new Stack<Integer>();
        this.stackMin = new Stack<Integer>();
    }

    public void push(int newNum) {
        if(this.stackMin.isEmpty()) {
            this.stackMin.push(newNum);
        } else if (newNum <= this.getMin()) {
            this.stackMin.push(newNum);
        } else {
            int num = this.stackMin.peek();
            this.stackMin.push(num);
        }
        this.stackData.push(newNum);
    }

    public int pop() {
        if(this.stackData.isEmpty()) {
            throw new RuntimeException("Your stack is empty.");
        }
        this.stackMin.pop();
        return this.stackData.pop();
    }

    public int getMin() {
        if(this.stackMin.isEmpty()) {
            throw new RuntimeException("Your stack is empty.");
        }
        return this.stackMin.peek();
    }

    public static void main(String[] args) {
        MyStack2 stack2 = new MyStack2();
        stack2.push(3);
        stack2.push(4);
        stack2.push(5);
        stack2.push(1);
        stack2.push(2);
        stack2.push(1);

        for(int i: stack2.stackMin) {
            System.out.println(i);
        }
    }
}
