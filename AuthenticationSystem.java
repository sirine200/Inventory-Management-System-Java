package JavaProject;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AuthenticationSystem {
    private List<User> users;

    public AuthenticationSystem() {
        this.users = new ArrayList<>();
    }

    public void addUser(User user) {
        users.add(user);
    }

    
    public boolean authenticate(String username, String password) {
        Optional<User> userOptional = users.stream()
                .filter(user -> user.getUsername().equals(username) && user.getPassword().equals(password))
                .findFirst();
        
        return userOptional.isPresent();
    }
}


