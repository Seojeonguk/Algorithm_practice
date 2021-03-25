import java.io.*;
import java.util.*;

public class Solution {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int t,n,lis_idx;
	static int[] arr,lis;
	
	public static void main(String[] args) throws Exception {
		t = Integer.valueOf(br.readLine());
		for(int tc=1 ; tc<=t; tc++) {
			n = Integer.valueOf(br.readLine());
			arr = new int[n+1];
			lis = new int[n+1];
			lis_idx=0;
			st = new StringTokenizer(br.readLine());
			
			for(int i=0;i<n;i++)
				arr[i] = Integer.valueOf(st.nextToken());
			
			lis[0] = arr[0];
			
			for(int i=1;i<n;i++) {
				if(lis[lis_idx] <= arr[i]) lis[++lis_idx] = arr[i];
				else lis[upperbound(lis_idx, arr[i])] = arr[i];
			}
			bw.write("#" + String.valueOf(tc) + " " + String.valueOf(lis_idx+1) + "\n");
		}
		bw.flush();
		bw.close();
	}
	
	public static int upperbound(int r,int target) {
		int l =0;
		while(l<r) {
			int mid =(l+r)/2;
			if(lis[mid] <= target) l = mid+1;
			else r = mid;
		}
		return r;
	}
}