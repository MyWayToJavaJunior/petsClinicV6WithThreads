package kz.petsclinic.clinic;

import kz.petsclinic.clinic.collection.PersonCollection;
import kz.petsclinic.clinic.controller.MainController;

/**
 * @author DK
 * @version 1.0.3
 */
public class Main {

    public static void main(String[] args) {
        PersonCollection clinic = new PersonCollection();
        MainController controller = new MainController(clinic);

        System.out.println(controller.getAll());
        controller.addPerson("vasya", "vasinkot", "Cat");
        controller.addPerson("petya", "petindog", "Dog");

        System.out.println(controller.getAll());

    }
}