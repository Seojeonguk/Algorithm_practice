import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int n,k,ans;
	static char[] arr;
	
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		
		n = Integer.valueOf(st.nextToken());
		k = Integer.valueOf(st.nextToken());
		
		arr = br.readLine().toCharArray();
		
		for(int i=0;i<n;i++) {
			if(arr[i]=='P') {
				for(int j=Math.max(0, i-k) ; j<=Math.min(n-1, i+k);j++) {
					if(arr[j]=='H') {
						arr[j]='.';
						ans++;
						break;
					}
				}
			}
		}
		
		System.out.println(ans);
		
		bw.flush();
		bw.close();
	}
}