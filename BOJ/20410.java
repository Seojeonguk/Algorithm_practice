import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static int m,seed,x1,x2;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());
		
		m = Integer.valueOf(st.nextToken());
		seed = Integer.valueOf(st.nextToken());
		x1 = Integer.valueOf(st.nextToken());
		x2 = Integer.valueOf(st.nextToken());
		
		boolean chk = false;
		for(int i=0;i<m;i++) {
			for(int j=0;j<m;j++) {
				int a = (i*seed+j)%m;
				int b = (i*x1+j)%m;
				if(x1==a && x2==b) {
					chk = true;
					bw.write(String.valueOf(i) + " " + String.valueOf(j));
					break;
				}
			}
			if(chk) break;
		}

		bw.flush();
		bw.close();
	}
}