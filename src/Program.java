import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class Program {
    static List<Priority> priorities = new ArrayList<>();
    static List<TaskInfo> tasks = new ArrayList<>();
    static String username = "Max";
    static int id = 0;
    static List<String> menu = new ArrayList<>();

    public static void addMenu(){
        menu.add("Добавить задачу");
        menu.add("Вывести список задач");
        menu.add("Пометить задчу как 'Выполнено'");
        menu.add("Удалить задачу");
        menu.add("Export задач");
    }

    public static void exportCsv(){
        ;


        try (OutputStream os = new FileOutputStream(new File("Planer.csv"))){
            StringBuilder sb = new StringBuilder();
            for (TaskInfo task:tasks) {
                sb.append(task.toString());
                sb.append('\n');
            }
            os.write(sb.toString().getBytes());
            PrintWriter w = new PrintWriter(new OutputStreamWriter(os, "UTF-8"));
            System.out.println("done!");
            os.close();
            w.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Scanner user = new Scanner(System.in);
        String start = "start";
        addPriority();
        addMenu();
        while (start.equals("start")){
            System.out.println("Меню:");
            for (int i = 0; i < menu.size(); i++) {
                System.out.println(i+1 + " " + menu.get(i));
            }
            System.out.println("6 Выйти из программы");
            int answer = user.nextInt();
            switch (answer) {
                case (1):
                    addTask();
                    break;
                case (2):
                    printTask();
                    break;
                case (3):
                    finishTask();
                    break;
                case (4):
                    removeTask();
                    break;
                case (5):
                    exportCsv();
                    break;
                case (6):
                    start = "end";
                    break;
            }

            System.out.println("-----------------------------");
        }
    }

    public static void addPriority(){
        PriorityLight priorityLight = new PriorityLight();
        PriorityMedium priorityMedium = new PriorityMedium();
        PriorityHigh priorityHigh = new PriorityHigh();
        priorities.add(priorityLight);
        priorities.add(priorityMedium);
        priorities.add(priorityHigh);
    }

    public static void addTask(){
        Scanner user = new Scanner(System.in);
        System.out.println("Выберите приоритет задачи от 1 до "+ priorities.size());
        for (int i = 0; i < priorities.size(); i++) {
            System.out.println(i+1 + " " + priorities.get(i));
        }

        String answer2 = user.nextLine();

        int answer = Integer.parseInt(answer2  );
        while (answer < 1 ||answer > 3){
            System.out.println("Вы ввели отсутсвующее значение, повторите попытку");
            System.out.println("Выберите приоритет задачи от 1 до "+ priorities.size());
            answer = user.nextInt();
        }

        System.out.println("Введите название задачи:");
        String name = user.nextLine();

        System.out.println("Введите срок задачи");
        System.out.println("Введите год: ");
        int y = Integer.parseInt( user.next() );
        System.out.println("Введите месяц: ");
        int m = Integer.parseInt( user.next()  );
        System.out.println("Введите день: ");
        int d = Integer.parseInt( user.next()  );

        LocalDate ld = LocalDate.of( y , m , d );
        TaskInfo taskInfo = new TaskInfo(username, id++);
        if (answer == 1) {
            PriorityLight priorityLight = new PriorityLight();
            Task<PriorityLight> task = new Task<>(name, ld, priorityLight);
            taskInfo.task = task;
        } else if (answer == 2) {
            PriorityMedium priorityMedium = new PriorityMedium();
            Task<PriorityMedium> task = new Task<>(name, ld, priorityMedium);
            taskInfo.task = task;
        } else {
            PriorityHigh priorityHigh = new PriorityHigh();
            Task<PriorityHigh> task = new Task<>(name, ld, priorityHigh);
            taskInfo.task = task;
        }
        tasks.add(taskInfo);
    }

    public static void printTask(){
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println("* " + tasks.get(i).task);
        }
    }

    public static void finishTask(){
        Scanner user = new Scanner(System.in);
        System.out.println("Выберите задачу: ");
        printTask();
        int answer = user.nextInt();
        tasks.get(answer).setStatus("Done");
    }

    public static void removeTask(){
        Scanner user = new Scanner(System.in);
        System.out.println("Выберите задачу: ");
        printTask();
        int answer = user.nextInt();
        priorities.remove(answer);
    }

}
