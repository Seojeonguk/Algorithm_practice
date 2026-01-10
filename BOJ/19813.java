import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int testCase = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < testCase; tc++) {
            String date = br.readLine();
            if (date.contains(".")) {
                String[] dateSplit = date.split("\\.");
                convert(dateSplit[2], dateSplit[1], dateSplit[0]);
            } else {
                String[] dateSplit = date.split("/");
                convert(dateSplit[2], dateSplit[0], dateSplit[1]);
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }

    public static void convert(String year, String month, String day) {
        int yearInt = Integer.parseInt(year);
        int monthInt = Integer.parseInt(month);
        int dayInt = Integer.parseInt(day);
        sb.append(String.format("%02d.%02d.%04d", dayInt, monthInt, yearInt))
                .append(" ")
                .append(String.format("%02d/%02d/%04d", monthInt, dayInt, yearInt))
                .append("\n");
    }
}
