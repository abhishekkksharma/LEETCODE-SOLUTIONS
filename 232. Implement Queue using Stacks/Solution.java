import java.util.Stack;

class MyQueue {
    Stack<Integer> first;
    Stack<Integer> second;

    public MyQueue() {
        first = new Stack<>();
        second = new Stack<>();
    }
    
    public void push(int x) {
        first.push(x);
    }
    
    public int pop() {
        while (!first.empty()) {
            second.push(first.pop());
        }
        int removed = second.pop();
        while (!second.empty()) {
            first.push(second.pop());
        }
        return removed;
    }
    
    public int peek() {
        while (!first.empty()) {
            second.push(first.pop());
        }
        int peek = second.peek();
        while (!second.empty()) {
            first.push(second.pop());
        }
        return peek;
    }
    
    public boolean empty() {
        return first.isEmpty();
    }
}
