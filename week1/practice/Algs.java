package com.hyace.util;
public class Algs{
	/**
	 * Binary search
	 */
	public static int binarySearch(int[]a,int key){
		int l=0,h=a.length-1;
		while(l<h){
			int mid=(l+h)/2;
			if(key<a[mid])
				h=mid-1;
			else if(key>a[mid])
				l=mid+1;
			else 
				return mid;
		}
		return -1;
	}	
	/**
	 * gcd
	 */
	public static int gcd(int p, int q){
		if(q==0) return p;
		else return gcd(q, p % q);
	}
}

