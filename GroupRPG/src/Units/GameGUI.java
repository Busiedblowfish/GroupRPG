/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Units;
import java.awt.Color;
import java.awt.Font;
import java.awt.List;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Random;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

/**
 *
 * @author Lenovo
 */
public class GameGUI extends javax.swing.JFrame implements KeyListener {

    static int STORY = 0;           //keeps track of user progress
    static ArrayList<Statistics> UnitList = new ArrayList<Statistics>(1);   //List of all in game units
    static ArrayList<Statistics> TurnList = new ArrayList<Statistics>(1);
    static String[][] POSITION = new String [6][2];
    static int PLAYER_COUNT = 0;     //keeps track of how many player units are active
    static int ENEMY_COUNT = 0;
    static int BATTLE_LOCK = 0;
    static int CONSOLE_LOCK = 0;
    static int TURN = 0;
    static int LOOP = 1;
    static int SELECTED_PLAYER = -1;
    static int SELECTED_ENEMY = -1;
    
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frontApp().setVisible(true);
            }
        });
    }
    
    //Passed object's name and generates player unit
    public static void factoryPlayer(String name, String num){
        switch(name){
            case "Berserker":   UnitList.add(new Berserker());
                                break;
            case "Juggernaut":  UnitList.add(new Juggernaut());
                                break;
            case "Barbarian":   UnitList.add(new Barbarian());
                                break;
            case "Marksman":    UnitList.add(new Marksman());
                                break;
            case "Witch Doctor":UnitList.add(new WitchDoctor());
                                break;
            case "Psychic":     UnitList.add(new Psychic());
                                break;
        }
        
        POSITION[PLAYER_COUNT][0] = UnitList.get(PLAYER_COUNT).getName(); 
        POSITION[PLAYER_COUNT][1] = num;
        
        //Limit player group size to 3
        //Move story to chapter 2
        PLAYER_COUNT++;
        if(PLAYER_COUNT == 3){
            STORY = 2;
            System.out.printf("PLAYER_COUNT: %d\n", PLAYER_COUNT);
            for(int i = 0; i < UnitList.size(); i++){
                System.out.println(UnitList.get(i).getName());
            }
        }
    }
    
    //Generates enemy units
    public static void factoryEnemy(){
        int first = -1, second = -1;
        for(int i = 0; i < 3; i++){
            Random rand = new Random();
            int now = rand.nextInt(6) + 1;
            //Make sure 3 unique random numbers are chosen
            if(now != first && now != second){
                if(i == 0){
                    first = now;
                }
                if(i == 1){
                    second = now;
                }
                //Add units to unit list
                switch(now){
                    case 1:     UnitList.add(new enemy_Marauder());
                                break;
                    case 2:     UnitList.add(new enemy_Brute());
                                break;
                    case 3:     UnitList.add(new enemy_Rogue());
                                break;
                    case 4:     UnitList.add(new enemy_Assassin());
                                break;
                    case 5:     UnitList.add(new enemy_Summoner());
                                break;
                    case 6:     UnitList.add(new enemy_Warlock());
                                break;
                }
            }
            else{
                //force a new unique number to be generated
                while(now == first || now == second){
                    now = rand.nextInt(6) + 1;
                }
                if(i == 0){
                    first = now;
                }
                if(i == 1){
                    second = now;
                }
                //Generate Enemy unit
                switch(now){
                    case 1:     UnitList.add(new enemy_Marauder());
                                break;
                    case 2:     UnitList.add(new enemy_Brute());
                                break;
                    case 3:     UnitList.add(new enemy_Rogue());
                                break;
                    case 4:     UnitList.add(new enemy_Assassin());
                                break;
                    case 5:     UnitList.add(new enemy_Summoner());
                                break;
                    case 6:     UnitList.add(new enemy_Warlock());
                                break;
                }
            }
        }
        ENEMY_COUNT = 3;
        STORY = 3;
    }
    
    public GameGUI() {        
        initComponents();
        //This text area keeps track when user hits enter
        console1.addKeyListener(this);
        
        //Prevents user from changing text area content
        console1.setEditable(false);
        console2.setEditable(false);
        
        //Prevents user from changing button initial states
        btnPlayer1.setEnabled(false);
        btnPlayer2.setEnabled(false);
        btnPlayer3.setEnabled(false);
        btnPlayer4.setEnabled(false);
        btnPlayer5.setEnabled(false);
        btnPlayer6.setEnabled(false);
        btnEnemy1.setEnabled(false);
        btnEnemy1.setText("");
        btnEnemy2.setEnabled(false);
        btnEnemy2.setText("");
        btnEnemy3.setEnabled(false);
        btnEnemy3.setText("");
        btnEnemy4.setEnabled(false);
        btnEnemy4.setText("");
        btnEnemy5.setEnabled(false);
        btnEnemy5.setText("");
        btnEnemy6.setEnabled(false);
        btnEnemy6.setText("");

        console1.append("+=============+  New Game  +=============+\n");
        console1.append("It's a new day and a new opportunity to earn your fair share of coin...\n" 
                        + "Stepping outside the tavern,\n"
                        + "the warmth of the twins Sol and Solara illuminate Huntsman's Rest;\n"
                        + "the Empirium's westernmost outpost and civilizations end.\n"
                        + "The lawless badlands of the Maw, an endless harbor for wanted men,\n"
                        + "stretches beyond the city walls.\n"
                        + "You take a deep breath, filling your lungs with one last breath of the peaceful country air...\n"
                        + "Press <ENTER> to continue");
    }
    
    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
     public void keyPressed(KeyEvent e) {
        
        if(e.getKeyCode() == KeyEvent.VK_ENTER) {
            if(SELECTED_ENEMY == -1 && CONSOLE_LOCK == 1){
                CONSOLE_LOCK = 0;
            }
//            REMOVE ENEMY HEALTH
            if(CONSOLE_LOCK == 1 && SELECTED_ENEMY != -1){
                
                System.out.println("\nCONSOLE_LOCK\n");
                for(int i = 3; i < POSITION.length; i++){
                    //System.out.println("***");
                    String position = "" + SELECTED_ENEMY;
                    if(POSITION[i][1].equals(position)){
                        switch(position){
                            case "1":   btnEnemy1.setSelected(!btnEnemy1.isSelected());
                                        btnEnemy1.setEnabled(false);
                                        break;
                            case "2":   btnEnemy2.setSelected(!btnEnemy2.isSelected());
                                        btnEnemy2.setEnabled(false);
                                        break;
                            case "3":   btnEnemy3.setSelected(!btnEnemy3.isSelected());
                                        btnEnemy3.setEnabled(false);
                                        break;
                            case "4":   btnEnemy4.setSelected(!btnEnemy4.isSelected());
                                        btnEnemy4.setEnabled(false);
                                        break;
                            case "5":   btnEnemy5.setSelected(!btnEnemy5.isSelected());
                                        btnEnemy5.setEnabled(false);
                                        break;
                            case "6":   btnEnemy6.setSelected(!btnEnemy6.isSelected());
                                        btnEnemy6.setEnabled(false);
                                        break;
                        }
                        for(int enemy = 3; enemy < UnitList.size();enemy++){
                            if(UnitList.get(enemy).getName().equals(POSITION[i][0])){
                                int damage = UnitList.get(enemy).getArmor() - UnitList.get(SELECTED_PLAYER).getAttack_s();
                                if(damage > 0){
                                    damage = 0;
                                }
                                else{
                                    UnitList.get(enemy).setHealth(damage);
                                }
                                
                                console1.setText(UnitList.get(SELECTED_PLAYER).getName() + " attacks enemy " + UnitList.get(enemy).getName() + " with " + UnitList.get(SELECTED_PLAYER).getWeapon() + "\n");
                                console1.append(UnitList.get(enemy).getName() + " takes " + UnitList.get(SELECTED_PLAYER).getAttack_s() + " weapon damage!\n");
                                console1.append(UnitList.get(enemy).getName() + " defends with " + UnitList.get(SELECTED_PLAYER).getArmor() + "armor,\n");
                                console1.append(UnitList.get(enemy).getName() + " suffers " + damage + " damage\n");
                                console1.append(UnitList.get(enemy).getName() + " HEALTH = " + UnitList.get(enemy).getHealth() + "\n");
                                console1.append("Press <Enter> to continue...\n");
                                
                                if(UnitList.get(enemy).getHealth() <= 0){
                                    for(int n = 3; n < POSITION.length; n++){
                                        if(POSITION[n][0] == UnitList.get(enemy).getName()){
                                            Border thickBorder = new LineBorder(Color.BLACK, 1);
                                            switch(POSITION[i][1]){
                                                case "1":   btnEnemy1.setEnabled(false);
                                                            btnEnemy1.setBorder(thickBorder);
                                                            break;
                                                case "2":   btnEnemy2.setEnabled(false);
                                                            btnEnemy2.setBorder(thickBorder);
                                                            break;
                                                case "3":   btnEnemy3.setEnabled(false);
                                                            btnEnemy3.setBorder(thickBorder);
                                                            break;
                                                case "4":   btnEnemy4.setEnabled(false);
                                                            btnEnemy4.setBorder(thickBorder);
                                                            break;
                                                case "5":   btnEnemy5.setEnabled(false);
                                                            btnEnemy5.setBorder(thickBorder);
                                                            break;
                                                case "6":   btnEnemy6.setEnabled(false);
                                                            btnEnemy6.setBorder(thickBorder);
                                                            break;
                                            }                                        
                                        }
                                    }
                                    
                                    ENEMY_COUNT--;
                                    if(ENEMY_COUNT == 0){
                                        ENEMY_COUNT = 0; STORY = 7;
                                    }
                                }
                            }
                        }    
                    }
                }
                
                SELECTED_ENEMY = -1;
            }
            if(STORY < 1){
                STORY = 1;
            }
            if(STORY == 3){
                STORY = 4;
            }
        }
        
        /**** BATTLE LOOP ****/
        if(BATTLE_LOCK == 1 && CONSOLE_LOCK == 0){
            for(int i = 0; i < 6; i++){
                System.out.printf(POSITION[i][0] + " POSITION " + POSITION[i][1] + "\n");
            }
            System.out.printf("BATTLE_LOCK\n");
            if(TURN > TurnList.size() - 1){
                TURN = 0;
                LOOP++;
            }
            System.out.println("TURN " + TurnList.get(TURN).getName());
            /*********************/
            /**** PLAYER TURN ****/
            /*********************/
            if( TurnList.get(TURN).getName() == "Barbarian" 
                || TurnList.get(TURN).getName() == "Berserker" 
                || TurnList.get(TURN).getName() == "Juggernaut" 
                || TurnList.get(TURN).getName() == "Marksman" 
                || TurnList.get(TURN).getName() == "Psychic" 
                || TurnList.get(TURN).getName() == "Witch Doctor"){
                    
                int player;

                //Get index from UnitList by matching name of current object's turn
                for(player = 0; player < PLAYER_COUNT; player++){
                    if(UnitList.get(player).getName() == TurnList.get(TURN).getName()){
                        System.out.println("Players ALIVE " + PLAYER_COUNT);
                        break;
                    }
                }
                SELECTED_PLAYER = player;
                
                //Check if player is alive
                //DEAD
                if(UnitList.get(player).getHealth() <= 0){
                    
                    console1.setText(UnitList.get(player).getName() + " IS DEAD!\n"
                                    +"Press <Enter> to continue...");
                    
                    for(int i = 0; i < 3; i++){
                        if(POSITION[i][0] == UnitList.get(player).getName()){
                            Border thickBorder = new LineBorder(Color.BLACK, 1);
                            switch(POSITION[i][1]){
                                case "1":   btnPlayer1.setEnabled(false);
                                            btnPlayer1.setBorder(thickBorder);
                                            break;
                                            
                                case "2":   btnPlayer2.setEnabled(false);
                                            btnPlayer2.setBorder(thickBorder);
                                            break;
                                            
                                case "3":   btnPlayer3.setEnabled(false);
                                            btnPlayer3.setBorder(thickBorder);
                                            break;
                                case "4":   btnPlayer4.setEnabled(false);
                                            btnPlayer4.setBorder(thickBorder);
                                            break;
                                case "5":   btnPlayer5.setEnabled(false);
                                            btnPlayer5.setBorder(thickBorder);
                                            break;
                                case "6":   btnPlayer6.setEnabled(false);
                                            btnPlayer6.setBorder(thickBorder);
                                            break;
                            }
                        }
                    }
                }
                else if(UnitList.get(player).getHealth() > 0){      //ALIVE
                    
                    console1.setText( "ROUND" + LOOP + ", TURN " + UnitList.get(player).getName() + "\n"
                                    + "HEALTH:    " + UnitList.get(player).getHealth() + "\n"
                                    + "ENDURANCE: " + UnitList.get(player).getEndurance() + "\n"
                                    + "SPIRIT:    " + UnitList.get(player).getSpirit() + "\n"
                                    + "Select enemy and press <Enter> to continue...");
                    
                        //Set living enemy buttons to active
                        Border selectBorder = new LineBorder(Color.YELLOW, 3);
                        for(int n = 3; n < POSITION.length; n++){
                            switch(POSITION[n][1]){
                                case "1": btnEnemy1.setBorder(selectBorder);
                                          btnEnemy1.setEnabled(true);
                                          break;
                                case "2": btnEnemy2.setBorder(selectBorder);
                                          btnEnemy2.setEnabled(true);
                                          break;
                                case "3": btnEnemy3.setBorder(selectBorder);
                                          btnEnemy3.setEnabled(true);
                                          break;
                                case "4": btnEnemy4.setBorder(selectBorder);
                                          btnEnemy4.setEnabled(true);
                                          break;
                                case "5": btnEnemy5.setBorder(selectBorder);
                                          btnEnemy5.setEnabled(true);
                                          break;
                                case "6": btnEnemy6.setBorder(selectBorder);
                                          btnEnemy6.setEnabled(true);
                                          break;
                            }
                        }
                        
                    Border playerBorder = new LineBorder(Color.GREEN, 3);
                    for(int i = 0; i < 3 ; i++){
                        for(int n = 0; n < PLAYER_COUNT; n++){
                            if(POSITION[i][0] == UnitList.get(n).getName() && UnitList.get(n).getHealth() > 0){
                                switch(POSITION[i][1]){
                                    case "1": btnPlayer1.setBorder(playerBorder);
                                              break;
                                    case "2": btnPlayer2.setBorder(playerBorder);
                                              break;
                                    case "3": btnPlayer3.setBorder(playerBorder);
                                              break;
                                    case "4": btnPlayer4.setBorder(playerBorder);
                                              break;
                                    case "5": btnPlayer5.setBorder(playerBorder);
                                              break;
                                    case "6": btnPlayer6.setBorder(playerBorder);
                                              break; 
                                }
                            }
                            else if(UnitList.get(player).getHealth() <= 0){
                                Border deathBorder = new LineBorder(Color.BLACK, 1);
                                switch(POSITION[n][1]){
                                    case "1": btnPlayer1.setBorder(deathBorder);
                                              break;
                                    case "2": btnPlayer2.setBorder(deathBorder);
                                              break;
                                    case "3": btnPlayer3.setBorder(deathBorder);
                                              break;
                                    case "4": btnPlayer4.setBorder(deathBorder);
                                              break;
                                    case "5": btnPlayer5.setBorder(deathBorder);
                                              break;
                                    case "6": btnPlayer6.setBorder(deathBorder);
                                              break; 
                                }
                            }
                            }
                        }
                        
                        //Designate current unit's turn with BLUE border
                        Border thickBorder = new LineBorder(Color.BLUE, 5);
                        for(int i = 0; i < 3; i++){
                            if(POSITION[i][0] == UnitList.get(player).getName()){
                                switch(POSITION[i][1]){
                                    case "1": btnPlayer1.setBorder(thickBorder);
                                              break;
                                    case "2": btnPlayer2.setBorder(thickBorder);
                                              break;
                                    case "3": btnPlayer3.setBorder(thickBorder);
                                              break;
                                    case "4": btnPlayer4.setBorder(thickBorder);
                                              break;
                                    case "5": btnPlayer5.setBorder(thickBorder);
                                              break;
                                    case "6": btnPlayer6.setBorder(thickBorder);
                                              break;                  
                                }
                            }
                        }
                        
                    }
                }
            else{
                //Enemy turn, disable buttons
                btnEnemy1.setEnabled(false);
                btnEnemy2.setEnabled(false);
                btnEnemy3.setEnabled(false);
                btnEnemy4.setEnabled(false);
                btnEnemy5.setEnabled(false);
                btnEnemy6.setEnabled(false);
                    
                Border enemyBorder = new LineBorder(Color.RED, 3);
                for(int p = 3; p < POSITION.length; p++){
                    switch(POSITION[p][1]){
                            case "1":   btnEnemy1.setBorder(enemyBorder);
                                        break;
                            case "2":   btnEnemy2.setBorder(enemyBorder);
                                        break;
                            case "3":   btnEnemy3.setBorder(enemyBorder);
                                        break;
                            case "4":   btnEnemy4.setBorder(enemyBorder);
                                        break;
                            case "5":   btnEnemy5.setBorder(enemyBorder);
                                        break;
                            case "6":   btnEnemy6.setBorder(enemyBorder);
                                        break;
                        }
                    }
                    
                    Border turnBorder = new LineBorder(Color.BLUE, 5);
                    for(int j = 3; j < POSITION.length; j++){
                        if(POSITION[j][0] == TurnList.get(TURN).getName()){
                            switch(POSITION[j][1]){
                                case "1": btnEnemy1.setBorder(turnBorder);
                                          break;
                                case "2": btnEnemy2.setBorder(turnBorder);
                                          break;
                                case "3": btnEnemy3.setBorder(turnBorder);
                                          break;
                                case "4": btnEnemy4.setBorder(turnBorder);
                                          break;
                                case "5": btnEnemy5.setBorder(turnBorder);
                                          break;
                                case "6": btnEnemy6.setBorder(turnBorder);
                                          break;
                        }   
                    }

                    //Reset LIVING Player Buttons
                    Border playerBorder = new LineBorder(Color.GREEN, 3);
                    for(int i = 0; i < 3 ; i++){
                        for(int n = 0; n < PLAYER_COUNT; n++){
                                if(POSITION[i][0] == UnitList.get(n).getName() && UnitList.get(n).getHealth() > 0){
                                    switch(POSITION[i][1]){
                                        case "1": btnPlayer1.setBorder(playerBorder);
                                                  break;
                                        case "2": btnPlayer2.setBorder(playerBorder);
                                                  break;
                                        case "3": btnPlayer3.setBorder(playerBorder);
                                                  break;
                                        case "4": btnPlayer4.setBorder(playerBorder);
                                                  break;
                                        case "5": btnPlayer5.setBorder(playerBorder);
                                                  break;
                                        case "6": btnPlayer6.setBorder(playerBorder);
                                                  break; 
                                    }
                                }
                            }
                        }
                    }
                    
                    //Randomly select Player
                    Random rand = new Random();
                    int target = rand.nextInt(3);
                    for(int i = 0; i < 3; i++){
                        if(POSITION[i][0] == UnitList.get(target).getName() && UnitList.get(target).getHealth() > 0){
                            Border thickBorder = new LineBorder(Color.YELLOW, 5);
                            switch(POSITION[i][1]){
                                case "1": btnPlayer1.setBorder(thickBorder);
                                          break;
                                case "2": btnPlayer2.setBorder(thickBorder);
                                          break;
                                case "3": btnPlayer3.setBorder(thickBorder);
                                          break;
                                case "4": btnPlayer4.setBorder(thickBorder);
                                          break;
                                case "5": btnPlayer5.setBorder(thickBorder);
                                          break;
                                case "6": btnPlayer6.setBorder(thickBorder);
                                          break;
                            }
                        }
                        else{
                            int first = target;
                            while(UnitList.get(target).getHealth() <= 0){
                                target = rand.nextInt(3);
                                if(target == first){
                                    target = rand.nextInt(3);
                                }
                            }
                            for(int n = 0; n < 3; n++){
                                if(POSITION[i][0] == UnitList.get(target).getName() && UnitList.get(target).getHealth() > 0){
                                    Border thickBorder = new LineBorder(Color.YELLOW, 5);
                                    switch(POSITION[i][1]){
                                        case "1":   btnPlayer1.setBorder(thickBorder);
                                                    break;
                                        case "2":   btnPlayer2.setBorder(thickBorder);
                                                    break;
                                        case "3":   btnPlayer3.setBorder(thickBorder);
                                                    break;
                                        case "4":   btnPlayer4.setBorder(thickBorder);
                                                    break;
                                        case "5":   btnPlayer5.setBorder(thickBorder);
                                                    break;
                                        case "6":   btnPlayer6.setBorder(thickBorder);
                                                    break;
                                        }
                                }
                            }
                        }
                    }
                    int damage = UnitList.get(target).getArmor() - TurnList.get(TURN).getAttack_s();
                    if(damage > 0){
                        damage = 0;
                    }
                    else{
                        UnitList.get(target).setHealth(damage);
                    }
                    
                    console1.setText("Enemy " + TurnList.get(TURN).getName()+ " attacks " + UnitList.get(target).getName() + " with " + TurnList.get(TURN).getWeapon() + ",\n"); 
                    console1.append(UnitList.get(target).getName() + " takes " + TurnList.get(TURN).getAttack_s() + " weapon damage!\n");
                    console1.append(UnitList.get(target).getName() + " defends with " + UnitList.get(target).getArmor() + " armor,\n");
                    console1.append(UnitList.get(target).getName() + " suffers " + damage + " damage!\n");
                    console1.append(UnitList.get(target).getName() + " HEALTH = " + UnitList.get(target).getHealth()+ "\n");
                    
                    if(UnitList.get(target).getHealth() <= 0){
                        for(int i = 0; i < 3; i++){
                            if(POSITION[i][0] == UnitList.get(target).getName()){
                                Border thickBorder = new LineBorder(Color.BLACK, 1);
                                switch(POSITION[i][1]){
                                    case "1":   btnPlayer1.setEnabled(false);
                                                btnPlayer1.setBorder(thickBorder);
                                                break;
                                    case "2":   btnPlayer2.setEnabled(false);
                                                btnPlayer2.setBorder(thickBorder);
                                                break;
                                    case "3":   btnPlayer3.setEnabled(false);
                                                btnPlayer3.setBorder(thickBorder);
                                                break;
                                    case "4":   btnPlayer4.setEnabled(false);
                                                btnPlayer4.setBorder(thickBorder);
                                                break;
                                    case "5":   btnPlayer5.setEnabled(false);
                                                btnPlayer5.setBorder(thickBorder);
                                                break;
                                    case "6":   btnPlayer6.setEnabled(false);
                                                btnPlayer6.setBorder(thickBorder);
                                                break;
                                }
                            }
                        }

                        PLAYER_COUNT--;
                        if(PLAYER_COUNT == 0){
                            BATTLE_LOCK = 0; STORY = 6;
                        }
                    }
                }
            TURN++;
        }
        //WIN OR LOSE CONDITION
        
        /*
            Launch a jOptionPane on win/lose
            Dispose gameGUI frame
            Enable the New Game button
            Reset the STORY variable to 0
            Start a new game or exit
        */
        if(STORY == 7){
            console1.setText("PLAYER WON");
            console2.setText("PLAYER WON");
            
            //Display the result and offer available options
            combatOutcome();
        }
        if(STORY == 6){
            console1.setText("ENEMY WON");
            console2.setText("ENEMY WON");
            
            //Display the result and offer available options
            combatOutcome();

        }
        /**** BATTLE LOOP ****/
        
        if(STORY == 1){
            console1.setText("");
            console1.append("A mercenary by trade, you lead a small cadre of men.\n"
                            + "Before embarking to fulfill the next contract,\n"
                            + "you select three companions.\n"
                            + "Choose 3 characters and Press <ENTER> to continue...");
            
            //Allow player to interact with buttons and choose characters
            btnPlayer1.setEnabled(true);
            btnPlayer2.setEnabled(true);
            btnPlayer3.setEnabled(true);
            btnPlayer4.setEnabled(true);
            btnPlayer5.setEnabled(true);
            btnPlayer6.setEnabled(true);

            //Indicate buttons are focus
            Border thickBorder = new LineBorder(Color.YELLOW, 3);
            btnPlayer1.setBorder(thickBorder);
            btnPlayer2.setBorder(thickBorder);
            btnPlayer3.setBorder(thickBorder);
            btnPlayer4.setBorder(thickBorder);
            btnPlayer5.setBorder(thickBorder);
            btnPlayer6.setBorder(thickBorder);
        }
        if(STORY == 2){
            Border thickBorder = new LineBorder(Color.BLACK, 1);
            
            /**** BUTTON 1 ****/
            if(!btnPlayer1.isSelected()){
                //Disable button 1
                btnPlayer1.setEnabled(false);
                btnPlayer1.setBorder(thickBorder);

            }
            else{
                //Enable button 1
                btnPlayer1.setSelected(!btnPlayer1.isSelected());

            }
            /**** BUTTON 1 ****/
            
            /**** BUTTON 2 ****/
            if(!btnPlayer2.isSelected()){
                //Disable button 2
                btnPlayer2.setEnabled(false);
                btnPlayer2.setBorder(thickBorder);
            }
            else{
                //Enable button 2
                btnPlayer2.setSelected(!btnPlayer2.isSelected());
            }
            /**** BUTTON 2 ****/

            /**** BUTTON 3 ****/
            if(!btnPlayer3.isSelected()){
                //Disable button 3
                btnPlayer3.setEnabled(false);
                btnPlayer3.setBorder(thickBorder);
            }
            else{
                //Enable button 3
                btnPlayer3.setSelected(!btnPlayer3.isSelected());
            }
            /**** BUTTON 3 ****/
            
            /**** BUTTON 4 ****/
            if(!btnPlayer4.isSelected()){
                //Disable button 4
                btnPlayer4.setEnabled(false);
                btnPlayer4.setBorder(thickBorder);
            }
            else{
                //Enable button 4
                btnPlayer4.setSelected(!btnPlayer4.isSelected());
            }
            /**** BUTTON 4 ****/
            
            /**** BUTTON 5 ****/
            if(!btnPlayer5.isSelected()){
                //Disable button 5
                btnPlayer5.setEnabled(false);
                btnPlayer5.setBorder(thickBorder);

            }
            else{
                //Enable button 5
                btnPlayer5.setSelected(!btnPlayer5.isSelected());
            }
            /**** BUTTON 5 ****/
                       
            /**** BUTTON 6 ****/
            if(!btnPlayer6.isSelected()){
                //Disable button 6
                btnPlayer6.setEnabled(false);
                btnPlayer6.setBorder(thickBorder);

            }
            else{
                //Enable button 6
                btnPlayer6.setSelected(!btnPlayer6.isSelected());
            }
            /**** BUTTON 6 ****/
            
            //Print members of user selected group
            console1.setText("WARRIORS SELECTED\n");
            for(int i = 0; i < PLAYER_COUNT; i++){
                console1.append(UnitList.get(i).getName() + "\n");
            }
            console1.append("Your group steps through the city gate...\n"
                            + "Press <ENTER> to continue...");

            factoryEnemy();
        }
        if(STORY == 3){
            //Randomly place enemies into game field
            console2.setText("ENEMIES\n");
                Border thickBorder = new LineBorder(Color.RED, 3);
                int first = -1, second = -1;
                for(int i = 3; i < 6; i++){
                    Random rand = new Random();
                    int now = rand.nextInt(6) + 1;
                    if(now != first && now != second){
                        if(i == 3){
                            first = now;
                        }
                        if(i == 4){
                            second = now;
                        }
                        
                        POSITION[i][0] = UnitList.get(i).getName(); 
                        POSITION[i][1] = "" + now;
                        
                        switch(now){
                            case 1: btnEnemy1.setBorder(thickBorder);
                                    btnEnemy1.setText(UnitList.get(i).getName());
                                    btnEnemy1.setBackground(Color.GRAY);
                                    break;
                            case 2: btnEnemy2.setBorder(thickBorder);
                                    btnEnemy2.setText(UnitList.get(i).getName());
                                    btnEnemy2.setBackground(Color.GRAY);
                                    break;
                            case 3: btnEnemy3.setBorder(thickBorder);
                                    btnEnemy3.setText(UnitList.get(i).getName());
                                    btnEnemy3.setBackground(Color.GRAY);
                                    break;
                            case 4: btnEnemy4.setBorder(thickBorder);
                                    btnEnemy4.setText(UnitList.get(i).getName());
                                    btnEnemy4.setBackground(Color.GRAY);
                                    break;
                            case 5: btnEnemy5.setBorder(thickBorder);
                                    btnEnemy5.setText(UnitList.get(i).getName());
                                    btnEnemy5.setBackground(Color.GRAY);
                                    break;
                            case 6: btnEnemy6.setBorder(thickBorder);
                                    btnEnemy6.setText(UnitList.get(i).getName());
                                    btnEnemy6.setBackground(Color.GRAY);
                                    break;
                        }
                    }
                    else{
                        while(now == first || now == second){
                            now = rand.nextInt(6) + 1;
                        }
                        if(i == 3){
                            first = now;
                        }
                        if(i == 4){
                            second = now;
                        }
                        
                        POSITION[i][0] = UnitList.get(i).getName(); 
                        POSITION[i][1] = "" + now;
                        
                        switch(now){
                            case 1: btnEnemy1.setBorder(thickBorder);
                                    btnEnemy1.setText(UnitList.get(i).getName());
                                    btnEnemy1.setBackground(Color.GRAY);
                                    break;
                            case 2: btnEnemy2.setBorder(thickBorder);
                                    btnEnemy2.setText(UnitList.get(i).getName());
                                    btnEnemy2.setBackground(Color.GRAY);
                                    break;
                            case 3: btnEnemy3.setBorder(thickBorder);
                                    btnEnemy3.setText(UnitList.get(i).getName());
                                    btnEnemy3.setBackground(Color.GRAY);
                                    break;
                            case 4: btnEnemy4.setBorder(thickBorder);
                                    btnEnemy4.setText(UnitList.get(i).getName());
                                    btnEnemy4.setBackground(Color.GRAY);
                                    break;
                            case 5: btnEnemy5.setBorder(thickBorder);
                                    btnEnemy5.setText(UnitList.get(i).getName());
                                    btnEnemy5.setBackground(Color.GRAY);
                                    break;
                            case 6: btnEnemy6.setBorder(thickBorder);
                                    btnEnemy6.setText(UnitList.get(i).getName());
                                    btnEnemy6.setBackground(Color.GRAY);
                                    break;
                        }
                    }
                console2.append(UnitList.get(i).getName() + "\n");
            }
        }
        if(STORY == 4){
            System.out.println("");
            console1.setText("BATTLE\nPress <ENTER> to continue...");
            
            BATTLE_LOCK = 1;
            
            TurnList = new ArrayList<Statistics>(UnitList.size());
            for(int index = 0; index < UnitList.size(); index++){
                switch(UnitList.get(index).getName()){
                    case "Berserker":   TurnList.add(new Berserker());
                                        break;
                    case "Juggernaut":  TurnList.add(new Juggernaut());
                                        break;
                    case "Barbarian":   TurnList.add(new Barbarian());
                                        break;
                    case "Marksman":    TurnList.add(new Marksman());
                                        break;
                    case "Witch Doctor":TurnList.add(new WitchDoctor());
                                        break;
                    case "Psychic":     TurnList.add(new Psychic());
                                        break;
                    case "Marauder":    TurnList.add(new enemy_Marauder());
                                        break;
                    case "Brute":       TurnList.add(new enemy_Brute());
                                        break;
                    case "Rogue":       TurnList.add(new enemy_Rogue());
                                        break;
                    case "Assassin":    TurnList.add(new enemy_Assassin());
                                        break;
                    case "Summoner":    TurnList.add(new enemy_Summoner());
                                        break;
                    case "Warlock":     TurnList.add(new enemy_Warlock());
                                        break;
                }
            }
            
            for(int i = 0; i < TurnList.size(); i++){
                if(i < TurnList.size() - 1){
                    for(int n = i + 1; n < TurnList.size(); n++)
                    if(TurnList.get(i).getSpeed() < TurnList.get(n).getSpeed()){
                        Statistics slower = TurnList.get(i), faster = TurnList.get(n);
                        TurnList.set(i, faster);
                        TurnList.set(n, slower);
                    }
                }
            }
            
            for(int i = 0; i< TurnList.size(); i++){
                System.out.println(TurnList.get(i).getName() + " " + TurnList.get(i).getSpeed());
            }
            STORY = 5;
        }
    }
    
    /**
     * Displays a jOptionPane based on the outcome of the combat
     */
    public void combatOutcome()
    {
	//Create objects of possible outcome
	Object[] option = {"Yes, please", "No way!"};
	String title = null;
        ImageIcon icon = null;
        int input;
        String msg = "Would you like to play again?";
        JLabel question = new JLabel(msg);     
       
	if(STORY == 6)
        {
            title = "Enemy Won!";
            
            try
            {
                icon = new javax.swing.ImageIcon(getClass().getResource("/pics/lost.png"));
            }// NOI18N
            catch(NullPointerException ex)
            {
                String message = ex.getMessage();
                System.out.println(message);
                System.out.println("Image file is missing!");
            }
                              
        }
		
	if(STORY == 7)
        {
            title = "Player Won!";            
            try
            {
                icon = new javax.swing.ImageIcon(getClass().getResource("/pics/won.png"));
            }// NOI18N
            catch(NullPointerException ex)
            {
                String message = ex.getMessage();
                System.out.println(message);
                System.out.println("Image file is missing!");
            }        
        }
        
        
        question.setVerticalTextPosition(SwingConstants.BOTTOM);
        question.setHorizontalTextPosition(SwingConstants.CENTER);
        
        input = JOptionPane.showOptionDialog(
        null, 
        question,
        title, 
        JOptionPane.YES_NO_OPTION, 
        JOptionPane.QUESTION_MESSAGE, 
        icon,
        option, 
        option[0]);
        

        if(input == 0)
        {
            //close the GameView
            this.dispose();

            //relaunch the viewCharacters
            new viewCharacters().setVisible(true);

            //reset the STORY
            STORY = 0;
            UnitList.clear();
            TurnList.clear();
           // POSITION = new String [6][2];
            PLAYER_COUNT = 0;
            ENEMY_COUNT = 0;
            BATTLE_LOCK = 0;
            CONSOLE_LOCK = 0;
            TURN = 0;
            LOOP = 1;
            SELECTED_PLAYER = -1;
            SELECTED_ENEMY = -1;                    
            
        }
        else
        {
            System.exit(0);
        }
    }
     
   
    @Override
    public void keyReleased(KeyEvent e) {}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Player1 = new javax.swing.JPanel();
        btnPlayer1 = new javax.swing.JToggleButton();
        player4 = new javax.swing.JPanel();
        btnPlayer4 = new javax.swing.JToggleButton();
        enemy1 = new javax.swing.JPanel();
        btnEnemy1 = new javax.swing.JToggleButton();
        enemy4 = new javax.swing.JPanel();
        btnEnemy2 = new javax.swing.JToggleButton();
        Player2 = new javax.swing.JPanel();
        btnPlayer2 = new javax.swing.JToggleButton();
        Player3 = new javax.swing.JPanel();
        btnPlayer3 = new javax.swing.JToggleButton();
        player5 = new javax.swing.JPanel();
        btnPlayer5 = new javax.swing.JToggleButton();
        enemy2 = new javax.swing.JPanel();
        btnEnemy3 = new javax.swing.JToggleButton();
        enemy5 = new javax.swing.JPanel();
        btnEnemy4 = new javax.swing.JToggleButton();
        player6 = new javax.swing.JPanel();
        btnPlayer6 = new javax.swing.JToggleButton();
        enemy3 = new javax.swing.JPanel();
        btnEnemy5 = new javax.swing.JToggleButton();
        enemy6 = new javax.swing.JPanel();
        btnEnemy6 = new javax.swing.JToggleButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        console2 = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        console1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("League of Warriors: Combat");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Player1.setBackground(new java.awt.Color(0, 153, 255));

        btnPlayer1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/berserker.png"))); // NOI18N
        btnPlayer1.setText("Berserker");
        btnPlayer1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlayer1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Player1Layout = new javax.swing.GroupLayout(Player1);
        Player1.setLayout(Player1Layout);
        Player1Layout.setHorizontalGroup(
            Player1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnPlayer1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, Short.MAX_VALUE)
        );
        Player1Layout.setVerticalGroup(
            Player1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnPlayer1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, Short.MAX_VALUE)
        );

        getContentPane().add(Player1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 176));

        player4.setBackground(new java.awt.Color(255, 51, 102));

        btnPlayer4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/juggernaut.png"))); // NOI18N
        btnPlayer4.setText("Juggernaut");
        btnPlayer4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlayer4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout player4Layout = new javax.swing.GroupLayout(player4);
        player4.setLayout(player4Layout);
        player4Layout.setHorizontalGroup(
            player4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnPlayer4, javax.swing.GroupLayout.PREFERRED_SIZE, 250, Short.MAX_VALUE)
        );
        player4Layout.setVerticalGroup(
            player4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnPlayer4, javax.swing.GroupLayout.PREFERRED_SIZE, 176, Short.MAX_VALUE)
        );

        getContentPane().add(player4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 0, -1, -1));

        enemy1.setBackground(new java.awt.Color(51, 0, 255));

        btnEnemy1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/psycic.png"))); // NOI18N
        btnEnemy1.setText("Marauder");
        btnEnemy1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnemy1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout enemy1Layout = new javax.swing.GroupLayout(enemy1);
        enemy1.setLayout(enemy1Layout);
        enemy1Layout.setHorizontalGroup(
            enemy1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnEnemy1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, Short.MAX_VALUE)
        );
        enemy1Layout.setVerticalGroup(
            enemy1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnEnemy1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, Short.MAX_VALUE)
        );

        getContentPane().add(enemy1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 0, -1, -1));

        enemy4.setBackground(new java.awt.Color(51, 153, 0));

        btnEnemy2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/psycic.png"))); // NOI18N
        btnEnemy2.setText("Brute");
        btnEnemy2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnemy2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout enemy4Layout = new javax.swing.GroupLayout(enemy4);
        enemy4.setLayout(enemy4Layout);
        enemy4Layout.setHorizontalGroup(
            enemy4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnEnemy2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, Short.MAX_VALUE)
        );
        enemy4Layout.setVerticalGroup(
            enemy4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnEnemy2, javax.swing.GroupLayout.PREFERRED_SIZE, 176, Short.MAX_VALUE)
        );

        getContentPane().add(enemy4, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 0, -1, -1));

        Player2.setBackground(new java.awt.Color(51, 0, 255));

        btnPlayer2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/barbarian.png"))); // NOI18N
        btnPlayer2.setText("Summoner");
        btnPlayer2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlayer2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Player2Layout = new javax.swing.GroupLayout(Player2);
        Player2.setLayout(Player2Layout);
        Player2Layout.setHorizontalGroup(
            Player2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnPlayer2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, Short.MAX_VALUE)
        );
        Player2Layout.setVerticalGroup(
            Player2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnPlayer2, javax.swing.GroupLayout.PREFERRED_SIZE, 176, Short.MAX_VALUE)
        );

        getContentPane().add(Player2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 177, -1, -1));

        Player3.setBackground(new java.awt.Color(255, 102, 204));

        btnPlayer3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/witch_doc.png"))); // NOI18N
        btnPlayer3.setText("Witch Doctor");
        btnPlayer3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlayer3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Player3Layout = new javax.swing.GroupLayout(Player3);
        Player3.setLayout(Player3Layout);
        Player3Layout.setHorizontalGroup(
            Player3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnPlayer3, javax.swing.GroupLayout.PREFERRED_SIZE, 250, Short.MAX_VALUE)
        );
        Player3Layout.setVerticalGroup(
            Player3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnPlayer3, javax.swing.GroupLayout.PREFERRED_SIZE, 176, Short.MAX_VALUE)
        );

        getContentPane().add(Player3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 354, -1, -1));

        player5.setBackground(new java.awt.Color(102, 102, 255));

        btnPlayer5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/marksman.png"))); // NOI18N
        btnPlayer5.setText("Marksman");
        btnPlayer5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlayer5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout player5Layout = new javax.swing.GroupLayout(player5);
        player5.setLayout(player5Layout);
        player5Layout.setHorizontalGroup(
            player5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnPlayer5, javax.swing.GroupLayout.PREFERRED_SIZE, 250, Short.MAX_VALUE)
        );
        player5Layout.setVerticalGroup(
            player5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnPlayer5, javax.swing.GroupLayout.PREFERRED_SIZE, 176, Short.MAX_VALUE)
        );

        getContentPane().add(player5, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 177, -1, -1));

        enemy2.setBackground(new java.awt.Color(102, 0, 102));

        btnEnemy3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/psycic.png"))); // NOI18N
        btnEnemy3.setText("Rogue");
        btnEnemy3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnemy3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout enemy2Layout = new javax.swing.GroupLayout(enemy2);
        enemy2.setLayout(enemy2Layout);
        enemy2Layout.setHorizontalGroup(
            enemy2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnEnemy3, javax.swing.GroupLayout.PREFERRED_SIZE, 250, Short.MAX_VALUE)
        );
        enemy2Layout.setVerticalGroup(
            enemy2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnEnemy3, javax.swing.GroupLayout.PREFERRED_SIZE, 176, Short.MAX_VALUE)
        );

        getContentPane().add(enemy2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 177, -1, -1));

        enemy5.setBackground(new java.awt.Color(0, 102, 102));
        enemy5.setPreferredSize(new java.awt.Dimension(250, 176));

        btnEnemy4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/psycic.png"))); // NOI18N
        btnEnemy4.setText("Assassin");
        btnEnemy4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnemy4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout enemy5Layout = new javax.swing.GroupLayout(enemy5);
        enemy5.setLayout(enemy5Layout);
        enemy5Layout.setHorizontalGroup(
            enemy5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnEnemy4, javax.swing.GroupLayout.PREFERRED_SIZE, 250, Short.MAX_VALUE)
        );
        enemy5Layout.setVerticalGroup(
            enemy5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnEnemy4, javax.swing.GroupLayout.PREFERRED_SIZE, 176, Short.MAX_VALUE)
        );

        getContentPane().add(enemy5, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 177, -1, -1));

        player6.setBackground(new java.awt.Color(51, 0, 255));

        btnPlayer6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/psycic.png"))); // NOI18N
        btnPlayer6.setText("Psychic");
        btnPlayer6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlayer6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout player6Layout = new javax.swing.GroupLayout(player6);
        player6.setLayout(player6Layout);
        player6Layout.setHorizontalGroup(
            player6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnPlayer6, javax.swing.GroupLayout.PREFERRED_SIZE, 250, Short.MAX_VALUE)
        );
        player6Layout.setVerticalGroup(
            player6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnPlayer6, javax.swing.GroupLayout.PREFERRED_SIZE, 176, Short.MAX_VALUE)
        );

        getContentPane().add(player6, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 354, -1, -1));

        enemy3.setBackground(new java.awt.Color(153, 51, 0));

        btnEnemy5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/psycic.png"))); // NOI18N
        btnEnemy5.setText("Summoner");
        btnEnemy5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnemy5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout enemy3Layout = new javax.swing.GroupLayout(enemy3);
        enemy3.setLayout(enemy3Layout);
        enemy3Layout.setHorizontalGroup(
            enemy3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnEnemy5, javax.swing.GroupLayout.PREFERRED_SIZE, 250, Short.MAX_VALUE)
        );
        enemy3Layout.setVerticalGroup(
            enemy3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnEnemy5, javax.swing.GroupLayout.PREFERRED_SIZE, 176, Short.MAX_VALUE)
        );

        getContentPane().add(enemy3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 354, -1, -1));

        enemy6.setBackground(new java.awt.Color(0, 255, 102));

        btnEnemy6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/psycic.png"))); // NOI18N
        btnEnemy6.setText("Warlock");
        btnEnemy6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnemy6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout enemy6Layout = new javax.swing.GroupLayout(enemy6);
        enemy6.setLayout(enemy6Layout);
        enemy6Layout.setHorizontalGroup(
            enemy6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnEnemy6, javax.swing.GroupLayout.PREFERRED_SIZE, 250, Short.MAX_VALUE)
        );
        enemy6Layout.setVerticalGroup(
            enemy6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnEnemy6, javax.swing.GroupLayout.PREFERRED_SIZE, 176, Short.MAX_VALUE)
        );

        getContentPane().add(enemy6, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 354, 250, -1));

        console2.setColumns(20);
        console2.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        console2.setRows(5);
        jScrollPane2.setViewportView(console2);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 530, 500, 180));

        console1.setColumns(20);
        console1.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        console1.setRows(5);
        jScrollPane1.setViewportView(console1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 530, 500, 180));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPlayer1ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        if(STORY == 1 && btnPlayer1.isSelected()){
            Border thickBorder = new LineBorder(Color.GREEN, 3);
            btnPlayer1.setBorder(thickBorder);
            Berserker berserker = new Berserker();
            factoryPlayer(berserker.getName(),"1");
            console2.setText("");
            console2.append(berserker.getCombineStat());
        }
        else if(STORY == 1 && !(btnPlayer1.isSelected())){
            Border thickBorder = new LineBorder(Color.YELLOW, 3);
            btnPlayer1.setBorder(thickBorder);
        }
    }

    private void btnPlayer4ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        if(STORY == 1 && btnPlayer4.isSelected()){
            Border thickBorder = new LineBorder(Color.GREEN, 3);
            btnPlayer4.setBorder(thickBorder);
            Statistics juggernaut = new Juggernaut();
            factoryPlayer(juggernaut.getName(),"4");
            console2.setText("");
            console2.append(juggernaut.getCombineStat());
        }
        else if(STORY == 1 && !(btnPlayer4.isSelected())){
            //Delete Unit from list
            Border thickBorder = new LineBorder(Color.YELLOW, 3);
            btnPlayer4.setBorder(thickBorder);
        }
    } 

    private void btnPlayer2ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        if(STORY == 1 && btnPlayer2.isSelected()){
            Border thickBorder = new LineBorder(Color.GREEN, 3);
            btnPlayer2.setBorder(thickBorder);
            Statistics barbarian = new Barbarian();
            factoryPlayer(barbarian.getName(),"2");
            console2.setText("");
            console2.append(barbarian.getCombineStat());
        }
        else if(STORY == 1 && !(btnPlayer2.isSelected())){
            //Delete Unit from list
            Border thickBorder = new LineBorder(Color.YELLOW, 3);
            btnPlayer2.setBorder(thickBorder);
        }
    } 

    private void btnPlayer3ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        if(STORY == 1 && btnPlayer3.isSelected()){
            Border thickBorder = new LineBorder(Color.GREEN, 3);
            btnPlayer3.setBorder(thickBorder);
            Statistics witchdr = new WitchDoctor();
            factoryPlayer(witchdr.getName(),"3");
            console2.setText("");
            console2.append(witchdr.getCombineStat());
        }
        else if(STORY == 1 && !(btnPlayer3.isSelected())){
            //Delete Unit from list
            Border thickBorder = new LineBorder(Color.YELLOW, 3);
            btnPlayer3.setBorder(thickBorder);
        }
    }

    private void btnPlayer5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayer5ActionPerformed
            if(STORY == 1 && btnPlayer5.isSelected()){
            Border thickBorder = new LineBorder(Color.GREEN, 3);
            btnPlayer5.setBorder(thickBorder);
            Statistics marksman = new Marksman();
            factoryPlayer(marksman.getName(), "5");
            console2.setText("");
            console2.append(marksman.getCombineStat());
            }
        else if(STORY == 1 && !(btnPlayer5.isSelected())){
            //Delete Unit from list
            Border thickBorder = new LineBorder(Color.YELLOW, 3);
            btnPlayer5.setBorder(thickBorder);
        }
    }//GEN-LAST:event_btnPlayer5ActionPerformed

    private void btnPlayer6ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        if(STORY == 1 && btnPlayer6.isSelected()){
            Border thickBorder = new LineBorder(Color.GREEN, 3);
            btnPlayer6.setBorder(thickBorder);
            Statistics psychic = new Psychic();
            factoryPlayer(psychic.getName(),"6");
            console2.setText("");
            console2.append(psychic.getCombineStat());
        }
        else if(STORY == 1 && !(btnPlayer6.isSelected())){
            //Delete Unit from list
            Border thickBorder = new LineBorder(Color.YELLOW, 3);
            btnPlayer6.setBorder(thickBorder);
        }
    }                                           

    private void btnEnemy1ActionPerformed(java.awt.event.ActionEvent evt) {                                          
        if(BATTLE_LOCK == 1 && btnEnemy1.isSelected()){
            SELECTED_ENEMY = 1; 
            String position = "" + SELECTED_ENEMY;
            System.out.println("Enemy selected " + position);
            
            Border thickBorder = new LineBorder(Color.RED, 5);
            btnEnemy1.setBorder(thickBorder);
            
            for(int index = 3; index < POSITION.length; index++){
                if(position.equals(POSITION[index][1])){
                    System.out.println("Index " + index + " " + POSITION[index][0]);
                    
                    for(int n = 3; n < UnitList.size(); n++){
                        if(POSITION[index][0] == UnitList.get(n).getName()){
                            console2.setText( "Enemy " + UnitList.get(n).getName() + "\n"
                                            + "HEALTH " +UnitList.get(n).getHealth() + "\n");
                            CONSOLE_LOCK = 1;
                            break;
                        }
                    }
                }
            }
            //System.out.println(POSITION[index][0] + " position" + POSITION[index][1]);            
        }
        else{
            SELECTED_ENEMY = -1;
            console2.setText("");
            Border thickBorder = new LineBorder(Color.YELLOW, 3);
            btnEnemy1.setBorder(thickBorder);
        }
    }                                         

    private void btnEnemy2ActionPerformed(java.awt.event.ActionEvent evt) {                                          
        if(BATTLE_LOCK == 1 && btnEnemy2.isSelected()){
            SELECTED_ENEMY = 2;
            String position = "" + SELECTED_ENEMY;
            System.out.println("Enemy selected " + position);
            
            Border thickBorder = new LineBorder(Color.RED, 5);
            btnEnemy2.setBorder(thickBorder);
            
            for(int index = 3; index < POSITION.length; index++){
                if(position.equals(POSITION[index][1])){
                    System.out.println("Index " + index + " " + POSITION[index][0]);
                    
                    for(int n = 3; n < UnitList.size(); n++){
                        if(POSITION[index][0] == UnitList.get(n).getName()){
                            console2.setText( "Enemy " + UnitList.get(n).getName() + "\n"
                                            + "HEALTH " +UnitList.get(n).getHealth() + "\n");
                            CONSOLE_LOCK = 1;
                            break;
                        }
                    }
                }
            }
            //System.out.println(POSITION[index][0] + " position" + POSITION[index][1]);
        }
        else{
            SELECTED_ENEMY = -1;
            console2.setText("");
            Border thickBorder = new LineBorder(Color.YELLOW, 3);
            btnEnemy2.setBorder(thickBorder);
        }
    }                                         

    private void btnEnemy3ActionPerformed(java.awt.event.ActionEvent evt) {                                          
        if(BATTLE_LOCK == 1 && btnEnemy3.isSelected()){
            SELECTED_ENEMY = 3;
            String position = "" + SELECTED_ENEMY;
            System.out.println("Enemy selected " + position);
            
            Border thickBorder = new LineBorder(Color.RED, 5);
            btnEnemy3.setBorder(thickBorder);
            
            for(int index = 3; index < POSITION.length; index++){
                if(position.equals(POSITION[index][1])){
                    System.out.println("Index " + index + " " + POSITION[index][0]);
                    
                    for(int n = 3; n < UnitList.size(); n++){
                        if(POSITION[index][0] == UnitList.get(n).getName()){
                            console2.setText( "Enemy " + UnitList.get(n).getName() + "\n"
                                            + "HEALTH " +UnitList.get(n).getHealth() + "\n");
                            CONSOLE_LOCK = 1;
                            break;
                        }
                    }
                }
            }
            //System.out.println(POSITION[index][0] + " position" + POSITION[index][1]);
        }
        else{
            SELECTED_ENEMY = -1;
            console2.setText("");
            Border thickBorder = new LineBorder(Color.YELLOW, 3);
            btnEnemy3.setBorder(thickBorder);
        }
    }                                         

    private void btnEnemy4ActionPerformed(java.awt.event.ActionEvent evt) {                                          
        if(BATTLE_LOCK == 1 && btnEnemy4.isSelected()){
            SELECTED_ENEMY = 4;
            String position = "" + SELECTED_ENEMY;
            System.out.println("Enemy selected " + position);
            
            Border thickBorder = new LineBorder(Color.RED, 5);
            btnEnemy4.setBorder(thickBorder);
            
            for(int index = 3; index < POSITION.length; index++){
                if(position.equals(POSITION[index][1])){
                    System.out.println("Index " + index + " " + POSITION[index][0]);
                    
                    for(int n = 3; n < UnitList.size(); n++){
                        if(POSITION[index][0] == UnitList.get(n).getName()){
                            console2.setText( "Enemy " + UnitList.get(n).getName() + "\n"
                                            + "HEALTH " +UnitList.get(n).getHealth() + "\n");
                            CONSOLE_LOCK = 1;
                            break;
                        }
                    }
                }
            }
            //System.out.println(POSITION[index][0] + " position" + POSITION[index][1]);
        }
        else{
            SELECTED_ENEMY = -1;
            console2.setText("");
            Border thickBorder = new LineBorder(Color.YELLOW, 3);
            btnEnemy4.setBorder(thickBorder);
        }
    }                                         

    private void btnEnemy5ActionPerformed(java.awt.event.ActionEvent evt) {                                          
        if(BATTLE_LOCK == 1 && btnEnemy5.isSelected()){
            SELECTED_ENEMY = 5;
            String position = "" + SELECTED_ENEMY;
            System.out.println("Enemy selected " + position);
            
            Border thickBorder = new LineBorder(Color.RED, 5);
            btnEnemy5.setBorder(thickBorder);
            
            for(int index = 3; index < POSITION.length; index++){
                if(position.equals(POSITION[index][1])){
                    System.out.println("Index " + index + " " + POSITION[index][0]);
                    
                    for(int n = 3; n < UnitList.size(); n++){
                        if(POSITION[index][0] == UnitList.get(n).getName()){
                            console2.setText( "Enemy " + UnitList.get(n).getName() + "\n"
                                            + "HEALTH " +UnitList.get(n).getHealth() + "\n");
                            CONSOLE_LOCK = 1;
                            break;
                        }
                    }
                }
            }
            //System.out.println(POSITION[index][0] + " position" + POSITION[index][1]);
        }
        else{
            SELECTED_ENEMY = -1;
            console2.setText("");
            Border thickBorder = new LineBorder(Color.YELLOW, 3);
            btnEnemy5.setBorder(thickBorder);
        }
    }                                         

    private void btnEnemy6ActionPerformed(java.awt.event.ActionEvent evt) {                                          
        if(BATTLE_LOCK == 1 && btnEnemy6.isSelected()){
            SELECTED_ENEMY = 6;
            String position = "" + SELECTED_ENEMY;
            System.out.println("Enemy selected " + position);
            
            Border thickBorder = new LineBorder(Color.RED, 5);
            btnEnemy6.setBorder(thickBorder);
            
            for(int index = 3; index < POSITION.length; index++){
                if(position.equals(POSITION[index][1])){
                    System.out.println("Index " + index + " " + POSITION[index][0]);
                    
                    for(int n = 3; n < UnitList.size(); n++){
                        if(POSITION[index][0] == UnitList.get(n).getName()){
                            console2.setText( "Enemy " + UnitList.get(n).getName() + "\n"
                                            + "HEALTH " +UnitList.get(n).getHealth() + "\n");
                            CONSOLE_LOCK = 1;
                            break;
                        }
                    }
                }
            }
            //System.out.println(POSITION[index][0] + " position" + POSITION[index][1]);
            

        }
        else{
            SELECTED_ENEMY = -1;
            console2.setText("");
            Border thickBorder = new LineBorder(Color.YELLOW, 3);
            btnEnemy6.setBorder(thickBorder);
        }
    }                                         

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Player1;
    private javax.swing.JPanel Player2;
    private javax.swing.JPanel Player3;
    private javax.swing.JToggleButton btnEnemy1;
    private javax.swing.JToggleButton btnEnemy2;
    private javax.swing.JToggleButton btnEnemy3;
    private javax.swing.JToggleButton btnEnemy4;
    private javax.swing.JToggleButton btnEnemy5;
    private javax.swing.JToggleButton btnEnemy6;
    private javax.swing.JToggleButton btnPlayer1;
    private javax.swing.JToggleButton btnPlayer2;
    private javax.swing.JToggleButton btnPlayer3;
    private javax.swing.JToggleButton btnPlayer4;
    private javax.swing.JToggleButton btnPlayer5;
    private javax.swing.JToggleButton btnPlayer6;
    private javax.swing.JTextArea console1;
    private javax.swing.JTextArea console2;
    private javax.swing.JPanel enemy1;
    private javax.swing.JPanel enemy2;
    private javax.swing.JPanel enemy3;
    private javax.swing.JPanel enemy4;
    private javax.swing.JPanel enemy5;
    private javax.swing.JPanel enemy6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel player4;
    private javax.swing.JPanel player5;
    private javax.swing.JPanel player6;
    // End of variables declaration//GEN-END:variables
}
