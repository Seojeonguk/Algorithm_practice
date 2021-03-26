import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	StringBuilder sb = new StringBuilder();
	//System.out.println(sb.toString());

	static class data{
		int x,y,cost;

		public data(int x,int y,int cost) {
			this.x = x;
			this.y = y;
			this.cost = cost;
		}
	}

	static int n,m,ans,idx;
	static int[][] map;
	static int[] p,rank;
	static int[] X= {1,0,-1,0},Y= {0,1,0,-1};
	static Queue<data> q,w;
	static PriorityQueue<data> pq = new PriorityQueue<data>((o1,o2) -> o1.cost >= o2.cost ? 1 : -1);

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		w = new LinkedList<data>();
		p = new int[7];
		rank = new int[7];
		
		for(int i=0;i<7;i++)
			p[i] = i;

		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				map[i][j] = -Integer.parseInt(st.nextToken());
			}
		}

		label();

		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(map[i][j] !=0) {
					for(int d=0;d<4;d++) {
						int nx = i+X[d];
						int ny = j+Y[d];
						if(isout(nx,ny) || map[nx][ny] != 0) continue;
						calc_cost(nx,ny,d,map[i][j]);
					}
				}
			}
		}
		
		while(!pq.isEmpty()) {
			data outdata = pq.poll();
			
			if(find(outdata.x) != find(outdata.y)) {
				merge(outdata.x,outdata.y);
				ans += outdata.cost;
			}
		}
		
		for(int i=1;i<idx;i++) {
			if(find(p[i]) != find(p[i+1]))
				ans = -1;
		}
		
		System.out.println(ans);
	}

	public static void label() {
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(map[i][j] == -1) {
					q = new LinkedList<data>();
					q.add(new data(i,j,0));
					map[i][j] = ++idx;

					while(!q.isEmpty()) {
						data outdata = q.poll();

						for(int d=0;d<4;d++) {
							int nx = outdata.x + X[d];
							int ny = outdata.y + Y[d];

							if(isout(nx,ny) || map[nx][ny] != -1) continue;
							map[nx][ny] = idx;
							q.add(new data(nx,ny,0));
						}
					}
				}
			}
		}
	}

	public static void calc_cost(int x,int y,int d,int idx) {
		int cost = 1;
		int find_idx= -1;
		while(true) {
			x += X[d];
			y += Y[d];
			if(isout(x,y)) break;
			if(map[x][y] != 0) {
				find_idx = map[x][y];
				break;
			}
			cost++;
		}
		if(find_idx != -1 && cost > 1) 
			pq.add(new data(idx,find_idx,cost));
	}

	public static boolean isout(int x,int y) {
		return x<0 || y<0 || x>n-1 || y>m-1;
	}
	
	public static int find(int u) {
        if(u==p[u]) return u;
        return p[u] = find(p[u]);
    }
     
	public static void merge(int u,int v) {
        u = find(u);
        v = find(v);
        if(u==v) return;
        if(rank[u]>rank[v])
            p[v]=u;
        else {
            p[u]=v;
            if(rank[u]==rank[v])
                rank[v]++;
        }
    }
}