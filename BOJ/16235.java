import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static class tree implements Comparable<tree> {
		int x,y,age;
		public tree(int x,int y,int age) {
			this.x = x;
			this.y = y;
			this.age = age;
		}
		
		@Override
		public int compareTo(tree o) {
			return this.age - o.age;
		}
	}
	
	static int n,m,k,x,y,age;
	static int[][] nutrient,land;
	static Deque<tree> dq = new ArrayDeque<Main.tree>();
	static List<tree> l,die_tree,breeding;
	static int[] X= {-1,-1,-1,0,0,1,1,1}, Y= {-1,0,1,-1,1,-1,0,1};

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		l = new LinkedList<tree>();
		nutrient = new int[n][n];
		land = new int[n][n];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				land[i][j] = 5;
				nutrient[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			age = Integer.parseInt(st.nextToken());
			l.add(new tree(x-1,y-1,age));
		}
		
		Collections.sort(l);
		dq.addAll(l);
		
		for(int time=0;time<k;time++) {
			int length = dq.size();
			die_tree = new LinkedList<tree>();
			for(int i=0;i<length;i++) {
				tree out = dq.pollFirst();
				if(land[out.x][out.y]>= out.age ) {
					land[out.x][out.y]-= out.age;
					dq.addLast(new tree(out.x,out.y,out.age+1));
				} else {
					die_tree.add(out);
				}
			}
			for(tree item : die_tree)
				land[item.x][item.y] += item.age/2;
				
			breeding = new LinkedList<tree>();
			for(tree item: dq) 
				if(item.age%5==0)
					breeding.add(item);
					
			for(tree item: breeding) {
				for(int i=0;i<8;i++) {
					int nx = item.x + X[i];
					int ny = item.y + Y[i];
					if(nx<0 || ny<0 || nx>n-1 || ny>n-1) continue;
					dq.addFirst(new tree(nx,ny,1));
				}
			}
			
			for(int i=0;i<n;i++)
				for(int j=0;j<n;j++)
					land[i][j] += nutrient[i][j];
		}
		sb.append(dq.size());
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}