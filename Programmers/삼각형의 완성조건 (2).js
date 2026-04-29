import java.util.Arrays;
import java.util.HashSet;

class Solution {
    public int solution(int[] sides) {
        HashSet<Integer> possibleSides = new HashSet<>();

        for (int side = 1; side < sides[0] + sides[1]; side++) {
            int[] tempSides = new int[sides.length + 1];
            for (int idx = 0; idx < sides.length; idx++) {
                tempSides[idx] = sides[idx];
            }
            tempSides[tempSides.length - 1] = side;
            Arrays.sort(tempSides);

            if (tempSides[0] + tempSides[1] > tempSides[2]) {
                possibleSides.add(side);
            }
        }

        return possibleSides.size();
    }
}