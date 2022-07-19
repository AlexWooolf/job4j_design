package ru.job4j.io;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ConsoleChat {
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    private final String path;
    private final String botAnswers;

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        String userText = scanner.nextLine();
        var botAnswer = readPhrases();
        Random random = new Random();
        List<String> log = new ArrayList<>();

        while (!OUT.equals(userText)) {
            while (!STOP.equals(userText)) {
                if (OUT.equals(userText)) {
                    saveLog(log);
                    break;
                } else if (CONTINUE.equals(userText)) {
                    System.out.println(userText);
                    log.add(userText);
                    String answer = botAnswer.get(random.nextInt(botAnswer.size()));
                    System.out.println(answer);
                    log.add(answer);
                    userText = scanner.nextLine();
                }
            }
            System.out.println(userText);
            log.add(userText);
            userText = scanner.nextLine();
        }
        saveLog(log);
    }

    private List<String> readPhrases() {
        List<String> answers = new ArrayList<>();
        try (BufferedReader buffer = new BufferedReader(new FileReader(botAnswers))) {
            buffer.lines().forEach(answers :: add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return answers;
    }

    private void saveLog(List<String> log) {
        try (PrintWriter save = new PrintWriter(
                new FileWriter(path, Charset.forName("WINDOWS-1251"), true))) {
           log.forEach(save :: println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        ConsoleChat cc = new ConsoleChat("", "");
        cc.run();
    }
}