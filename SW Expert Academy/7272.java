import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
 
class Solution {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static String no = "CEFGHIJKLMNSTUVWXYZ";
	static String one = "ADOPQR";
	static String two = "B";
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int tc = Integer.valueOf(st.nextToken());
		
        for (int test_case = 1; test_case <= tc; test_case++) {
        	st = new StringTokenizer(br.readLine());
        	String a = st.nextToken();
        	String b = st.nextToken();
        	
        	boolean chk = true;
        	
        	if(a.length() != b.length()) {
        		chk = false;
        	}
        	else {
	        	for(int i=0;i<a.length();i++) {
	        		if(!chk(String.valueOf(a.charAt(i)),String.valueOf(b.charAt(i)))) {
	        			chk = false;
	        			break;
	        		}
	        	}
        	}
        	
        	bw.write("#" + String.valueOf(test_case) + " " + (chk?"SAME":"DIFF") + "\n");
        }
        
        bw.flush();
        bw.close();
    }
	
	public static boolean chk(String a, String b) {
		if(no.contains(a) && no.contains(b))
			return true;
		if(one.contains(a) && one.contains(b))
			return true;
		if(two.contains(a) && two.contains(b)) 
			return true;
		return false;
	}
}