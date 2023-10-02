package interview.livecoding.fintex;

import java.util.Optional;

public class UserTask {

    private static final class User {

        private boolean isAdmin;

        private String email;

        public User(boolean isAdmin, String email) {

            this.isAdmin = isAdmin;

            this.email = email;

        }

        public Optional<String> getEmail() {

            return Optional.ofNullable(email);

        }

        public boolean isAdmin() {
            return isAdmin;
        }

        public void setAdmin(boolean admin) {
            isAdmin = admin;
        }

    }

    // admin false, in

    // Using initial code call User getEmail method and then using Optional class filter out admin users
    // and then if email present then change email part before @ symbol to your name, else return some default email.
    public static void main(String[] args) {
        User user = new User(false, "email@gmail.com");

        Optional<User> userOptional = Optional.ofNullable(user);

        Optional<String> resultUserEmail = userOptional.filter(u -> !u.isAdmin).map(u -> u.getEmail().map(e -> e). orElse("default@gmail.com"));

        // TODO use optional.flatmap
    }

}
