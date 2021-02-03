import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static int t,n;
	static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		t = Integer.valueOf(br.readLine());
		
		for(int test_case=1 ;test_case<=t;test_case++) {
			n = Integer.valueOf(br.readLine());
			arr = new int[n];
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<n;i++) arr[i] = Integer.valueOf(st.nextToken());
			
			Arrays.sort(arr);

			bw.write(arr[0] + " " + arr[n-1] + "\n");
		}

		bw.flush();
		bw.close();
	}
}