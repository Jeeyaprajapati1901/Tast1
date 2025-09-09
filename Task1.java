import java.util.Scanner;

public class Main {

    public static double celsiusToFahrenheit(double c) {
        return (c * 9 / 5) + 32;
    }

    public static double celsiusToKelvin(double c) {
        return c + 273.15;
    }

    public static double fahrenheitToCelsius(double f) {
        return (f - 32) * 5 / 9;
    }

    public static double fahrenheitToKelvin(double f) {
        return (f - 32) * 5 / 9 + 273.15;
    }

    public static double kelvinToCelsius(double k) {
        return k - 273.15;
    }

    public static double kelvinToFahrenheit(double k) {
        return (k - 273.15) * 9 / 5 + 32;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double value = 0.0;
        String from = "", to = "";

        // Input temperature value safely
        System.out.print("Enter temperature value: ");
        if (input.hasNextDouble()) {
            value = input.nextDouble();
        } else {
            System.out.println("Invalid temperature input!");
            return;
        }

        input.nextLine(); // consume leftover newline

        // Input from unit
        System.out.print("Convert from (Celsius/Fahrenheit/Kelvin): ");
        if (input.hasNextLine()) {
            from = input.nextLine().trim().toLowerCase();
        } else {
            System.out.println("Missing 'from' input!");
            return;
        }

        // Input to unit
        System.out.print("Convert to (Celsius/Fahrenheit/Kelvin): ");
        if (input.hasNextLine()) {
            to = input.nextLine().trim().toLowerCase();
        } else {
            System.out.println("Missing 'to' input!");
            return;
        }

        double result = 0.0;

        if (from.equals(to)) {
            result = value;
        } else if (from.equals("celsius")) {
            if (to.equals("fahrenheit")) result = celsiusToFahrenheit(value);
            else if (to.equals("kelvin")) result = celsiusToKelvin(value);
            else invalidUnit();
        } else if (from.equals("fahrenheit")) {
            if (to.equals("celsius")) result = fahrenheitToCelsius(value);
            else if (to.equals("kelvin")) result = fahrenheitToKelvin(value);
            else invalidUnit();
        } else if (from.equals("kelvin")) {
            if (to.equals("celsius")) result = kelvinToCelsius(value);
            else if (to.equals("fahrenheit")) result = kelvinToFahrenheit(value);
            else invalidUnit();
        } else {
            invalidUnit();
            return;
        }

        System.out.printf("%.2f %s = %.2f %s%n", value, capitalize(from), result, capitalize(to));
    }

    public static void invalidUnit() {
        System.out.println("Invalid unit entered! Please use Celsius, Fahrenheit, or Kelvin.");
    }

    public static String capitalize(String str) {
        if (str == null || str.isEmpty()) return str;
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}