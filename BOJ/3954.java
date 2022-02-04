import java.io.*;
import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static int t;
	static int sm,sc,si;
	static int idx,brr_idx,crr_idx;
	static int cnt;
	static char[] brr,crr;
	static int[] jump,arr,count;
	static int maxcnt,mincnt;
	static Stack<Integer> s;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		t = Integer.valueOf(br.readLine());
		
		for(int tc=0;tc<t;tc++) {
			st = new StringTokenizer(br.readLine());
			
			sm = Integer.valueOf(st.nextToken());
			sc = Integer.valueOf(st.nextToken());
			si = Integer.valueOf(st.nextToken());
			
			arr = new int[sm];
			jump = new int[sc];
			count = new int[sc];
			idx = cnt = crr_idx = brr_idx = 0;
			s = new Stack<Integer>();
			
			brr = br.readLine().toCharArray();
			crr = br.readLine().toCharArray();
			
			for(int i=0;i<sc;i++) {
				if(brr[i]=='[') s.push(i);
				else if(brr[i]==']') {
					int top = s.pop();
					jump[top] = i;
					jump[i] = top;
				}
			}
			
			while(cnt<=50000000 && brr_idx<sc) {
				if(brr[brr_idx]=='+') arr[idx] = (arr[idx]+1) % 256;
				else if(brr[brr_idx]=='-') arr[idx] = (arr[idx]-1+256) % 256;
				else if(brr[brr_idx]=='<') idx = (idx-1+sm)%sm;
				else if(brr[brr_idx]=='>') idx = (idx+1)%sm;
				else if(brr[brr_idx]=='[') {
					if(arr[idx]==0) brr_idx = jump[brr_idx];
				}
				else if(brr[brr_idx]==']') {
					if(arr[idx]!=0) {
						brr_idx = jump[brr_idx];
					}
				}
				else if(brr[brr_idx]=='.') {}
				else if(brr[brr_idx] == ',') arr[idx] = (crr_idx==si?255:crr[crr_idx++]);
				cnt++;
				brr_idx++;
			}
			if(cnt<=50000000) bw.write("Terminates");
			else {
				bw.write("Loops ");
				maxcnt = brr_idx;
				mincnt = brr_idx;
				while(cnt-->0) {
					if(brr[brr_idx]=='+') arr[idx] = (arr[idx]+1) % 256;
					else if(brr[brr_idx]=='-') arr[idx] = (arr[idx]-1+256) % 256;
					else if(brr[brr_idx]=='<') idx = (idx-1+sm)%sm;
					else if(brr[brr_idx]=='>') idx = (idx+1)%sm;
					else if(brr[brr_idx]=='[') {
						if(arr[idx]==0) brr_idx = jump[brr_idx];
					}
					else if(brr[brr_idx]==']') {
						if(arr[idx]!=0) {
							brr_idx = jump[brr_idx];
						}
					}
					else if(brr[brr_idx]=='.') {}
					else if(brr[brr_idx] == ',') arr[idx] = (crr_idx==si?255:crr[crr_idx++]);
					brr_idx++;
					
					maxcnt = Math.max(maxcnt, brr_idx);
					mincnt = Math.min(mincnt, brr_idx);
				}
				bw.write(String.valueOf(mincnt-1) + " " + String.valueOf(maxcnt));
			}
			bw.newLine();
		}
		
		bw.flush();
		bw.close();
	}
}