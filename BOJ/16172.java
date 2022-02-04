import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int s_size,p_size;
	static char[] temp,s,p;
	static int[] fail;
	static boolean chk;
	
	
	public static void main(String[] args) throws Exception {
		temp = br.readLine().toCharArray();
		s = new char[200002];
		for(char item : temp) {
			if('0'<=item && item<='9') continue;
			s[s_size++] = item;
		}
		
		p = br.readLine().toCharArray();
		p_size = p.length;
		fail = new int[p_size];
		
		for(int i=1,j=0;i<p_size;i++) {
			while(j>0 && p[i] != p[j]) j= fail[j-1];
			if(p[i] == p[j]) fail[i] = ++j;
		}
		
		for(int i=0,j=0;i<s_size;i++) {
			while(j>0 && s[i] != p[j]) j=fail[j-1];
			if(s[i]==p[j]) {
				if(j==p_size-1) {
					chk = true;
					break;
				}
				else j++;
			}
		}
		
		
		
		if(chk) System.out.println("1");
		else System.out.println("0");
	}
}