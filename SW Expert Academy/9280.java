import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;
 
class Solution {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static int n,m,ans,size;
	static int R[],W[],park[];
	static List<Integer> l;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int tc = Integer.valueOf(st.nextToken());
		
        for (int test_case = 1; test_case <= tc; test_case++) {
        	st = new StringTokenizer(br.readLine());
        	
        	n = Integer.valueOf(st.nextToken());
        	m = Integer.valueOf(st.nextToken());
        	
        	ans=0;
        	size=0;
        	R = new int[n+1];
        	W = new int[m+1];
        	park = new int[n+1];
        	l = new LinkedList<Integer>();
   
        	
        	for(int i=1;i<=n;i++) {
        		st = new StringTokenizer(br.readLine());
        		R[i] = Integer.valueOf(st.nextToken());
        	}
        	
        	for(int i=1;i<=m;i++) {
        		st = new StringTokenizer(br.readLine());
        		W[i] = Integer.valueOf(st.nextToken());
        	}
        	
        	for(int k=0;k<2*m;k++) {
        		st = new StringTokenizer(br.readLine());
        		int num = Integer.valueOf(st.nextToken());
        		
        		if(num>0) {
	        		if(size<n) {
	        			for(int i=1;i<=n;i++) {
	        				if(park[i]==0) {
	        					park[i] = num;
	        					ans += W[num] * R[i];
	        					size++;
	        					break;
	        				}
	        			}
	        		}
	        		else {
	        			l.add(num);
	        		}
        		}
        		else if(num<0) {
        			boolean chk = false;
        			for(int i=1;i<=n;i++) {
        				if(park[i] == -num) {
        					park[i] = 0;
        					chk = true;
        					break;
        				}
        			}
        			if(chk) {
        				if(l.size()!=0) {
        					int x = l.remove(0);
        					for(int i=1;i<=n;i++) {
        						if(park[i] == 0) {
        							park[i] = x;
        							ans += W[x] * R[i];
        							break;
        						}
        					}
        				}
        				else size--;
        			}
        			else {
        				for(int i=0;i<l.size();i++) {
        					if(l.get(i) == -num) {
        						l.remove(i);
        						break;
        					}
        				}
        			}
        		}
        	}
        	
        	bw.write("#" + String.valueOf(test_case) + " " + String.valueOf(ans) + "\n");
        }
        
        bw.flush();
        bw.close();
    }
}