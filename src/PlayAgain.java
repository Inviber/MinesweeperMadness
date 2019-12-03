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
	private JLabel textLabel = new JLabel();
	private JLabel tittleLabel;
	private int currentLevel;
	private final int MAX_LEVEL = 3;
	
	private ImageClass image = new ImageClass();
	private IntermediateStory story2 = new IntermediateStory();
	private ExpertStory story3 = new ExpertStory();
	private Game game = new Game();
	@SuppressWarnings("unused")
	private Menu menu;
	
	
	public PlayAgain()
	{
		frame.setSize(900, 980);
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
		
		tittleLabel = new JLabel("Game Over!");
		Font font = new Font("Bell MT",Font.BOLD,55);
		
		gameOverImageTextOption(currentLevel);
		
		
		tittleLabel.setForeground(Color.WHITE);
		tittleLabel.setFont(font);
		
	    buttonPanel.setLayout(new GridLayout(3,1, 2, 8));
	   
	    buttonPanel.add(playAgainButton);
	    buttonPanel.add(startMenuButton);
	    buttonPanel.add(exitButton);
	     
	    mainPanel.add(tittleLabel);
	    mainPanel.add(imageLabel);
	    mainPanel.add(textLabel);
	    
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
			tittleLabel = new JLabel("Congratulations, You Finished the Game!");
			Font font = new Font("Bell MT",Font.BOLD, 35);
			
			tittleLabel.setForeground(Color.WHITE);
			tittleLabel.setFont(font);
			
			gameClearedImageTextOption(currentLevel);
			
			buttonPanel.setLayout(new GridLayout(2,1, 2, 8));
			buttonPanel.add(startMenuButton);
		    buttonPanel.add(exitButton);
		
		    mainPanel.add(tittleLabel);
		    mainPanel.add(imageLabel);
		    mainPanel.add(textLabel);
		    
		    frame.add(buttonPanel, BorderLayout.SOUTH);
		    frame.add(mainPanel, BorderLayout.CENTER);	    
		}
		
		else 
		{
			tittleLabel = new JLabel("Congratulations!");
			Font font = new Font("Bell MT",Font.BOLD,55);
			
			tittleLabel.setForeground(Color.WHITE);
			tittleLabel.setFont(font);
			
			gameClearedImageTextOption(currentLevel);
			
		    buttonPanel.setLayout(new GridLayout(3,1, 2, 8));
		    
		    buttonPanel.add(playNextButton);
		    buttonPanel.add(startMenuButton);
		    buttonPanel.add(exitButton);
		    
		    
		    mainPanel.add(tittleLabel);
		    mainPanel.add(imageLabel);
		    mainPanel.add(textLabel);
		    
		    frame.add(buttonPanel, BorderLayout.SOUTH);
		    frame.add(mainPanel, BorderLayout.CENTER);
		    
		}
		
		frame.setResizable(false);
	    frame.setLocationRelativeTo(null);
	    frame.setVisible(true);
	}
	
	public void gameOverImageTextOption(int currentLevel)
	{
		Font font = new Font("Bell MT",Font.BOLD, 20);
		textLabel.setForeground(Color.WHITE);
		
		if(currentLevel == 1)
		{
			imageLabel.setIcon(image.getAngryKnight());
			textLabel.setText("<html>ANGRY KNIGHT:<br/>"
					+ "OH MY GOD DID YOU DETONATE A MINE!?!?<br/>"
					+ "NOW WE ARE TRAPPED DOWN HERE ETERNALLY!!!<br/>"
					+ "NO, MORE IMPORTANTLY I AM TRAPPED DOWN HERE WITH YOU!!!!!<br/>"
					+ "GREAT! JUST GREAT!!<br/>"
					+ "I HOPE YOU ENJOY ROCKS AS FOOD CAUSE THAT'S WHAT WE WILL BE EATING<br/>"
					+ "FOR THE REST OF OUR LIVES!!!!!!!<br/>"
					+ "</html>");
			textLabel.setFont(font);
		}
		
		else if(currentLevel == 2)
		{
			imageLabel.setIcon(image.getSadWizardImage());
			textLabel.setText("<html>SAD WIZARD CAT:<br/>"
					+ "You Failed And Now We Are Trapped Down Here Forever....<br/>"
					+ "HOW WILL I EVER FIND A MORE ECO-FRIENDLY FAIRY MEOW!?!?<br/>"
					+ "ESPECIALLY ONE THAT DOES NOT SAY MEAN THINGS AGAINST<br/>"
					+ "A SAD, ADORABLE WIZARD CAT MEOW!!!<br/>"
					+ "YOU DEFINITELY DO NOT GET TO PET THE GREAT ME NOW MEOW MEOW!!!<br/>"
					+ "</html>");
			textLabel.setFont(font);
		}
		
		else if(currentLevel == 3)
		{
			imageLabel.setIcon(image.getAngryWarriorSorceress());
			textLabel.setText("<html>ANGRY WARRIOR:<br/>"
					+ "Did You Hear That...It's The Sound Of Our Incoming Death...<br/>"
					+ "There's No Where To Run...<br/>"
					+ "We Are So Going To Be Flayed Alive...<br/>"
					+ "Well I Guess This Is What We Get For Putting Our Hopes On An Apprentice.<br/>"
					+ "DISSAPOINTED SORCERESS:<br/>"
					+ "I'm Usually An Optimistic Person But....Even I Cannot See The Hope In This Situation...<br/>"
					+ "</html>");
			textLabel.setFont(font);
		}
	}
	
	
	public void gameClearedImageTextOption(int currentLevel)
	{
		Font font = new Font("Bell MT",Font.BOLD, 20);
		textLabel.setForeground(Color.WHITE);
		
		if(currentLevel == 1)
		{
			imageLabel.setIcon(image.getHappyKnight());
			textLabel.setText("<html>HAPPY KNIGHT:<br/>"
					+ "Good Job!! I TOTALLY BELIEVED You Could Do It!<br/>"
					+ "Definitely Did Not Think You Would Trap Us Down Here!!<br/>"
					+ "Anyway, You Go On Ahead! I'm Going To Wait Here Cause You Know...<br/>"
					+ "It's Best That I Stay Here In Case Anything Happens...Yeah...<br/>"
					+ "IT'S TOTALLY NOT BECAUSE I'M A COWARD OKAY!!<br/>"
					+ "Good Luck!! Let Me Know When You've Finished Clearing The Tower<br/>"
					+ "So I Can Esca...I Mean Help You Exit Safely!!<br/>"
					+ "</html>");
			textLabel.setFont(font);
		}
		
		else if(currentLevel == 2)
		{
			imageLabel.setIcon(image.getHappyWizardImage());
			textLabel.setText("<html>HAPPY WIZARD CAT:<br/>"
					+ "YOU DID IT MEOW!! I KNEW YOU COULD!!<br/>"
					+ "My Eco-Friendly Fairy Says That She Is Proud Of You As Well!!<br/>"
					+ "She Also Says I Should Let You Pet Me BUT I THINK NOT MEOW!!<br/>"
					+ "Well...Not Until We Get Out Of Here Meow!<br/>"
					+ "If We Make It Alive In One Piece Then I Shall Let You Pet<br/>"
					+ "My Powerful And Adorable Self A Few Times!!<br/>"
					+ "Be Grateful Human Because I Usually Don't Let Just Anyone Pet The Great Me Meow!!<br/>"
					+ "Good Luck Human Meow!! I Know You Can Get Us Out Of Here Meow Meow!!<br/>"
					+ "</html>");
			textLabel.setFont(font);
		}
		
		else if(currentLevel == 3)
		{
			imageLabel.setIcon(image.getHappyWarriorSorceress());
			textLabel.setText("<html>PROUD WARRIOR:<br/>"
					+ "Well You Did A Good Job!!<br/>"
					+ "We Successfully Escaped That Evil Dragon!<br/>"
					+ "Thank You For Helping Us Get Out! I'm Glad I Put My Trust In You!<br/>"
					+ "<br/>"
					+ "PROUD SORCERESS:<br/>"
					+ "You Did Amazing!! I Had Confidence In You This Entire Time!!!<br/>"
					+ "I'm Sure You Will Be A Mighty Fine Minesweeper One Day And<br/>"
					+ "I Believe You Just Took A Step Closer To That Goal!!<br/>"
					+ "The Wizard Cat and Knight Have Already Left So Lets Get Out Of Here!!<br/>"
					+ "</html>");
			textLabel.setFont(font);
		}
	}
	

	public void nextLevelStory(int currentLevel)
	{
		if(currentLevel == 1)
		{
			story2.intermediateStory();
		}
		
		else if(currentLevel == 2)
		{
			story3.expertStory();
		}
		
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
			
			nextLevelStory(currentLevel);
		}
		
	}


}
