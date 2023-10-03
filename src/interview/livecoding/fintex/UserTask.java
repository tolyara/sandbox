package interview.livecoding.fintex;

import interview.livecoding.fortest.TestCaseArrayInt;
import interview.livecoding.fortest.TestCaseString;
import interview.livecoding.fortest.TestUtil;

import java.util.List;
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
        runTestCases();
    }

    private static void runTestCases() {
        List<TestCaseString> testCases = List.of(
                new TestCaseString("default@gmail.com", null),
                new TestCaseString("default@gmail.com", new User(false, null)),
                new TestCaseString("tony@gmail.com", new User(false, "someemail@gmail.com")),
                new TestCaseString("default@gmail.com", new User(true, "admin@gmail.com"))
        );

        testCases.forEach((t) -> {
            String result = getEmail((User) t.getTarget());
            TestUtil.printTestResult(t.getExpected(), result);
        });
    }

    private static String getEmail(User user) {
        String replacement = "tony";
        String defaultEmail = "default@gmail.com";

        Optional<User> userOptional = Optional.ofNullable(user);
        String result = userOptional.filter(u -> !u.isAdmin).map(u -> u.getEmail())
                .map(e -> e.map(email -> replacement + "@" + email.split("@")[1]).orElse(defaultEmail))
                .orElse(defaultEmail);

        // TODO use optional.flatmap

        return result;
    }

}
