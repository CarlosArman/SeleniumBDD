package modelos;

import net.datafaker.Faker;

public class Usuario {
    private final String name;
    private final String lastname;
    private final String zipcode;

    public Usuario() {
        final var faker = new Faker();
        this.name = faker.name().firstName();
        this.lastname = faker.name().lastName();
        this.zipcode = faker.address().zipCode();
    }

    public String getLastname() {
        return lastname;
    }

    public String getName() {
        return name;
    }

    public String getZipcode() {
        return zipcode;
    }
}
