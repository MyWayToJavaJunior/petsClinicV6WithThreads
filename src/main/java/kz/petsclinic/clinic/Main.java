package kz.petsclinic.clinic;

import kz.petsclinic.clinic.collection.PersonCollection;
import kz.petsclinic.clinic.controller.MainController;
import kz.petsclinic.clinic.emulatedUsers.Administrator;
import kz.petsclinic.clinic.emulatedUsers.User;

/**
 * @author DK
 * @version 1.0.3
 */
public class Main {
    static Administrator admin;
    static User user;
    public static void main(String[] args) {
        PersonCollection clinic = new PersonCollection();
        MainController controller = new MainController(clinic);
        admin = new Administrator(controller);
        Thread adminTread = new Thread(admin);
        adminTread.start();
        user = new User(controller);
        Thread userThread = new Thread(user);
        userThread.start();
    }
}