import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        StringBuilder logFile = new StringBuilder("Log установки:");
        // 1
        logFile.append(createDir("g:/Мой диск/Games/src")); // Чтобы создать в паке с main.java ./src вместо g:/Мой диск
        logFile.append(createDir("g:/Мой диск/Games/res"));
        logFile.append(createDir("g:/Мой диск/Games/savegames"));
        logFile.append(createDir("g:/Мой диск/Games/temp"));
        // 2
        logFile.append(createDir("g:/Мой диск/Games/src/main"));
        logFile.append(createDir("g:/Мой диск/Games/src/test"));
        // 3
        logFile.append(createF("g:/Мой диск/Games/src/main", "Main.java"));
        logFile.append(createF("g:/Мой диск/Games/src/main", "Util.java"));
        // 4
        logFile.append(createDir("g:/Мой диск/Games/res/drawables"));
        logFile.append(createDir("g:/Мой диск/Games/res/vectors"));
        logFile.append(createDir("g:/Мой диск/Games/res/icons"));
        // 5
        logFile.append(createF("g:/Мой диск/Games/temp", "temp.txt"));
        try {
            FileWriter fileWriter = new FileWriter("g:/Мой диск/Games/temp/temp.txt", false);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(logFile.toString());
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("Ошибка записи в файл!");
            //e.printStackTrace();
            System.out.println(e.getMessage());
        }
        System.out.println(logFile);
    }

    private static String createF(String path, String fileName) {
        try {
            File file = new File(path, fileName);
            if (file.createNewFile()) {
                return "\nФайл " + fileName + " создан.";
            } else {
                return "\nФайл " + fileName + " уже существует.";
            }
        } catch (IOException e) {
            System.out.println("Ошибка при создании файла!");
            //e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return "\nОшибка при создании файла!";
    }
    private static String createDir(String path) {
        File dir = new File(path);
        if (dir.mkdir()) {
            return "\nКаталог " + path + " создан.";
        } else {
            return "\nНе удалось создать каталог " + path;
        }
    }
}