import java.io.*;
import java.util.ArrayList;

public class Program {
    public static void find() throws IOException {
        ArrayList<Person> hunman = new ArrayList<>();
        System.out.print("Enter path: ");
        String path = Validation.checkString();
        BufferedReader input = new BufferedReader(new FileReader(path));
        String line = input.readLine();
        while (line != null) {
            String[] content = line.split(";");
            hunman.add(new Person(content[0], content[1], Double.parseDouble(content[2])));
            line = input.readLine();
        }
        input.close();
        System.out.print("Enter minimun salary: ");
        double salary = Validation.checkDouble();
        System.out.println("__________________ Result __________________");
        System.out.printf("%18s%18s  %-8s\n", "Name", "Address", "Salary");
        for (Person i : hunman) {
            if (i.getSalary() >= salary) i.print();
        }
    }

    public static void copy() throws IOException {
        System.out.print("Enter source: ");
        String source = Validation.checkString();
        BufferedReader bf = new BufferedReader(new FileReader(source));
        String line = bf.readLine();
        StringBuilder data = new StringBuilder();
        while (line != null) {
            data.append(line);
            data.append("\n");
            line = bf.readLine();
        }
        System.out.print("Enter new file name: ");
        String fileName = Validation.checkString();
        FileWriter fw = new FileWriter(fileName);
        fw.write(data.toString());
        fw.close();
        bf.close();

    }
}

