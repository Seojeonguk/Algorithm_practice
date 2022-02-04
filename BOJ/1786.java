import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static char[] t,p;
	static int t_length,p_length;
	static int[] fail;
	static List<Integer> ans = new ArrayList<Integer>();
	
	public static void main(String[] args) throws Exception {
		t = br.readLine().toCharArray();
		p = br.readLine().toCharArray();
		t_length = t.length;
		p_length = p.length;
		
		fail = new int[p_length+3];
		
		for(int i=1,j=0;i<p_length;i++) {
			while(j>0 && p[i] != p[j]) j=fail[j-1];
			if(p[i]==p[j]) fail[i] = ++j;
		}
		
		
		for(int i=0, j=0;i<t_length;i++) {
			while(j>0 && t[i] != p[j]) j=fail[j-1];
			
			if(t[i]==p[j]) {
				if(j==p_length-1) {
					ans.add(i-p_length+2);
					j = fail[j];
				} else j++;
			}
		}
		
		System.out.println(ans.size());
		for(int item : ans)
			System.out.print(item + " ");
	}
}