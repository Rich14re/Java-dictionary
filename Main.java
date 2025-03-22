import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean exit = false;
        Scanner sc = new Scanner(System.in);

        while(!exit){
            System.out.println("Выберите действие... ");
            System.out.println("1. Чтение");
            System.out.println("2. Добавление");
            System.out.println("3. Удаление");
            System.out.println("4. Поиск по ключу");
            System.out.println("5. Выход");

            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch){
                case 1: break; //вывод
                case 2: break; //добавление
                case 3: break; //удаление
                case 4: break; //поиск по ключу
                case 5: break; //выход
            }
        }
    }
}