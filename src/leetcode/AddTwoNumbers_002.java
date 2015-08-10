package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 原题

　　You are given two linked lists representing two non-negative numbers. 
The digits are stored in reverse order and each of their nodes contain a single digit. 
Add the two numbers and return it as a linked list. 
　　Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) 
　　Output: 7 -> 0 -> 8 

题目大意

　　有两个单链表，代表两个非负数，每一个节点代表一个数位，数字是反向存储的，
即第一个结点表示最低位，最后一个结点表示最高位。求两个数的相加和，并且以链表形式返回。 

解题思路

　　对两个链表都从第一个开始处理，进行相加，结果再除以10求商，
作为下一位相加的进位，同时记录余数，作为本位的结果，一直处理，直到所有的结点都处理完。
 * @author MPJ
 *
 */
public class AddTwoNumbers_002 {
public static void main(String[] args) {
//	Scanner scan=new Scanner(System.in);
//	String input=scan.next();
	String input="(2->4->3)+(5->6->4)";
	//将输入的字符串进行分割，获取需要的参数
	String par[]=input.split("\\+");	
	String numbers1[]=par[0].substring(1, par[0].length()-1).split("->");
	String numbers2[]=par[1].substring(1, par[1].length()-1).split("->");
	
	List<Integer>sum=new ArrayList<Integer>();
	int c=0;//进位标记
	
	//遍历相加，注意进位
	for(int i=0;i<numbers1.length;i++){
		int temp=Integer.parseInt(numbers1[i])+Integer.parseInt(numbers2[i]);
		sum.add(temp%10+c);
		c=temp/10;
	}
	//遍历输出
	for(int i=0;i<sum.size();i++){
		if(i==sum.size()-1){
			System.out.print(sum.get(i));
		}
		else 
			System.out.print(sum.get(i)+"->");
	}
	System.out.println();
}
}
