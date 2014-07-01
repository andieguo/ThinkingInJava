package com.andieguo.yanghui;

import java.math.BigInteger;

/**
 * 杨辉三角的生成方法
 * a[i,k]+a[i,k+1]=a[i+1,k+1]
 * @author Administrator
 *
 */
public class YangHuiDemo {
	public static void main(String[] args) {
//		System.out.println(run2(4));//3
		System.out.println(run4(0));//4
//		daying(3);
//		int result = generatorBigData(1000000000);
//		System.out.println("----------"+result);
	}
	/**
	 * 生成杨辉三角
	 * @param n 行数 1000000000
	 * @return	最后一行中第一个为偶数的序号
	 */
	public static int generatorBigData(int n) {
		int result = 0;
		boolean flag = false;
		BigInteger[][] a = new BigInteger[n + 1][n + 1];
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j < i; j++) {
				if(j==0||j==i-1){//判断很重要
					a[i][j]=BigInteger.valueOf(1);
				}else{
					a[i][j] = a[i - 1][j - 1].add(a[i - 1][j]);
				}
				if(i==n&&a[i][j].remainder(BigInteger.valueOf(2)).equals(BigInteger.valueOf(0))&&!flag){
					flag = true;
					result = j+1;
				}
				System.out.print(a[i][j] +"\t");
			}
			System.out.println();
		}
		return result;
	}
	/**
	 * 1
	 * 1 1 1
	 * 1 2 3 2 1
	 * 1 3 6 7 6 3 1
	 * 
	 */
	public static int run4(int n){
		BigInteger[][] a = new BigInteger[2*n + 1][2*n + 1];
		for(int i = 0;i<n;i++){//0~n-1
			for(int j=0;j<2*i+1;j++){//0~i+1
				if(j==0||j==2*i){
					a[i][j]=BigInteger.valueOf(1);
				}else{
					if(j==1){
						if(i==1){
							a[i][j]=BigInteger.valueOf(1);
						}else{
							a[i][j]=a[i-1][j-1].add(a[i-1][j]);
						}
					}else if(j==2*i-1){
						a[i][j]=a[i-1][j-2].add(a[i-1][j-1]);
					}else{
						a[i][j]=a[i-1][j-2].add(a[i-1][j-1]).add(a[i-1][j]);
					}
				}
				if(i==n-1&&a[i][j].remainder(BigInteger.valueOf(2)).equals(BigInteger.valueOf(0))){
					return j+1;
				}
			}
		}
		return 0;
	}
	/**
	 * 1
	 * 1 1 1
	 * 1 2 3 2 1
	 * 1 3 6 7 6 3 1
	 * 
	 */
	public static int run(int n){
		/**
		 * i=0;j=0
		 * i=1;j=0,1,2
		 * i=2;j=0,1,2,3,4
		 */
		int[][] a = new int[2*n + 1][2*n + 1];
		for(int i = 0;i<n;i++){//i取值：0~n-1(共有n行)
			for(int j=0;j<2*i+1;j++){//j取值：0~2i(第i行共有2i+1个数)
				if(j==0||j==2*i){
					a[i][j]=1;
				}else{
					if(j==1){
						a[i][j]=a[i-1][j-1]+a[i-1][j];
					}else if(j==2*i-1){
						a[i][j]=a[i-1][j-2]+a[i-1][j-1];
					}else{
						a[i][j]=a[i-1][j-2]+a[i-1][j-1]+a[i-1][j];
					}
				}
				System.out.print(a[i][j] +"\t");
			}
			System.out.println();
		}
		return 0;
	}
	
	public static int run2(int n){
		/**
		 * i=0;j=0
		 * i=1;j=0,1,2
		 * i=2;j=0,1,2,3,4
		 */
		int result = 0;
		boolean flag = false;
		int[][] a = new int[2*n + 1][2*n + 1];
		for(int i = 0;i<n;i++){//0~n-1
			for(int j=0;j<2*i+1;j++){//0~i+1
				if(j==0||j==2*i){
					a[i][j]=1;
				}else{
					if(j<2){
						a[i][j]=a[i-1][j-1]+a[i-1][j];
					}else{
						a[i][j]=a[i-1][j-2]+a[i-1][j-1]+a[i-1][j];
					}
				}
				if(i==n-1&&a[i][j]%2==0&&!flag){
					flag = true;
					result = j+1;
				}
				System.out.print(a[i][j] +"\t");
			}
			System.out.println();
		}
		return result;
	}
	/**
	 *  1	
		1	1	1	
		1	2	3	2	1	
		1	3	6	7	6	3	1	
		1	4	10	16	19	16	10	4	1
	 * @param n
	 * @return
	 */
	public static int run3(int n){
		int[][] a = new int[2*n + 1][2*n + 1];
		for(int i = 0;i<n;i++){//0~n-1
			for(int j=0;j<2*i+1;j++){//0~i+1
				if(j==0||j==2*i){
					a[i][j]=1;
				}else{
					if(j<2){
						a[i][j]=a[i-1][j-1]+a[i-1][j];
					}else{
						a[i][j]=a[i-1][j-2]+a[i-1][j-1]+a[i-1][j];
					}
				}
				if(i==n-1&&a[i][j]%2==0){
					return j+1;
				}
			}
		}
		return 0;
	}
	public static int generatorData(int n) {
		int result = 0;
		boolean flag = false;
		int[][] a = new int[n + 1][n + 1];
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j < i; j++) {
				if(j==0||j==i-1){//判断很重要
					a[i][j]=1;
				}else{
					a[i][j] = a[i - 1][j - 1] + a[i - 1][j];
				}
				if(i==n&&a[i][j]%2==0&&!flag){
					flag = true;
					result = j+1;
				}
				System.out.print(a[i][j] +"\t");
			}
			System.out.println();
		}
		return result;
	}
	
	public static void daying(int line) {
		int a[][] = new int[line + 1][];
		for (int i = 0; i <= line; i++)
		{
			a[i] = new int[i + 1]; // 指定每行的列数
		}
		yanghui(a, line);
	}

	static void yanghui(int a[][], int ROW) {
		for (int i = 0; i <= ROW; i++)
			for (int j = 0; j <= a[i].length - 1; j++) {
				if (i == 0 || j == 0 || j == a[i].length - 1)
					a[i][j] = 1;
				else
					a[i][j] = a[i - 1][j - 1] + a[i - 1][j];
			}
		for (int i = 0; i <= ROW; i++) {
			for (int j = 0; j <= a[i].length - 1; j++)
				System.out.print(a[i][j] + "\t");
			System.out.println();
		}
	}
}
