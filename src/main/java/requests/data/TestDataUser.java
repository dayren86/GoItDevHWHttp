package requests.data;

import entity.user.User;

import java.util.ArrayList;
import java.util.List;

public class TestDataUser {

    public User user1 = new User(1, "userTest1", "firstNameTest1", "lastNameTest1", "test1@test.com", "sdffas1", "2342234", 1);
    public User user2 = new User(2, "userTest2432543523", "firstNameTest2", "lastNameTest2", "test2@test.com", "sdffas2", "2342234", 2);
    public User user3 = new User(3, "userTest3", "firstNameTest3", "lastNameTest3", "test3@test.com", "sdffas3", "2342234", 3);
    public User user5 = new User(5, "userTest5", "firstNameTest5", "lastNameTest5", "test5@test.com", "sdffas5", "2342234", 3);
    public User[] userArray = {user1, user2, user3};
    public List<User> list = new ArrayList<>();

    public TestDataUser() {
        list.add(user1);
        list.add(user2);
        list.add(user3);
    }
}
