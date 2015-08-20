package swordFingersOffer;



import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的min函数。在该栈中，调用min，push及pop的时间复杂度都是O(1).
 * 使用辅助栈，保存每次压入元素时数据栈中的最小元素
 * @author mpj12875
 *
 */
class MinStack{
	private Stack<Integer>stack=new Stack<Integer>();
	private Stack<Integer>minstack=new Stack<Integer>();
	
	public void push(int number){
		if(minstack.size()==0||minstack.peek()>number)
			minstack.push(number);
		else minstack.push(minstack.peek());
		stack.push(number);
	}
	
	public Integer pop(){
		if(stack.size()==0)
			return null;
		minstack.pop();
		return stack.pop();
				
	}
	
	 public Integer getMin(){
		 if(stack.size()==0)
				return null;
		 return minstack.peek();
	 }
}
public class A_021 {

	public static void main(String[] args) {
		MinStack stack=new MinStack();
		stack.push(1);
		System.out.println(stack.getMin());
		stack.push(2);
		System.out.println(stack.getMin());
		stack.push(3);
		System.out.println(stack.getMin());
		System.out.println(stack.pop());
		stack.push(0);
		System.out.println(stack.getMin());
	}
}
