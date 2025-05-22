import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class DictManager {
    private AbstractDictionary currentDict;
    private File dictFile;

    public void setup() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Укажите файл словаря: ");
        String path = sc.nextLine();

        dictFile = new File(path);
        if(!dictFile.exists()) {
            try {
                dictFile.createNewFile();
                System.out.println("Создан новый файл!");
            } catch(IOException e) {
                System.out.println("Ошибка создания файла!");
            }
        }

        selectDictType();
    }

    void selectDictType() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Выберите тип:");
        System.out.println("1. 4 буквы - буквенный");
        System.out.println("2. 5 цифр - циферный");

        int type = sc.nextInt();
        sc.nextLine();

        if(type == 1) {
            currentDict = new LetterDictionary(dictFile);
        } else {
            currentDict = new NumberDictionary(dictFile);
        }
    }

    public void changeDictType() {
        selectDictType();
        System.out.println("Тип изменен!");
    }

    public boolean addWord(String word, String trans) {
        return currentDict.add(word, trans);
    }

    public boolean removeWord(String word) {
        return currentDict.remove(word);
    }

    public String getTranslation(String word) {
        return currentDict.find(word);
    }

    public void showDict() {
        currentDict.print();
    }
}
