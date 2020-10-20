package pl.coderslab.user;

import java.util.HashMap;
import java.util.Map;

public class UserRepository {
    private Map<Integer, User> users;
    public UserRepository() {
        this.users = new HashMap<>();
    }
    public void persist(User user) {
        Integer id = users.size()+1;
        user.setId(id);
        users.put(id, user);
    }
    public User findByName(String name) {
        return users.entrySet().stream()
                .filter(u->u.getValue().getName().equals(name))
                .findAny()
                .get()
                .getValue();
    }
    public void update(User user) {
        User userFromDatabase = users.get(user.getId());
        userFromDatabase.setName(user.getName());
    }
    public void deleteById(Integer id) {
        users.remove(id);
    }
    public int count() {
        return users.size();
    }
// pozostałe metody
}