package swordFingersOffer;

/**
 * 循环打印数组
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字
 *  1，2，3，4
	5，6，7，8
	9，10，11，12
	13，14，15，16
	则依次打印出数字1，2，3，4，8，12，16，15，14，13，9，5，6，7，11，10.
 * @author MPJ
 *
 */
public class A_020 {
/**
 * 控制函数，每次用不同的起始位置开始
 * @param array
 */
public static void printMatrixInCircle(int array[][]){
	if(array==null)
		return ;
	int start=0;
	while(array[0].length>start*2&&array.length>start*2){
		printOneCircle(array, start);
		start++;
	}
}
/**
 * 从开始位置打印一圈
 * @param array
 * @param start
 */
public static void printOneCircle(int array[][],int start){
	int columns=array[0].length;
	int rows=array.length;
	int endX=columns-start-1;
	int endY=rows-start-1;
//	System.out.println("endx:"+endX+" endY:"+endY);
	for(int i=start;i<=endX;i++){
		System.out.println(array[start][i]);
	}
	
	if(start<endY){
		for(int i=start+1;i<endY;i++)
			System.out.println(array[i][endX]);
	}
	if(start<endY&&start<endX){
		for(int i=endX;i>start;i--){
			System.out.println(array[endY][i]);
		}
		for(int i=endY;i>start;i--){
			System.out.println(array[i][start]);
		}
	}
	
}

public static void main(String[] args) {
//	int[][] arr={{1,2,3,4},{5,6,7,8},{9,10,11,12}}; 
//	int [][]arr={{1,2,3,4}};
//	int [][]arr={{1}};
	int[][] arr={{1,2,3,4},{5,6,7,8}}; 
	printMatrixInCircle(arr);
}
}
