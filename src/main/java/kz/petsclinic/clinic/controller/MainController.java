package kz.petsclinic.clinic.controller;

import kz.petsclinic.clinic.Person;
import kz.petsclinic.clinic.collection.PersonCollection;
import kz.petsclinic.clinic.exception.UserException;
import kz.petsclinic.clinic.pets.AbstractPet;
import kz.petsclinic.clinic.pets.Bird;
import kz.petsclinic.clinic.pets.Cat;
import kz.petsclinic.clinic.pets.Dog;

/**
 * Прямой котроллер для работы с
 * коллекцией
 */
public class MainController {
    private PersonCollection clinic;

    public MainController(final PersonCollection clinic) {
        this.clinic = clinic;
    }

    public void addPerson(final String nameOfPerson,
                          final String nameOfPet, final String typeOfPet) {
        AbstractPet pet;
        switch (typeOfPet) {
            default:
            case "Cat":     pet = new Cat(nameOfPet);
                break;
            case "Bird":    pet = new Bird(nameOfPet);
                break;
            case "Dog":     pet = new Dog(nameOfPet);
        }
        Person person = new Person(nameOfPerson, pet);
        clinic.add(person);
    }

    public String getAll() {
        return clinic.isEmpty() ? "Clinic is empty" : clinic.toString();
    }

    public String getPersonByName(final String nameOfPerson) {
        int idOfPerson = clinic.getPersonId(getBlankPersonByName(nameOfPerson));
        return idOfPerson < 0 ? "Not found" : "> " + clinic.get(idOfPerson).toString();
    }

    public String getPersonByPetName(final String nameOfPet) {
        int idOfPerson = clinic.getPersonId(getBlankPersonByPetName(nameOfPet));
        return idOfPerson < 0 ? "Not found" : "> " + clinic.get(idOfPerson).toString();
    }

    public boolean removeByName(final String nameOfPerson) {
        int idOfPerson = clinic.getPersonId(getBlankPersonByName(nameOfPerson));
        if (idOfPerson >= 0) clinic.remove(idOfPerson);
        return idOfPerson < 0 ? false : true;
    }

    public boolean removeByPetName(final String nameOfPet) {
        int idOfPerson = clinic.getPersonId(getBlankPersonByPetName(nameOfPet));
        if (idOfPerson >= 0) clinic.remove(idOfPerson);
        return idOfPerson < 0 ? false : true;
    }

    public boolean renamePerson(final String nameOfPerson, final String newNameOfPerson) {
        int idOfPerson = clinic.getPersonId(getBlankPersonByName(nameOfPerson));
        if (idOfPerson >= 0) clinic.get(idOfPerson).setNameOfPerson(newNameOfPerson);
        return idOfPerson < 0 ? false : true;
    }

    public boolean renamePet(final String nameOfPet, final String newNameOfPet) {
        int idOfPerson = clinic.getPersonId(getBlankPersonByPetName(nameOfPet));
        if (idOfPerson >= 0) clinic.get(idOfPerson).setNameOfPet(newNameOfPet);
        return idOfPerson < 0 ? false : true;
    }

    private Person getBlankPersonByPetName(final String nameOfPet) {
        return new Person(null, new Cat(nameOfPet));
    }

    private Person getBlankPersonByName(final String nameOfPerson) {
        return new Person(nameOfPerson, null);
    }


}
