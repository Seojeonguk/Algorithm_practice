import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int t;
	static double h,angle,d;

	public static void main(String[] args) throws Exception {
		t = Integer.parseInt(br.readLine());
		
		for(int i=1;i<=t;i++) {
			st = new StringTokenizer(br.readLine());
			h = Double.parseDouble(st.nextToken());
			angle = Double.parseDouble(st.nextToken());
			
			d = Math.abs(h/Math.tan(angle/180*Math.PI)-h);
			sb.append("Case " + i + ": " + d + "\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}