import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int candidateCnt = Integer.parseInt(br.readLine());
        int dasomTicket = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> tickets = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < candidateCnt - 1; i++) {
            int ticket = Integer.parseInt(br.readLine());
            tickets.add(ticket);
        }

        int buyingCnt = 0;
        while (!tickets.isEmpty() && tickets.peek() >= dasomTicket) {
            int ticket = tickets.poll();
            tickets.add(ticket - 1);
            dasomTicket++;
            buyingCnt++;
        }
        sb.append(buyingCnt);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
