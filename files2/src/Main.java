import java.io.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {

//        FileInputStream fis = new FileInputStream("C://Users//Ziiad//Downloads//testfile.csv");
//       byte[] b = new byte[100];
//       fis.read(b);
//       String s = new String(b);
//        System.out.println(s);

        File f = new File("abc.csv");

        f.createNewFile();
        System.out.println(f.exists());


    }
}