package swordFingersOffer;


import java.util.Stack;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 * @author mpj12875
 *
 */
public class E22StackPushPopOrder {
	/**
	 * 如果下一个弹出的数字刚好是栈顶数字，那么直接弹出。
	 * 如果下一个弹出的数字不在栈顶，我们把压栈序列中还没有入栈的数字压入辅助栈，知道把下一个需要弹出的数字压入栈顶为止。
	 * 如果所有的数字都压入栈了仍没有找到下一个弹出的数字，那么该序列不可能是一个弹出序列。
	 * @param put
	 * @param out
	 * @return
	 */
public boolean check(int[]put,int []out){
	boolean isPossible=false;
	Stack<Integer> stack=new Stack<Integer>();
	int i=0,j=0;
	stack.push(put[i]);
	while(true){
		
		if(stack.peek()==out[j]){
			System.out.println(stack.peek());
			stack.pop();
			j++;
			if(j==out.length)
				return isPossible=true;
		}
		else {
			if(i==put.length)
				return isPossible=false;
			System.out.println(put[i]);
			stack.push(put[i]);
			i++;
		}
	}
	
}
public static void main(String[] args) {
	int[] put = { 1, 2, 3, 4, 5 };    
    // 出栈序列    
//    int[] out = { 4, 3, 5, 2, 1 };  
	int[] out ={6,4, 3, 5, 2, 1 };//{4,3,5,1,2}  
    E22StackPushPopOrder test=new E22StackPushPopOrder();
    System.out.println(test.check(put, out));
}
}
