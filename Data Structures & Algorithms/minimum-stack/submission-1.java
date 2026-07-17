class MinStack {
    private Deque<Integer> stack;
    private Deque<Integer> minStack;

    public MinStack() {
        stack = new ArrayDeque<>(); 
        minStack = new ArrayDeque<>();
    }
    
    public void push(int val) {
        stack.push(val);

        int minVal = val;
        if (!minStack.isEmpty()) minVal = Math.min(val, minStack.peek());
        minStack.push(minVal);
    }
    
    public void pop() {
        stack.pop();
        minStack.pop();
    }
    
    public int top() {
        return stack.peek(); 
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
