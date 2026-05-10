package Source.ToDoList;

import java.util.ArrayList;

//TODO: 修改数据读取，用TodoService返回对象，再用对象的方法读取数据  状态:✔️

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

    public int getSize(){
        return todo.size();
    }

    public TodoList getTodo(int index){
        return todo.get(index);
    }
}
