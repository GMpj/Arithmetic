package swordFingersOffer;

/**
 * 逆序打印链表
 * 递归和栈
 */
import java.util.Stack;

class Node {  
    public int data;  
    public Node nextNode;  
  
    public Node() {  
  
    }  
  
    public Node(int data) {  
        this.data = data;  
    }  
} 
public class A_005 {
public static void main(String[] args) {
	 Node start = new Node(1);  
     Node two = new Node(2);  
     start.nextNode = two; 
     
//     print(start);
     printStack(start);
}
public static void print(Node node){
	if(node==null)
		return ;
	else {
		print(node.nextNode);
		System.out.println(node.data);
	}
	
}
public static void printStack(Node node){
	if(node==null){
		System.out.println("list is null");
		return ;
	}
	Stack<Node> stack=new Stack<Node>();
	while(node!=null){
		stack.add(node);
		node=node.nextNode;
	}
	while(!stack.empty()){
		System.out.println(stack.pop().data);
	}
}
}
