import java.io.*;
import java.util.*;
 
class Solution {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static int tc,ans;
	static String a,b;
	static Set<Integer> av,bv;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer st = new StringTokenizer(br.readLine());
		tc = Integer.valueOf(br.readLine());
		
        for (int test_case = 1; test_case <= tc; test_case++) {
        	a = br.readLine();
        	b = br.readLine();
        	av = new HashSet<Integer>();
        	bv = new HashSet<Integer>();
        	for(int i=0;i<a.length();i++) {
        		String tmp = a;
        		if(tmp.charAt(i) == '0') {
        			tmp = tmp.substring(0, i) + "1" + tmp.subSequence(i+1, tmp.length());
        		}
        		else {
        			tmp = tmp.substring(0, i) + "0" + tmp.subSequence(i+1, tmp.length());
        		}
        		solve(tmp,2);
        	}
        	
        	for(int i=0;i<b.length();i++) {
        		String tmp = b;
        		if(tmp.charAt(i)=='0') {
        			solve( tmp.substring(0, i) + "1" + tmp.subSequence(i+1, tmp.length()),3);
        			solve( tmp.substring(0, i) + "2" + tmp.subSequence(i+1, tmp.length()),3);
        		}
        		else if(tmp.charAt(i)=='1') {
        			solve( tmp.substring(0, i) + "0" + tmp.subSequence(i+1, tmp.length()),3);
        			solve( tmp.substring(0, i) + "2" + tmp.subSequence(i+1, tmp.length()),3);
        		}
        		else if(tmp.charAt(i)=='2') {
        			solve( tmp.substring(0, i) + "0" + tmp.subSequence(i+1, tmp.length()),3);
        			solve( tmp.substring(0, i) + "1" + tmp.subSequence(i+1, tmp.length()),3);
        		}
        	}
        	
        	bw.write("#"+String.valueOf(test_case)+" ");
        	for(int x : av) {
        		if(bv.contains(x)) {
        			bw.write(String.valueOf(x));
        		}
        	}
        	bw.newLine();
        }
        
        bw.flush();
        bw.close();
    }
	public static void solve(String x,int gop) {
		int gg = 1;
		int sum =0;
		for(int i=x.length()-1;i>=0;i--) {
			sum += (x.charAt(i)-'0') * gg;
			gg*=gop;
		}
		if(gop==2)
			av.add(sum);
		else if(gop==3)
			bv.add(sum);
	}
}