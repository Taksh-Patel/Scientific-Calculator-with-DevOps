package devops_calculator;

import java.util.InputMismatchException;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import java.util.Scanner;
//ngrok testing !!!!!!
public class ScientificCalculator {
    private static final Logger log = LogManager.getLogger(ScientificCalculator.class);

    public double squareRoot(double num) {
        double answer = Math.sqrt(num);
        log.info("[SQUARE ROOT] : " + num);
        log.info("[SQUARE ROOT - ANSWER] : " + answer);
        return answer;
    }
    public double factorial(double num) {
        double answer = 1;
        for(int i = 1; i <= num; i++)
        {
            answer = answer*i;
        }
        log.info("[FACTORIAL] : " + num);
        log.info("[FACTORIAL - ANSWER] : " + answer);
        return answer;
    }
    public double naturalLogarithm(double num) {
        double answer = 0;
        log.info("[NATURAL LOGARITHM] : " + num);
        try {
            if (num <0 ) {
                answer = Double.NaN;
                throw new ArithmeticException("Number can not be less than zero\n");
            }
            else {
                answer = Math.log(num);
            }
        } catch (ArithmeticException err) {
            log.info("[NATURAL LOGARITHM - EXCEPTION] : " + err.getLocalizedMessage());
        }
        log.info("[NATURAL LOGARITHM - ANSWER] : " + answer);
        return answer;
    }
    public double power(double num1, double num2) {
        double answer = Math.pow(num1, num2);
        log.info("[POWER] : " + num1 + " ^ " + num2);
        log.info("[POWER - ANSWER] : " + answer);
        return answer;
    }

    public static void main(String[] args) {
        ScientificCalculator cal = new ScientificCalculator();
        double num1, num2;
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("<Scientific Calculator>");
            System.out.println("(a) Square Root");
            System.out.println("(b) Factorial");
            System.out.println("(c) Natural Logarithm");
            System.out.println("(d) Power");
            System.out.println("(e) exit");
            System.out.println("Select Operation: ");
            char operation;
            try {
                operation = sc.next().charAt(0);
            } catch (InputMismatchException error) {
                return;
            }

            if(operation=='a')
            {
                System.out.println("---------------Square Root Function----------------");
                System.out.print("Enter the Number : ");
                num1 = sc.nextDouble();
                System.out.println("Square Root ("+num1+") = " + cal.squareRoot(num1));
                System.out.println("--------------------------------------------------\n");
            }
            else if(operation=='b')
            {
                System.out.println("------------Factorial Function---------------------");
                System.out.print("Enter the Number : ");
                num1 = sc.nextDouble();
                System.out.println("("+num1+" !) = " + cal.factorial(num1));
                System.out.println("--------------------------------------------------\n");
            }
            else if(operation=='c')
            {
                System.out.println("--------Natural Logarithm Function (Base e)--------");
                System.out.print("Enter the Number : ");
                num1 = sc.nextDouble();
                System.out.println("ln("+num1+") = " + cal.naturalLogarithm(num1));
                System.out.println("--------------------------------------------------\n");
            }
            else if(operation=='d')
            {
                System.out.println("---------------Power Function-----------------------");
                System.out.print("Enter the Number 1 : ");
                num1 = sc.nextDouble();
                System.out.print("Enter the Number 2 : ");
                num2 = sc.nextDouble();
                System.out.println(num1+ " ^ "+num2+" = " + cal.power(num1,num2));
                System.out.println("--------------------------------------------------\n");
            }
            else{
                System.out.println("Exiting From Calculator!!!");
                break;
            }
        }
    }
}
