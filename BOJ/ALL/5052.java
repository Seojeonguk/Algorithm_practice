import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int t,n;
	static String[] arr;
	static boolean chk;

	public static void main(String[] args) throws Exception {
		t = Integer.valueOf(br.readLine());
		
		while(t-->0) {
			n = Integer.valueOf(br.readLine());
			arr = new String[n];
			chk = false;
			
			for(int i=0;i<n;i++)
				arr[i] = br.readLine();

			Arrays.sort(arr);
			
			for(int i=0;i<n-1;i++) {
				int up_size = arr[i].length();
				int down_size = arr[i+1].length();
				int sub_length = up_size > down_size ? down_size : up_size;
				
				if(arr[i].equals(arr[i+1].substring(0,sub_length))) {
					chk = true;
					break;
				}
			}
			
			if(chk) bw.write("NO");
			else bw.write("YES");
			bw.newLine();
		}

		bw.flush();
		bw.close();
	}
}