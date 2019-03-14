package com.test.springboot.junitest;

public class BinaryTest {

	public static void main(String[] args) {
		// 十进制转二进制
		Integer tenBinaryNumber = 555555555;
		binaryTwoConvertTenTest1(tenBinaryNumber);
		binaryTwoConvertTenTest2(tenBinaryNumber);
		binaryTwoConvertTenTest3(tenBinaryNumber);
	}

	/**
	 * 除基倒取余法
	 * @param n
	 */
	private static void binaryTwoConvertTenTest1(Integer n) {
		int orNumber=n;
		int t = 0; // 用来记录位数
		int bin = 0; // 用来记录最后的二进制数
		int r = 0; // 用来存储余数
		while (n != 0) {
			r = n % 2;
			n = n / 2;
			bin += r * Math.pow(10, t);
			t++;
		}
		System.out.println("【"+orNumber+"】十进制转二进制："+bin);
	}
	
	/**
	 * 但是int型最大只能表示2^31-1 的正数，所以，存储的二进制数位数有限；我们都知道，int在java中的存储范围是32位，
	 * 则可以使用字符串的拼接（+）来实现，代码如下:
	 * @param n
	 */
	private static void binaryTwoConvertTenTest2(Integer n) {
		int orNumber=n;
		String str="";
		while (n != 0) {
			str = n % 2 +str;
			n = n / 2;
		}
		System.out.println("【"+orNumber+"】十进制转二进制："+str);
	}
	
	/**
	 * 利用“移位”操作实现
	 * @param n
	 */
	private static void binaryTwoConvertTenTest3(Integer n) {
		 for(int i = 31;i >= 0; i--) {
			System.out.print(n >>> i & 1);
	     }
		 String result=Integer.toBinaryString(n);
		 System.out.println("\n"+result+"\n"+result.length());
	}

}
