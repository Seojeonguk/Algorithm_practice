import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int totalParticipant = Integer.parseInt(st.nextToken());
        int budget = Integer.parseInt(st.nextToken());
        int totalHotel = Integer.parseInt(st.nextToken());
        int week = Integer.parseInt(st.nextToken());
        int minBudget = budget+1;
        Loop1:
        for(int i=0;i<totalHotel;i++) {
        	int cost = Integer.parseInt(br.readLine());
        	st = new StringTokenizer(br.readLine());
        	
        	if(cost * totalParticipant > budget) {
        		continue;
        	}
        	
        	for(int j=0;j<week;j++) {
        		int canStayHotel = Integer.parseInt(st.nextToken());
        		if(canStayHotel >= totalParticipant) {
        			minBudget = Math.min(minBudget, cost * totalParticipant);
        			continue Loop1;
        		}
        	}
        }
        
        if(minBudget == budget+1) {
        	sb.append("stay home");
        } else {
        	sb.append(minBudget);
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
