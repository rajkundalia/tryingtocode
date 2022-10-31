package interviewbit.stacksandqueues;

import java.util.Stack;

/*
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) – Push element x onto stack.
pop() – Removes the element on top of the stack.
top() – Get the top element.
getMin() – Retrieve the minimum element in the stack.
Note that all the operations have to be constant time operations.

Questions to ask the interviewer :

Q: What should getMin() do on empty stack?
A: In this case, return -1.

Q: What should pop do on empty stack?
A: In this case, nothing.

Q: What should top() do on empty stack?
A: In this case, return -1
NOTE : If you are using your own declared global variables, make sure to clear them out in the constructor.
 */
public class MinStack {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(5);
        minStack.push(4);
        minStack.push(6);
        System.out.println(minStack.getMin());
        System.out.println(minStack.top());
        minStack.pop();
        minStack.pop();
        System.out.println(minStack.getMin());
    }

    Stack<Integer> stack;
    int min = 0;

    public MinStack() {
        stack = new Stack<>();
    }

    /*
        topval (stack's top) = 2*x - min
        topval = 2 * currentMinimum - previousMinimum
        previousMinimum = 2 * currentMinimum - topval
     */
    public void push(int x) {
        if (stack.empty()) {
            min = x;
            stack.push(x);
            return;
        }
        if (x < min) {
            stack.push(2 * x - min);
            min = x;
        } else {
            stack.push(x);
        }
    }

    public void pop() {
        if (stack.empty()) return;
        if (stack.peek() < min) {
            int previousMinimum = 2 * min - stack.peek();
            min = previousMinimum;
            stack.pop();
        } else {
            stack.pop();
        }
    }

    public int top() {
        if (stack.empty()) return -1;
        if (stack.peek() < min) {
            return min;
        }
        return stack.peek();
    }

    public int getMin() {
        if (stack.empty()) return -1;
        return min;
    }
}
