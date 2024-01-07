import java.util.ArrayList;
import java.util.Scanner;
public class Calculator {

    private int numberOfPeople;
    private double totalCost = 0;
    private ArrayList<String> listOfProducts;
    private ArrayList<Double> costOfProducts;

    Formater format = new Formater();

    Scanner scanner = new Scanner(System.in);

    Calculator(int numberOfPeople){
        this.numberOfPeople = numberOfPeople;
        listOfProducts = new ArrayList<String>();
        costOfProducts = new ArrayList<Double>();
    }

    public void addProduct(){
        while(true){
            System.out.print("Введите название продукта: ");
            String str = scanner.next();
            if(!str.isEmpty()){
                this.listOfProducts.add(str);
                addProductCost();
                System.out.println("Товар успешно добавлен!");
                break;
            }
        }
    }

    public void addProductCost(){
        System.out.print("Введите цену товара: ");
        double cost = format.scanDouble();
        this.costOfProducts.add(cost);
        this.totalCost += cost;

    }

    public void show(){
        double result = totalCost/numberOfPeople;
        String rubl = format.checkRes(result);
        System.out.println("Добавленные товары: ");
        for(int i = 0; i < listOfProducts.size(); i++){
            System.out.printf("%-10s %20.2f \n", listOfProducts.get(i), costOfProducts.get(i));
        }
        System.out.printf("\nИтого с человека:%10.2f %-2s\n", result, rubl);
    }

}
