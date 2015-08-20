package swordFingersOffer;

import java.util.LinkedList;
import java.util.Stack;


/**
 * 用两个栈实现队列
 * @author mpj12875
 *
 */
 class QueueWithTwoStacks{
	private Stack<String>stack1=new Stack<String>();
	private Stack<String>stack2=new Stack<String>();
	
	public void append(String str){
		stack1.push(str);
	}
	
	public void delete(){
		String temp;
		if(!stack2.isEmpty())
			 temp=stack2.pop();
		else {
		while(!stack1.isEmpty()){
			stack2.push(stack1.pop());
		}
		 temp=stack2.pop();
		}
		System.out.println(temp);
	}
}
/**
 * 用两个队列实现栈
 * @author mpj12875
 *
 */
 class StacksWithTwoQueue{
	 private LinkedList<String> queue1=new LinkedList<String>();
	 private LinkedList<String> queue2=new LinkedList<String>();
	 
	 public void append(String str){
		 queue1.add(str);
	 }
	 
	 public void delete(){
		 if(queue1.size()>0){
			 while(queue1.size()>0){
				 String temp=queue1.removeFirst();
				 if(queue1.size()>0)
					 queue2.add(temp);
				 else System.out.println(temp);
			 }
		 }
		 else if(queue1.size()==0){
			 while(queue2.size()>0){
				 String temp=queue2.removeFirst();
				 if(queue2.size()>0)
					 queue1.add(temp);
				 else System.out.println(temp);
			 }
		 }
	 }
 }
public class E07QueueWithTwoStacks {
public static void main(String[] args) {
	System.out.println("模拟队列");
	QueueWithTwoStacks qs=new QueueWithTwoStacks();
	qs.append("1");
	qs.append("2");
	qs.delete();
	qs.append("3");
	qs.delete();
	System.out.println("模拟栈");
	StacksWithTwoQueue sq=new StacksWithTwoQueue();
	sq.append("1");
	sq.append("2");
	sq.delete();
	sq.append("3");
	sq.delete();
}
}
