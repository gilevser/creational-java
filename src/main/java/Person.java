import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    private OptionalInt age = OptionalInt.empty();
    protected String address;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        if (age < 0) {
            throw new IllegalArgumentException("Некорректный возраст");
        } else {
            this.age = OptionalInt.of(age);
        }
    }

    public boolean hasAge() {
        return age.isPresent();
    }
    public boolean hasAddress() {
        return address != null;
    }

    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public OptionalInt getAge() {
        return age;
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public void happyBirthday() {
        if (hasAge()) {
            age = OptionalInt.of(age.getAsInt() + 1);
        }
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder()
                .setSurname(this.surname)
                .setAge(0)
                .setAddress(this.address);
    }

    @Override
    public String toString() {
        return "Имя: " + this.name + "\n" +
                "Фамилия: " + this.surname + "\n" +
                "Возраст: " + (hasAge() ? age.getAsInt() : "0") + "\n" +
                "Адрес: " + this.address + "\n";
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}