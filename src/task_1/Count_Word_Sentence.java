package task_1;

import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class Count_Word_Sentence {
    private static File file;

    public static File getDirectory() {
        return file;
    }

    public static String getFileName() {
        return file.getName();
    }

    public void setDirectory() {
        Scanner scanUserInput = new Scanner(System.in);
        System.out.println("Введите полный путь к файлу:");
        file = new File(scanUserInput.nextLine());
    }

    public int countWords() {
        int words = 0;
        setDirectory();

        try {
            Scanner scan = new Scanner(new FileReader(file));

            while (scan.hasNext()) {
                scan.next();
                words++;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return words;
    }

    public int countSentence() {
        int sentence = 0;

        try {
            Scanner scan = new Scanner(new FileReader(file));
            scan.useDelimiter("(?<=[.!?])");

            while (scan.hasNext()) {
                scan.next();
                sentence++;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return sentence;


    }
}
