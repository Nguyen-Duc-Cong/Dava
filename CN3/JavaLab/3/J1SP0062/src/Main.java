public class Main {
    public static char getDisk(String f){
        return f.charAt(0);
    }
    public static String getFileName(String f){
        int i=f.lastIndexOf("\\");
        if (i>=0) return f.substring(i+1);
        return null;
    }
    public static String getExtension(String f){
        int i=f.lastIndexOf(".");
        if (i>=0) return f.substring(i+1);
        return null;
    }
    public static String getPath(String f){
        int i=f.lastIndexOf("\\");
        if (i>=0) return f.substring(0, i-1);
        return null;
    }
    public static String getFolder(String f){
        f=getPath(f);
        int i=f.lastIndexOf("\\");
        if (i>=0) return f.substring(i+1);
        return null;
    }
    public static void main(final String[] args) {
        System.out.print("Enter file path: ");
        String f=Validation.checkString();
        System.out.println("Disk: "+getDisk(f));
        System.out.println("Extension: "+getExtension(f));
        System.out.println("FileName: "+getFileName(f));
        System.out.println("Path: "+getPath(f));
        System.out.println("Folder: "+getFolder(f));
    }
}
