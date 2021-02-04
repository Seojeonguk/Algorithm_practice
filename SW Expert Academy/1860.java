import java.io.*;
import java.util.*;
 
class Solution {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static int tc,n,m,k;
	static int brr[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		tc = Integer.valueOf(st.nextToken());
		
        for (int test_case = 1; test_case <= tc; test_case++) {
        	st = new StringTokenizer(br.readLine());
        	
        	n = Integer.valueOf(st.nextToken());
        	m = Integer.valueOf(st.nextToken());
        	k = Integer.valueOf(st.nextToken());
        	
        	brr = new int[n];
        	
        	st = new StringTokenizer(br.readLine());
        	for(int i=0;i<n;i++) 
        		brr[i] = Integer.valueOf(st.nextToken());
        	
        	Arrays.sort(brr);
        	
        	boolean chk = true;
        	
        	for(int i=0;i<n;i++) {
        		if(brr[i] == 0 ) {
        			chk = false;
        			break;
        		}
        		int x = (brr[i]/m)*k-i-1;
        		if(x<0) {
        			chk = false;
        			break;
        		}
        	}
        	
        	bw.write("#" + String.valueOf(test_case)+ " " + (chk ? "Possible" : "Impossible") + "\n");
        }
        
        bw.flush();
        bw.close();
    }
}