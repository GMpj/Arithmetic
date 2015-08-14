package leetcode;

/**
 * 原题

　　The string “PAYPALISHIRING” is written in a zigzag pattern on a given number of rows like this: 
(you may want to display this pattern in a fixed font for better legibility) 
　　P A H N 
　　APLSIIG 
　　Y I R 
　　And then read line by line: “PAHNAPLSIIGYIR” 
　　Write the code that will take a string and make this conversion given a number of rows: 
　　string convert(string text, int nRows); 
　　convert(“PAYPALISHIRING”,3) should return “PAHNAPLSIIGYIR”. 

题目大意

　　输入一个字符串和指定的行数，将字符以Z字型输出。 

解题思路

　　计算出字符的最大列数，根据列数和行数创建一个二维数组，再计算每个字符中二维数组中的位置，再对一维数组中的字符进行紧凑操作，返回结果。
注意：本题的最主要是进行转换，目前是使用二维数组进行解决，但是数据量大的话，其中会出现很多为空的字段，可以直接转换成长度为字符串长度的一维数组的位置，
即转换和去除空空元素同时进行，直接形成紧凑的字符数组，可进行优化。
 * @author mpj12875
 *
 */
public class ZigZagConversion_006 {

/**
 * 使用一维数组解决，使数据紧凑，不会出现为空的元素
 * @param text
 * @param nRows
 * @return
 */
public static String convertNew(String text,int nRows){
	int nLine=0;
	int linetemp=text.length()/(nRows*2-2);
	int model=text.length()%(nRows*2-2);
	StringBuffer result=new StringBuffer();
	
	if(model==0)
		nLine=linetemp*(nRows-1);
	else if(model<=nRows)
		nLine=linetemp*(nRows-1)+1;
	else nLine=linetemp*(nRows-1)+model-nRows;
	
	String[] table=new String[text.length()];
	int k=0;
	for(int i=0;i<nRows;i++){
		int count=0;
		int address=0;
		while(k<table.length){
			address=count*(nRows*2-2)+i;
			System.out.println("address:"+address);
			if(address<text.length()){
				System.out.println("k:"+k+" "+text.charAt(address));
				table[k++]=text.charAt(address)+"";
			}
			else break;
			
			address=address+((nRows*2-2)-i*2);
			
			System.out.println("address:"+address);
			if(i==0||i==nRows-1){
				count++;
				continue;
			}
			
			else if(address<text.length()){
				System.out.println("k:"+k+" "+text.charAt(address));
				table[k++]=text.charAt(address)+"";
			}
			else break;
			count++;
		}
	}
	for(int i=0;i<table.length;i++)
		result=result.append(table[i]);
	System.out.println(result);
	return result.toString();
}
/**
 * 二维数组处理，数据会出现为空，占用空间
 * @param text
 * @param nRows
 * @return
 */
public static String convert(String text,int nRows){
	int nLine=0;
	int linetemp=text.length()/(nRows*2-2);
	int model=text.length()%(nRows*2-2);
	StringBuffer result=new StringBuffer();
	
	if(model==0)
		nLine=linetemp*(nRows-1);
	else if(model<=nRows)
		nLine=linetemp*(nRows-1)+1;
	else nLine=linetemp*(nRows-1)+model-nRows;
	
	String[][] table=new String[nRows][nLine];
	
	System.out.println(nLine);
	int i=0,k=0;
	for(;k<nLine;){
	
		for(int j=0;j<nRows&&i<text.length();j++,i++){
			table[i%(nRows*2-2)][k]=text.charAt(i)+"";
//			j++;
			System.out.println(j+" k:"+k);
		}
		k++;
		for(int j=0;j<nRows-2&&i<text.length();j++,i++){
			
			table[nRows-i%(nRows*2-2)+1][k]=text.charAt(i)+"";
			System.out.println(i+" k:"+k);
//			j++;
			k++;
		}
	}
	for(int t=0;t<nRows;t++){
		for(int j=0;j<nLine;j++){
			if(table[t][j]!=null)
//			System.out.print(table[t][j]);
			result=result.append(table[t][j]);
			else result=result.append("");
		}
			
		
	}
	System.out.println(result);
	return result.toString();
}

public static void main(String[] args) {
	String text="PAYPALISHIRING";
	convertNew(text, 3);
//	String[] table=new String[3*4];
//	table[0]=" ";
//	for(int i=0;i<8;i++){
//		System.out.println("i:"+i);
//	if(i%2==0){
//		System.out.println("使用continue");
//		continue;
//	}
//	}
}
}
