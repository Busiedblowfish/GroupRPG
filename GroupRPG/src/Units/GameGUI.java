/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Units;
import java.awt.Color;
import java.awt.List;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

/**
 *
 * @author Lenovo
 */
public class GameGUI extends javax.swing.JFrame implements KeyListener {

    static int STORY = 0;           //keeps track of user progress
    static ArrayList<Statistics> UnitList = new ArrayList<Statistics>(1);   //List of all in game units
    static int PlayerCount = 0;     //keeps track of how many units user selects
    
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frontApp().setVisible(true);
            }
        });
    }
    
    //Passed object's name and generates player unit
    public static void factoryPlayer(String name){
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
        //Limit player group size to 3
        //Move story to chapter 2
        PlayerCount++;
        if(PlayerCount == 3){
            STORY = 2;
            System.out.printf("PlayerCount: %d\n", PlayerCount);
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
        //btnEnemy1.setBackground(Color.BLACK);
        btnEnemy1.setText("");
        btnEnemy2.setEnabled(false);
        //btnEnemy2.setBackground(Color.BLACK);
        btnEnemy2.setText("");
        btnEnemy3.setEnabled(false);
        //btnEnemy3.setBackground(Color.BLACK);
        btnEnemy3.setText("");
        btnEnemy4.setEnabled(false);
        //btnEnemy4.setBackground(Color.BLACK);
        btnEnemy4.setText("");
        btnEnemy5.setEnabled(false);
        //btnEnemy5.setBackground(Color.BLACK);
        btnEnemy5.setText("");
        btnEnemy6.setEnabled(false);
        //btnEnemy6.setBackground(Color.BLACK);
        btnEnemy6.setText("");

        console1.append("+=============+  New Game  +=============+\n");
        console1.append("It's a new day and a new opportunity to earn your fair share of coin...\n" 
                        + "Stepping outside the tavern,\n"
                        + "the warmth of the twins Sol and Solara illuminate Huntsman's Rest;\n"
                        + "the Empirium's westernmost outpost and civilizations end.\n"
                        + "The lawless badlands of the Maw, an endless harbor for wanted men,\n"
                        + "stretches beyond the city walls.\n"
                        + "You take a deep breath, filling your lungs with one last breath of the peaceful country air...\n"
                        + "Press <Enter> to continue");
    }
    
    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ENTER) {
            if(STORY < 1){
                STORY++;
            }
            if(STORY == 3){
                STORY++;
            }
        }
        if(STORY == 1){
            console1.setText("");
            console1.append("A mercenary by trade, you lead a small cadre of men.\n"
                            + "Before embarking to fulfill the next contract,\n"
                            + "you select three companions.\n"
                            + "Choose 3 characters and Press <Enter> to continue...");
            
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
            if(!btnPlayer1.isSelected()){
                //Disable button 1
                btnPlayer1.setText("");
                btnPlayer1.setBorder(thickBorder);
                btnPlayer1.setBackground(Color.BLACK);
            }
            else{
                //Enable button 1
                btnPlayer1.setSelected(!btnPlayer1.isSelected());
                btnPlayer1.setEnabled(false);
            }
            if(!btnPlayer2.isSelected()){
                //Disable button 2
                btnPlayer2.setText("");
                btnPlayer2.setBorder(thickBorder);
                btnPlayer2.setBackground(Color.BLACK);
            }
            else{
                //Enable button 2
                btnPlayer2.setSelected(!btnPlayer2.isSelected());
                btnPlayer2.setEnabled(false);
            }
            if(!btnPlayer3.isSelected()){
                //Disable button 3
                btnPlayer3.setText("");
                btnPlayer3.setBorder(thickBorder);
                btnPlayer3.setBackground(Color.BLACK);
            }
            else{
                //Enable button 3
                btnPlayer3.setSelected(!btnPlayer3.isSelected());
                btnPlayer3.setEnabled(false);
            }
            if(!btnPlayer4.isSelected()){
                //Disable button 4
                btnPlayer4.setText("");
                btnPlayer4.setBorder(thickBorder);
                btnPlayer4.setBackground(Color.BLACK);
            }
            else{
                //Enable button 4
                btnPlayer4.setSelected(!btnPlayer4.isSelected());
                btnPlayer4.setEnabled(false);
            }
            if(!btnPlayer5.isSelected()){
                //Disable button 5
                btnPlayer5.setText("");
                btnPlayer5.setBorder(thickBorder);
                btnPlayer5.setBackground(Color.BLACK);
            }
            else{
                //Enable button 5
                btnPlayer5.setSelected(!btnPlayer5.isSelected());
                btnPlayer5.setEnabled(false);
            }
            if(!btnPlayer6.isSelected()){
                //Disable button 6
                btnPlayer6.setText("");
                btnPlayer6.setBorder(thickBorder);
                btnPlayer6.setBackground(Color.BLACK);
            }
            else{
                //Enable button 6
                btnPlayer6.setSelected(!btnPlayer6.isSelected());
                btnPlayer6.setEnabled(false);
            }
            
            //Print members of user selected group
            console1.setText("GROUP SELECTED\n");
            for(int i = 0; i < PlayerCount; i++){
                console1.append(UnitList.get(i).getName() + "\n");
            }
            console1.append("Your group steps through the city gate...\n");

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
            LinkedList<Statistics> TurnList = new LinkedList<Statistics>();
            for(int i = 0; i < UnitList.size(); i++){
                switch(UnitList.get(i).getName()){
                    case "Barbarian":       TurnList.add(new Barbarian());
                                            break;
                    case "Berserker":       TurnList.add(new Berserker());
                                            break;
                    case "Juggernaut":      TurnList.add(new Juggernaut());
                                            break;
                    case "Marksman":        TurnList.add(new Marksman());
                                            break;
                    case "Pyschic":         TurnList.add(new Psychic());
                                            break;
                    case "Witch Doctor":    TurnList.add(new WitchDoctor());
                                            break;
                    case "Assassin":        TurnList.add(new enemy_Assassin());
                                            break;
                    case "Brute":           TurnList.add(new enemy_Brute());
                                            break;
                    case "Marauder":        TurnList.add(new enemy_Marauder());
                                            break;
                    case "Rogue":           TurnList.add(new enemy_Rogue());
                                            break;
                    case "Summoner":        TurnList.add(new enemy_Summoner());
                                            break;
                    case "Warlock":         TurnList.add(new enemy_Warlock());
                                            break;
                }
            }
            console1.setText("BATTLE");
            console2.setText("BATTLE");
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
        setTitle("League of Warriors: Select Warriors");
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
            .addComponent(btnEnemy1, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
        );
        enemy1Layout.setVerticalGroup(
            enemy1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnEnemy1, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
        );

        getContentPane().add(enemy1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 0, -1, -1));

        enemy4.setBackground(new java.awt.Color(51, 153, 0));

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
            .addComponent(btnEnemy2, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
        );
        enemy4Layout.setVerticalGroup(
            enemy4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnEnemy2, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
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
            .addComponent(btnEnemy3, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
        );
        enemy2Layout.setVerticalGroup(
            enemy2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnEnemy3, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
        );

        getContentPane().add(enemy2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 177, -1, -1));

        enemy5.setBackground(new java.awt.Color(0, 102, 102));
        enemy5.setPreferredSize(new java.awt.Dimension(250, 176));

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
            .addComponent(btnEnemy4, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
        );
        enemy5Layout.setVerticalGroup(
            enemy5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnEnemy4, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
        );

        getContentPane().add(enemy5, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 177, -1, -1));

        player6.setBackground(new java.awt.Color(51, 0, 255));

        btnPlayer6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/psycic.png"))); // NOI18N
        btnPlayer6.setText("Psychic");
        btnPlayer6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPlayer6MouseClicked(evt);
            }
        });
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
            .addComponent(btnEnemy5, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
        );
        enemy3Layout.setVerticalGroup(
            enemy3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnEnemy5, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
        );

        getContentPane().add(enemy3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 354, -1, -1));

        enemy6.setBackground(new java.awt.Color(0, 255, 102));

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
            .addComponent(btnEnemy6, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
        );
        enemy6Layout.setVerticalGroup(
            enemy6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnEnemy6, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
        );

        getContentPane().add(enemy6, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 354, 250, -1));

        console2.setColumns(20);
        console2.setRows(5);
        jScrollPane2.setViewportView(console2);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 530, 500, 180));

        console1.setColumns(20);
        console1.setRows(5);
        jScrollPane1.setViewportView(console1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 530, 500, 180));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPlayer1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayer1ActionPerformed
        if(STORY == 1 && btnPlayer1.isSelected()){
            Border thickBorder = new LineBorder(Color.GREEN, 3);
            btnPlayer1.setBorder(thickBorder);
            Berserker berserker = new Berserker();
            factoryPlayer(berserker.getName());
            console2.setText("");
            console2.append(berserker.getName() + "\n"
                            + "Weapon: " + berserker.getWeapon() + "\n"
                            + "Armor: " + berserker.getArmor() + "\n"
                            + "Speed: " + berserker.getSpeed() + "\n"
                            + "Attack: " + berserker.getAttack_s() + "\n"
                            + "Block: " + berserker.getBlock_s() + "\n"
                            + "Health: " + berserker.getHealth() + "\n"
                            + "Endurance: " + berserker.getEndurance() + "\n"
                            + "Spirit: " + berserker.getSpirit() + "\n");
            
        }
        else if(STORY == 1 && !(btnPlayer1.isSelected())){
            Border thickBorder = new LineBorder(Color.YELLOW, 3);
            btnPlayer1.setBorder(thickBorder);
        }
    }//GEN-LAST:event_btnPlayer1ActionPerformed

    private void btnPlayer4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayer4ActionPerformed
        if(STORY == 1 && btnPlayer4.isSelected()){
            Border thickBorder = new LineBorder(Color.GREEN, 3);
            btnPlayer4.setBorder(thickBorder);
            Statistics juggernaut = new Juggernaut();
            factoryPlayer(juggernaut.getName());
            console2.setText("");
            console2.append(juggernaut.getName() + "\n"
                            + "Weapon: " + juggernaut.getWeapon() + "\n"
                            + "Armor: " + juggernaut.getArmor() + "\n"
                            + "Speed: " + juggernaut.getSpeed() + "\n"
                            + "Attack: " + juggernaut.getAttack_s() + "\n"
                            + "Block: " + juggernaut.getBlock_s() + "\n"
                            + "Health: " + juggernaut.getHealth() + "\n"
                            + "Endurance: " + juggernaut.getEndurance() + "\n"
                            + "Spirit: " + juggernaut.getSpirit() + "\n");

        }
        else if(STORY == 1 && !(btnPlayer4.isSelected())){
            //Delete Unit from list
            Border thickBorder = new LineBorder(Color.YELLOW, 3);
            btnPlayer4.setBorder(thickBorder);
        }
    }//GEN-LAST:event_btnPlayer4ActionPerformed

    private void btnPlayer2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayer2ActionPerformed
        if(STORY == 1 && btnPlayer2.isSelected()){
            Border thickBorder = new LineBorder(Color.GREEN, 3);
            btnPlayer2.setBorder(thickBorder);
            Statistics barbarian = new Barbarian();
            factoryPlayer(barbarian.getName());
            console2.setText("");
            console2.append(barbarian.getName() + "\n"
                            + "Weapon: " + barbarian.getWeapon() + "\n"
                            + "Armor: " + barbarian.getArmor() + "\n"
                            + "Speed: " + barbarian.getSpeed() + "\n"
                            + "Attack: " + barbarian.getAttack_s() + "\n"
                            + "Block: " + barbarian.getBlock_s() + "\n"
                            + "Health: " + barbarian.getHealth() + "\n"
                            + "Endurance: " + barbarian.getEndurance() + "\n"
                            + "Spirit: " + barbarian.getSpirit() + "\n");
        }
        else if(STORY == 1 && !(btnPlayer2.isSelected())){
            //Delete Unit from list
            Border thickBorder = new LineBorder(Color.YELLOW, 3);
            btnPlayer2.setBorder(thickBorder);
        }
    }//GEN-LAST:event_btnPlayer2ActionPerformed

    private void btnPlayer3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayer3ActionPerformed
        if(STORY == 1 && btnPlayer3.isSelected()){
            Border thickBorder = new LineBorder(Color.GREEN, 3);
            btnPlayer3.setBorder(thickBorder);
            Statistics witchdr = new WitchDoctor();
            factoryPlayer(witchdr.getName());
            console2.setText("");
            console2.append(witchdr.getName() + "\n"
                            + "Weapon: " + witchdr.getWeapon() + "\n"
                            + "Armor: " + witchdr.getArmor() + "\n"
                            + "Speed: " + witchdr.getSpeed() + "\n"
                            + "Attack: " + witchdr.getAttack_s() + "\n"
                            + "Block: " + witchdr.getBlock_s() + "\n"
                            + "Health: " + witchdr.getHealth() + "\n"
                            + "Endurance: " + witchdr.getEndurance() + "\n"
                            + "Spirit: " + witchdr.getSpirit() + "\n");

        }
        else if(STORY == 1 && !(btnPlayer3.isSelected())){
            //Delete Unit from list
            Border thickBorder = new LineBorder(Color.YELLOW, 3);
            btnPlayer3.setBorder(thickBorder);
        }
    }//GEN-LAST:event_btnPlayer3ActionPerformed

    private void btnPlayer5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayer5ActionPerformed
            if(STORY == 1 && btnPlayer5.isSelected()){
            Border thickBorder = new LineBorder(Color.GREEN, 3);
            btnPlayer5.setBorder(thickBorder);
            Statistics marksman = new Marksman();
            factoryPlayer(marksman.getName());
            console2.setText("");
            console2.append(marksman.getName() + "\n"
                            + "Weapon: " + marksman.getWeapon() + "\n"
                            + "Armor: " + marksman.getArmor() + "\n"
                            + "Speed: " + marksman.getSpeed() + "\n"
                            + "Attack: " + marksman.getAttack_s() + "\n"
                            + "Block: " + marksman.getBlock_s() + "\n"
                            + "Health: " + marksman.getHealth() + "\n"
                            + "Endurance: " + marksman.getEndurance() + "\n"
                            + "Spirit: " + marksman.getSpirit() + "\n");
            
            }
        else if(STORY == 1 && !(btnPlayer5.isSelected())){
            //Delete Unit from list
            Border thickBorder = new LineBorder(Color.YELLOW, 3);
            btnPlayer5.setBorder(thickBorder);
        }
    }//GEN-LAST:event_btnPlayer5ActionPerformed

    private void btnPlayer6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayer6ActionPerformed
        //Enter button -> launch gameGUI.java
        
            if(STORY == 1 && btnPlayer6.isSelected())
            {
                Border thickBorder = new LineBorder(Color.GREEN, 3);
                btnPlayer6.setBorder(thickBorder);
                Statistics psychic = new Psychic();
                factoryPlayer(psychic.getName());
                console2.setText("");
                console2.append(psychic.getName() + "\n"
                                + "Weapon: " + psychic.getWeapon() + "\n"
                                + "Armor: " + psychic.getArmor() + "\n"
                                + "Speed: " + psychic.getSpeed() + "\n"
                                + "Attack: " + psychic.getAttack_s() + "\n"
                                + "Block: " + psychic.getBlock_s() + "\n"
                                + "Health: " + psychic.getHealth() + "\n"
                                + "Endurance: " + psychic.getEndurance() + "\n"
                                + "Spirit: " + psychic.getSpirit() + "\n");
   
            }
            else if(STORY == 1 && !(btnPlayer6.isSelected()))
            {
                //Delete Unit from list
                Border thickBorder = new LineBorder(Color.YELLOW, 3);
                btnPlayer6.setBorder(thickBorder);
            }
    }//GEN-LAST:event_btnPlayer6ActionPerformed

    private void btnEnemy1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnemy1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEnemy1ActionPerformed

    private void btnEnemy2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnemy2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEnemy2ActionPerformed

    private void btnEnemy3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnemy3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEnemy3ActionPerformed

    private void btnEnemy4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnemy4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEnemy4ActionPerformed

    private void btnEnemy5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnemy5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEnemy5ActionPerformed

    private void btnEnemy6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnemy6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEnemy6ActionPerformed

    private void btnPlayer6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPlayer6MouseClicked
        // TODO add your handling code here
 
    }//GEN-LAST:event_btnPlayer6MouseClicked

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
