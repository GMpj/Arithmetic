package swordFingersOffer;

/**
 * 通过数组将空格替换成特殊字符
 * @author MPJ
 *
 */
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
public static void replaceAllBlank(String testString){
	if(testString == null || testString.length() <= 0){  
        return;  
    }  
    //字符数组初始长度  
    int length = testString.length();  
    //字符数组增加长度后  
    int newLength = testString.length()+ getBlankNum(testString)*2;  
    char[] tempArray = new char[newLength];  
    System.arraycopy(testString.toCharArray(), 0, tempArray, 0, testString.toCharArray().length);  
    int indexofOriginal = length - 1;  
    int indexofNew = newLength -1;  
    System.out.println("未替换空格时的字符串：");  
    printArray(testString.toCharArray());  
    while(indexofOriginal >=0 && indexofOriginal != indexofNew){  
        if(tempArray[indexofOriginal]==' '){  
            tempArray[indexofNew--]='0';  
            tempArray[indexofNew--]='2';  
            tempArray[indexofNew--]='%';  
        }else{  
            tempArray[indexofNew--]= tempArray[indexofOriginal];  
        }  
        indexofOriginal--;  
    }  
    System.out.println("替换空格后的字符串：");  
    printArray(tempArray);  
}
}
