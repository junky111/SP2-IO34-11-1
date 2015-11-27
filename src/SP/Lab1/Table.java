package SP.Lab1;

import java.util.LinkedHashMap;
import java.util.Map;

public class Table {

    private LinkedHashMap<Integer, Rows> map;

    public Table(Map<Integer, Rows> map) {
        this.map = new LinkedHashMap<>(map);
    }

    public Rows searchById(int id) {
        return map.get(id);
    }

    public int[] searchByName(String name) {

        int sch, temp = -1;
        int arr2[] = new int[map.size()];
        int arr1[] = new int[map.size()];
        String arr0[] = name.toLowerCase().split("");

        for (Map.Entry<Integer, Rows> entry : map.entrySet()) {
            String mas[] = entry.getValue().getName().toLowerCase().split("");

            temp++;
            sch = 0;
            for (int i = 1; i < mas.length; i++) {
                for (int j = 1; j < arr0.length; j++) {
                    if (mas[i].equals(arr0[j])) {
                        sch++;
                    }
                }
            }
            arr2[temp] = sch;
            arr1[temp] = entry.getKey();
        }

        for (int i = arr2.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr2[j] < arr2[j + 1]) {
                    int temp0 = arr2[j];
                    int temp1 = arr1[j];
                    arr2[j] = arr2[j + 1];
                    arr2[j + 1] = temp0;
                    arr1[j] = arr1[j + 1];
                    arr1[j + 1] = temp1;
                }
            }
        }

        int var = arr2[0];
        int var0 = 0;
        for (int i = 1; i < arr2.length; i++) {
            if (var == arr2[i]) {
                var0++;
            }
        }

        int arr3[] = new int[var0 + 1];
        arr3[0] = arr1[0];

        for (int i = 1; i < var0 + 1; i++) {
            arr3[i] = arr1[i];
        }

        return arr3;
    }

    public int searchBySalary(double salary) {
        int id = 0;
        for (Map.Entry<Integer, Rows> entry : map.entrySet()) {
            double temp = entry.getValue().getUnion().getSalary();
            if (salary == temp) {
                id = entry.getKey();
            }
        }
        return id;
    }

    public int searchByOverlap(String overlap) {
        int id = 0;
        for (Map.Entry<Integer, Rows> entry : map.entrySet()) {
            String temp = entry.getValue().getName();
            if (overlap.equals(temp)) {
                id = entry.getKey();
            }
        }
        return id;
    }


    public void showTable() {

        System.out.println("---------------------------|");
        System.out.println("Id  |    Name    | Salary  |");
        System.out.println("---------------------------|");

        for (Map.Entry<Integer, Rows> entry : map.entrySet()) {
            System.out.printf("%2s%12s%14s%n", entry.getKey(), entry.getValue().getName(), entry.getValue().getUnion().getSalary() + "  |");
        }

        System.out.println("---------------------------|");
        System.out.println();
    }

    public void delete(int id) {
        map.remove(id);
    }

    public void updateName(int id, String name) {
        map.get(id).setName(name);
    }

    public void updateSalary(int id, double salary) {
        map.get(id).setUnion( new UnionType(salary));
    }

}