import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int n,ans,sum,now,out_cnt;
	static int[] arr = {0,1,2,3,4,5,6,7,8};
	static int[][] brr;
	
	public static void main(String[] args) throws Exception {
		n = Integer.valueOf(br.readLine());
		
		brr = new int[n][9];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j=0;j<9;j++)
				brr[i][j] = Integer.valueOf(st.nextToken());
		}
		
		do {
			if(arr[3]!=0) continue;
			now = sum = 0;
			
			for(int i=0;i<n;i++) {
				out_cnt = 0;
				boolean[] j = new boolean[4];
				while(out_cnt!=3) {
					if(brr[i][arr[now]]==0) {
						out_cnt++;
					} else {
						for(int k=3;k>=1;k--) {
							if(j[k]) {
								j[k] = false;
								if(k+brr[i][arr[now]] >=4) sum++;
								else j[k+brr[i][arr[now]]] = true;
							}
						}
						if(brr[i][arr[now]]==4) sum++;
						else j[brr[i][arr[now]]]= true;
					}
					now = (now+1)%9;
				}
			}
			ans = Math.max(ans, sum);
		}while(np());
		
		System.out.println(ans);
		
		bw.flush();
		bw.close();
	}
	
	public static boolean np() {
		int i=8;
		while(i>0 && arr[i-1]>=arr[i]) i--;
		
		if(i==0) return false;
		
		int j=8;
		while(arr[i-1]>=arr[j]) j--;
		swap(i-1,j);
		
		int k=8;
		while(i<k) {
			swap(i++,k--);
		}
		return true;
	}
	
	public static void swap(int x,int y) {
		int temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}
}