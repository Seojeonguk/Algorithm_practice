import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static char[] p;
	static int p_length;
	static int[] fail;
	static List<Integer> ans = new ArrayList<Integer>();
	
	public static void main(String[] args) throws Exception {
		p_length = Integer.parseInt(br.readLine());
		p = br.readLine().toCharArray();
		
		fail = new int[p_length+3];
		
		for(int i=1,j=0;i<p_length;i++) {
			while(j>0 && p[i] != p[j]) j=fail[j-1];
			if(p[i]==p[j]) fail[i] = ++j;
		}

		System.out.println(p_length-fail[p_length-1]);
	}
}