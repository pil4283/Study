import java.util.ArrayList;

public class HelloWorld{
    static void ReadItem(/* ItemJsonData */ArrayList<Item> items) {
        // LoadItemFromDB
        items.add(new Item("1", 100, "1Item"));
        items.add(new Item("2", 200, "2Item"));
        items.add(new Item("3", 300, "3Item"));
        items.add(new Item("4", 400, "4Item"));
        items.add(new Item("5", 500, "5Item"));
    }

    public static void main(String[] args) {
        Customer customer = new Customer(new NormalStratage());
        ArrayList<Item> items = new ArrayList<Item>();
        ReadItem(items);

        customer.Add(500, 1);
        customer.PrintBill();

        Customer halfCustomer = new Customer(new HalfStratage());
        halfCustomer.Add(1000, 10);
        halfCustomer.PrintBill();
    }
}

class Item{
    String name;
    double price;
    String caption;

    public Item(String name, double price, String caption)
    {
        this.name = name;
        this.price = price;
        this.caption = caption;
    }
}

interface IBillingStratage{
    double GetPrice(double rawPrice);
}

class NormalStratage implements IBillingStratage{
    public double GetPrice(double rawPrice)
    {
        return rawPrice;
    }
}

class HalfStratage implements IBillingStratage{
    public double GetPrice(double rawPrice)
    {
        return rawPrice * 0.5f;
    }
}

class Customer{
    IBillingStratage stratage;
    private ArrayList<Double> money;
    public Customer(IBillingStratage stratage)
    {
            money = new ArrayList<Double>();
            this.stratage = stratage;
    }

    public void Add(double price, int qty)
    {
        money.add(stratage.GetPrice(price * qty));
    }

    public void PrintBill(){
        double sum = 0;
        for (double i : money) {
            sum += i;
        }
        System.out.println(sum);
        money.clear();
    }
}