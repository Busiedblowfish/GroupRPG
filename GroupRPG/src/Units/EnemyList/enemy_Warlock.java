//Enemy Warlock Unit
package Units.EnemyList;

import Units.Skills.Combat;
import Units.Skills.IntelligenceUnit;

public class enemy_Warlock extends IntelligenceUnit implements Combat {
    
    public String weapon = "Wand";
    
    public enemy_Warlock(){ super("Warlock"); }
    
    public String getWeapon(){ return weapon; }
    
    public void Lightning_Bolt(){
        System.out.printf("The enemy Warlock fires a Lightning Bolt.\nTarget is stunned for 1 turn.\nCosts Endurance\n");
    }
    
    public void Draining_Curse(){
        System.out.printf("The enemy Warlock casts a Draining Curses.\nTarget suffers 1 damage for 2 turns.\nCosts Spirit\n");
    }
    
//    @Override
//    public int Attack(int Defender_health, int Attacker_damage){
//        return Defender_health - Attacker_damage;
//    }

    @Override
    public int Attack(Combat Attacker, Combat Defender) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int Block(Combat Defender, Combat Attacker) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
