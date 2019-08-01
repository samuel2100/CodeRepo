package com.problems.simple;
/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 *	push(x) -- Push element x onto stack.
 *	pop() -- Removes the element on top of the stack.
 *	top() -- Get the top element.
 *	getMin() -- Retrieve the minimum element in the stack.
 * @author samuel
 *
 */
class MinStack {
    
    /** initialize your data structure here. */
	Node node, tempNode;
    public MinStack() {
        node = null;
     
    }
    
    public void push(int x) {
        if (node == null){
            node = new Node();
            node.prev = null;
            node.min = x;            
        } else {
            tempNode = node;
            node = new Node();
            node.prev = tempNode;
            node.min = Math.min(tempNode.min, x);
        }
        node.value = x; 
    }
    
    public void pop() {
        if (node != null){
            node = node.prev;
        }
    }
    
    public int top() {
        if (node != null)
            return node.value;
        return -1;
    }
    
    public int getMin() {
        return node.min;
    }
    
    class Node{
        int value;
        Node prev;
        int min;
    }
    
    public static void main(String[] args){
    	MinStack minStack = new MinStack();
    	minStack.push(2147483646);
    	minStack.push(2147483646);
    	minStack.push(2147483647);
    	System.out.println(minStack.top()==2147483647);
    	minStack.pop();
    	System.out.println(minStack.getMin()==2147483646);
    	minStack.pop();
    	System.out.println(minStack.getMin()==2147483646);
    	minStack.pop();
    	minStack.push(2147483647);
    	System.out.println(minStack.top()==2147483647);
    	System.out.println(minStack.getMin()==2147483647);
    	
    	minStack.push(-2147483648);    	
    	minStack.top();
    	System.out.println(minStack.getMin() == -2147483648);
    	minStack.pop();
    	System.out.println(minStack.getMin() == 2147483647);
    	
    }
}
