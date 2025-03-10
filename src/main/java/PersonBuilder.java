import java.util.OptionalInt;

public class PersonBuilder {
    private String name;
    private String surname;
    private OptionalInt age;
    private String address;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }
    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }
    public PersonBuilder setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Некорректный возраст");
        } else {
            this.age = OptionalInt.of(age);
            return this;
        }
    }
    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() {
        if (name == null || surname == null) {
            throw new IllegalStateException("Не хватает обязательных полей");
        }
        Person person;
        if (age.isPresent()) {
            person = new Person(name, surname, age.getAsInt());
        } else {
            person = new Person(name, surname);
        }
        return person;
    }
}