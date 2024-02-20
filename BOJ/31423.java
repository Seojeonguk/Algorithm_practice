import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int collegeCnt = Integer.parseInt(br.readLine());
        College[] colleges = new College[collegeCnt + 1];
        for (int i = 1; i <= collegeCnt; i++) {
            String name = br.readLine();
            colleges[i] = new College(name);
        }

        int lastX = -1;
        for (int i = 0; i < collegeCnt - 1; i++) {
            StringTokenizer selectedColleges = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(selectedColleges.nextToken());
            int y = Integer.parseInt(selectedColleges.nextToken());

            colleges[x].last.setNext(colleges[y]);
            colleges[x].last = colleges[y].last;

            lastX = x;
        }

        College college = colleges[lastX];
        while (college != null) {
            sb.append(college.name);
            college = college.next;
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static class College {
        String name;
        College next;
        College last;

        College(String name) {
            this.name = name;
            next = null;
            last = this;
        }

        public void setNext(College next) {
            this.next = next;
        }
    }
}
