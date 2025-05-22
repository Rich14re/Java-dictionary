import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
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
            System.out.println("Файл не найден!");
        }
    }
}
