package task_1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class File_Statistics {
    private final int wordCount;
    private final int sentenceCount;
    private String fileName;
    private final String directory;

    public File_Statistics() {
        Count_Word_Sentence counter = new Count_Word_Sentence();
//        counter.setDirectory();
        wordCount = counter.countWords();
        sentenceCount = counter.countSentence();
        fileName = Count_Word_Sentence.getFileName();
        directory = Count_Word_Sentence.getDirectory().getParent();

    }


    public void createNewFile() {
        fileName = fileName.substring(0, fileName.length() - 4);
        File file = new File((directory + "\\" + fileName + " statistics"));

        try {
            if (file.createNewFile()) {
                System.out.println("Файл успешно создан. Путь: " + file.getAbsolutePath());
            } else {
                System.out.println("Не получилось создать файл. Так как файл с таким именем уже имеется.  Путь: " + file.getAbsolutePath());
            }

            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write("Количество слов: " + wordCount);
            bufferedWriter.newLine();
            bufferedWriter.write("Количество предложений: " + sentenceCount);
            bufferedWriter.close();
            fileWriter.close();

            System.out.println("Статистика записана.");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        File_Statistics fileStatistics = new File_Statistics();
        fileStatistics.createNewFile();
    }
}
