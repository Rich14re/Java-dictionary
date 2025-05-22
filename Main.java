import java.util.Scanner;

public class Main {
    static DictManager manager;

    public static void main(String[] args) {
        startApp();
    }

    static void startApp() {
        System.out.println("*** СЛОВАРЬ ***");
        manager = new DictManager();
        manager.setup();
        showMenu();
    }

    static void showMenu() {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("\n=== МЕНЮ ===");
            System.out.println("1. Сменить тип словаря");
            System.out.println("2. Добавить запись");
            System.out.println("3. Удалить запись");
            System.out.println("4. Найти перевод");
            System.out.println("5. Показать словарь");
            System.out.println("6. Выйти");
            System.out.print("Выберите: ");

            String choice = input.nextLine();

            switch (choice) {
                case "1":
                    manager.changeDictType();
                    break;
                case "2":
                    addNewWord(input);
                    break;
                case "3":
                    deleteWord(input);
                    break;
                case "4":
                    findTranslation(input);
                    break;
                case "5":
                    manager.showDict();
                    break;
                case "6":
                    System.exit(0);
                default:
                    System.out.println("Не понял...");
            }
        }
    }
}