import java.util.ArrayList;

/**
 * Created by Alexey on 3/1/2017.
 */
public class Client implements Person {
    private String firstName;
    private String sureName;
    private Address address;
    private String phoneNumber;
    private ArrayList<Pet> pets;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSureName(String sureName) {
        this.sureName = sureName;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void assignPet(Pet pet) {
        this.pets.add(pet);
    }

    public String getFirstName() {
        return firstName;

    }

    public String getSureName() {
        return sureName;
    }

    public Address getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public ArrayList<Pet> getPets() {
        return pets;
    }

    public Client(String firstName, String sureName, Address address, String phoneNumber) {
        this.firstName = firstName;
        this.sureName = sureName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.pets = new ArrayList<>();
    }
}
