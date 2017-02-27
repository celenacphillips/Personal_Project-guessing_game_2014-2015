package guessinggame;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//@author: Celena Williams
//Last edited: February 26, 2017

//Code may be kept and modified, so long as my name stays the creator.
//Parts of code may be used without documentation if code is understood.

public class GuessingGame extends JFrame implements ActionListener {
	JLabel instructionLabel1, instructionLabel2, gameLabel, cheaterLabel;
	JLabel cheatStatusLabel, pastGuessesLabel, guessingLabel, guessesLabel;
	JTextField guessingField;
	JButton enterButton;
	JMenuBar menuBar;
	JMenu menu;
	JMenuItem cheatMenuItem, restartMenuItem, playerChangeMenuItem;
	JPanel northPanel, northNorthPanel, northSouthPanel;
        JPanel northNorthNorthPanel, northNorthSouthPanel;
	JPanel southPanel, southNorthPanel, southSouthPanel, centerPanel;
        JPanel centerNorthPanel, centerSouthPanel, southCenterPanel;
	JPanel centerSouthNorthPanel, centerSouthSouthPanel;

	String name = "";
	int randomNumber;
	int cheatMin, cheatMax, cheatMin2, cheatMax2;
	int guesses = 0;
	int low = 1, high = 1000;

	public static void main (String [] args) {
            GuessingGame application = new GuessingGame ();
            application.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
	}//END public static void main (String [] args)

	public GuessingGame () {
            setResizable (false);
            setLayout (new BorderLayout ());
            setTitle ("Guessing Game");

            name = JOptionPane.showInputDialog ("Enter Your Name");

            //If the player doesn't eneter a name, exit the game.
            if (name == null || name.equals (""))
                System.exit (0);

            //Creates the random number.
            randomNumber = (int) (Math.random () * (1000));
            
            //If someone wants to cheat, I wanted to make sure the range
            //relatively 20 numbers apart in either direction. To prevent
            //specific numbers and a pattern (like the number is 38, the cheat
            //range would show as 18 and 58), I also divided the range by ten,
            //then multiplied it again by ten. This makes the range example 10
            //and 50, so it makes the number harder to guess.
            cheatMin2 = (randomNumber - 20) / 10;
            cheatMax2 = (randomNumber + 20) / 10;
            cheatMin = cheatMin2 * 10;
            cheatMax = cheatMax2 * 10;

            //Creates the layout for the window.
            northPanel = new JPanel ();
            northPanel.setLayout (new BorderLayout ());
            southPanel = new JPanel ();
            southPanel.setLayout (new BorderLayout ());
            centerPanel = new JPanel ();
            centerPanel.setLayout (new BorderLayout ());
            northNorthPanel = new JPanel ();
            northNorthPanel.setLayout (new BorderLayout ());
            centerSouthPanel = new JPanel ();
            centerSouthPanel.setLayout (new BorderLayout ());

            northNorthNorthPanel = new JPanel ();
            northNorthNorthPanel.setLayout (new FlowLayout (FlowLayout.CENTER));
            northNorthSouthPanel = new JPanel ();
            northNorthSouthPanel.setLayout (new FlowLayout (FlowLayout.CENTER));
            northSouthPanel = new JPanel ();
            northSouthPanel.setLayout (new FlowLayout (FlowLayout.CENTER));
            southNorthPanel = new JPanel ();
            southNorthPanel.setLayout (new FlowLayout (FlowLayout.CENTER));
            southCenterPanel = new JPanel ();
            southCenterPanel.setLayout (new FlowLayout (FlowLayout.CENTER));
            southSouthPanel = new JPanel ();
            southSouthPanel.setLayout (new FlowLayout (FlowLayout.CENTER));
            centerNorthPanel = new JPanel ();
            centerNorthPanel.setLayout (new FlowLayout (FlowLayout.CENTER));
            centerSouthNorthPanel = new JPanel ();
            centerSouthNorthPanel.setLayout (new FlowLayout
                                             (FlowLayout.CENTER));
            centerSouthSouthPanel = new JPanel ();
            centerSouthSouthPanel.setLayout (new FlowLayout
                                             (FlowLayout.CENTER));

            instructionLabel1 = new JLabel
                ("The object is to guess the number without using the cheat.");
            instructionLabel2 = new JLabel
                  ("You may use the cheat, but it will be shown you cheated.");
            northNorthNorthPanel.add (instructionLabel1);
            northNorthSouthPanel.add (instructionLabel2);
            gameLabel = new JLabel
                ("Guess a Randomly Generated Number between " +
                 low + " and " + high);
            northSouthPanel.add (gameLabel);
            cheaterLabel = new JLabel ();
            southNorthPanel.add (cheaterLabel);
            guessesLabel = new JLabel ("Guesses: " + guesses);
            southCenterPanel.add (guessesLabel);
            cheatStatusLabel = new JLabel (name +
                                            " has not used the cheat yet.");
            southSouthPanel.add (cheatStatusLabel);
            pastGuessesLabel = new JLabel ();
            centerSouthNorthPanel.add (pastGuessesLabel);
            guessingLabel = new JLabel ();
            centerSouthSouthPanel.add (guessingLabel);

            guessingField = new JTextField (20);
            guessingField.addActionListener (this);
            centerNorthPanel.add (guessingField);
            enterButton = new JButton ("Enter");
            enterButton.addActionListener (this);
            centerNorthPanel.add (enterButton);

            menuBar = new JMenuBar ();
            menu = new JMenu ("Menu");
            
            //Coding the menu item actions up here enables me to also add
            //button actions in to the program.
            cheatMenuItem = new JMenuItem ("Cheat");
            cheatMenuItem.setEnabled (true);
            cheatMenuItem.addActionListener ((ActionEvent e) -> {
                cheatStatusLabel.setText (name + " has now used the cheat.");
                cheaterLabel.setText ("The number is between " + cheatMin +
                                      " and " + cheatMax  +  ".");
                cheatMenuItem.setEnabled (false);
                cheatStatusLabel.setForeground (Color.RED);
                cheaterLabel.setForeground (Color.RED);
            });//END cheatMenuItem.addActionListener ((ActionEvent e)
            
            restartMenuItem = new JMenuItem ("Restart");
            restartMenuItem.setEnabled (false);
            restartMenuItem.addActionListener ((ActionEvent e) -> {
                guessingField.setText ("");
                guessingField.requestFocus ();
                guessingLabel.setText ("");
                pastGuessesLabel.setText ("");
                cheatStatusLabel.setText (name +
                                          " has not used the cheat yet.");
                cheaterLabel.setText ("");
                
                randomNumber = (int) (Math.random () * (1000));
                
                //Resets the cheat min and max.
                cheatMin2 = (randomNumber - 20) / 10;
                cheatMax2 = (randomNumber + 20) / 10;
                cheatMin = cheatMin2 * 10;
                cheatMax = cheatMax2 * 10;

                restartMenuItem.setEnabled (false);
                cheatMenuItem.setEnabled (true);
                playerChangeMenuItem.setEnabled (true);
                cheatStatusLabel.setForeground (Color.BLACK);
                cheaterLabel.setForeground (Color.BLACK);
                guessingField.setEditable (true);
                enterButton.setEnabled (true);
                guesses = 0;
                guessesLabel.setText ("Guesses: " + guesses);
                low = 1;
                high = 1000;
                gameLabel.setText ("Guess a Randomly Generated Number between "
                                   + low + " and " + high);
            });//END restartMenuItem.addActionListener ((ActionEvent e)
            
            playerChangeMenuItem = new JMenuItem ("Player Change");
            playerChangeMenuItem.setEnabled (false);
            playerChangeMenuItem.addActionListener ((ActionEvent e) -> {
                name = JOptionPane.showInputDialog ("Enter Your Name");
                cheatStatusLabel.setText (name +
                                          " has not used the cheat yet.");
                playerChangeMenuItem.setEnabled (false);

                if (name == null || name.equals (""))
                    System.exit (0);
            });//END playerChangeMenuItem.addActionListener ((ActionEvent e)

            //Adds the menu items to the menu.
            menu.add (cheatMenuItem);
            menu.addSeparator ();
            menu.add (restartMenuItem);
            menu.addSeparator ();
            menu.add (playerChangeMenuItem);
            menuBar.add (menu);
            setJMenuBar (menuBar);

            //Adds the content to the window.
            add (northPanel, BorderLayout.NORTH);
            add (southPanel, BorderLayout.SOUTH);
            add (centerPanel, BorderLayout.CENTER);

            northPanel.add (northNorthPanel, BorderLayout.NORTH);
            northPanel.add (northSouthPanel, BorderLayout.SOUTH);
            southPanel.add (southNorthPanel, BorderLayout.NORTH);
            southPanel.add (southCenterPanel, BorderLayout.CENTER);
            southPanel.add (southSouthPanel, BorderLayout.SOUTH);
            centerPanel.add (centerNorthPanel, BorderLayout.NORTH);
            centerPanel.add (centerSouthPanel, BorderLayout.SOUTH);
            northNorthPanel.add (northNorthNorthPanel, BorderLayout.NORTH);
            northNorthPanel.add (northNorthSouthPanel, BorderLayout.SOUTH);
            centerSouthPanel.add (centerSouthNorthPanel, BorderLayout.NORTH);
            centerSouthPanel.add (centerSouthSouthPanel, BorderLayout.SOUTH);

            setSize (600, 500);
            setVisible (true);
	}//END public GuessingGame ()

	@Override
	public void actionPerformed (ActionEvent e) {
            String num;
            int number = 0;

            try {
                num = guessingField.getText ();

                //If the user doesn't enter a number
                if (num.equals ("")) {
                    JOptionPane.showMessageDialog (this,
                                                   "Enter a number",
                                                   "Enter a number",
                                         JOptionPane.ERROR_MESSAGE);
                    guessingField.setText ("");
                    guessingField.requestFocus ();
                }//END if (num.equals (""))
                else {
                    number = Integer.parseInt (num);

                    //So long as the number of guesses is less than 10
                    if (guesses < 10) {
                        //If the user enters a number out of range
                        if (number > 1000) {
                            JOptionPane.showMessageDialog (this, "Enter a "
                                                         + "number less "
                                                         + "than 1000",
                                                           "Enter a number",
                                                 JOptionPane.ERROR_MESSAGE);
                            guessingField.setText ("");
                            guessingField.requestFocus ();
                        }//END if (number > 1000)
                        else if (number < 1) {
                            JOptionPane.showMessageDialog (this, "Enter a "
                                                         + "number more "
                                                         + "than 1",
                                                           "Enter a number",
                                                 JOptionPane.ERROR_MESSAGE);
                            guessingField.setText ("");
                            guessingField.requestFocus ();
                        }//END if (number < 1)
                        else {
                            //If the number is guessed
                            if (number == randomNumber) {
                                JOptionPane.showMessageDialog (this,
                                                  "You guessed the number.",
                                                  "You guessed the number.",
                                                 JOptionPane.PLAIN_MESSAGE);
                                guessingField.setEditable (false);
                                enterButton.setEnabled (false);
                                cheatMenuItem.setEnabled (false);
                                restartMenuItem.setEnabled (true);
                            }//END if (number == randomNumber)

                            //If the number is not guessed
                            if (number != randomNumber) {
                                String pastGuesses =
                                    pastGuessesLabel.getText ();
                                pastGuessesLabel.setText (pastGuesses +
                                                          number + ", ");
                                guessingField.setText ("");
                                guessingField.requestFocus ();
                            }//END if (number != randomNumber)

                            String guessing = guessingLabel.getText ();
                            
                            //If the user guesses greater than the number
                            if (number > randomNumber) {
                                    guessingLabel.setText (guessing +
                                                           "Too High, ");

                                    //Replace the max with the user's number
                                    if (number < high)
                                        high = number;
                            }//END if (number > randomNumber)

                            //If the user guesses lesser than the number
                            if (number < randomNumber) {
                                guessingLabel.setText (guessing +
                                                       "Too Low, ");

                                //Replace the min with the user's number
                                if (number > low)
                                    low = number;
                            }//END if (number < randomNumber)

                            //Resets the range between the new range with
                            //what the user guessed
                            gameLabel.setText("Guess a Randomly Generated " 
                                            + "Number between " + low + 
                                              " and " + high);

                            guesses++;
                            guessesLabel.setText ("Guesses: " + guesses);
                        }//END else

                        //If the user guesses ten times
                        if (guesses == 10) {
                            enterButton.setEnabled (false);
                            guessingField.setEditable (false);
                        }//END if (guesses == 10)
                    }//END if (guesses < 10)
                }//END else

                String lost = "You lost.\nYou took " + guesses + 
                              " guesses.\nThe number was " + randomNumber + 
                              ".";

                //If the user tries ten times and doesn't guess the number
                if (guesses == 10 && number != randomNumber) {
                    JOptionPane.showMessageDialog (this, lost, "You lost",
                                                 JOptionPane.PLAIN_MESSAGE);

                    guessingField.setEditable (false);
                    enterButton.setEnabled (false);
                    cheatMenuItem.setEnabled (false);
                    restartMenuItem.setEnabled (true);
                }//END if (guesses == 10 && number != randomNumber)
            }//END try

            catch (NumberFormatException numberFormatException) {
                JOptionPane.showMessageDialog (this, "Enter a valid number",
                                               "Enter a valid number",
                                               JOptionPane.ERROR_MESSAGE);
                guessingField.setText ("");
            }//END catch (NumberFormatException numberFormatException)
	}//END public void actionPerformed (ActionEvent e)
}//END public class GuessingGame