package kz.petsclinic.clinic;

import kz.petsclinic.clinic.pets.AbstractPet;

/**
 * Запись - Персона
 */
public class Person {
    private String nameOfPerson;
    private AbstractPet pet;

    public Person(final String nameOfPerson, final AbstractPet pet) {
        this.nameOfPerson = nameOfPerson;
        this.pet = pet;
    }

    public String getNameOfPerson() {
        return nameOfPerson;
    }

    public void setNameOfPerson(final String newNameOfPerson) {
        this.nameOfPerson = newNameOfPerson;
    }

    public String getNameOfPet() {
        return pet.getNameOfPet();
    }

    public void setNameOfPet(final String newNameOfPet) {
        pet.setNameOfPet(newNameOfPet);
    }

    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        if (!(obj instanceof Person)) return false;
        Person entry = (Person) obj;
        if (entry.nameOfPerson == null) {
            if(entry.pet != null) result = pet.getNameOfPet().equals(entry.getNameOfPet());
        }
        else
            if (nameOfPerson != null) result = nameOfPerson.equals(entry.nameOfPerson);
        return result;
    }

    @Override
    public String toString() {
        return "Name of Person: " + nameOfPerson + ", " + pet;
    }
}
