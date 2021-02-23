import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int t,n,ans,idx;
	static int[] arr,brr;
	
	public static void main(String[] args) throws Exception {
		t = Integer.valueOf(br.readLine());
		
		while(t--!=0) {
			n = Integer.valueOf(br.readLine());
			
			arr = new int[n];
			brr = new int[n];
			ans=idx=0;
			
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<n;i++)
				arr[i] = Integer.valueOf(st.nextToken());
			
			Arrays.sort(arr);
			
			for(int i=0;i<n;i+=2) {
				brr[idx++]=arr[i];
			}
			
			for(int i=(n%2==0?n-1:n-2);i>=0;i-=2)
				brr[idx++]=arr[i];
			
			for(int i=0;i<n;i++)
				ans = Math.max(ans,Math.abs(brr[i]-brr[(i+1)%n]));
			
			bw.write(String.valueOf(ans+"\n"));
		}
		
		bw.flush();
		bw.close();
	}
}