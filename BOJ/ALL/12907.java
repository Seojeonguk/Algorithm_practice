import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int n,cnt,x,i,j;
	static int[] arr;
	
	
	public static void main(String[] args) throws Exception {
		n = Integer.parseInt(br.readLine());
		arr = new int[41];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<n;i++) {
			x = Integer.parseInt(st.nextToken());
			arr[x]++;
		}
		
		for(i=0;i<41;i++) {
			if(arr[i]==0) break;
			arr[i]--;
		}
		
		for(j=0;j<41;j++) {
			if(arr[j]==0) break;
			arr[j]--;
		}
		
		if(i+j != n) System.out.println("0");
		else System.out.println(1<<(j+(i==j ? 0:1)));
	}
}