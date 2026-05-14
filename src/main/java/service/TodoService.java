package service;

import model.TodoList;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class TodoService {
    private ArrayList<TodoList> todo = new ArrayList<>();
    File file;

    public TodoService() {
        this.file = new File("src/todos.txt");
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(" ");
                for (int i = 0; i < data.length; i++) {
                    System.out.println(data[i]);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            throw new RuntimeException(e);
        }
        if (file == null) {
            file = new File("todos.txt");
        }
    }


    public void addTodo(String todo, String details, String date){
        this.todo.add(new TodoList(todo, details, date));
    }

    public void removeTodo(int index){
        todo.remove(index);
    }

    public void setTodoName(String name,int index){
        todo.get(index).setTodo(name);
    }

    public void setTodoDetail(String detail,int index){
        todo.get(index).setDetails(detail);
    }

    public void setTodoDate(String date,int index){
        todo.get(index).setDate(date);
    }

    public int getSize(){
        return todo.size();
    }

    public TodoList getTodo(int index){
        return todo.get(index);
    }
}
