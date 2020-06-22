import java.util.Scanner;

class Validation{
    public static Scanner sc=new Scanner(System.in);
    public static String checkString()
    {
        String res=sc.nextLine();
        if (res.isEmpty()){
            System.out.print("String can't be NULL, enter again: ");
            return checkString();
        }
        return res;
    }

    public static double checkDouble()
    {
        double res;
        try{
            res=sc.nextDouble();
        }catch (Exception e){
            sc.nextLine();
            System.out.print("Wrong input, enter again: ");
            return checkDouble();
        }
        return res;
    }
    public static int checkInt()
    {
        int res;
        try{
            res=sc.nextInt();
            sc.nextLine();
        }catch (Exception e){
            sc.nextLine();
            System.out.print("Wrong input, enter again: ");
            return checkInt();
        }
        return res;
    }
    public static int checkRange(int a,int b)
    {
        int res=checkInt();
        if ((res<a)||(res>b))
        {
            System.out.print("Out Of Range!, Type Again: ");
            return checkRange(a,b);
        }
        return res;
    }
}