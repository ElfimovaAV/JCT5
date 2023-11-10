package ru.geekbrains.lesson5.hw;

import java.io.File;

public class Tree {
    public static void print(File file, String indent, boolean isLast) {
        System.out.print(indent);

        if (isLast) {
            System.out.print("└─");
            indent += "  ";
        } else {
            System.out.print("├─");
            indent += "│ ";
        }

        if (file.isDirectory()) {
            System.out.println(file.getName() + "/");
        } else {
            System.out.println("F " + file.getName());
            return;
        }

        File[] files = file.listFiles();
        if (files == null) {
            return;
        }

        int totalDirectoriesNumber= 0;
        int totalFilesNumber = 0;
        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory()) {
                totalDirectoriesNumber++;
            } else {
                totalFilesNumber++;
            }
        }

        int directoriesCounter = 0;
        int filesCounter = 0;
        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory()) {
                print(files[i], indent, directoriesCounter == totalDirectoriesNumber - 1 && filesCounter == totalFilesNumber);
                directoriesCounter++;
            } else {
                print(files[i], indent, filesCounter == totalFilesNumber - 1 && directoriesCounter == totalDirectoriesNumber);
                filesCounter++;
            }
        }
    }
}
