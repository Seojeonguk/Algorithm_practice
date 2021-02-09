import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static int n,input;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.valueOf(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			bw.write(String.valueOf(n+1-Integer.valueOf(st.nextToken())) + " ");
		}

		bw.flush();
		bw.close();
	}
}