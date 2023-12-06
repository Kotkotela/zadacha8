import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, List<User>> userMap = new HashMap<>();
        String name;
        Integer age;
        for (int i = 1; i < 6; i++){
            System.out.println("введите имя номер " + i  + " :" );
            name = scanner.nextLine();
            System.out.println("введите возраст: ");
            age = Integer.valueOf(scanner.nextLine());
            List<User> userList = userMap.get(age);
            if (userList == null){
                userList = new ArrayList<>();
                userMap.put(age, userList);
            }
            User user = new User(name,age);
            userList.add(user);

    }
        System.out.println("Введите требуемый возраст: ");
        Integer age2 = Integer.valueOf(scanner.nextLine());

        List<User> user2 = userMap.get(age2);
        if(user2 != null) {
            Collections.sort(user2, Comparator.comparing(User::getname));
            System.out.println("Пользователи возраста " + age2 + " :");
            for (User user : user2) {
                System.out.println(user.getname());

            }
        }else{
              System.out.println("Нет пользователей с требуемым возрастом " + age2);
            }
        }
}
class User{
    private String name;
    private Integer age;
    public User(String name, Integer age){
        this.name = name;
        this.age = age;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setAge(Integer age){
        this.age = age;
    }
    public String getname(){
        return name;
    }
    public Integer getAge(){
        return age;
    }
    public String toString(){
        return name + ", возраст " + age + " лет";
    }
}