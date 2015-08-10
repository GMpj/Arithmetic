package leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * 题目大意

　　给定一个整数数组，找出其中两个数满足相加等于你指定的目标数字。 
　　要求：这个函数twoSum必须要返回能够相加等于目标数字的两个数的索引，且index1必须要小于index2。
   请注意一点，你返回的结果（包括index1和index2）都不是基于0开始的。你可以假设每一个输入肯定只有一个结果。 
   
解题思路

　　 创建一个辅助类数组，对辅助类进行排序，使用两个指针，开始时分别指向数组的两端，看这两个下标对应的值是否等于目标值，
	如果等于就从辅助类中找出记录的下标，构造好返回结果，返回。如果大于就让右边的下标向左移，进入下一次匹配，如果小于就让左边的下标向右移动，
	进入下一次匹配，直到所有的数据都处理完 
 * @author MPJ
 *
 */
public class TwoSum_001 {
/**
 * 排序方法，对数组进行排序，使用java内部排序库，排序方法未知
 * @param list
 * @return
 */
public static List<Integer> sort(List<Integer>list){
	list.sort(new Comparator<Integer>() {

		@Override
		//重写排序方法，很据返回值判断排序的大小
		public int compare(Integer o1, Integer o2) {
			if(o1>o2)
				return 1;
			else if(o1==o2)
				return 0;
			else return -1;
		}
	});
	
	return list;
}

public static void main(String[] args) {
	//生成求和数组
	List<Integer>list=new ArrayList<Integer>();
	for(int i=1;i<10;i++){
		list.add(i);
		}
	//获取要求的和
	Scanner in=new Scanner(System.in);
	int sum=in.nextInt();
	
	sort(list);
	
	int front=0;//前指针
	int back=list.size()-1;//后指针
	
	for(;front<back;){
		int k=list.get(front)+list.get(back);
		//相等就输出
		if(k==sum){
			int index1=front+1;
			int index2=back+1;
			System.out.println("index1:"+index1+"index2:"+index2);
			return;
		}
		//如果小，前面后移
		else if(k<sum){
			front++;
		}
		//如果大，后面前移
		else if(k>sum){
			back--;
		}
	}
	
	System.out.println("no results");
}
}
