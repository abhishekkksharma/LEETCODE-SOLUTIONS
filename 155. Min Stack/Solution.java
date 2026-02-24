class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;
    public MinStack() {
        this.stack=new Stack<>();
        this.minStack=new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if(minStack.isEmpty() || val<=minStack.peek()){
            minStack.push(val);
        }
    }
    
    public void pop() {
        if(stack.isEmpty()) return;
        int removed = stack.pop();
        if(removed == minStack.peek()){
            minStack.pop();
        }
    }
    
    public int top() {
        return stack.isEmpty()? 0:stack.peek();
    }
    
    public int getMin() {
        return minStack.isEmpty()? 0: minStack.peek();
    }
}