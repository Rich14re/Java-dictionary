import java.io.IOException;

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
}
