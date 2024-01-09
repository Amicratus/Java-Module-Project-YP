import java.util.Scanner;

public class Formater {

    private Scanner scanner = new Scanner(System.in);


    public int scanInt(){
        while(true){
            if(scanner.hasNextInt()){
                int numbForScan = scanner.nextInt();
                if(numbForScan > 1){
                    return numbForScan;
                }
                else{
                    System.out.println("Ошибка! Введите корректное число.");
                    scanner = null;
                    scanner = new Scanner(System.in);
                }
            }
            else {
                System.out.println("Ошибка! Введите корректное число.");
                scanner = null;
                scanner = new Scanner(System.in);
            }
        }
    }

    public double scanDouble(){
        while(true){
            if(scanner.hasNextDouble()){
                double numbForScan = scanner.nextDouble();
                if(numbForScan > 0){
                    return numbForScan;
                }
                else{
                    System.out.println("Ошибка! Введите корректное число.");
                    scanner = null;
                    scanner = new Scanner(System.in);
                }
            }
            else {
                System.out.println("Ошибка! Введите корректное число.");
                scanner = null;
                scanner = new Scanner(System.in);
            }
        }
    }

    public String checkRes(double numb){
        int a = (int) Math.floor(numb);
        if(a % 10 == 1) {
            if(a % 100 == 11) return "рублей";
            else return "рубль";
        }
        else if (a % 100 >= 12 && a % 100 <= 15) return "рублей";
        else if (a % 10 > 1 && a % 10 < 5) return "рубля";
        else return "рублей";
    }
}
