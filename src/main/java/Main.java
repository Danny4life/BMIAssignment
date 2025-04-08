import java.util.Scanner;

public class Main {


    private static Scanner input = new Scanner(System.in);

    private static final String INPUT_ERROR = "Input is not valid, try again";
    public static void main(String[] args) {
        double lbs, inches, meters, kgs, bmi;
        String classification;
        System.out.println("Calculate BMI");


        // Get validated weight from user
        lbs = inputWeight();

        // Get validated height from user
        inches = inputHeight();

        kgs = ConvertTokgs(lbs);
        meters = ConvertToInches(inches);
        bmi = calBMI(kgs, meters);
        classification = bmiclassifications(bmi);
        System.out.println("Your bmi is " + bmi + ".");
        System.out.println("Your bmi classification is " + classification);
    }

    // Method to repeatedly prompt the user for weight (in lbs)
    // And Validates that the input is numeric and greater than 0
    private static double inputWeight() {
        double weight = 0.0;
        boolean valid = false;

        // do/while loop: Ensures the user is repeatedly prompted until a valid number is entered.
        // We use a do-while loop when we want a block of code to run at-least once no matter what happens
        do {
            System.out.print("Enter weight (lbs): ");
            String inputStr = input.nextLine();

            //try/catch block: Catches NumberFormatException for invalid string input.
            // try/catch block is used to handled exception that may happen in our code
            // to enable the smooth flow of our program execution
            try{
                // Try parsing the input as a double
                weight = Double.parseDouble(inputStr);

                // Check if the number is greater than zero
                if (weight > 0) {
                    valid = true;
                } else {
                    // Print error if zero or negative
                    System.out.println(INPUT_ERROR);
                }
            } catch (NumberFormatException e) {
                // Print error if input is not a valid number
                System.out.println(INPUT_ERROR);
            }
        }while (!valid); // Keep asking the user to input a value until valid input is entered
        return weight;
    }

    private static double inputHeight() {
        double height = 0.0;
        boolean valid = false;

        do {
            System.out.print("Enter height (inches): ");
            String inputStr = input.nextLine();
            try {
                height = Double.parseDouble(inputStr);
                if (height > 0) {
                    valid = true;
                } else {
                    System.out.println(INPUT_ERROR);
                }
            } catch (NumberFormatException e) {
                System.out.println(INPUT_ERROR);
            }
        } while (!valid);

        return height;
    }



    private static double ConvertToInches(double Height) {

        return Height / 39.37;
    }

    private static double ConvertTokgs(double Weight) {

        return Weight / 2.2046;
    }

    public static double calBMI(double kgs, double meters) {
        return kgs / (meters * meters);
    }

    public static String bmiclassifications(double bmi) {
        String classification;
        if (bmi < 18.5) {
            classification = "Underweight";
        } else if (bmi < 25.0) {
            classification = "Normal";
        } else if (bmi < 30.0) {
            classification = "Overweight";
        } else {
            classification = "Obese";
        }

        return classification;
    }


}