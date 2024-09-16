import java.util.Scanner;

public class
TestKata {
    public static void main(String[] args) {

        System.out.println(textModifier());
    }

    private static String textModifier() {

        final String task1 = userInputAndDeleteExtraSpace();
        final String task2 = swapSymbolsAroundMinus(task1);
        final String task3 = changePlusToExclamationMark(task2);
        final String task4 = findSumOfAllDigits(task3);

        return task4;
    }

    private static String userInputAndDeleteExtraSpace() {

        final Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строку");
        final String input = scanner.nextLine();
        scanner.close();
        /*
        a. Если в тексте между словами присутствует несколько пробелов подряд, надо оставить только один из них.
        Для реализации этого подпункта нельзя пользоваться методами replace() и replaceAll().
        */

        final String[] splitWords = input.split("\\s+");
        final StringBuilder sbWithoutExtraSpace = new StringBuilder();

        for (int i = 0; i < splitWords.length; i++) {
            sbWithoutExtraSpace.append(splitWords[i]);
            if (i < splitWords.length - 1) {
                sbWithoutExtraSpace.append(" ");
            }
        }
        return sbWithoutExtraSpace.toString();
    }

    private static String swapSymbolsAroundMinus(final String input) {

        /*
        b.Если в тексте присутствует знак минус (-), это значит, что символ слева от этого знака надо поменять местами с символом, который стоит справа от этого знака.
        Обратите внимание, что символом может быть не только буква, но и цифра или любой другой знак/символ, в том числе символ пробела.
        После смены символов местами, знак минус (-) надо удалить из строки результата.
        */

        final char[] charsArray = input.toCharArray();
        final StringBuilder swapSymbols = new StringBuilder();

        for (int i = 0; i < charsArray.length; i++) {
            if (charsArray[i] == '-') {
                if (i > 0 && i < charsArray.length - 1) {
                    final char previous = charsArray[i - 1];
                    final char next = charsArray[i + 1];

                    swapSymbols.setCharAt(swapSymbols.length() - 1, next);
                    swapSymbols.append(previous);
                    i++;
                }
            } else {
                swapSymbols.append(charsArray[i]);
            }
        }
        return swapSymbols.toString();
    }

    private static String changePlusToExclamationMark(final String input) {

        /*
        c. Если в тексте присутствует знак плюс (+), вам необходимо заменить его на восклицательный знак (!).
        */

        final char[] charsArray = input.toCharArray();
        final StringBuilder changeSymbols = new StringBuilder();

        for (final char c : charsArray) {
            if (c == '+') {
                changeSymbols.append('!');
            } else {
                changeSymbols.append(c);
            }
        }
        return changeSymbols.toString();
    }

    private static String findSumOfAllDigits(final String input) {

        /*
        d. В тексте могут присутствовать цифры (от 0 до 9). Вам необходимо посчитать их сумму и удалить из текста.
        Сумму цифр вам нужно добавить в конец результирующей строки через пробел (пробел должен стоять перед суммой цифр).
        Если цифр в тексте не было - "0" (ноль) в конце строки выводить не нужно.
        */

        final char[] charsArray = input.toCharArray();
        final StringBuilder sumOfAllDigits = new StringBuilder();
        int sum = 0;

        for (final char c: charsArray) {
            if (Character.isDigit(c)) {
                sum += Character.getNumericValue(c);
            } else {
                sumOfAllDigits.append(c);
            }
        }
        sumOfAllDigits.append(" ");
        if (sum > 0) {
            sumOfAllDigits.append(sum);
        }
        return sumOfAllDigits.toString();
    }
}