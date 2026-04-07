import java.util.List;
import java.util.ArrayList;


public class UserService {
    private List<RegisteredUsers> userList = new ArrayList<>();

   
    public void addUser(RegisteredUsers user) {
        userList.add(user);
        System.out.println("【UserService】添加用户: " + user.getFullName());
    }

    public boolean removeUser(String email) {
        for (RegisteredUsers user : userList) {
            if (user.getEmailAddress().equalsIgnoreCase(email)) {
                userList.remove(user);
                System.out.println("【UserService】删除用户: " + email);
                return true;
            }
        }
        System.out.println("【UserService】未找到用户: " + email);
        return false;
    }

    
    public boolean updateUser(String oldEmail, RegisteredUsers newUserInfo) {
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getEmailAddress().equalsIgnoreCase(oldEmail)) {
                userList.set(i, newUserInfo);
                System.out.println("【UserService】更新用户: " + oldEmail);
                return true;
            }
        }
        System.out.println("【UserService】未找到用户: " + oldEmail);
        return false;
    }

   
    public List<RegisteredUsers> retrieveUsers() {
        System.out.println("【UserService】查询所有用户...");
        return new ArrayList<>(userList); 
    }
}
