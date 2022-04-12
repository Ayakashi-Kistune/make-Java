import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class messedUP{
    public static void main(String[] args){

        String name = args[0];
        name = Character.toString(name.charAt(0)).toUpperCase() + name.substring(1);

        System.out.println("making " + name);
       
        String dir = System.getProperty("user.dir");
        File makeFile = new File(dir + "/" + name);
        File src = new File(makeFile.getPath() + "/src");
        File bin = new File(makeFile.getPath() + "/bin");
        File lib = new File(makeFile.getPath() + "/lib");
       
        makeFile.mkdir(); 
        src.mkdir();
        bin.mkdir();
        lib.mkdir();
        inject.insert(src, name);
    }
}

class inject{
    static void insert(File srcPath, String name){
        try {
            FileWriter file = new FileWriter(srcPath.getPath() + "/" + name + ".java" );
            file.write("public class " + name + "{\n\n" + "\tpublic static void main(String[] args){\n\n\t}" +"\n}");
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}