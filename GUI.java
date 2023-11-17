import java.awt.Container; 				//(awt stand for Abstract Window Toolkit)
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

	public class GUI extends JFrame
	{
		private Container pane; //hold content pane
		private String currentPlayer; //current player 
		private JButton [][] board; //2D array board
		private boolean hasWinner; //whether or not we have a winner
		private JMenuBar menuBar; 
		private JMenu menu;
		private JMenuItem quit;
		private JMenuItem newGame;
		
		
		//constructor
		public GUI() 
		{
			super(); //calls parent class
			pane = this.getContentPane();
			pane.setLayout(new GridLayout(3,3));
			setTitle("Tic Tac Toe");
			setSize(500,500);
			setResizable(false);
			setDefaultCloseOperation(DISPOSE_ON_CLOSE); //used to specify one of several options for the close button
			setVisible(true);
			currentPlayer = "X";
			board = new JButton[3][3];
			hasWinner = false;
			initializeBoard();
			initializeMenuBar();
		}
		
		//methods
		private void initializeMenuBar() 
		{
			menuBar = new JMenuBar();
			menu = new JMenu("File");
			
			newGame = new JMenuItem("New Game");
			newGame.addActionListener (new ActionListener()
			{
				
				@Override
				public void actionPerformed(ActionEvent e) 
				{
					resetBoard(); //resets the board
				}
			});
			quit = new JMenuItem("Quit");
			quit.addActionListener (new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{
					System.exit(0); //terminate the program
				}
			});
			menu.add(newGame);
			menu.add(quit);
			menuBar.add(menu);
			setJMenuBar (menuBar);
		}
		
		private void resetBoard()
		{
			currentPlayer = "X";
			hasWinner = false;
			for(int i = 0; i < 3; i++)
			{
				for (int j = 0; j <3; j++)//nested for loop
				{
					board[i][j].setText("");
				}
			}
			
		}
		
		private void initializeBoard()
		{
			for(int i = 0; i <3; i++)
			{
				for (int j = 0; j < 3; j++) //nested for loop
				{
					JButton btn = new JButton("");
					btn.setFont(new Font(Font.SANS_SERIF,Font.BOLD,100));
					board[i][j] = btn;
					btn.addActionListener(new ActionListener()
					{
						@Override
						public void actionPerformed(ActionEvent e)
						{
							if (((JButton)e.getSource()).getText().equals("") && //checks if its a valid move
							hasWinner == false) 
								{
									btn.setText(currentPlayer);
									hasWinner();
									togglePlayer();
								}
						}
					});
					pane.add(btn);
				}
			}
		}
		
		
		private void togglePlayer()
		{
			if (currentPlayer.equals("X"))
				currentPlayer = "O";
			else
				currentPlayer = "X";
		}
		
		private void hasWinner()
		{		//Vertically
				if (board[0][0].getText().equals(currentPlayer) && board[1][0].getText().equals(currentPlayer) && board[2][0].getText().equals(currentPlayer)) 
				{
				JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " Wins");
				hasWinner = true;
				}
				else if (board[0][1].getText().equals(currentPlayer) && board[1][1].getText().equals(currentPlayer) && board[2][1].getText().equals(currentPlayer)) 
				{
				JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " Wins");
				hasWinner = true;
				}
				else if (board[0][2].getText().equals(currentPlayer) && board[1][2].getText().equals(currentPlayer) && board[2][2].getText().equals(currentPlayer)) 
				{
				JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " Wins");
				hasWinner = true;
				}
				//Horizontally
				else if (board[0][0].getText().equals(currentPlayer) && board[0][1].getText().equals(currentPlayer) && board[0][2].getText().equals(currentPlayer)) 
				{
				JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " Wins");
				hasWinner = true;
				}
				else if (board[1][0].getText().equals(currentPlayer) && board[1][1].getText().equals(currentPlayer) && board[1][2].getText().equals(currentPlayer)) 
				{
				JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " Wins");
				hasWinner = true;
				}
				else if (board[2][0].getText().equals(currentPlayer) && board[2][1].getText().equals(currentPlayer) && board[2][2].getText().equals(currentPlayer)) 
				{
				JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " Wins");
				hasWinner = true;
				}
				//Diagonally
				else if (board[0][0].getText().equals(currentPlayer) && board[1][1].getText().equals(currentPlayer) && board[2][2].getText().equals(currentPlayer)) 
				{
				JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " Wins");
				hasWinner = true;
				}
				else if (board[0][2].getText().equals(currentPlayer) && board[1][1].getText().equals(currentPlayer) && board[2][0].getText().equals(currentPlayer)) 
				{
				JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " Wins");
				hasWinner = true;
				}
				
				
		}
	}
	
