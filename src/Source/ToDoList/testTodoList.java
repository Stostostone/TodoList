package Source.ToDoList;

import java.util.Scanner;

//TODO:加退出功能,输入校验
//TODO: 加文件持久

public class testTodoList {
    public static void main(String[] args){

        TodoService todoService = new TodoService();
        Scanner input = new Scanner(System.in);
        boolean flag =true;

        while(flag){
            System.out.println("1:add a todo | 2:delete a todo | 3:display all | 4:reset Todo | 5:exit");

            if (!input.hasNextInt()) {
                System.out.println("Invalid input");
                input.nextLine();
                continue;
            }
            int enter = input.nextInt();
            input.nextLine();

            switch (enter){
                case 1:
                    System.out.println("Enter todo name: ");
                    String todoName = input.nextLine();
                    System.out.println("Enter todo details: ");
                    String details = input.nextLine();
                    System.out.println("Enter todo endDate: ");
                    String date = input.nextLine();
                    todoService.addTodo(todoName,details,date);
                    break;
                case 2:
                    System.out.println("Enter Index to delete: ");

                    int index = input.nextInt();
                    input.nextLine();

                    if (index < 1 || index > todoService.getSize()){
                        System.out.println("Invalid index");
                        break;
                    }

                    todoService.removeTodo(index-1);
                    break;
                case 3:
                    System.out.println("-----------------------------------------");
                    System.out.print("   name       detail       date\n");
                    for (int i = 0; i < todoService.getSize(); i++){
                    System.out.print((i+1) + ": ");
                    System.out.printf("%-10s %-15s %-20s\n",todoService.getTodo(i).getName(),todoService.getTodo(i).getDetails(),todoService.getTodo(i).getDate());
                    }
                    if (todoService.getSize() == 0){
                        System.out.println("no todo");
                    }
                    System.out.println("-----------------------------------------");
                    break;
                case 4:
                    System.out.println("Choose the todo you want to reset");

                    int newIndex = input.nextInt();
                    input.nextLine();
                    if (newIndex > todoService.getSize() || newIndex < 1){
                        System.out.println("todo is not exist");
                            break;
                        }

                    newIndex = newIndex - 1;

                    System.out.println("Choose the part 1:name 2:detail 3:date 4:all");

                    int reset = input.nextInt();
                    input.nextLine();

                    switch (reset){
                        case 1:
                            System.out.println("Enter new Name: ");
                            String newName = input.nextLine();
                            todoService.setTodoName(newName, newIndex);
                            break;
                        case 2:
                            System.out.println("Enter new Detail: ");
                            String newDetail = input.nextLine();
                            todoService.setTodoDetail(newDetail, newIndex);
                            break;
                        case 3:
                            System.out.println("Enter new date: ");
                            String newDate = input.nextLine();
                            todoService.setTodoDate(newDate, newIndex);
                            break;
                        case 4:
                            System.out.println("Enter new Name: ");
                            String nameAll = input.nextLine();
                            todoService.setTodoName(nameAll, newIndex);
                            System.out.println("Enter new Detail: ");
                            String detailAll = input.nextLine();
                            todoService.setTodoDetail(detailAll, newIndex);
                            System.out.println("Enter new date: ");
                            String dateAll = input.nextLine();
                            todoService.setTodoDate(dateAll, newIndex);
                            break;
                    }
                    break;
                case 5: System.out.println("Bye"); flag = false; break;
            }
        }
    }
}
