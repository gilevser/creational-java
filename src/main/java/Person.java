import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    private int age ;
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
            this.age = age;
        }
    }

    public boolean hasAge() {
        return age >= 0;
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
    public int getAge() {
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
            age++;
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
                "Возраст: " + this.age + "\n" +
                "Адрес: " + this.address + "\n";
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}