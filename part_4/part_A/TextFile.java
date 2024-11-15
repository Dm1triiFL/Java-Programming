package part_4.part_A;

import java.io.*;

public class TextFile extends File {

    public TextFile(String name, Directory directory) {
        super(name, directory);
    }

    @Override
    public void create() {
        try {
            new FileWriter(directory.getPath() + java.io.File.separator + name).close();
            System.out.println("Файл '" + name + "' успешно создан.");
        } catch (IOException e) {
            System.out.println("Ошибка при создании файла: " + e.getMessage());
        }
    }

    @Override
    public void rename(String newName) {
        java.io.File oldFile = new java.io.File(directory.getPath() + java.io.File.separator + name);
        java.io.File newFile = new java.io.File(directory.getPath() + java.io.File.separator + newName);
        if (oldFile.renameTo(newFile)) {
            name = newName;
            System.out.println("Файл переименован в '" + name + "'.");
        } else {
            System.out.println("Ошибка при переименовании файла.");
        }
    }

    @Override
    public void append(String content) {
        try (FileWriter writer = new FileWriter(directory.getPath() + java.io.File.separator + name, true)) {
            writer.write(content);
            System.out.println("Текст успешно добавлен в файл '" + name + "'.");
        } catch (IOException e) {
            System.out.println("Ошибка при добавлении текста: " + e.getMessage());
        }
    }

    @Override
    public void display() {
        try (BufferedReader reader = new BufferedReader(new FileReader(directory.getPath() + java.io.File.separator + name))) {
            System.out.println("Содержимое файла '" + name + "':");
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }

    @Override
    public void delete() {
        java.io.File fileToDelete = new java.io.File(directory.getPath() + java.io.File.separator + name);
        if (fileToDelete.delete()) {
            System.out.println("Файл '" + name + "' успешно удален.");
        } else {
            System.out.println("Ошибка при удалении файла.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "TextFile{" +
                "name='" + name + '\'' +
                ", directory=" + directory +
                '}';
    }
}



