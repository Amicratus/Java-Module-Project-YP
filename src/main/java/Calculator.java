import java.util.ArrayList;
import java.util.Scanner;
public class Calculator {

    private int numberOfPeople;
    private double totalCost = 0;
    private final ArrayList<String> listOfProducts;
    private final ArrayList<Double> costOfProducts;

    private final Formater format = new Formater();

    private final Scanner scanner = new Scanner(System.in);

    Calculator(){
        listOfProducts = new ArrayList<>();
        costOfProducts = new ArrayList<>();
    }

    public void start(){
        System.out.print("Сколько человек будет делить счет: ");
        this.numberOfPeople = format.scanInt();
        addProduct();

        while(true){
            System.out.print("Желаете добавить ещё один товар? (Да/Завершить): ");
            String str = scanner.next();
            if(str.equalsIgnoreCase("Завершить")){
                show();
                break;
            }
            if(str.equalsIgnoreCase("Да")) {
                addProduct();
            }
        }
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
        System.out.printf("\nИтого с человека:%10.2f %-2s\n(Поделено на %d человек)\n",
                result, rubl, numberOfPeople);
    }

}
