package Assignment06_000315902;

/**
 * Main class used to test methods
 * @author Armand Amores
 */
public class Main {
    public static void main(String[] args) {

        Manticore manty = new Manticore("mantytown",20,10,8);
        System.out.println(manty);

        Goblin gobby = new Goblin("gobtown",16,13,12);
        System.out.println(gobby);

//        manty.attackMonster(gobby);

        Orc orcy = new Orc("orcland",15,15,15);
        System.out.println(orcy.toString());


        orcy.attackMonster(gobby); // make sure attack method works, note orc selects a golin to attack

        orcy.battleCry(); // test battlecry method... note multiple applied not taking specific infantry orc health

        Goblin gobby2 = new Goblin("goblinville");
        System.out.println(gobby2);

        gobby2.getEnemy(); // used to get goblins sworn enemy









    }
}
