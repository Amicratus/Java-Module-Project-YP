
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Formater format = new Formater();

        System.out.print("Сколько человек будет делить счет: ");
        int numberOfPeople = format.scanInt();
        Calculator calculator = new Calculator(numberOfPeople);
        calculator.addProduct();

        while(true){
            System.out.print("Желаете добавить ещё один товар? (Да/Завершить): ");
            String str = scanner.next();
            if(str.equalsIgnoreCase("Завершить")){
                calculator.show();
                break;
            }
            if(str.equalsIgnoreCase("Да")) {
                calculator.addProduct();
            }
        }
    }
}