package Assignment06_000315902;


/**
 * Derived from Monster class, has an attack buff applied to monster
 * @author Armand Amores
 */
public class Manticore extends Monster{

    /** Manticore with customizable attributes
     * @param clan
     * @param ferocity
     * @param defense
     * @param magic
     */
    public Manticore(String clan,int ferocity, int defense, int magic){
        super(clan,ferocity, defense, magic); // takes remaining monster attributes and fills rest with user arguments

    }

    /** takes clan name as argument
     * @param clan
     */
    public Manticore(String clan) {
        super(clan); // takes remaining monster attributes and takes string clan name
    }

    /** Display monster stats, also note attack buff displayed
     * @return
     */
    @Override
    public String toString() {
        return "\n* Manticore (1.5x buff on attacks) attackscore: " + this.generateAttackScore(this.getFerocity(),this.getDefence(),this.getMagic())
                + " \n" + super.toString();

    }

    /** Note only class that can change clan name
     * @param clan
     */
    protected void betrayClan(String clan){
        super.setClan(clan);
        System.out.println("\n" + this + " has betrayed his clan!");
        System.out.println(this + " new clan is: " + super.getClan());
        System.out.println(this.toString());
        System.out.println(super.toString());

    }

    /** Applies attack buff
     * @param ferocity
     * @param defence
     * @param magic
     * @return
     */
    @Override
    public double generateAttackScore(int ferocity, int defence, int magic){
        double attackScore = (double) ((ferocity+defence+magic) / 3.0);
        return (Math.round((attackScore * 10.0) / 10.0) * 1.5) ;
    }


}
