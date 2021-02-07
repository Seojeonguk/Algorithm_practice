import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static int n;
	static char[] str;
	static double[] value;
	static Stack<Double> s;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.valueOf(br.readLine());
		str = br.readLine().toCharArray();
		
		value = new double[n];
		s = new Stack<Double>();
		
		for(int i=0;i<n;i++) value[i] = Double.valueOf(br.readLine());
		
		int size = str.length;
		for(int i=0;i<size;i++) {
			if('A' <= str[i] && str[i]<='Z')
				s.push(value[str[i]-'A']);
			else {
				double a = s.pop();
				double b = s.pop();

				s.push(solve(a,b,str[i]));
			}
		}
		
		System.out.printf("%.2f",s.peek());

		bw.flush();
		bw.close();
	}
	
	public static double solve(double a,double b, char c) {
		if(c=='+') return b+a;
		else if(c=='-') return b-a;
		else if(c=='*') return b*a;
		else if(c=='/') return b/a;
		return 0;
	}
}