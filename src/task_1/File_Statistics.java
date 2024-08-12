package task_1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class File_Statistics {
    private int wordCount =  new Count_Word_Sentence().countWords();
    private int sentenceCount =  new Count_Word_Sentence().countSentence();
    private String fileName = new Count_Word_Sentence().getFileName();


    public void createNewFile() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Укажите путь где хотите создать файл:");
        fileName = fileName.substring(0, fileName.length() - 4);
        File file = new File(scan.nextLine() + "\\" + fileName + " statistics");

        try {
            if (file.createNewFile()) {
                System.out.println("Файл создан. Путь: " + file.getAbsolutePath());
            } else {
                System.out.println("Файл уже создан. Путь: " + file.getAbsolutePath());
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
