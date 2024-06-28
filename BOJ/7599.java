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

            while (true) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String libraryName = st.nextToken();
                int characterWidth = Integer.parseInt(st.nextToken());

                if ("#".equals(libraryName)) {
                    break;
                }

                sb.append(libraryName).append(" Library").append("\n");

                int bookCnt = Integer.parseInt(br.readLine());
                for (int bookNum = 1; bookNum <= bookCnt; bookNum++) {
                    StringTokenizer bookToken = new StringTokenizer(br.readLine());
                    int bookWidth = Integer.parseInt(bookToken.nextToken());
                    String displayedText = bookToken.nextToken();

                    int width = displayedText.length() * characterWidth;
                    sb.append("Book").append(" ").append(bookNum).append(" ").append(bookWidth >= width + 2 ? "horizontal" : "vertical").append("\n");
                }
            }

            bw.write(sb.toString());
        }
    }
}
