import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
/*
 * Created by JFormDesigner on Fri Feb 28 14:15:36 MSK 2020
 */


/**
 * @author unknown
 */
public class GuessingGame extends JFrame {
    public GuessingGame() {
        initComponents();
    }

    private void btnGuessActionPerformed(ActionEvent e) {
        checkGuess();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        firstLabel = new JLabel();
        label1 = new JLabel();
        btnGuess = new JButton();
        txtGuess = new JTextField();
        lblOutput = new JLabel();

        //======== this ========
        setTitle("HiLo Guessing game");
        var contentPane = getContentPane();

        //---- firstLabel ----
        firstLabel.setText("Welcome to Shmelev Andrei's HiLo Guesiin game");
        firstLabel.setHorizontalAlignment(SwingConstants.CENTER);
        firstLabel.setFont(firstLabel.getFont().deriveFont(firstLabel.getFont().getStyle() | Font.BOLD));

        //---- label1 ----
        label1.setText("Guess a number between 1 and 100:");
        label1.setHorizontalAlignment(SwingConstants.RIGHT);

        //---- btnGuess ----
        btnGuess.setText("GUESS!");
        btnGuess.setFont(btnGuess.getFont().deriveFont(btnGuess.getFont().getStyle() | Font.BOLD));
        btnGuess.addActionListener(e -> btnGuessActionPerformed(e));

        //---- lblOutput ----
        lblOutput.setText("Enter a number above and click Guess!");
        lblOutput.setHorizontalAlignment(SwingConstants.CENTER);

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addGap(143, 143, 143)
                                .addComponent(btnGuess)
                                .addContainerGap(181, Short.MAX_VALUE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(contentPaneLayout.createParallelGroup()
                                        .addComponent(firstLabel, GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE)
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addComponent(label1, GroupLayout.PREFERRED_SIZE, 253, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtGuess, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 35, Short.MAX_VALUE))
                                        .addComponent(lblOutput, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE))
                                .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(firstLabel)
                                .addGap(32, 32, 32)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(label1)
                                        .addComponent(txtGuess, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(34, 34, 34)
                                .addComponent(btnGuess)
                                .addGap(45, 45, 45)
                                .addComponent(lblOutput)
                                .addContainerGap(71, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JLabel firstLabel;
    private JLabel label1;
    private JButton btnGuess;
    private JTextField txtGuess;
    private JLabel lblOutput;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    private int theNumber;
    private int numberOfTries;

    public void checkGuess() {
        String guessText = txtGuess.getText();
        String message = "";

        try {
            int guess = Integer.parseInt(guessText);
            numberOfTries++;

            if (guess > theNumber)
                message = guess + " is too high. Try again!";
            else if (guess < theNumber)
                message = guess + " is too low. Try again!";
            else {
                message = guess +
                        " is correct. You win after " + numberOfTries + " tries";
                newGame();
            }

        } catch (Exception e) {
            message = "Enter a whole number between 1 and 100.";

        } finally {
            lblOutput.setText(message);
            txtGuess.requestFocus();
            txtGuess.selectAll();
        }
    }

    public void newGame() {
        theNumber = (int) (Math.random() * 100 + 1);
    }

    public static void main(String[] args) {
        GuessingGame theGame = new GuessingGame();
        theGame.newGame();
        theGame.setSize(new Dimension(450, 300));
        theGame.setVisible(true);
    }

}
