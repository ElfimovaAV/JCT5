package ru.geekbrains.lesson5.hw;

import java.io.File;


public class Main {

        public static void main(String[] args) {

            Tree.print(new File("."), "", true);

            String sourceDirectory = "C:\\Users\\admin\\Documents";
            SaveBackUp.createBackup(sourceDirectory);
        }

}
