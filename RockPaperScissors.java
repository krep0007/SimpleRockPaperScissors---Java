import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class RockPaperScissors {

    public static void main(String[] args){

        try {//required try-catch block for creating files

            File winLoss = new File("WinLosses.txt");//creating a new file

            if (winLoss.createNewFile()) {
                System.out.println("File created: " + winLoss.getName());

            } else {
                System.out.println("File already exists. You're an experienced player I see!");
            }

        } catch (IOException e) {
            System.out.println("Error");
            e.printStackTrace();
        }

        JFrame a = new JFrame();//using Jframe for the window of the game
        JPanel b = new JPanel();//creating a panel
        a.setSize(650, 200);//window size
        a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//program closes when the window is exited

        //three Buttons labeled: Rock, paper, scissors
        final JButton buttonR = new JButton ("Rock");
        final JButton buttonP = new JButton ("Paper");
        final JButton buttonS = new JButton ("Scissors");

        //have a label displaying intro text
        JLabel colourLabel = new JLabel("Welcome to rock paper scissors!");

        class RockGame extends JPanel implements ActionListener{//my class RockGame inherits the JPanel class

            public void actionPerformed(ActionEvent gameChoice) {

                Color colouredButtons; //color variable

                if (gameChoice.getSource() == buttonR){//if rock button is clicked

                    //changing button backgrounds
                    colouredButtons = Color.gray;
                    buttonR.setBackground(colouredButtons);
                    buttonP.setBackground(null);//changes the other buttons to blank in case they were already picked
                    buttonS.setBackground(null);

                    //creating a random number to decide the CPU's game choice
                    int cpuMove = (int)(Math.random()*3);

                    //Depending on the CPU's choice, output a different message.
                    if(cpuMove == 0) {
                        colourLabel.setText("You chose rock. Your opponent chose rock. It's a tie!");

                    } else if(cpuMove == 1) {
                        colourLabel.setText("You chose rock. Your opponent chose paper. You lose!");

                    } else {
                        colourLabel.setText("You chose rock. Your opponent chose scissors. You win!");
                    }

                    //Now the program will write the outcome of the game to the file we created earlier
                    try { //required try-catch block
                        FileWriter wlWriter = new FileWriter("WinLosses.txt");

                        //if statements for each possible CPU game choice
                        if(cpuMove == 0) {
                            wlWriter.write("Player chose rock and tied");
                            wlWriter.close();
                        } else if (cpuMove == 1){
                            wlWriter.write("Player chose rock and lost");
                            wlWriter.close();
                        } else {
                            wlWriter.write("Player chose rock and won!");
                            wlWriter.close();
                        }
                    } catch (IOException e) {
                        System.out.println("An error occurred.");
                        e.printStackTrace();
                    }


                } else if (gameChoice.getSource() == buttonP){//if paper button is clicked

                    //changing button backgrounds
                    colouredButtons = Color.orange;
                    buttonR.setBackground(null);
                    buttonP.setBackground(colouredButtons);
                    buttonS.setBackground(null);

                    //creating a random number to decide the CPU's game choice
                    int cpuMove = (int)(Math.random()*3);

                    if(cpuMove == 0) {
                        colourLabel.setText("You chose paper. Your opponent chose rock. You win!");

                    } else if(cpuMove == 1) {
                        colourLabel.setText("You chose paper. Your opponent chose paper. It's a tie!");

                    } else {
                        colourLabel.setText("You chose paper. Your opponent chose scissors. You lose!");
                    }

                    //Now the program will write the outcome of the game to the file we created earlier
                    try {
                        FileWriter wlWriter = new FileWriter("WinLosses.txt");

                        //if statements for each possible CPU game choice
                        if(cpuMove == 0) {
                            wlWriter.write("Player chose paper and won!");
                            wlWriter.close();
                        } else if (cpuMove == 1){
                            wlWriter.write("Player chose paper and tied");
                            wlWriter.close();
                        } else {
                            wlWriter.write("Player chose paper and lost");
                            wlWriter.close();
                        }
                    } catch (IOException e) {
                        System.out.println("An error occurred.");
                        e.printStackTrace();
                    }



                } else {//if scissors button is clicked

                    //changing button backgrounds
                    colouredButtons = Color.cyan;
                    buttonR.setBackground(null);
                    buttonP.setBackground(null);
                    buttonS.setBackground(colouredButtons);

                    //creating a random number to decide the CPU's game choice
                    int cpuMove = (int)(Math.random()*3);

                    if(cpuMove == 0) {
                        colourLabel.setText("You chose scissors. Your opponent chose rock. You lose!");

                    } else if(cpuMove == 1) {
                        colourLabel.setText("You chose scissors. Your opponent chose paper. You win!");

                    } else {
                        colourLabel.setText("You chose scissors. Your opponent chose scissors. It's a tie!");
                    }

                    //Now the program will write the outcome of the game to the file we created earlier
                    try {
                        FileWriter wlWriter = new FileWriter("WinLosses.txt");

                        //if statements for each possible CPU game choice
                        if(cpuMove == 0) {
                            wlWriter.write("Player chose scissors and lost");
                            wlWriter.close();
                        } else if (cpuMove == 1){
                            wlWriter.write("Player chose scissors and won!");
                            wlWriter.close();
                        } else {
                            wlWriter.write("Player chose scissors and tied");
                            wlWriter.close();
                        }
                    } catch (IOException e) {
                        System.out.println("An error occurred.");
                        e.printStackTrace();
                    }
                }
            }
        }

        //this block of code gives the buttons functionality
        buttonR.addActionListener(new RockGame());
        buttonP.addActionListener(new RockGame());
        buttonS.addActionListener(new RockGame());

        //calling the add() method to add buttons, labels and panels to the window
        b.add(colourLabel);
        b.add(buttonR);
        b.add(buttonP);
        b.add(buttonS);
        a.add(b);
        a.setVisible(true);
    }
}