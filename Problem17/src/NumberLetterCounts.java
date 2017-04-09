/**
 * Created by tolgaustunkok on 07.04.2017.
 */
public class NumberLetterCounts {

    public NumberLetterCounts() {
        int acc = 0;
        for (int i = 1; i <= 999; i++) {
            acc += read(i).length();
        }

        acc += 11;

        System.out.println(acc);
    }

    private String read(int num) {
        int digitNum = digitCount(num);
        String result = null;

        if (digitNum == 1) {
            result = readDigit(num);
        } else if (digitNum == 2) {
            result = readTwoDigitNumber(num);
        } else if (digitNum == 3) {
            if (getDigit(1, num) == 0 && getDigit(0, num) == 0) {
                result = readDigit(getDigit(2, num)) + "hundred";
            } else if (getDigit(1, num) == 0 && getDigit(0, num) != 0) {
                result = readDigit(getDigit(2, num)) + "hundredand" + readDigit(getDigit(0, num));
            } else {
                int twoDigitPart = Integer.parseInt("" + getDigit(1, num) + getDigit(0, num));
                result = readDigit(getDigit(2, num)) + "hundredand" + readTwoDigitNumber(twoDigitPart);
            }
        }

        return result;
    }

    private String readTwoDigitNumber(int num) {
        String result = null;
        if (getDigit(1, num) == 1) {
            if (getDigit(0, num) == 0) {
                result = "ten";
            } else if (getDigit(0, num) == 1) {
                result = "eleven";
            } else if (getDigit(0, num) == 2) {
                result = "twelve";
            } else if (getDigit(0, num) == 3) {
                result = "thirteen";
            } else if (getDigit(0, num) == 4) {
                result = "fourteen";
            } else if (getDigit(0, num) == 5) {
                result = "fifteen";
            } else if (getDigit(0, num) == 6) {
                result = "sixteen";
            } else if (getDigit(0, num) == 7) {
                result = "seventeen";
            } else if (getDigit(0, num) == 8) {
                result = "eighteen";
            } else if (getDigit(0, num) == 9) {
                result = "nineteen";
            }
        } else if (getDigit(1, num) == 2) {
            if (getDigit(0, num) == 0) {
                result = "twenty";
            } else {
                result = "twenty" + readDigit(getDigit(0, num));
            }
        } else if (getDigit(1, num) == 3) {
            if (getDigit(0, num) == 0) {
                result = "thirty";
            } else {
                result = "thirty" + readDigit(getDigit(0, num));
            }
        } else if (getDigit(1, num) == 4) {
            if (getDigit(0, num) == 0) {
                result = "forty";
            } else {
                result = "forty" + readDigit(getDigit(0, num));
            }
        } else if (getDigit(1, num) == 5) {
            if (getDigit(0, num) == 0) {
                result = "fifty";
            } else {
                result = "fifty" + readDigit(getDigit(0, num));
            }
        } else if (getDigit(1, num) == 6) {
            if (getDigit(0, num) == 0) {
                result = "sixty";
            } else {
                result = "sixty" + readDigit(getDigit(0, num));
            }
        } else if (getDigit(1, num) == 7) {
            if (getDigit(0, num) == 0) {
                result = "seventy";
            } else {
                result = "seventy" + readDigit(getDigit(0, num));
            }
        } else if (getDigit(1, num) == 8) {
            if (getDigit(0, num) == 0) {
                result = "eighty";
            } else {
                result = "eighty" + readDigit(getDigit(0, num));
            }
        } else if (getDigit(1, num) == 9) {
            if (getDigit(0, num) == 0) {
                result = "ninety";
            } else {
                result = "ninety" + readDigit(getDigit(0, num));
            }
        }

        return result;
    }

    private String readDigit(int digit) {
        switch (digit) {
            case 0:
                return "zero";
            case 1:
                return "one";
            case 2:
                return "two";
            case 3:
                return "three";
            case 4:
                return "four";
            case 5:
                return "five";
            case 6:
                return "six";
            case 7:
                return "seven";
            case 8:
                return "eight";
            case 9:
                return "nine";
            default:
                return "NaN";
        }
    }

    private int getDigit(int digitIndex, int num) {
        if (digitIndex >= digitCount(num)) {
            return -1;
        }

        int digit = 0;

        for (int i = 0; i < digitIndex + 1; i++) {
            digit = num % 10;
            num /= 10;
        }

        return digit;
    }

    private int digitCount(int num) {
        int count = 0;

        if (num == 0) {
            count++;
        }

        while (num > 0) {
            num /= 10;
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        new NumberLetterCounts();
    }
}
