package task_1;

import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class Count_Word_Sentence {
    static String directory;

    public String getFileName() {
        File file = new File(directory);
        return file.getName();
    }

    public void setDirectory() {
        Scanner scanUserInput = new Scanner(System.in);

        System.out.println("Введите путь к файлу:");
        directory = scanUserInput.nextLine();
    }

    public int countWords() {
        int words = 0;
        setDirectory();

        try {
            Scanner scan = new Scanner(new FileReader(new File(directory)));

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
            Scanner scan = new Scanner(new FileReader(new File(directory)));
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
