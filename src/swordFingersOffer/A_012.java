package swordFingersOffer;

/**
 * 输入数字n，按顺序打印出从1最大的的n位数十进制数。比如输入3，则打印出1，2，3一直到最大的3位数即999.
 * 要用数组计数，每个元素保存一位
 * @author mpj12875
 *
 */
public class A_012 {
	
	/**
	 * 数组计数自增
	 * @param n
	 */
	public static void  increment(int n){
		int array[]=new int [n];
		
		while(true){
			array[0]++;
			if(array[0]>=10){
				array[0]=0;
				int c=1;
				//进位计算
				for(int i=1;i<array.length;i++){
					array[i]=array[i]+c;
					if(array[i]>=10){
						array[i]=0;
						c=1;
					}
					else break;
				}
			}
			//打印
			output(array);
			//判断是否达到最大数
			if(maxNum(array))
				break;
		}
	}
	/**
	 * 判断是否是最大值
	 * @param array
	 * @return
	 */
	public static boolean maxNum(int array[]){
		boolean flag=false;
		int i=0;
		for(;i<array.length;i++){
			if(array[i]!=9){
				flag=false;
				break;
			}
		}
		if(i==array.length)
			flag=true;
		return flag;
	}
	/**
	 * 打印
	 * @param array
	 */
	public static void output(int array[]){
		boolean flag=false;
		for(int i=array.length-1;i>=0;i--){
			if(flag)
				System.out.print(array[i]);
			else {
				if(array[i]!=0){
					System.out.print(array[i]);
					flag=true;
				}
			}
		}
		System.out.println();
			
	}
	public static void main(String[] args) {
		int n=3;
		increment(n);
	}
}
