package Assignment06_000315902;

import java.util.ArrayList;


/**
 * Derived from Monster class. When goblin created a sworn enemy attached. Method to call enemy available
 */
public class Goblin extends Monster{
    /** enemy goblin list */
    private static ArrayList<Goblin> enemyGoblinList = new ArrayList<>();
    /** created goblin list  */
    private static ArrayList<Goblin> goblinList = new ArrayList<>();

    /** Goblin with customizable attributes
     * @param clan
     * @param ferocity
     * @param defense
     * @param magic
     */
    public Goblin(String clan,int ferocity, int defense, int magic){
        super(clan, ferocity, defense, magic); // takes remaining monster attributes and fills rest with user arguments
        goblinList.add(this); // adds goblin to list
        assignEnemy(); // assigns an enemy to created goblin
    }

    /** takes clan name as argument
     * @param clan
     */
    public Goblin(String clan) {
        super(clan); // takes remaining monster attributes and takes string clan name
        goblinList.add(this); // adds goblin to list
        assignEnemy(); // assigns an enemy to created goblin
    }

    /** goblin stats
     * @return
     */
    @Override
    public String toString() {
        return "\n* Goblin" + " \n" + super.toString();
    }

    /** Unable to change, only Manticores can
     * @param clan
     */
    @Override
    protected void setClan(String clan) {
        System.out.println("Unable to change clan.");

    }

    /**
     * Assigns an enemy goblin of same stats
     */
    private void assignEnemy() {
        for (Goblin goblin : goblinList) {
            goblin = this; //create goblin
            enemyGoblinList.add(goblin); // add to enemy list
        }
    }

    /**
     * Used to get the enemy of created goblin. Note that enemy goblin list is iterated through goblinList index position
     * so that each enemy is specific to created goblin.
     */
    public void getEnemy(){
        System.out.println("\nSworn enemy" + enemyGoblinList.get(goblinList.indexOf(this)));

    }
}
