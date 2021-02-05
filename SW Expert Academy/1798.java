import java.io.*;
import java.util.*;

class Solution {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static int t,n,m;
	static int[][] arr;
	static int start_idx,happiness;
	static List<Integer> ans;
	static List<P> p;
	static List<Integer> h;
	static List<Integer> move_list;
	static boolean[]visit;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		t = Integer.valueOf(br.readLine());
		
		for(int test_case = 1;test_case<=t;test_case++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.valueOf(st.nextToken());
			m = Integer.valueOf(st.nextToken());
			
			p = new LinkedList<P>();
			h = new LinkedList<Integer>();
			move_list = new LinkedList<Integer>();
			ans = new LinkedList<Integer>();
			arr = new int[n][n];
			visit = new boolean[n];
			happiness = 0;
			
			for(int i=0;i<n-1;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=i+1;j<n;j++) 
					arr[i][j] = arr[j][i] = Integer.valueOf(st.nextToken());
			}
			
			for(int i=0;i<n;i++) {
				st = new StringTokenizer(br.readLine());
				
				String a = st.nextToken();
				if(a.equals("A")) start_idx = i;
				else if(a.equals("P")) p.add(new P(i,Integer.valueOf(st.nextToken()),Integer.valueOf(st.nextToken())));
				else if(a.equals("H")) h.add(i);
			}
	
			solve(start_idx,1,0,0);
			bw.write("#" + String.valueOf(test_case) + " " + String.valueOf(happiness) + " ");
			for(int item : ans) 
				bw.write(String.valueOf(item+1) + " " );
			bw.newLine();
		}

		bw.flush();
		bw.close();
	}
	
	public static void solve(int idx, int day,int happy,int time) {
		for(P item : p) {
			if(!visit[item.idx] && time+arr[idx][item.idx]+item.cost<=540) {
				visit[item.idx] = true;
				move_list.add(item.idx);
				solve(item.idx,day,happy+item.happy,time+arr[idx][item.idx]+item.cost);
				move_list.remove(move_list.size()-1);
				visit[item.idx] = false;
			}
		}
		
		
		if(day==m) {
			if(happy > happiness && time + arr[idx][start_idx] <= 540) {
				happiness = happy;
				ans = new LinkedList<Integer>(move_list);
				ans.add(start_idx);
			}
		}
		else {
			for(int hotel : h) {
				if(arr[idx][hotel] + time <= 540) {
					move_list.add(hotel);
					solve(hotel,day+1,happy,0);
					move_list.remove(move_list.size()-1);
				}
			}
		}
	}
}

class P {
	int idx,cost,happy;
	
	public P(int idx,int cost,int happy) {
		this.idx = idx;
		this.cost = cost;
		this.happy = happy;
	}
	
	public P(P p) {
		idx = p.idx;
		cost = p.cost;
		happy = p.happy;
	}
}