import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static double d[] = new double[3];
	static double a,b,c;

	public static void main(String[] args) throws Exception {		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<3;i++)
			d[i] = Double.valueOf(st.nextToken());
		
		a = (d[0] + d[1]-d[2])/2;
		b = d[0]-a;
		c = d[1]-a;

		if(a>0 && b>0 && c>0) {
			System.out.println("1");
			System.out.println(a + " " + b + " " + c);
		}
		else {
			System.out.println("-1");
		}
		
		bw.flush();
		bw.close();
	}
}