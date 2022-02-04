import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int[] arr,brr;


	public static void main(String[] args) throws Exception {
		arr = new int[9];
		brr = new int[9];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<9;i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<9;i++)
			brr[i] = Integer.parseInt(st.nextToken());
		
		boolean chk = false;
		int ans = 0;
		for(int i=0;i<9;i++) {
			ans += arr[i];
			if(ans>0) chk = true;
			ans -= brr[i];
		}
		if(chk && ans <0) sb.append("Yes");
		else sb.append("No");
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}