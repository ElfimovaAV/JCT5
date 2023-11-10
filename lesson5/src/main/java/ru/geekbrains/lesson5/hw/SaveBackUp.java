package ru.geekbrains.lesson5.hw;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class SaveBackUp {
    public static void createBackup(String sourceDirectory) {
        File sourcePath = new File(sourceDirectory);
        File backupPath = new File(sourcePath.getParent(), "backup");

        if (!backupPath.exists()) {
            boolean created = backupPath.mkdirs();
            if (!created) {
                System.err.println("*Failed to create a backup directory*");
                return;
            }
        }

        File[] files = sourcePath.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    File destination = new File(backupPath.getAbsolutePath(), file.getName());
                    try {
                        Files.copy(file.toPath(), destination.toPath(), StandardCopyOption.REPLACE_EXISTING);
                    } catch (IOException e) {
                        System.err.println("Failed to perform backup " + file.getName() + ": " + e.getMessage());
                    }
                }
            }
            System.out.println();
            System.out.println("*Backup completed successfully*");
        }
    }
}
