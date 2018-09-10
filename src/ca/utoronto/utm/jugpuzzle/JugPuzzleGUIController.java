package ca.utoronto.utm.jugpuzzle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Create a jug puzzle game.
 * 
 * @author Emilie
 *
 */

public class JugPuzzleGUIController {

	private JugPuzzleGUI view;
	private JugPuzzle model;
	private int from, to, fromjug, tojug;

	/**
	 * Create a jug puzzle game.
	 * 
	 * @param view
	 *            controls the GUI of the game
	 * @param model
	 *            controls the model of the game
	 */

	public JugPuzzleGUIController(JugPuzzleGUI view, JugPuzzle model) {
		this.view = view;
		this.model = model;
		this.view.addFromListeners(new FromButtonListener());
		this.view.addToListeners(new ToButtonListener());
		this.view.addQuitListener(new QuitButtonListener());
		this.view.addNewGameListener(new NewGameButtonListener());
	}

	/**
	 * Create and play the jug puzzle game.
	 * 
	 * @param args
	 *            are not used
	 */

	public static void main(String[] args) {
		JugPuzzleGUI view = new JugPuzzleGUI();
		JugPuzzle model = new JugPuzzle();
		new JugPuzzleGUIController(view, model);
	}

	/**
	 * This class waits to receive action events; in this case, when a user clicks
	 * one of the from buttons.
	 * 
	 * @author Emilie
	 *
	 */

	class FromButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand() == "8") {
				fromjug = 8;
				from = 0;
			}
			if (e.getActionCommand() == "5") {
				from = 1;
				fromjug = 5;
			}
			if (e.getActionCommand() == "3") {
				from = 2;
				fromjug = 3;
			}
			view.disableFromButtons();
			view.enableToButtons();
		}
	}

	/**
	 * This class waits to receive action events; in this case, when a user clicks
	 * one of the to buttons.
	 * 
	 * @author Emilie
	 *
	 */

	class ToButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand() == "8") {
				to = 0;
				tojug = 8;
			}
			if (e.getActionCommand() == "5") {
				to = 1;
				tojug = 5;
			}
			if (e.getActionCommand() == "3") {
				to = 2;
				tojug = 3;
			}
			view.enableFromButtons();
			view.disableToButtons();
			model.move(from, to);
			view.setNumMoves(Integer.toString(model.getMoves()));
			view.setAmount(fromjug, Integer.toString(model.jugs[from].getAmount()));
			view.setAmount(tojug, Integer.toString(model.jugs[to].getAmount()));
			if (model.getIsPuzzleSolved() == true) {
				view.disableFromButtons();
				view.disableToButtons();
				view.gameOver(Integer.toString(model.getMoves()));
			}
		}
	}

	/**
	 * This class waits to receive action events; in this case, when a user clicks
	 * the quit button.
	 * 
	 * @author Emilie
	 *
	 */

	class QuitButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			view.closeGame();
		}
	}

	/**
	 * This class waits to receive action events; in this case, when a user clicks
	 * the new game/play again button.
	 * 
	 * @author Emilie
	 *
	 */

	class NewGameButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			view.closeGame();
			JugPuzzleGUI newgui = new JugPuzzleGUI();
			JugPuzzle newmodel = new JugPuzzle();
			new JugPuzzleGUIController(newgui, newmodel);
		}
	}
}
