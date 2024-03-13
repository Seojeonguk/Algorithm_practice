import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Map;

public class Main {

    static final Map<Character, Integer> ROMAN_NUMERAL_BASE_VALUES = Map.of(
            'I', 1,
            'V', 5,
            'X', 10,
            'L', 50,
            'C', 100,
            'D', 500,
            'M', 1000
    );

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        char[] aromaticNumbers = br.readLine().toCharArray();

        int aromaticValue = 0;
        for (int idx = 0; idx < aromaticNumbers.length; idx += 2) {
            int arabicDigit = aromaticNumbers[idx] - '0';
            int romanNumeralValue = ROMAN_NUMERAL_BASE_VALUES.get(aromaticNumbers[idx + 1]);
            int nextRomanNumeralValue = (idx + 3 < aromaticNumbers.length ? ROMAN_NUMERAL_BASE_VALUES.get(aromaticNumbers[idx + 3]) : 0);

            aromaticValue += arabicDigit * romanNumeralValue * (romanNumeralValue < nextRomanNumeralValue ? -1 : 1);
        }

        sb.append(aromaticValue);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
