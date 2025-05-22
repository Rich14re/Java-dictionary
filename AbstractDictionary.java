import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

abstract class AbstractDictionary {
    protected HashMap<String, String> words = new HashMap<>();
    protected File file;

    public AbstractDictionary(File f) {
        file = f;
        load();
    }

    abstract boolean checkWord(String word);

    void load() {
        try {
            Scanner fileReader = new Scanner(file);
            while(fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                String[] parts = line.split(" - ");
                if(parts.length == 2 && checkWord(parts[0])) {
                    words.put(parts[0], parts[1]);
                }
            }
            fileReader.close();
        } catch(FileNotFoundException e) {
            System.out.println("Файл не найден");
        }
    }

    boolean add(String word, String trans) {
        if(checkWord(word)) {
            words.put(word, trans);
            save();
            return true;
        }
        return false;
    }

    boolean remove(String word) {
        if(words.remove(word) != null) {
            save();
            return true;
        }
        return false;
    }

    String find(String word) {
        return words.get(word);
    }

    void print() {
        if(words.isEmpty()) {
            System.out.println("Словарь пуст");
            return;
        }

        int i = 1;
        for(Map.Entry<String, String> entry : words.entrySet()) {
            System.out.println(i++ + ". " + entry.getKey() + " - " + entry.getValue());
        }
    }

    void save() {
        try {
            PrintWriter writer = new PrintWriter(file);
            for(Map.Entry<String, String> entry : words.entrySet()) {
                writer.println(entry.getKey() + " - " + entry.getValue());
            }
            writer.close();
        } catch(IOException e) {
            System.out.println("Ошибка при сохранении");
        }
    }
}
