import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static String a,b,c;
	static int[] fail;
	static int a_size,b_size,c_size;
	static boolean a_chk,b_chk;
	
	public static void main(String[] args) throws Exception {
		a = br.readLine();
		b = br.readLine();
		c = br.readLine();
		
		a_size = a.length();
		b_size = b.length();
		c_size = c.length();
		
		fail = new int[c_size];
		
		for(int i=1,j=0;i<c_size;i++) {
			while(j>0 && c.charAt(i) != c.charAt(j)) j = fail[j-1];
			if(c.charAt(i) == c.charAt(j)) fail[i] = ++j;
		}
		
		for(int i=0,j=0;i<a_size;i++) {
			while(j>0 & a.charAt(i) != c.charAt(j)) j = fail[j-1];
			
			if(a.charAt(i) == c.charAt(j)) {
				if(j==c_size-1) {
					a_chk = true;
					break;
				} else j++;
			}
		}
		
		for(int i=0,j=0;i<b_size;i++) {
			while(j>0 & b.charAt(i) != c.charAt(j)) j = fail[j-1];
			
			if(b.charAt(i) == c.charAt(j)) {
				if(j==c_size-1) {
					b_chk = true;
					break;
				} else j++;
			}
		}
		
		if(a_chk && b_chk) System.out.println("YES");
		else System.out.println("NO");
	}
}