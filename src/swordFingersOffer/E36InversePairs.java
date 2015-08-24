package swordFingersOffer;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * 题目：在数组中的两个数字如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数
 * 使用归并排序
 * @author mpj12875
 *
 */
public class E36InversePairs {
	static int number=0;//计数
	/**
	 * 递归调用进行归并排序
	 * @param data
	 * @param left
	 * @param right
	 */
public void sort(int data[],int left,int right){
	if(left>=right)
		return ;
	int center=(left+right)/2;
	sort(data,left,center);
	sort(data,center+1,right);
	number=number+count(data,left,center,right);
	merge(data, left, center, right);
	
}
/**
 * 统计逆序对个数
 * @param data
 * @param left
 * @param center
 * @param right
 * @return
 */
public int count(int data[],int left,int center,int right){
	int number=0;
	//以左边的数组为主，统计能够有多少个逆序对
	for(int i=center;i>=left;i--){
		for(int j=right;j>center;j--){
			if(data[i]>data[j]){
				number=number+j-center;
				print(data,center+1,i,j);
				System.out.println("left"+number);
				break;
			}
				
		}
	}
	//以右边的数组为主，统计逆序对个数
	for(int i=right;i>center;i--){
		for(int j=center;j>=left;j--){
			if(data[i]>data[j]){
			number=number+j-left+1;
			print(data,left,i,j);
			System.out.println("right"+number);
			break;
			}
		}
	}
	return number;
}
/**
 * 打印
 * @param data
 * @param left
 * @param currentHead
 * @param currentValue
 */
public void print(int data[],int left,int currentHead,int currentValue){
	for(;currentValue>=left;currentValue--)
		System.out.println(data[currentHead]+","+data[currentValue]);
}
/**
 * 将两个排序好的数组进行合并
 * @param data
 * @param left
 * @param center
 * @param right
 */
public void merge(int data[],int left,int center,int right){
	int i=center;
	int j=right;
	int tempArr[]=new int[data.length];
	int temp=right;
	while(i>=left&&j>center){
		if(data[i]>data[j])
			tempArr[temp--]=data[i--];
		else
			tempArr[temp--]=data[j--];
	}
	while(i>=left)
		tempArr[temp--]=data[i--];
	while(j>center)
		tempArr[temp--]=data[j--];
	temp++;
//	System.out.println(temp);
	System.out.print("data:");
	while(temp<=right){
		data[temp]=tempArr[temp++];
		System.out.print(data[temp-1]);
	}
	System.out.println();
}
/**
 * 将数组中重复的数字去除
 * @param data
 * @return
 */
public int[] removal(int [] data){
	Set<Integer>set=new HashSet<Integer>();
	for(int i=0;i<data.length;i++ )
		set.add(data[i]);
	int []newData=new int[set.size()];
	int i=0;
	for(int temp:set)
		newData[i++]=temp;
	return newData;
}

public static void main(String[] args) {
	 int[] arr={7,5,6,4,5,1,2,3};  
     E36InversePairs test = new E36InversePairs();
     int data[]=test.removal(arr);
     for(int i=0;i<data.length;i++)
    	 System.out.print(data[i]);
    	 System.out.println();
     test.sort(data, 0, data.length-1);
     System.out.println(number);
     
     for (int i = 0; i < data.length; i++) {  
         System.out.print(data[i]);  
     } 
}
}
