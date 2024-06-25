import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int anniversary = Integer.parseInt(br.readLine());

            Calendar calendar = Calendar.getInstance();
            calendar.set(2014, Calendar.APRIL, 2);
            calendar.add(Calendar.DATE, anniversary - 1);

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            sb.append(dateFormat.format(calendar.getTime()));

            bw.write(sb.toString());
        }
    }
}
