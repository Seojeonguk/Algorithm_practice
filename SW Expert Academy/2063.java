import java.io.*;
import java.util.*;

class Solution {

    static Scanner sc = new Scanner(System.in);
	static int n,sum;
	static int[] arr;

	public static void main(String[] args) throws Exception {
        arr = new int[101];
		n = sc.nextInt();
		
		for(int i=0;i<n;i++) arr[sc.nextInt()]++;

		for(int i=0;i<=100;i++) {
			if(sum+arr[i] >= n/2+1) {
				System.out.println(i);
				break;
			}
			sum+=arr[i];
		}
	}
}