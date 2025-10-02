class MinStack {
    private Stack<Integer> s;
    private Stack<Integer> stk;
    public MinStack() {
        s = new Stack<>(); //all values
        stk = new Stack<>(); //track of all minimum
    }
    
    public void push(int val) {
        s.push(val);
        if(stk.isEmpty() || val <= stk.peek()){
            stk.push(val);
        }
    }
    
    public void pop() {
        if(s.peek().equals(stk.peek())){
            stk.pop();
        }
        s.pop();
    }
    
    public int top() {
        if(!s.isEmpty()){
            return s.peek();
        }
        return -1;
    }
    
    public int getMin() {
        if(!stk.isEmpty()){
            return stk.peek();
        }
        return -1;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */