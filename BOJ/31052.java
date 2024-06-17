import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            StringTokenizer st = new StringTokenizer(br.readLine());
            int companyCnt = Integer.parseInt(st.nextToken());
            int queryCnt = Integer.parseInt(st.nextToken());

            Company[] companies = new Company[companyCnt + 1];
            StringTokenizer locations = new StringTokenizer(br.readLine());
            for (int companyNum = 1; companyNum <= companyCnt; companyNum++) {
                int location = Integer.parseInt(locations.nextToken());
                companies[companyNum] = new Company(location);
            }

            for (int queryNum = 0; queryNum < queryCnt; queryNum++) {
                StringTokenizer queries = new StringTokenizer(br.readLine());
                int command = Integer.parseInt(queries.nextToken());
                int a = Integer.parseInt(queries.nextToken());
                int b = Integer.parseInt(queries.nextToken());

                if (command == 1) {
                    companies[a].setLocation(b);
                } else if (command == 2) {
                    sb.append(companies[a].getDistance(companies[b])).append("\n");
                }
            }

            bw.write(sb.toString());
        }
    }

    static class Company {
        int location;

        Company(int location) {
            this.location = location;
        }

        public void setLocation(int location) {
            this.location = location;
        }

        public int getDistance(Company other) {
            return Math.abs(location - other.location);
        }
    }
}
