import java.io.*;
import java.util.*;

class Solution {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static int n;
	static String str;
	static Stack<String> s;
	static boolean chk;
	static String[] arr= {"(","[","{","<"};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		for(int test_case=1 ;test_case<=10;test_case++) {
			chk = true;
			n = Integer.valueOf(br.readLine());
			
			str = br.readLine();
			
			s = new Stack<String>();
			
			for(int i=0;i<n;i++) {
				String tmp = str.substring(i,i+1);
				
				if(tmp.equals("(") || tmp.equals("{") || tmp.equals("<") || tmp.equals("[")) {
					s.push(tmp);
				}
				else {
					String top=null;
					if(!s.isEmpty()) {
						top = s.peek();
						s.pop();
					}
					if(top==null) {
						chk = false;
						break;
					}
					if(tmp.equals(")")) {
						if(!top.equals("(")) {
							chk = false; 
							break;
						}
					}
					if(tmp.equals("]")) {
						if(!top.equals("[")) {
							chk = false;
							break;
						}
					}
					if(tmp.equals("}")) {
						if(!top.equals("{")) {
							chk = false;
							break;
						}
					}
					if(tmp.equals(">")) {
						if(!top.equals("<")) {
							chk = false;
							break;
						}
					}
				}
			}

			System.out.printf("#%d %d\n",test_case,(chk?1:0));
		}

		bw.flush();
		bw.close();
	}
}