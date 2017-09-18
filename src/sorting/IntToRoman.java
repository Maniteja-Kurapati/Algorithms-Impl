package sorting;

import java.util.Stack;

import utils.TimeUtil;

public class IntToRoman {

    public static void main(final String[] args) {
        IntToRoman board = new IntToRoman();
        TimeUtil.start();
        System.out.println(board.intToRoman(3999));
        TimeUtil.stop();
        System.out.println(TimeUtil.elaspedTime());

    }

    public String intToRoman(int num) {
        StringBuilder roman = new StringBuilder();
        Stack<Integer> stack = new Stack<Integer>();
        int power = -1;
        int digit = 0;
        while (num != 0) {
            stack.push(num % 10);
            num = num / 10;
            power++;
        }

        while (!stack.isEmpty()) {
            digit = (int) (Math.pow(10, power) * stack.peek());
            power--;
            if (digit >= 1000) {
                thousnadsMap(roman, stack.pop());
            } else if (digit >= 100 && digit < 1000) {
                hundredsMap(roman, stack.pop());
            } else if (digit >= 10 && digit < 100) {
                tensMap(roman, stack.pop());
            } else {
                onesMap(roman, stack.pop());
            }
        }
        return roman.toString();
    }

    private StringBuilder onesMap(final StringBuilder builder, final int num) {
        switch (num) {
        case 0:
            break;
        case 1:
            builder.append("I");
            break;
        case 2:
            builder.append("II");
            break;
        case 3:
            builder.append("III");
            break;
        case 4:
            builder.append("IV");
            break;
        case 5:
            builder.append("V");
            break;
        case 6:
            builder.append("VI");
            break;
        case 7:
            builder.append("VII");
            break;
        case 8:
            builder.append("VIII");
            break;
        case 9:
            builder.append("IX");
            break;
        }
        return builder;
    }

    private StringBuilder tensMap(final StringBuilder builder, int num) {
        if (num == 4) {
            builder.append("XL");
        }

        if (num == 9) {
            builder.append("XC");
        }

        if (num >= 5 && num < 9) {
            builder.append("L");
        }

        while (num > 0 && num < 4) {
            builder.append("X");
            num--;
        }
        while (num > 5 && num < 9) {
            builder.append("X");
            num--;
        }

        return builder;
    }

    private StringBuilder hundredsMap(final StringBuilder builder, int num) {
        if (num == 4) {
            builder.append("CD");
        }

        if (num == 9) {
            builder.append("CM");
        }

        if (num >= 5 && num < 9) {
            builder.append("D");
        }

        while (num > 0 && num < 4) {
            builder.append("C");
            num--;
        }

        while (num > 5 && num < 9) {
            builder.append("C");
            num--;
        }

        return builder;
    }

    private StringBuilder thousnadsMap(final StringBuilder builder, int num) {
        while (num > 0) {
            builder.append("M");
            num--;
        }
        return builder;
    }

}
