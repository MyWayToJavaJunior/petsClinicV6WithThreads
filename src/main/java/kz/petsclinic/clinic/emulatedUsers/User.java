package kz.petsclinic.clinic.emulatedUsers;

import kz.petsclinic.clinic.controller.MainController;

import java.util.Random;

import static kz.petsclinic.clinic.emulatedUsers.Generator.getPersonName;
import static kz.petsclinic.clinic.emulatedUsers.Generator.getPetName;
import static kz.petsclinic.clinic.emulatedUsers.Generator.getPetType;

/**
 * эмулирует работу Пользователей,
 * меняющих имена животных
 */
public class User implements Runnable{

    private MainController controller;
    private int failCount;

    public User(final MainController controller) {
        this.controller = controller;
    }

    @Override
    public void run() {
        long timer = - System.currentTimeMillis();
        for (int i = 0; i < 20; i++) {
            if (controller.renamePet(getPetName(), getPetName()) == false) {
                System.out.println("User operations: rename failed");
                failCount++;
            }
            System.out.println(controller.getAll());
            sleep();
        }
        timer += System.currentTimeMillis();
        System.out.println("Passed: " +  (timer)/1000 + " sec (User)" );
        System.out.println("Operations failed: " + failCount + " times (User)");
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
