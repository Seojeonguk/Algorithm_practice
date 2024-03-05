import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    final static char[][] SMART_TELEPHONE_SCREENS = {{'*', 'x', '*'}, {' ', 'x', 'x'}, {'*', ' ', '*'}};

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int k = Integer.parseInt(br.readLine());

        char[][] computerScreens = new char[3 * k][3 * k];

        for (int i = 0; i < SMART_TELEPHONE_SCREENS.length; i++) {
            for (int j = 0; j < SMART_TELEPHONE_SCREENS.length; j++) {
                for (int p = 0; p < k; p++) {
                    for (int q = 0; q < k; q++) {
                        computerScreens[i * k + p][j * k + q] = SMART_TELEPHONE_SCREENS[i][j];
                    }
                }
            }
        }

        for (int i = 0; i < computerScreens.length; i++) {
            for (int j = 0; j < computerScreens.length; j++) {
                sb.append(computerScreens[i][j]);
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
