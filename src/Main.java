import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Roboter rob1 = new Roboter();
        Roboter rob2 = new Roboter();

        System.out.println("Roboter 1: " + "Atk: " + rob1.getAtk() + ", Hp: " + rob1.getHp()+ ", Crit Chance: " + rob1.getCritChance());
        System.out.println("Roboter 2: " + "Atk: " + rob2.getAtk() + ", Hp: " + rob2.getHp()+ ", Crit Chance: " + rob2.getCritChance() + "\n");
        rob1.attack(rob2, rob1);
        rob2.attack(rob1, rob2);



    }
}

class Roboter{
    private int atk;
    private int hp;
    private int critChance;
    private Random rando;


    public Roboter(){
        rando = new Random();

        this.atk = rando.nextInt(10) + 1;
        this.hp = rando.nextInt(101);
        this.critChance = rando.nextInt(101);
    }

    public int getAtk(){return atk;}

    public int getHp(){return hp;}

    public int getCritChance(){return critChance;}

    public void attack(Roboter enemy, Roboter attacker){
        rando = new Random();
        int critCheck = rando.nextInt(101);
        int damage = attacker.getAtk();
        if(critCheck <= attacker.getCritChance()){
            damage *= 2;
        }

        int newHp = enemy.getHp() - damage;
        enemy.takeDamage(newHp);
        System.out.println(attacker + " attacks and does: " + damage + " damage to " + enemy);

    }

    public void takeDamage(int hp){this.hp = hp;}





}