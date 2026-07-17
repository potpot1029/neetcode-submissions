class MinStack {
    Deque<Integer> stack;
    Deque<Integer> minStack;

    public MinStack() {
        this.stack = new ArrayDeque<>(); 
        this.minStack = new ArrayDeque<>();
    }
    
    public void push(int val) {
        this.stack.push(val);

        int minVal = val;
        if (!this.minStack.isEmpty()) minVal = Math.min(val, this.minStack.peek());
        this.minStack.push(minVal);
    }
    
    public void pop() {
        this.stack.pop();
        this.minStack.pop();
    }
    
    public int top() {
        return this.stack.peek(); 
    }
    
    public int getMin() {
        return this.minStack.peek();
    }
}
