package kz.petsclinic.clinic.emulatedUsers;

import kz.petsclinic.clinic.controller.MainController;

import java.util.Random;

import static kz.petsclinic.clinic.emulatedUsers.Generator.*;

/**
 * эмулирует работу јдминистратора,
 * добавл€ющего записи в клинику
 */
public class Administrator implements Runnable{

    private MainController controller;
    private int failCount;

    public Administrator(final MainController controller) {
        this.controller = controller;
    }

    @Override
    public void run() {
        long timer = - System.currentTimeMillis();
        for (int i = 0; i < 20; i++) {
            if (controller.addPerson(getPersonName(), getPetName() , getPetType()) == false) {
                System.out.println("Administrator operations: add failed");
                failCount++;
            }
            System.out.println(controller.getAll());
            sleep();
        }
        timer += System.currentTimeMillis();
        System.out.println("Passed: " +  (timer)/1000 + " sec (Administrator)" );
        System.out.println("Operations failed: " + failCount + " times (Administrator)");
    }

    private void sleep() {
        Random rand = new Random();
        try {
            Thread.sleep(rand.nextInt(4) * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
