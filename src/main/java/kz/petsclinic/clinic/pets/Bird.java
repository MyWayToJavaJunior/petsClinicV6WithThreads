package kz.petsclinic.clinic.pets;

/**
 * ����� ������������ �� AbstractPet
 */
public class Bird extends AbstractPet {

    private static final String ABILITY = "Kill dogs";

    public Bird(final String nameOfPet) {
        super(nameOfPet, ABILITY);
    }
}
