package swordFingersOffer;

/**
 * 题目：丑数
 * 我们把只包含因子2，3，5的数称为丑数（Ugly Number).
 * 求按从小到大的顺序的第1500个丑数。
 * 例如6，8都是丑数，但14不是，因为它含有因子7.习惯上我们把1当作第一个丑数
 * @author mpj12875
 *
 */
public class E34UglyNumber {
	
	/**
	 * 将一个数组里面存放所有的丑数，丑数来自于前面的丑数进行合成，即*2、*3、*5
	 * 因为乘丑数因子的时候步伐是不一致的，因此需要三个数来保存各自走到的位置
	 * 将各自当前位置上的丑数分别乘自己的步伐，然后比较生成的丑数哪个更小，
	 * 选取最小的丑数作为下个丑数，同时确定是哪个因子做出了贡献，将该因子向前走一步
	 * @param index
	 */
public void getUglyNumber(int index){
	if(index<=0)
		return;
	int []uglyArray=new int[index];
	uglyArray[0]=1;
	int min2=0;
	int min3=0;
	int min5=0;
	for(int i=1;i<index;i++){
		//选取最小的丑数
	int minNum=min(uglyArray[min2]*2,uglyArray[min3]*3,uglyArray[min5]*5);
	uglyArray[i]=minNum;
//	System.out.println(i+":"+minNum);
	if(uglyArray[i]==uglyArray[min2]*2) min2++;
	if(uglyArray[i]==uglyArray[min3]*3) min3++;
	if(uglyArray[i]==uglyArray[min5]*5) min5++;
	}
//	for(int i=0;i<uglyArray.length;i++)
//		System.out.println(uglyArray[i]);
	
}
/**
 * 判断三个数中的最小数，用于生成的丑数的判断
 * @param min1
 * @param min2
 * @param min3
 * @return
 */
public int min(int min1,int min2,int min3){
//	System.out.println(min1+"_"+min2+"_"+min3);
	int min;
	if(min1>min2)
		min=min2;
	else min=min1;
	if(min>min3)
		return min3;
	else return min;
}
public static void main(String[] args) {
	E34UglyNumber test=new E34UglyNumber();
	test.getUglyNumber(1500);
	 System.out.println(test.getUglyNumber1(1500));  
}
/**
 * 判断是否是丑数
 * @param number
 * @return
 */
public boolean isUgly(int number){  
    while(number % 2 == 0)  
        number/=2;  
    while(number % 3 == 0)  
        number /=3;  
    while(number % 5 == 0)  
        number /=5;  
    return (number ==1)? true:false;  
}  
/**
 * 方法1，遍历所有的数字，如果是丑数计数加1，直到满足第k个数
 * @param index
 * @return
 */
public int getUglyNumber1(int index){  
    if(index <= 0)  
        return 0;  
    int number = 0;  
    int uglyFound = 0;  
    while(uglyFound < index){  
        number++;  
        if(isUgly(number)){  
            ++uglyFound;  
        }  
    }  
    return number;  
}
}
