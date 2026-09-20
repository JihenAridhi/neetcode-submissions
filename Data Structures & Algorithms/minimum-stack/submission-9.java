class MinStack {

    Stack<Integer> stack;
    Stack<Integer> sorted;

    public MinStack() {
        this.stack = new Stack<>();
        this.sorted = new Stack<>();
    }

    public void push(int val) {
        if(sorted.isEmpty() || sorted.peek()>=val)
            sorted.push(val);
        stack.push(val);
    }

    public void pop() {
        if((stack.peek()).equals(sorted.peek()))
            sorted.pop();
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return sorted.peek();
    }
}
