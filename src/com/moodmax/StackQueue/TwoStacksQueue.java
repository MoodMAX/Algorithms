package com.moodmax.StackQueue;

import java.util.Stack;

public class TwoStacksQueue {

    private Stack<Integer> stackPush;
    private Stack<Integer> stackPop;

    public TwoStacksQueue() {
        this.stackPush = new Stack<Integer>();
        this.stackPop = new Stack<Integer>();
    }

    // 这一步不是应该判断stackPush是否为空，若为空才可以将新数据pushNum压入stackPush吗？
    public void add(int pushNum) {
        stackPush.push(pushNum);
    }

    public int poll() {
        if(stackPop.isEmpty() && stackPush.isEmpty()) {
            throw new RuntimeException("Queue is empty.");
        } else if (stackPop.isEmpty()) {
            while(!stackPush.isEmpty()) {
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.pop();
    }

    public int peek() {
        if(stackPop.isEmpty() && stackPush.isEmpty()) {
            throw new RuntimeException("Queue is empty.");
        } else if (stackPop.isEmpty()) {
            while(!stackPush.isEmpty()) {
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.peek();
    }

    // test sample
    public static void main(String[] args) {
        TwoStacksQueue stackstoqueue = new TwoStacksQueue();
        stackstoqueue.add(5);
        stackstoqueue.add(4);
        stackstoqueue.add(3);
        stackstoqueue.add(2);
        stackstoqueue.add(1);

        System.out.println(stackstoqueue.poll());
        System.out.println(stackstoqueue.poll());
        System.out.println(stackstoqueue.poll());
        System.out.println(stackstoqueue.poll());
        System.out.println(stackstoqueue.poll());
    }
}
