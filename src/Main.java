import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите арифметические действие двух чисел от 1 до 10: ");
        String input = scanner.nextLine();

        String[] parts = input.split("[+-/*]");
        if (parts.length!= 2) {
            System.out.println("Ошибка: неверный формат ввода!");
            return;
        }

        int num1 = checkNumber(parts[0]);
        int num2 = checkNumber(parts[1]);
        if (num1 == -1 || num2 == -1) {
            return;
        }

        char operation = getOperation(input);
        if (operation == '\0') {
            System.out.println("Ошибка: неизвестная операция!");
            return;
        }

        int result = 0;
        switch (operation) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2!= 0) {
                    result = num1 / num2;
                } else {
                    System.out.println("Ошибка: деление на ноль!");
                    return;
                }
                break;
        }

        System.out.println("Результат: " + result);
    }

    private static int checkNumber(String number) {
        try {
            int num = Integer.parseInt(number);
            if (num < 1 || num > 10) {
                System.out.println("Ошибка: число вне диапазона от 1 до 10!");
                return -1;
            }
            return num;
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: неверный формат числа!");
            return -1;
        }
    }

    private static char getOperation(String input) {
        for (char c : input.toCharArray()) {
            if (c == '+' || c == '-' || c == '*' || c == '/') {
                return c;
            }
        }
        return '\0';
    }
}