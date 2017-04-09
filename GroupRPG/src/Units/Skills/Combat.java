package Units.Skills;

public interface Combat {
        
    public int Attack(Combat Attacker, Combat Defender);
    
    public int Block(Combat Defender, Combat Attacker);
}
