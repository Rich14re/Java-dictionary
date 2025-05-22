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
                System.out.println("Создан новый файл словаря, так как введенный не найден.");
            } catch(IOException e) {
                System.out.println("ошибка при создании файла");
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

    public void addNewWord(Scanner sc) {
        System.out.print("Введите слово: ");
        String word = sc.nextLine();
        System.out.print("Введите перевод: ");
        String trans = sc.nextLine();

        if(addWord(word, trans)) {
            System.out.println("Успешно добавлено!");
        } else {
            System.out.println("Ошибка формата!");
        }
    }

    public void deleteWord(Scanner sc) {
        System.out.print("Введите слово для удаления: ");
        String word = sc.nextLine();

        if(removeWord(word)) {
            System.out.println("Удалено!");
        } else {
            System.out.println("Не найдено!");
        }
    }

    public void findTranslation(Scanner sc) {
        System.out.print("Введите слово: ");
        String word = sc.nextLine();

        String result = getTranslation(word);
        if(result != null) {
            System.out.println("Перевод: " + result);
        } else {
            System.out.println("Нет такого!");
        }
    }
}
