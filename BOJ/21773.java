import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            StringTokenizer st = new StringTokenizer(br.readLine());
            int times = Integer.parseInt(st.nextToken());
            int processCnt = Integer.parseInt(st.nextToken());

            PriorityQueue<Process> processes = new PriorityQueue<>((o1, o2) -> {
                if (o1.priority == o2.priority) {
                    return Integer.compare(o1.id, o2.id);
                }
                return Integer.compare(o2.priority, o1.priority);
            });

            for (int i = 0; i < processCnt; i++) {
                StringTokenizer processInfo = new StringTokenizer(br.readLine());
                int id = Integer.parseInt(processInfo.nextToken());
                int requiredTime = Integer.parseInt(processInfo.nextToken());
                int priority = Integer.parseInt(processInfo.nextToken());

                processes.add(new Process(id, requiredTime, priority));
            }

            for (int i = 0; i < times; i++) {
                Process process = processes.poll();
                process.processing();

                if (process.requiredTime > 0) {
                    processes.add(process);
                }

                sb.append(process.id).append("\n");
            }

            bw.write(sb.toString());
        }
    }

    static class Process {
        int id;
        int requiredTime;
        int priority;

        Process(int id, int requiredTime, int priority) {
            this.id = id;
            this.requiredTime = requiredTime;
            this.priority = priority;
        }

        public void processing() {
            this.priority--;
            this.requiredTime--;
        }
    }
}
