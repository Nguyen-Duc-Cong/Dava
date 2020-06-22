import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static ArrayList<Country> input(InputChecker ic){
        ArrayList<Country> result=new ArrayList<>();
        while (true){
            System.out.print("Please type id: ");String id=ic.inputString();
            System.out.print("Please type name: ");String name=ic.inputString();
            System.out.print("Please type area: ");double area=ic.inputDouble();
            System.out.print("Please type terrain: ");String terrain=ic.inputString();
            result.add(new Country(id, name, area, terrain));
            System.out.print("Wanna add another country? (0/1): ");
            int choice=ic.inputIntRange(0, 1);
            if (choice==0) break;
        }
        return result;
    }
    public static void search(ArrayList<Country> a,InputChecker ic){
        System.out.print("Input name to search: ");String name=ic.inputString();
        for (Country i:a)
            if (i.getName().equalsIgnoreCase(name)) {
                System.out.println("FOUND!");
                System.out.printf("%5s %10s %10s %10s\n","ID","NAME","AREA","TERRAIN");
                System.out.printf("%5s %10s %10.2f %10s\n",i.getId(),i.getName(),i.getArea(),i.getTerrain());
                return;
            }
        System.out.println("NOT FOUND!");
    }
    public static void display(ArrayList<Country> countryArr){
        System.out.printf("%5s %10s %10s %10s\n","ID","NAME","AREA","TERRAIN");
        for (Country i:countryArr) i.display();
    }
    public static void main(String[] args) {
        InputChecker ic=new InputChecker();
        ArrayList<Country> countryArr=new ArrayList<>();
        while (true){
            int choice= Manager.menu(ic);
            switch (choice) {
                case 1: countryArr=input(ic);
                        break;
                case 2: display(countryArr);
                        break;
                case 3: search(countryArr,ic);
                        break;
                case 4: Collections.sort(countryArr, new SortByID());
                        System.out.println("____________________ Sort By ID ____________________");
                        display(countryArr);
                        Collections.sort(countryArr, new SortByName());
                        System.out.println("___________________ Sort By Name ___________________");
                        display(countryArr);
                        Collections.sort(countryArr, new SortByArea());
                        System.out.println("___________________ Sort By Area ___________________");
                        display(countryArr);
                        break;
                case 5: System.out.println("Exitting...");
                        System.exit(0);
            }
        }
    }
}