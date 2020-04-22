public class LC232ImplementQueueUsingStacks {

	class MyOptimizedQueue {
	    
	    Stack<Integer> stack;
	    Stack<Integer> temp;

	    /** Initialize your data structure here. */
	    public MyQueue() {
	        stack = new Stack<Integer>();
	        temp = new Stack<Integer>();
	    }
	    
	    /** Push element x to the back of queue. */
	    public void push(int x) {
	        while (!stack.isEmpty()) {
	            temp.push(stack.pop());
	        }
	        stack.push(x);
	        while (!temp.isEmpty()) {
	            stack.push(temp.pop());
	        }
	    }
	    
	    /** Removes the element from in front of queue and returns that element. */
	    public int pop() {
	        return stack.pop();
	    }
	    
	    /** Get the front element. */
	    public int peek() {
	        return stack.peek();
	    }
	    
	    /** Returns whether the queue is empty. */
	    public boolean empty() {
	        return stack.isEmpty() && temp.isEmpty();
	    }
	}

	/**
	 * Queue: first in first out
	 * Stack: first in last out
	 * 两个stack 来回倒腾, 操作完之后永远保证只有Stack1里放着东西，就不会搞错。
	 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Implement Queue using Stacks.
	 * Memory Usage: 37.1 MB, less than 6.25% of Java online submissions for Implement Queue using Stacks.
	 */
	class MyNaiveQueue {
	    
	    Stack<Integer> stack1;
	    Stack<Integer> stack2;

	    /** Initialize your data structure here. */
	    public MyQueue() {
	        stack1 = new Stack<Integer>();
	        stack2 = new Stack<Integer>();
	    }
	    
	    /** Push element x to the back of queue. */
	    public void push(int x) {
	        stack1.push(x);
	    }
	    
	    /** Removes the element from in front of queue and returns that element. */
	    public int pop() {
	        while (!stack1.isEmpty()) {
	            stack2.push(stack1.pop());
	        }
	        int pop = stack2.pop();
	        while (!stack2.isEmpty()) {
	            stack1.push(stack2.pop());
	        }
	        return pop;
	    }
	    
	    /** Get the front element. */
	    public int peek() {
	        while (!stack1.isEmpty()) {
	            stack2.push(stack1.pop());
	        }
	        int peek = stack2.peek();
	        while (!stack2.isEmpty()) {
	            stack1.push(stack2.pop());
	        }
	        return peek;
	    }
	    
	    /** Returns whether the queue is empty. */
	    public boolean empty() {
	        return stack1.isEmpty() && stack2.isEmpty();
	    }
	}

	/**
	 * Your MyQueue object will be instantiated and called as such:
	 * MyQueue obj = new MyQueue();
	 * obj.push(x);
	 * int param_2 = obj.pop();
	 * int param_3 = obj.peek();
	 * boolean param_4 = obj.empty();
	 */
}