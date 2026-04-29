package Source.ToDoList;

import java.util.ArrayList;

public class TodoService {
    private ArrayList<TodoList> todo = new ArrayList<>();

    public TodoService(){
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

    public String getTodoName(int index){
        return todo.get(index).getTodo();
    }

    public  String getTodoDetail(int index){
        return todo.get(index).getDetails();
    }

    public String getTodoDate(int index){
        return todo.get(index).getDate();
    }

    public int getSize(){
        return todo.size();
    }
}
