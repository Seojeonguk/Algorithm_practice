import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static String s;
	static int ans;
	static int[] fail;
	
	
	public static void main(String[] args) throws Exception {
		s = br.readLine();
		for(int i=0;i<s.length();i++)
			solve(s.substring(i));
		System.out.println(ans);
	}
	
	public static void solve(String str) {
		int size = str.length();
		fail = new int[size+1];
		
		for(int i=1,j=0;i<size;i++) {
			while(j>0 && str.charAt(i) != str.charAt(j)) j=fail[j-1];
			
			if(str.charAt(i) == str.charAt(j)) fail[i] = ++j;
			
			ans = Math.max(ans, fail[i]);
		}
	}
}