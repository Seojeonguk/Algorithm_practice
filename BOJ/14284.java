import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Comparator;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int totalPoint = Integer.parseInt(st.nextToken());
        int totalNodes = Integer.parseInt(st.nextToken());
        
        ArrayList<Node>[] nodes = new ArrayList[totalPoint + 1];
        for(int i = 1; i <= totalPoint; i++) {
        	nodes[i] = new ArrayList<>();
        }
        
        for(int i=0;i<totalNodes;i++) {
        	st = new StringTokenizer(br.readLine());
        	int aPoint = Integer.parseInt(st.nextToken());
        	int bPoint = Integer.parseInt(st.nextToken());
        	int cost = Integer.parseInt(st.nextToken());
        	
        	nodes[aPoint].add(new Node(bPoint, cost));
        	nodes[bPoint].add(new Node(aPoint, cost));
        }
        
        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        
        int[] dist = new int[totalPoint + 1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        
        dist[s] = 0;
        PriorityQueue<Node> q = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
        q.add(new Node(s,0));
        
        while(!q.isEmpty()) {
        	Node cur = q.poll();
        	
        	if(dist[cur.point] < cur.cost) {
        		continue;
        	}
        	
        	for(Node node : nodes[cur.point]) {
        		int nextPoint = node.point;
        		int nextCost = cur.cost + node.cost;
        		
        		if(dist[nextPoint] <= nextCost) {
        			continue;
        		}
        		dist[nextPoint] = nextCost;
        		q.add(new Node(nextPoint, nextCost));
        	}
        }
        
        sb.append(dist[t]);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    
    static class Node {
    	int point,cost;
    	
    	Node(int point,int cost) {
    		this.point = point;
    		this.cost = cost;
    	}
    }
}
