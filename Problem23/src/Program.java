import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by tolgaustunkok on 01.05.2017.
 */
public class Program {
    private List<Integer> abundantNumbers;
    private List<Integer> perfectNumbers;
    private List<Integer> deficientNumbers;
    private List<Integer> sumOfTwoAbundantNums;

    public enum NumberCategory {
        ABUNDANT, DEFICIENT, PERFECT
    }

    public Program() {
        abundantNumbers = new ArrayList<>();
        perfectNumbers = new ArrayList<>();
        deficientNumbers = new ArrayList<>();
        sumOfTwoAbundantNums = new ArrayList<>();

        findAll();

        for (int i = 0; i < abundantNumbers.size(); i++) {
            for (int j = i; j < abundantNumbers.size(); j++) {
                int sum = abundantNumbers.get(i) + abundantNumbers.get(j);
                if (sum <= 28123 && !sumOfTwoAbundantNums.contains(sum)) {
                    sumOfTwoAbundantNums.add(sum);
                }
            }
        }

        int result = 0;
        for (int i = 1; i <= 28123; i++) {
            if (!sumOfTwoAbundantNums.contains(i)) {
                result += i;
            }
        }

        System.out.println("Result is: " + result);
    }

    private void findAll() {
        for (int i = 1; i <= 28123; i++) {
            NumberCategory n = categorize(i, findDivisors(i));
            if (n == NumberCategory.ABUNDANT) {
                abundantNumbers.add(i);
            } else if (n == NumberCategory.DEFICIENT) {
                deficientNumbers.add(i);
            } else {
                perfectNumbers.add(i);
            }
        }
    }

    private NumberCategory categorize(int num, int[] divisors) {
        int sum = sumArray(divisors);

        if (sum == num) {
            return NumberCategory.PERFECT;
        } else if (sum < num) {
            return NumberCategory.DEFICIENT;
        } else {
            return NumberCategory.ABUNDANT;
        }
    }

    private int sumArray(int[] arr) {
        int accum = 0;

        for (int i : arr) {
            accum += i;
        }

        return accum;
    }

    private int sumArray(List<Integer> arr) {
        int accum = 0;

        for (int i : arr) {
            accum += i;
        }

        return accum;
    }

    private int[] findDivisors(int num) {
        int maxNum = num / 2;
        int[] tempResult = new int[maxNum];
        int j = 0;

        for (int i = 1; i <= maxNum; i++) {
            if (num % i == 0) {
                tempResult[j++] = i;
            }
        }

        return Arrays.copyOf(tempResult, j);
    }

    public static void main(String[] args) {
        new Program();
    }
}
