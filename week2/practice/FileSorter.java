import java.io.File;

public class FileSorter {
    public static void main(String[] args){
        File file = new File(args[0]);
        File[] filelist=file.listFiles();
        Insertion.sort(filelist);
        for(File f : filelist){
            StdOut.println(f.getName());
        }
    }
}
