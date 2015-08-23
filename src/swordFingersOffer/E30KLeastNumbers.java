package swordFingersOffer;

import java.util.Arrays;


/**
 * 输入n个整数，找出其中最小的k个数。例如输入4，5，1，6，2，7，3，8这8个数字，则最小的4个数字是1，2，3，4
 * 我们可以先创建一个大小为k的数据容器来存储最小的k个数字，接下来我们每次从输入的n个整数中读入一个数。
 * 如果容器中已有数字少于k个，则直接把这次读入的整数放入容器中；
 * 如果容器中已有k个数字了，也就是容器已满，此时我们不能再插入新的数字了而只能替换已有的数字。
 * 找出这已有的k个数中的最大值，然后拿这次待插入的整数和最大值进行比较。
 * 如果待插入的值比当前已有的最小值小，则用这个数替换当前已有的最大值；
 * 如果待插入的值比当前已有的最大值还大，那么这个数不可能是最小的k个整数之一，于是我们可以抛弃这个整数。
 * 
 * 问题变成如何在插入和删除一个元素之后得到这个容器的最大值
 * 
 * 使用大根堆可以方便的获取最大值
 * 
 * 对于n个关键字序列，最坏情况下每个节点需比较log2(n)次，因此其最坏情况下时间复杂度为nlogn。
 * 堆排序为不稳定排序，不适合记录较少的排序。
 * @author MPJ
 *
 */
public class E30KLeastNumbers {

	/**
	 * 创建堆，将数组中的元素构建成大根堆，即满足Key[i]>=Key[2i+1]&&key>=key[2i+2]
	 * @param array
	 * @param lastIndex
	 */
	public void buildMaxHeap(int []array,int lastIndex){
		//对每个根元素都需要进行判断，从子节点向树根节点进行判断
		for(int i=(lastIndex-1)/2;i>=0;i--){
			int k=i;
			//从上往下检查该节点以及子节点是否全部满足
			while(2*k+1<=lastIndex){
				int bigger=2*k+1;
				//如果右儿子比左儿子大，那么和右儿子比较
				if(bigger<lastIndex){
					if(array[bigger]<array[bigger+1])
						bigger++;
				}
				//如果不满足大根堆特点，进行交换，并继续检查子节点在交换后是否满足
				if(array[k]<array[bigger]){
					swap(array,k,bigger);
					k=bigger;
				}
				//如果满足继续检查下一个根节点
				else break;
			}
		}
	}
	public void swap(int array[],int i,int j){
		int temp=array[i];
		array[i]=array[j];
		array[j]=temp;
	}
	/**
	 * 大根堆排序
	 * 将当前无序区的堆顶元素R[1]同该区间的最后一个记录交换，然后将新的无序区调整为新的堆。
	 * 防止出现疏漏
	 * @param array
	 */
	public void heapSort(int[] array){
		for(int i=0;i<array.length-1;i++){
			buildMaxHeap(array,array.length-i-1);  
            swap(array,0,array.length-i-1); 		
		}
	}
	
	public void getLeastNumbers(int[] arr,int k){  
        if(arr == null || k<0 || k>arr.length)  
            return;  
        //根据输入数组前k个数简历最大堆  
        //从k+1个数开始与根节点比较  
        //大于根节点，舍去  
        //小于，取代根节点，重建最大堆  
        int[] kArray = Arrays.copyOfRange(arr, 0, k);  
        heapSort(kArray);  
        for(int i = k;i<arr.length;i++){  
            if(arr[i]<kArray[k-1]){  
                kArray[k-1] = arr[i];  
                heapSort(kArray);  
            }  
        }  
        for(int i:kArray)  
            System.out.print(i);  
    }  
	public static void main(String[] args){  
        int[] arr= {4,5,1,6,2,7,3,8};  
        E30KLeastNumbers test = new E30KLeastNumbers();  
//        test.getLeastNumbers(arr, 3);  
        test.heapSort(arr);
        for(int i=0;i<arr.length;i++)
        	System.out.print(arr[i]);
        	
    } 
}
