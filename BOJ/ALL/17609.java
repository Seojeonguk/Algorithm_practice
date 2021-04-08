import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int t,start,end;
	static char[] arr;

	public static void main(String[] args) throws Exception {
		t = Integer.parseInt(br.readLine());
		
		for(int tc=0;tc<t;tc++) {
			arr = br.readLine().toCharArray();
			int l = 0, r = arr.length-1;
			int ans=0;
			while(l<r) {
				if(arr[l] == arr[r]) {
					l++;
					r--;
					continue;
				} 
				
				if(arr[l+1] != arr[r] && arr[l] != arr[r-1]) {
					ans = 2;
					break;
				}
				
				boolean chk =false;
				for(int i=0;i<2 && !chk;i++) {
					start = l;
					end = r;
					if(i==0) start++;
					else end--;
					
					chk = true;
					
					while(start<end) {
						if(arr[start++] != arr[end--]) {
							chk = false;
							break;
						}
					}
				}
				ans = chk?1:2;
				break;
			}
			sb.append(ans+"\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}