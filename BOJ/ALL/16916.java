import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static String s,p;
	static int s_length,p_length;
	static int[] fail;
	static boolean chk;
	
	
	public static void main(String[] args) throws Exception {
		s = br.readLine();
		p = br.readLine();
		
		s_length = s.length();
		p_length = p.length();
		
		fail = new int[p_length];
		for(int i=1,j=0;i<p_length;i++) {
			while(j>0 && p.charAt(i) != p.charAt(j)) j = fail[j-1];
			
			if(p.charAt(i) == p.charAt(j)) fail[i] = ++j;
			
		}
		for(int i=0,j=0;i<s_length;i++) {
			while(j>0 && s.charAt(i) != p.charAt(j)) j = fail[j-1];
			
			if(s.charAt(i) == p.charAt(j)) {
				if(j==p_length-1) {
					chk = true;
					break;
				} else j++;
			}
		}
		if(chk) System.out.println("1");
		else System.out.println("0");
	}
}