import java.io.*;
import java.util.Scanner;

class FileRead {
    public String readFile(String path)  {
        Arr<String> readWord = new Arr<String>();
        try {
            FileReader fr = new FileReader(path);
            Scanner scanFile = new Scanner(fr);
            readWord.setWord(scanFile.nextLine());
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        }
        return readWord.getWord();
    }
    }


