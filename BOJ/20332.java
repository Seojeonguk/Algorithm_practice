import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static int n,w,sum;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.valueOf(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<n;i++) sum += Integer.valueOf(st.nextToken());
		
		bw.write(sum%3==0 ? "yes" : "no");

		bw.flush();
		bw.close();
	}
}