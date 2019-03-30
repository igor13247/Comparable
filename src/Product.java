import java.util.Arrays;
import java.util.Comparator;


// создадим объект, в котором будем хранить данные
class Product {
    private String name;
    private double count;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getCount() {
        return count;
    }
    public void setCount(double count) {
        this.count = count;
    }
}

//сортировки по названию
class Name implements Comparator<Product> {

    public int compare(Product obj1, Product obj2) {
        String name1 = obj1.getName();
        String name2 = obj2.getName();
        return name1.compareTo(name2);
    }
}

//сортировки по цене
class Count implements Comparator<Product> {

    public int compare(Product obj1, Product obj2) {
        double count1 = obj1.getCount();
        double count2 = obj2.getCount();
        if(count1 > count2) {
            return 1;
        }
        else if(count1 < count2) {
            return -1;
        }
        else {
            return 0;
        }
    }
}

class Example {

    public static void main(String[] args) {
        Product[] p = new Product[4];

        // заполним объект Product содержимым
        p[0] = new Product();
        p[0].setName("Tea");
        p[0].setCount(5);

        p[1] = new Product();
        p[1].setName("Juice");
        p[1].setCount(20);

        p[2] = new Product();
        p[2].setName("Compote");
        p[2].setCount(15);

        p[3] = new Product();
        p[3].setName("Soda");
        p[3].setCount(2);

        // выведем данные без сортировки
        System.out.println("Исходные данные без сортировки");
        for(Product i : p) {
            System.out.println("Name: " + i.getName() + " Count: " + i.getCount());
        }

        // отсортируем и выведем данные по цене
        System.out.println("Сортировка по цене");
        Arrays.sort(p, new Count());
        for(Product i : p) {
            System.out.println("Name: " + i.getName() + " Count: " + i.getCount());
        }

        // отсортируем и выведем данные по названию
        System.out.println("Сортировка по имени");
        Arrays.sort(p, new Name());
        for(Product i : p) {
            System.out.println("Name: " + i.getName() + " Count: " + i.getCount());
        }
    }

}