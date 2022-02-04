import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static String a,b,a_str,b_str;
	static boolean chk;
	
	public static void main(String[] args) throws Exception {
		a = br.readLine();
		b = br.readLine();
		int a_length = a.length();
		int b_length = b.length();
		
		int a_b_lcm = a_length * b_length / gcd(a_length,b_length);
		
		for(int i=0;i<a_b_lcm/a_length;i++)
			a_str += a;
		for(int i=0;i<a_b_lcm/b_length;i++)
			b_str += b;
		if(a_str.equals(b_str)) System.out.println("1");
		else System.out.println("0");
	}
	
	public static int gcd(int x,int y) {
		if(y==0) return x;
		return gcd(y,x%y);
	}
}