package Assignment06_000315902;

import java.util.Arrays;
import java.util.Random;


/**
 * Derived from monster class. When Constructor is called Orc is randomized between Warlord or Infantry.
 * Contains special attributes ( leadership, rank, and special methods).
 * @author Armand Amores
 */
public class Orc extends Monster{
    /** Display if warlord or infantry  */
    private String rank;
    /** if warlord rating > 1 if infantry rating = 0 */
    private int leaderShipRating;
    /** warlords have access to 5 infantry orcs through list  */
    private Orc[] infantryOrc;
    /** if orc created is infantry, one warlord attached through list */
    private Orc [] warlordOrc;


    /** Customizable orc. Uses kindOfOrc method to determine if orc is warlord or infantry
     * @param clan
     * @param ferocity
     * @param defence
     * @param magic
     */
    public Orc(String clan, int ferocity, int defence, int magic){
       super(clan, ferocity, defence, magic); // uses super to get monster attributes
       kindOfOrc(); // method to determine orc warlord or infantry
    }

    /** just clan customizable, uses kindOfOrc method to determine orc warlord or infantry
     * @param clan
     */
    public Orc(String clan) {
        super(clan); // grabs monster attributes and replaces clan
        kindOfOrc(); // method to determine orc warlord or infantry
    }

    /**
     * determine if orc is a warlord or is infantry. Based on type of orc, special attributes applied.
     */
    private void kindOfOrc() {

        Random random = new Random(); // used to generate random number
        int randomRank = random.nextInt(10) ; // generate number from 0-10
        System.out.println("\n"+randomRank); // console randomRank to see what it generates
        if (randomRank >= 5) { // if 5 or greater, orc warlord
            this.setRank("Warlord");
            this.leaderShipRating = (int) (Math.random() * 5) + 1; //warlords get a rating greater than 0
            this.infantryOrc = new Orc [5]; // sets infantry units
            for (int i = 0; i < 5; i++) { // creates infantry orcs
                Orc orc = this;
                this.infantryOrc[i] = orc; // move to this.orc(warlord) infantryOrc list
            }
        }else if (randomRank < 5) { // case for infantry orc
            this.setRank("Infantry");
            this.setLeaderShipRating(0); // default value
            this.warlordOrc = new Orc[1]; // set list space to fit one warlord
            Orc orc = this; // same stats basically
            this.warlordOrc[0] = orc; // moves warlord orc to list
        }
        System.out.println(this.getRank()); // console out rank

    }

    /** Display orc rank, leadership value, and stats
     * @return
     */
    @Override
    public String toString() {
        return "\n* Orc - " + this.getRank() + " - Leadership rating: " +
                leaderShipRating + "\n" + super.toString();
    }

    /**
     * @return rank
     */
    public String getRank() {
        return this.rank;
    }

    /** set rank
     * @param rank
     */
    public void setRank(String rank) {
        this.rank = rank;

    }

    /** leadership rating
     * @return
     */
    public int getLeaderShipRating() {
        return leaderShipRating;
    }

    /**  increases based on rank warlord and amount of treasure
     * @param leaderShipRating
     */
    public void setLeaderShipRating(int leaderShipRating) {
        this.leaderShipRating = leaderShipRating;

        //if treasure is divisible by 10 it will increase leadership rating by 1 and orc must be warlord
        if (this.getTreasure() % 10 == 0 && this.rank.equals("Warlord")){
            leaderShipRating ++;
        }

    }

    /** Overides Monster method and makes it so that if orc is a warlord, there attack score receives multiplier of 1.5
     * @param ferocity
     * @param defence
     * @param magic
     * @return
     */
    @Override
    public double generateAttackScore(int ferocity, int defence, int magic){
        double attackScore; // initialize attack score
        if (this.getRank().equals("Warlord")){
            attackScore = (double) ((ferocity+defence+magic) / 3.0) * 1.5; // if warlord
        } else {
            attackScore = (double) ((ferocity+defence+magic) / 3.0); // if infantry
        }
        return attackScore;
    }

    /**
     * Method for warlords, displays infantry at his command
     */
    public void getInfantry() {
        if (this.rank.equals("Warlord")) {
            //calls on each orc in infantry list
            for (Orc orcInfantry : this.infantryOrc) {
                orcInfantry.setRank("Infantry");
                System.out.println("\nReporting for duty" + orcInfantry);
            }
        } else {
            System.out.println("\nThis Orc is not a Warlord!"); // case for if infantry orc calls method
        }
    }

    /**
     * Method for Infantry orcs, callable only by them.
     */
    public void getWarlord(){
        if (this.rank.equals("Infantry")){
            this.warlordOrc[0].setRank("Warlord"); // sets warlord rank
            System.out.println("\nSir!" + this.warlordOrc[0]); // displays warlord in list
        } else {
            System.out.println("This Orc is a Warlord!"); // case if warlord orc calls method
        }
    }

    /**
     * Callable by warlords only and must be alive, heals all orcs within infantry list...small issue with multiple.
     * Tried to specify each orc in lists specific health to be changed but for some reason health is carried over and
     * multiple applied to carried over value.
     *
     */
    public void battleCry() {
        if (this.rank.equals("Warlord") && this.isAliveStatus()) { //alive and warlord
            System.out.println(this);
            System.out.println("Warlord Sounds Battlecry!!!");
            for (Orc orcInfantry : this.infantryOrc) { // loop through each infantry orc
                orcInfantry.setRank("Infantry");
                System.out.println(orcInfantry.getHealth());
                System.out.println(this.getLeaderShipRating());
                orcInfantry.setHealth(orcInfantry.getHealth()+ this.getLeaderShipRating() * 5); // specifying infantry orc health
                System.out.println(orcInfantry);
            }

        } else if(this.rank.equals("Warlord") && !this.isAliveStatus()){ // case if dead
            System.out.println("This Warlord Orc is dead!!");;
        }else {
            System.out.println("Unable to sound Battlecry"); // case if infantry orc tries to use
        }
    }

    /** Only manticores can change clans
     * @param clan
     */
    @Override
    protected void setClan(String clan) {
        System.out.println("Unable to change clan.");

    }


}
