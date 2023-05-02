package Assignment06_000315902;

import java.util.Random;

/**
 * Main Model class from which all deviations of Monsters are derived from.
 * Contains Basic Methods and Attributes that are accessible within the different Monster
 * Classes.
 * @author Armand Amores
 */
public class Monster {
    /** Display clan name */
    private  String clan;
    /**  Monster Attributes, factor for attack score */
    private int ferocity, defence, magic ;
    /** Monster Treasure */
    private int treasure;
    /** Monster Health */
    private double health ;
    /** Monster status */
    private boolean aliveStatus = true;


    /** Customizable monster
     * @param clan
     * @param ferocity
     * @param defence
     * @param magic
     */
    public Monster(String clan, int ferocity, int defence, int magic){
        this.clan = clan;
        this.ferocity = ferocity;
        this.defence = defence;
        this.magic = magic;
        //default values
        this.health = 10.0;
        this.treasure = 2;

    }

    /** Monster constructor that passes only clan name
     * @param clan
     */
    public Monster(String clan) {
        this.clan = clan;
        Random random = new Random();
        //Generates random number between 1 and 20
        this.ferocity = (random.nextInt(20) +1);
        this.defence = (random.nextInt(20) +1);
        this.magic = (random.nextInt(20) +1);
        //default values
        this.health = 10.0;
        this.treasure = 2;

    }

    /**
     * @return returns monster stats
     */
    @Override
    public String toString() {
        String aliveOrDead = aliveStatus ? "Alive" : "Dead";
        return "\t\t-----Monster Stats-----" +
                "\nStatus: " + aliveOrDead +
                "\tClan: " + clan +
                "\tHealth: " + health +
                "\nFerocity: " + ferocity +
                "\tDefence: " + defence +
                "\t\tMagic: " + magic +
                "\tTreasure: " + treasure;
    }

    /** Handles logic for attack monsters.
     * @param monster (specifies which monster to attack)
     */
    public void attackMonster(Monster monster) {
        if (this.aliveStatus && monster.aliveStatus) { //makes sure monsters have to be alive to fight
            //take both monsters attack score to compare
            double fighter1 = Math.round(this.generateAttackScore(this.ferocity, this.defence,this.magic) * 10.0) / 10.0; //calls attack score method and rounds to one decimal place
            double fighter2 = Math.round(monster.generateAttackScore(monster.ferocity,monster.defence,monster.magic) * 10.0) / 10.0;
            double loseHealth; // used to take away health points
//            System.out.println(fighter1);
//            System.out.println(fighter2);
            System.out.println("\n---------------fight commence---------------");

            //situations for who wins
            if (fighter1 > fighter2) {
                loseHealth = Math.round((fighter1 - fighter2) * 10.0) / 10.0; // determines how much health is lost
                monster.setHealth(Math.round(monster.getHealth()) * 10.0 / 10.0 - loseHealth); // subtract lost health
                monster.setTreasure(monster.getTreasure() - 1); // monster is the loser here, loses treasure

                //display losers result
                System.out.println(monster);
                System.out.println("* Lost the fight and lost " + loseHealth + " health points.");

                //display winners result
                if (monster.getTreasure() > 0){

                    this.setTreasure(this.getTreasure() + 1); // winner gets treasure
                    System.out.println(this);
                    System.out.println("* Won the fight and has taken opponents treasure (+1)");
                } else {
                    System.out.println(this);
                    System.out.println("* Won the fight");
                }

            } else if(fighter2 > fighter1) { // same case just opposite of above case
                loseHealth = Math.round((fighter2 - fighter1) * 10.0) / 10.0;
                this.setHealth(Math.round(this.getHealth()) * 10.0 / 10.0 - loseHealth);
                this.setTreasure(this.getTreasure() - 1);

                //display loser result
                System.out.println(this);
                System.out.println("* Lost the fight and lost " + loseHealth + " health points.");

                //display winner result
                if (this.getTreasure() > 0) {
                    monster.setTreasure(monster.getTreasure() + 1);
                    System.out.println(monster);
                    System.out.println("* Won the fight and has taken opponents treasure (+1)");
                } else {
                    System.out.println(monster);
                    System.out.println("* Won the fight");
                }


            } else if(fighter1 == fighter2) { // handles equal attack score
                System.out.println("The fight was a draw!");
            }
            System.out.println("\n-----------------end fight------------------");
        } else { //if either monster is dead
            System.out.println("Dead Monsters can't fight!");
        }

    }

    /** Calculates attack score, when fighting whichever monster has a higher score, wins.
     * @param ferocity
     * @param defence
     * @param magic
     * @return
     */
    public double generateAttackScore(int ferocity, int defence, int magic){
        double attackScore = (double) ((ferocity+defence+magic) / 3.0); // takes attributes and divides by 3
        return (Math.round(attackScore * 10.0) / 10.0);
    }

    /**
     * @return clan name
     */
    public String getClan() {
        return clan;
    }

    /** Monster needs to be alive to use method... Also note method is protected. Only Manticore structured
     * so that they can use method.
     * @param clan
     */
    protected void setClan(String clan) {
        if (aliveStatus) {
            this.clan = clan;
        } else {
            System.out.println("unable to change clan");
        }
    }

    /**
     * @return Ferocity
     */
    public int getFerocity() {
        return ferocity;
    }

    /** Set Ferocity
     * @param ferocity
     */
    public void setFerocity(int ferocity) {
        this.ferocity = ferocity;

    }

    /**
     * @return defense
     */
    public int getDefence() {
        return defence;
    }

    /** get defense
     * @param defence
     */
    public void setDefence(int defence) {
        this.defence = defence;
    }

    /**
     * @return magic
     */
    public int getMagic() {
        return magic;
    }

    /** set magic
     * @param magic
     */
    public void setMagic(int magic) {
        this.magic = magic;
    }

    /**
     * @return treasure
     */
    public int getTreasure() {
        return treasure;
    }

    /** set treasure. Note that treasure can not go below 0
     * @param treasure
     */
    public void setTreasure(int treasure) {
        this.treasure = treasure;
        if (this.treasure <= 0) {
            this.treasure = 0;
        }
    }

    /** get health rounded to 1 decimal place
     * @return
     */
    public double getHealth() {
        return Math.round(health * 10.0) / 10.0;
    }

    /** set health. Note health can not be negative. if 0 monster is dead
     * @param health
     */
    public void setHealth(double health) {
        this.health = health;
        if (this.health <=  0.0) {
            this.health = 0.0;
            aliveStatus = false;
            System.out.println("Dead");
        } else if (this.health > 0.0) {
            aliveStatus = true;

        }
    }

    /**
     * @return is monster alive
     */
    public boolean isAliveStatus() {
        return aliveStatus;
    }


}
