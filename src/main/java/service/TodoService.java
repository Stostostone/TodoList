package service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.TodoList;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class TodoService {
    private ArrayList<TodoList> todo = new ArrayList<>();
    ObjectMapper mapper = new ObjectMapper();
    File file;

    public TodoService() {
        this.file = new File("todos.json");
    }

    public void loadTodo(){
        if (! file.exists() || file.length() == 0) {
            todo = new ArrayList<>();
            try {
                mapper.writeValue(file, this.todo);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return;
        }
        try {
            todo = mapper.readValue(file, new TypeReference<ArrayList<TodoList>>() {
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveTodo(){
        try {
            mapper.writeValue(file, this.todo);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void addTodo(String todo, String details, String date){
        this.todo.add(new TodoList(todo, details, date));
        saveTodo();
    }

    public void removeTodo(int index){
        todo.remove(index);
        saveTodo();
    }

    public void setTodoName(String name,int index){
        todo.get(index).setTodo(name);
        saveTodo();
    }

    public void setTodoDetail(String detail,int index){
        todo.get(index).setDetails(detail);
        saveTodo();
    }

    public void setTodoDate(String date,int index){
        todo.get(index).setDate(date);
        saveTodo();
    }

    public int getSize(){
        return todo.size();
    }

    public TodoList getTodo(int index){
        return todo.get(index);
    }
}
