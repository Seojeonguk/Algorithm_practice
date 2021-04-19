import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int n,r,c;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++)
				if(((i%2)^(j%2)) == ((r%2) ^ (c%2))) sb.append('v');
				else sb.append('.');
			sb.append("\n");
		}
				
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}