import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PlayAgain implements MouseListener {
	
	private JFrame frame = new JFrame();
	private JButton playAgainButton = new JButton("Play Level Again");
	private JButton playNextButton = new JButton("Play Next Level");
	private JButton startMenuButton = new JButton("Start Menu");
	private JButton exitButton = new JButton("Exit Game");
	private JPanel buttonPanel = new JPanel();
	private JPanel mainPanel = new JPanel();
	private JLabel imageLabel = new JLabel();
	private JLabel tittleLabel;
	private int currentLevel;
	private final int MAX_LEVEL = 3;
	
	private ImageClass image = new ImageClass();
	private Game game = new Game();
	@SuppressWarnings("unused")
	private Menu menu;
	
	
	public PlayAgain()
	{
		frame.setSize(900, 900);
	    frame.setTitle("Minesweeper Madness");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    mainPanel.setBackground(Color.BLACK);
	    buttonPanel.setBackground(Color.BLACK);
	    
	    playAgainButton.setPreferredSize(new Dimension(150, 60));
	    startMenuButton.setPreferredSize(new Dimension(150, 60));
	    exitButton.setPreferredSize(new Dimension(150, 60));
	    playNextButton.setPreferredSize(new Dimension(150, 60));
		
	}
	
	
	public void gameOver(int currentLevel)
	{
		this.currentLevel = currentLevel;
		
		tittleLabel = new JLabel("Game Over");
		Font font = new Font("Bell MT",Font.BOLD,55);
		
		//imageLabel.setIcon(image.getCrystalCaveImage());
		
		tittleLabel.setForeground(Color.WHITE);
		tittleLabel.setFont(font);
		
	    buttonPanel.setLayout(new GridLayout(3,1, 2, 8));
	    
	    playAgainButton.setBackground(Color.WHITE);
	    startMenuButton.setBackground(Color.WHITE);
	    exitButton.setBackground(Color.WHITE);
	    
	    playAgainButton.addMouseListener(this);
	    startMenuButton.addMouseListener(this);
	    exitButton.addMouseListener(this);
	    
	    buttonPanel.add(playAgainButton);
	    buttonPanel.add(startMenuButton);
	    buttonPanel.add(exitButton);
	    
	    
	    mainPanel.add(tittleLabel);
	    mainPanel.add(imageLabel);
	    
	    frame.add(buttonPanel, BorderLayout.SOUTH);
	    frame.add(mainPanel, BorderLayout.CENTER);
	    
	    frame.setResizable(false);
	    frame.setLocationRelativeTo(null);
	    frame.setVisible(true);
	    
	    Music.stop();
	}
	
	
	
	public void continueGame(int currentLevel)
	{
		this.currentLevel = currentLevel;
		
		if(currentLevel == MAX_LEVEL)
		{
			tittleLabel = new JLabel("Congragulations You Finished the Game!");
			Font font = new Font("Bell MT",Font.BOLD,55);
			
			//imageLabel.setIcon(image.getCrystalCaveImage());
			
			tittleLabel.setForeground(Color.WHITE);
			tittleLabel.setFont(font);
			
		    
		    mainPanel.add(tittleLabel);
		    mainPanel.add(imageLabel);
		    
		    frame.add(mainPanel, BorderLayout.CENTER);
		    
		    frame.setResizable(false);
		    frame.setLocationRelativeTo(null);
		    frame.setVisible(true);
		    
		    Music.stop();
		}
		
		else 
		{
			tittleLabel = new JLabel("Congragulations!");
			Font font = new Font("Bell MT",Font.BOLD,55);
			
			//imageLabel.setIcon(image.getCrystalCaveImage());
			
			tittleLabel.setForeground(Color.WHITE);
			tittleLabel.setFont(font);
			
		    buttonPanel.setLayout(new GridLayout(3,1, 2, 8));
		    
		    playNextButton.setBackground(Color.WHITE);
		    startMenuButton.setBackground(Color.WHITE);
		    exitButton.setBackground(Color.WHITE);
		    
		    playNextButton.addMouseListener(this);
		    startMenuButton.addMouseListener(this);
		    exitButton.addMouseListener(this);
		    
		    buttonPanel.add(playNextButton);
		    buttonPanel.add(startMenuButton);
		    buttonPanel.add(exitButton);
		    
		    
		    mainPanel.add(tittleLabel);
		    mainPanel.add(imageLabel);
		    
		    frame.add(buttonPanel, BorderLayout.SOUTH);
		    frame.add(mainPanel, BorderLayout.CENTER);
		    
		    frame.setResizable(false);
		    frame.setLocationRelativeTo(null);
		    frame.setVisible(true);
		    
		    Music.stop();
		}
		
		
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		
		if(e.getSource() == playAgainButton)
		{
			frame.dispose();
			game.playGame(currentLevel);
	
		}
		
		else if(e.getSource() == startMenuButton)
		{
			frame.dispose();
			menu = new Menu();
		}
		
		else if(e.getSource() == exitButton)
		{
			frame.dispose();
		}
		
		else if(e.getSource() == playNextButton)
		{
			frame.dispose();
			game.playGame(currentLevel + 1);
		}
		
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
