import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        while (true) {
            int choice = Manager.menu();
            switch (choice) {
                case 1:
                    try {
                        Program.find();
                    } catch (IOException e) {
                        System.out.println("Error while find data!");
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    try {
                        Program.copy();
                    } catch (IOException e) {
                        System.out.println("Error while copy file!");
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    System.out.println("Program exitting...");
                    System.exit(0);
            }
        }
    }
}

