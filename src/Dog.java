/**
 * Created by Alexey on 3/1/2017.
 */
public class Dog implements Pet {
    private String name;
    private String breed;
    private int age;
    private Person owner;

    public void setName(String name) {
        this.name = name;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {

        return name;
    }

    public String getBreed() {
        return breed;
    }

    public int getAge() {
        return age;
    }

    public Person getOwner() {
        return owner;
    }

    public Dog() {

    }

    public Dog(String name, String breed) {

        this.name = name;
        this.breed = breed;
    }

    public Dog(String name, String breed, int age, Person owner) {

        this.name = name;
        this.breed = breed;
        this.age = age;
        this.owner = owner;
        owner.assignPet(this);
    }


    @Override
    public void changeOwner(Person newOwner) {
        this.owner = newOwner;
        newOwner.assignPet(this);
    }

    @Override
    public String toString() {
        return "Name: " +this.getName()+ ", Breed: " +this.getBreed()+ ", Age: " +this.getAge() + ", Owner: "+ ((Client)owner).getSureName();
    }
}
