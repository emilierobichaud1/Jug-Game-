package ca.utoronto.utm.jugpuzzle;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

/**
 * 
 * Create the GUI for the jug puzzle game.
 * 
 * @author Emilie
 *
 *
 */
public class JugPuzzleGUI {

	private JFrame frame;

	private JLabel titleLabel = new JLabel("Welcome to the Jug Puzzle Game!");
	private JLabel subTitleLabel = new JLabel(
			"The goal of the game is to get 4 units of water into the first two jugs.");

	private JPanel contentPanel;
	private JPanel titlePanel;
	private JPanel gamePanel;
	private JPanel buttonPanel;

	private JLabel amountLabel = new JLabel("Amount: ");
	private JTextField jug8Amount = new JTextField("8");
	private JTextField jug5Amount = new JTextField("0");
	private JTextField jug3Amount = new JTextField("0");

	private JLabel fromLabel = new JLabel("From: ");
	private JButton from8Button = new JButton("8");
	private JButton from5Button = new JButton("5");
	private JButton from3Button = new JButton("3");

	private JLabel toLabel = new JLabel("To: ");
	private JButton to8Button = new JButton("8");
	private JButton to5Button = new JButton("5");
	private JButton to3Button = new JButton("3");

	private JLabel winner = new JLabel();

	private JButton newGameButton = new JButton("New Game");
	private JButton quitButton = new JButton("Quit");

	private JLabel moveLabel = new JLabel("Moves: ");
	private JLabel numOfMovesLabel = new JLabel("0");

	/**
	 * Construct the jug puzzle GUI.
	 */

	public JugPuzzleGUI() {
		frame = new JFrame("Jug Puzzle");
		createGUI();
		;
	}

	private void createGUI() {
		// set some defaults for the application window
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 400);

		// different panels that make up the frame
		contentPanel = new JPanel(new GridLayout(0, 1));
		titlePanel = new JPanel(new GridLayout(4, 1));
		buttonPanel = new JPanel(new GridBagLayout());
		gamePanel = new JPanel(new GridLayout(4, 4));
		// styling
		Border padding = BorderFactory.createEmptyBorder(15, 15, 15, 15);
		contentPanel.setBorder(padding);

		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 20;
		c.weightx = 0.4;
		c.gridx = 0;
		c.gridy = 0;

		GridBagConstraints d = new GridBagConstraints();
		d.fill = GridBagConstraints.HORIZONTAL;
		d.ipady = 20;
		d.weightx = 0.5;
		d.gridx = 1;
		d.gridy = 0;

		winner.setHorizontalAlignment(JLabel.CENTER);
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		titleLabel.setFont(new Font("Times", Font.PLAIN, 16));
		subTitleLabel.setHorizontalAlignment(JLabel.CENTER);
		subTitleLabel.setFont(new Font("Verdana", Font.ITALIC, 12));

		jug8Amount.setEditable(false);
		jug8Amount.setHorizontalAlignment(JLabel.CENTER);
		jug5Amount.setEditable(false);
		jug5Amount.setHorizontalAlignment(JLabel.CENTER);
		jug3Amount.setEditable(false);
		jug3Amount.setHorizontalAlignment(JLabel.CENTER);

		to8Button.setEnabled(false);
		to5Button.setEnabled(false);
		to3Button.setEnabled(false);

		// add components to panels
		titlePanel.add(titleLabel);
		titlePanel.add(subTitleLabel);
		titlePanel.add(winner);

		buttonPanel.add(newGameButton, c);
		buttonPanel.add(quitButton, d);

		gamePanel.add(amountLabel);
		gamePanel.add(jug8Amount);
		gamePanel.add(jug5Amount);
		gamePanel.add(jug3Amount);
		gamePanel.add(fromLabel);
		gamePanel.add(from8Button);
		gamePanel.add(from5Button);
		gamePanel.add(from3Button);
		gamePanel.add(toLabel);
		gamePanel.add(to8Button);
		gamePanel.add(to5Button);
		gamePanel.add(to3Button);
		gamePanel.add(moveLabel);
		gamePanel.add(numOfMovesLabel);

		// add panels to frame
		frame.setContentPane(contentPanel);
		frame.add(titlePanel);
		frame.add(buttonPanel);
		frame.add(gamePanel);

		// pack and display
		frame.pack();
		frame.setVisible(true);
	}

	/**
	 * Set the number of moves label on the GUI.
	 * 
	 * @param s
	 */

	public void setNumMoves(String s) {
		numOfMovesLabel.setText(s);
	}

	/**
	 * Set the amount of the jug.
	 * 
	 * @param jug
	 *            0, 1 or 2
	 * @param amount
	 *            a non-negative integer
	 */

	public void setAmount(int jug, String amount) {
		if (jug == 8)
			jug8Amount.setText(amount);
		if (jug == 5)
			jug5Amount.setText(amount);
		if (jug == 3)
			jug3Amount.setText(amount);
	}

	/**
	 * Get the amount in the jug.
	 * 
	 * @param jug
	 *            0, 1 or 2
	 * @return a non-negative integer
	 */

	public int getAmount(int jug) {
		if (jug == 8)
			return Integer.parseInt(jug8Amount.getText());
		if (jug == 5)
			return Integer.parseInt(jug5Amount.getText());
		if (jug == 3)
			return Integer.parseInt(jug3Amount.getText());
		return -1;
	}

	/**
	 * Disable all the from buttons.
	 */

	public void disableFromButtons() {
		this.from3Button.setEnabled(false);
		this.from5Button.setEnabled(false);
		this.from8Button.setEnabled(false);
	}

	/**
	 * Enable all the from buttons.
	 */

	public void enableFromButtons() {
		this.from3Button.setEnabled(true);
		this.from5Button.setEnabled(true);
		this.from8Button.setEnabled(true);
	}

	/**
	 * Disable all the to buttons.
	 */

	public void disableToButtons() {
		this.to3Button.setEnabled(false);
		this.to5Button.setEnabled(false);
		this.to8Button.setEnabled(false);
	}

	/**
	 * Enable all the to buttons.
	 */
	public void enableToButtons() {
		this.to3Button.setEnabled(true);
		this.to5Button.setEnabled(true);
		this.to8Button.setEnabled(true);
	}

	/**
	 * Add action listeners to all the from buttons.
	 * 
	 * @param fromListener
	 *            listen for from buttons
	 */

	public void addFromListeners(ActionListener fromListener) {
		from8Button.addActionListener(fromListener);
		from5Button.addActionListener(fromListener);
		from3Button.addActionListener(fromListener);
	}

	/**
	 * Add action listeners to all the to buttons.
	 * 
	 * @param toListener
	 *            listen for to buttons
	 */

	void addToListeners(ActionListener toListener) {
		to8Button.addActionListener(toListener);
		to5Button.addActionListener(toListener);
		to3Button.addActionListener(toListener);
	}

	/**
	 * Add action listener to the quit button.
	 * 
	 * @param quitListener
	 *            listen for quit button
	 */

	public void addQuitListener(ActionListener quitListener) {
		quitButton.addActionListener(quitListener);
	}

	/**
	 * Add action listener to the new game button.
	 * 
	 * @param newGameListener
	 *            listen for new game button
	 */

	public void addNewGameListener(ActionListener newGameListener) {
		newGameButton.addActionListener(newGameListener);
	}

	/**
	 * Change the GUI for when the game is over.
	 * 
	 * @param s
	 *            the number of moves it took to win the game
	 */

	public void gameOver(String s) {
		winner.setFont(new Font("Winner Font", Font.BOLD, 16));
		this.winner.setText("Congrats! You won the game in " + s + " moves!");
		this.newGameButton.setText("Play Again");

	}

	/**
	 * Close the game.
	 */

	public void closeGame() {
		frame.dispose();
	}
}
