public class Manager {
    public static int menu(){
        int choice=0;
        System.out.println("========== File Progressing ==========");
        System.out.println("1 - Find person infomation with user-define minimum salary");
        System.out.println("2 - Copy data to new file");
        System.out.println("3 - Exit");
        System.out.print("=====> Your choice : ");
        choice=Validation.checkRange(1, 3);
        return choice;
    }
}
