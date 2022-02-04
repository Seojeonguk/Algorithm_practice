import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static float a,b,c,d;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		
		a = Float.valueOf(st.nextToken());
		b = Float.valueOf(st.nextToken());
		c = Float.valueOf(st.nextToken());
		
		d = (float) ((Math.sqrt(a*a-b*b) * Math.sqrt(a*a-c*c)-b*c)/a);
		
		System.out.println((int)d<=0?-1:(int)d);
		
		bw.flush();
		bw.close();
	}
}