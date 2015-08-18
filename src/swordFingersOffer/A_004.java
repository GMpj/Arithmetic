package swordFingersOffer;
public class A_004 {

public static void main(String[] args) {
	String str="";
	str.replaceAll("", ",");
}
//计算字符串中包含的空格个数  
public static int getBlankNum(String testString){  
    int count = 0 ;  
    for(int i = 0;i<testString.length();i++){  
        String tempString = String.valueOf(testString.charAt(i));  
        if(tempString.equals(" ")){  
            count++;  
        }  
    }  
    return count;  
}  
//打印char[] 数组  
public static void printArray(char[] testArray){  
    for(char i :testArray){  
        System.out.print(i);  
    }  
    System.out.println();  
}  
public static void replaceAllBlank(String str){
	
}
}
