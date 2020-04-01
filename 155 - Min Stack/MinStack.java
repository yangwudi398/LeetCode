class MinStack {
    private Stack<Integer> stack;
    private int min;

    /** initialize your data structure here. */
    public MinStack() {
        this.stack = new Stack<Integer>();
    }
    
    public void push(int x) {
        if (this.stack.empty())
            this.min = x;
        else if (x <= this.min) {
            this.stack.push(this.min);
            this.min = x;
        }
        this.stack.push(x);
    }
    
    public void pop() {
        if (this.stack.pop() == min && !this.stack.empty())
            this.min = this.stack.pop();
    }
    
    public int top() {
        return this.stack.peek();
        
    }
    
    public int getMin() {
        return this.min;
    }
}