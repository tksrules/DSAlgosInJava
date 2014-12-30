/**
 * 1.The User constructor is private, which means that this class can not be directly instantiated from the client code.
 * 2.The class is once again immutable. All attributes are final and they’re set on the constructor. Additionally, we only provide getters for them.
 * 3.The builder uses the Fluent Interface idiom to make the client code more readable (we’ll see an example of this in a moment).
 * 4.The builder constructor only receives the required attributes and this attributes are the only ones that are defined “final” on the
 * builder to ensure that their values are set on the constructor.
 * 5.Can also throw exceptions while creating object fail fast. see age >120
 */

package DesignPatterns;

public class BuilderPattern {
    public static void main(final String... args) {
        final User x = new User.UserBuilder("john", "Doe").age(30).phone("1234567").address("Fake address 1234")
                .build();
        System.out.println(x.getAddress());
    }
}

class User {
    private final String firstName; // required
    private final String lastName; // required
    private final int age; // optional
    private final String phone; // optional
    private final String address; // optional

    private User(final UserBuilder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.age = builder.age;
        this.phone = builder.phone;
        this.address = builder.address;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public static class UserBuilder {
        private final String firstName;
        private final String lastName;
        private int age;
        private String phone;
        private String address;

        public UserBuilder(final String firstName, final String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public UserBuilder age(final int age) {
            this.age = age;
            return this;
        }

        public UserBuilder phone(final String phone) {
            this.phone = phone;
            return this;
        }

        public UserBuilder address(final String address) {
            this.address = address;
            return this;
        }

        public User build() {
            final User user = new User(this);
            if (user.getAge() > 120) {
                throw new IllegalStateException("Age out of range"); // thread-safe
            }
            return user;
        }
    }
}