package Source.ToDoList;

import java.util.ArrayList;
import java.util.Scanner;

public class testTodoList {
    public static void main(String[] args){

        TodoService todoService = new TodoService();
        Scanner input = new Scanner(System.in);

        while(true){
            System.out.println("1:add a todo 2:delete a todo 3:display all 4:reset Todo");

            int enter = input.nextInt();
            input.nextLine();

            switch (enter){
                case 1:
                    System.out.println("Enter todo name: ");
                    String todoName = input.nextLine();
                    System.out.println("Enter todo details: ");
                    String Details = input.nextLine();
                    System.out.println("Enter todo endDate: ");
                    String Date = input.nextLine();
                    todoService.addTodo(todoName,Details,Date);
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
                    System.out.printf("%-10s %-15s %-20s\n",todoService.getTodoName(i),todoService.getTodoDetail(i),todoService.getTodoDate(i));
                    }
                    if (todoService.getSize() == 0){
                        System.out.println("no todo");
                    }
                    System.out.println("-----------------------------------------");
                    break;
                case 4:
                    System.out.println("Choose the todo you want to reset");

                    int Index = input.nextInt();
                    input.nextLine();
                    if (Index > todoService.getSize() || Index < 1){
                        System.out.println("todo is not exist");
                            break;
                        }

                    Index = Index - 1;

                    System.out.println("Choose the part 1:name 2:detail 3:date 4:all");

                    int reset = input.nextInt();
                    input.nextLine();

                    switch (reset){
                        case 1:
                            System.out.println("Enter new name: ");
                            String name = input.nextLine();
                            todoService.setTodoName(name, Index);
                            break;
                        case 2:
                            System.out.println("Enter new detail: ");
                            String detail = input.nextLine();
                            todoService.setTodoDetail(detail, Index);
                            break;
                        case 3:
                            System.out.println("Enter new date: ");
                            String date = input.nextLine();
                            todoService.setTodoDate(date, Index);
                            break;
                        case 4:
                            System.out.println("Enter new name: ");
                            String name1 = input.nextLine();
                            todoService.setTodoName(name1, Index);
                            System.out.println("Enter new detail: ");
                            String detail1 = input.nextLine();
                            todoService.setTodoDetail(detail1, Index);
                            System.out.println("Enter new date: ");
                            String date1 = input.nextLine();
                            todoService.setTodoDate(date1, Index);
                            break;
                    }
                    break;
            }
        }
    }
}
