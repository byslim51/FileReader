package chapter14.test;

import task1.B;

import java.io.*;
import java.util.Scanner;

public class Test {
    private int wordCount =  new Test_count().countWords();
    private int sentenceCount =  new Test_count().countSentence();
    private String fileName = new Test_count().getFileName();


    public void createNewFile() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Укажите путь где хотите создать файл:");
        File file = new File(scan.nextLine() + "\\" + "statistics " + fileName);

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
        Test test = new Test();
        test.createNewFile();
    }
}
