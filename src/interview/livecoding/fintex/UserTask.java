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

    public static final String at = "@";

    // admin false, in

    // Using initial code call User getEmail method and then using Optional class filter out admin users
    // and then if email present then change email part before @ symbol to your name, else return some default email.
    public static void main(String[] args) {
        runTestCases();
    }

    private static void runTestCases() {
        List<TestCaseString> testCases = List.of(
                new TestCaseString("default@gmail.com", Optional.empty()),
                new TestCaseString("default@gmail.com", Optional.of(new User(false, null))),
                new TestCaseString("tony@gmail.com", Optional.of(new User(false, "someemail@gmail.com"))),
                new TestCaseString("default@gmail.com", Optional.of(new User(true, "admin@gmail.com")))
        );

        testCases.forEach((t) -> {
            String result = getEmail((Optional<User>) t.getTarget());
            TestUtil.printTestResult(t.getExpected(), result);
        });
    }

    private static String getEmail(Optional<User> user) {
        String replacement = "tony";
        String defaultEmail = "default@gmail.com";

//        Optional<User> userOptional = Optional.ofNullable(user);

        return user.filter(u -> !u.isAdmin).map(u -> u.getEmail())
                .map(e -> e.map(email -> replacement + at + email.split(at)[1]).orElse(defaultEmail))
                .orElse(defaultEmail);
    }

    /**
     * https://stackoverflow.com/questions/30864583/what-is-the-difference-between-optional-flatmap-and-optional-map
     *  You only need to use 'flatMap' when you're facing nested Optionals.
     */
    private static String getEmail2(Optional<User> user) {
        String replacement = "tony";
        String defaultEmail = "default@gmail.com";

        return user.filter(u -> !u.isAdmin).flatMap(u -> u.getEmail())
                .map(e -> replacement + at + e.split(at)[1])
                .orElse(defaultEmail);
    }

}
