class MinStack {
    private Deque<Long> stack;
    private long minValue;

    public MinStack() {
        stack = new ArrayDeque<>(); 
        minValue = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        if (stack.isEmpty()) {
            minValue = val;
            stack.push(0l);
        } else {
            long diff = val - minValue;
            stack.push(diff);
            if (diff < 0) minValue = val;
        }
    }
    
    public void pop() {
        long encode = stack.pop();
        if (encode < 0) {
            minValue -= encode;
        }
    }
    
    public int top() {
        if (stack.peek() < 0) return (int) minValue;
        return (int) (stack.peek() + minValue); 
    }
    
    public int getMin() {
        return (int) minValue;
    }
}

