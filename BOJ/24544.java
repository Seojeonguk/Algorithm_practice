import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int contentCnt = Integer.parseInt(br.readLine());

            View[] views = new View[contentCnt];

            StringTokenizer interestings = new StringTokenizer(br.readLine());
            StringTokenizer registrationStatuses = new StringTokenizer(br.readLine());

            for (int i = 0; i < contentCnt; i++) {
                int interesting = Integer.parseInt(interestings.nextToken());
                int registrationStatus = Integer.parseInt(registrationStatuses.nextToken());

                views[i] = new View(interesting, registrationStatus);
            }

            int totalInteresting = Arrays.stream(views)
                    .mapToInt(view -> view.interesting)
                    .sum();

            int totalInterestingRegistered = Arrays.stream(views)
                    .filter(view -> view.registrationStatus == 0)
                    .mapToInt(view -> view.interesting)
                    .sum();

            sb.append(totalInteresting)
                    .append("\n")
                    .append(totalInterestingRegistered);


            bw.write(sb.toString());
        }
    }

    static class View {
        int interesting;
        int registrationStatus;

        public View(int interesting, int registrationStatus) {
            this.interesting = interesting;
            this.registrationStatus = registrationStatus;
        }
    }
}
