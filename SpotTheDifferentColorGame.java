import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SpotTheDifferentColorGame extends JFrame {

    private JButton[][] buttons;
    private int differentColorRowIndex;
    private int differentColorColIndex;
    private static final int GRID_SIZE = 5;
    private static final int GAME_TIME_LIMIT_SECONDS = 30;
    private JLabel timerLabel;
    private Timer gameTimer;

    public SpotTheDifferentColorGame() {
        setTitle("Spot The Different Color Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setLayout(new BorderLayout());

        buttons = new JButton[GRID_SIZE][GRID_SIZE];

        // Generate random indices for the button with a different color
        differentColorRowIndex = new Random().nextInt(GRID_SIZE);
        differentColorColIndex = new Random().nextInt(GRID_SIZE);

        // Create the grid of buttons
        JPanel buttonPanel = new JPanel(new GridLayout(GRID_SIZE, GRID_SIZE));
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                buttons[row][col] = new JButton();
                buttons[row][col].setBackground(getRandomColor());
                buttons[row][col].addActionListener(new ButtonClickListener());
                buttonPanel.add(buttons[row][col]);
            }
        }

        // Create a timer label
        timerLabel = new JLabel("Time: " + GAME_TIME_LIMIT_SECONDS + " seconds", SwingConstants.CENTER);
        timerLabel.setFont(new Font("Arial", Font.PLAIN, 18));

        // Create a timer to change the different color dynamically
        gameTimer = new Timer(1000, new TimerActionListener());

        // Add components to the frame
        add(timerLabel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);

        // Start the game timer
        gameTimer.start();

        // Set the timer to end the game after the specified time limit
        Timer endGameTimer = new Timer(GAME_TIME_LIMIT_SECONDS * 1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                endGame();
            }
        });
        endGameTimer.setRepeats(false);
        endGameTimer.start();
    }

    private Color getRandomColor() {
        Random rand = new Random();
        return new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
    }

    private void changeDifferentColor() {
        buttons[differentColorRowIndex][differentColorColIndex].setBackground(getRandomColor());

        // Update differentColorRowIndex and differentColorColIndex to new random indices
        differentColorRowIndex = new Random().nextInt(GRID_SIZE);
        differentColorColIndex = new Random().nextInt(GRID_SIZE);
        buttons[differentColorRowIndex][differentColorColIndex].setBackground(getRandomColor());
    }

    private class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton clickedButton = (JButton) e.getSource();
            if (clickedButton.getBackground() == buttons[differentColorRowIndex][differentColorColIndex].getBackground()) {
                // Correct button clicked
                changeDifferentColor();
            }
        }
    }

    private class TimerActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int remainingTime = Integer.parseInt(timerLabel.getText().split(" ")[1]) - 1;
            if (remainingTime >= 0) {
                timerLabel.setText("Time: " + remainingTime + " seconds");
            } else {
                endGame();
            }
        }
    }

    private void endGame() {
        gameTimer.stop();
        JOptionPane.showMessageDialog(null, "Time's up! Game Over.");
        System.exit(0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SpotTheDifferentColorGame game = new SpotTheDifferentColorGame();
            game.setVisible(true);
        });
    }
}
