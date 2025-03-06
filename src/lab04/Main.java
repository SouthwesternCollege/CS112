package lab04;
public class Main {
    public static void main(String[] args) {
        Weapon elfWeapon1 = new Weapon("Poison Dagger", 3, 2, 2);
        Weapon elfWeapon2 = new Weapon("Short Bow", 2, 15, 2);
        Elf elf1 = new Elf();
        elf1.setAll("Fentoris", "Druid", "Chaotic Good", 100, 35, 1, elfWeapon1, elfWeapon2);

        System.out.println(elf1.toString());
    }

}