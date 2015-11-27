package SP.Lab1;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class Main {

    public static void main(String[] args) {

        System.out.println(3413%20 + 1);
        System.out.println(3413%10 + 1);

        Rows row1 = new Rows("Oleg", new UnionType(4800.50));
        Rows row2 = new Rows("Ivan", new UnionType(3280.20));
        Rows row3 = new Rows("Sergey", new UnionType(5400.30));
        Rows row4 = new Rows("Olexii", new UnionType(4000.00));
        Rows row5 = new Rows("Alexandr", new UnionType(4575.80));
        Rows row6 = new Rows("Nikita", new UnionType(3700.00));

        HashMap<Integer , Rows> map = new LinkedHashMap<>();

        map.put( 1, row1);
        map.put( 2 , row2);
        map.put( 3 , row3);
        map.put( 4, row4);
        map.put( 5 , row5);
        map.put( 6 , row6);

        Table table = new Table(map);

        table.showTable();

     //   table.updateName(1, "antuan");

        int id1 = table.searchBySalary(4000.0);
        int id2 = table.searchByOverlap("Alexandr");
        int arr[] = table.searchByName("olemm");

        System.out.println();
        System.out.println("Search by id : ");
        System.out.println(table.searchById(6));
        System.out.println();
        System.out.println("Search by salary : ");
        System.out.println(table.searchById(id1).toString());
        System.out.println();
        System.out.println("Search by name : ");
        System.out.println(table.searchById(id2).toString());


        System.out.println();
        System.out.println("Search by key result : ");



        for (int i = 0; i < arr.length; i++) {
            System.out.println(table.searchById(arr[i]));
        }


        table.updateSalary(2, 2222.22);
        System.out.println();
        table.showTable();
    }
}
