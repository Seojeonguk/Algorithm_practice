import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int n,cnt,zero,temp;
	static String s,p;
	static int[] fail;
	static boolean chk;
	
	
	
	public static void main(String[] args) throws Exception {
		n = Integer.parseInt(br.readLine());
		s = br.readLine().replace(" ", "");
		p = br.readLine().replace(" ", "");
		s += s.substring(0,s.length()-1);
		int p_size = p.length();
		int s_size = s.length();
		fail = new int[2*n];
		for(int i=1,j=0;i<p_size;i++) {
			while(j>0 && p.charAt(i)!=p.charAt(j)) j = fail[j-1];
			if(p.charAt(i) == p.charAt(j)) fail[i] = ++j;
		}


		
		for(int i=0,j=0;i<s_size;i++) {
			while(j>0 && s.charAt(i) != p.charAt(j)) j=fail[j-1];
			if(s.charAt(i) == p.charAt(j)) {
				if(j==n-1) {
					cnt++;
					j = fail[j];
				} else j++;
			}
		}
		
		int gg = gcd(cnt,n);
		System.out.println((cnt/gg) + "/" + (n/gg));
	}
	
	public static int gcd(int x,int y) {
		if(y==0) return x;
		return gcd(y,x%y);
	}
}