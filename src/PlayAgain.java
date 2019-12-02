import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PlayAgain implements ActionListener {
	
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
	    
	    playAgainButton.setBackground(Color.WHITE);
	    startMenuButton.setBackground(Color.WHITE);
	    exitButton.setBackground(Color.WHITE);
	    playNextButton.setBackground(Color.WHITE);
	    
	    playAgainButton.setPreferredSize(new Dimension(150, 60));
	    startMenuButton.setPreferredSize(new Dimension(150, 60));
	    exitButton.setPreferredSize(new Dimension(150, 60));
	    playNextButton.setPreferredSize(new Dimension(150, 60));
	    
	    playAgainButton.addActionListener(this);
	    startMenuButton.addActionListener(this);
	    exitButton.addActionListener(this);
	    playNextButton.addActionListener(this);
		
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
			
			buttonPanel.setLayout(new GridLayout(2,1, 2, 8));
			buttonPanel.add(startMenuButton);
		    buttonPanel.add(exitButton);
		
		    mainPanel.add(tittleLabel);
		    mainPanel.add(imageLabel);
		    
		    frame.add(buttonPanel, BorderLayout.SOUTH);
		    frame.add(mainPanel, BorderLayout.CENTER);	    
		}
		
		else 
		{
			tittleLabel = new JLabel("Congragulations!");
			Font font = new Font("Bell MT",Font.BOLD,55);
			
			//imageLabel.setIcon(image.getCrystalCaveImage());
			
			tittleLabel.setForeground(Color.WHITE);
			tittleLabel.setFont(font);
			
		    buttonPanel.setLayout(new GridLayout(3,1, 2, 8));
		    
		    buttonPanel.add(playNextButton);
		    buttonPanel.add(startMenuButton);
		    buttonPanel.add(exitButton);
		    
		    
		    mainPanel.add(tittleLabel);
		    mainPanel.add(imageLabel);
		    
		    frame.add(buttonPanel, BorderLayout.SOUTH);
		    frame.add(mainPanel, BorderLayout.CENTER);
		    
		}
		
		frame.setResizable(false);
	    frame.setLocationRelativeTo(null);
	    frame.setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
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


}
