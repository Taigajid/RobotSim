import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Main {
    static boolean win;

    public static void main(String[] args) {
        Roboter rob1 = new Roboter("Robot 1");
        Roboter rob2 = new Roboter("Robot 2");
        win = false;

        System.out.println("Robot 1: " + "Atk: " + rob1.getAtk() + ", Hp: " + rob1.getHp()+ ", Crit Chance: " + rob1.getCritChance());
        System.out.println("Robot 2: " + "Atk: " + rob2.getAtk() + ", Hp: " + rob2.getHp()+ ", Crit Chance: " + rob2.getCritChance() + "\n");

        while(!win){
            checkWin(rob1, rob2);
            rob1.attack(rob2, rob1);
            System.out.println("Robot 2 now has " + rob2.getHp() + " HP" + "\n");
            checkWin(rob1, rob2);
            if(win){break;}
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {e.printStackTrace();}
            rob2.attack(rob1, rob2);
            System.out.println("Robot 1 now has " + rob1.getHp() + " HP" + "\n");
            checkWin(rob1, rob2);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {e.printStackTrace();}

        }




    }

    static void checkWin(Roboter rob1, Roboter rob2){
        if(rob1.getHp() <= 0){
            System.out.println("Robot 1 has 0 Hp left! Robot 2 wins! The battle ius now over!");
            win = true;
        }else if(rob2.getHp() <= 0){
            System.out.println("Robot 2 has 0 Hp left! Robot 1 wins! The battle ius now over!");
            win = true;
        }


    }
}

class Roboter{
    private final String name;
    private final int atk;
    private int hp;
    private final int critChance;
    private Random rando;


    public Roboter(String name){
        rando = new Random();
        this.name = name;
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
        if(critCheck < attacker.getCritChance()){
            damage *= 2;
        }

        int newHp = enemy.getHp() - damage;
        enemy.takeDamage(newHp);
        System.out.println(attacker.name + " attacks and does " + damage + " damage to " + enemy.name + "!");

    }

    public void takeDamage(int hp){this.hp = hp;}





}