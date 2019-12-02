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

public class BeginnerStory implements ActionListener {
	
	private JFrame frame = new JFrame();
	private JLabel label;
	private JButton optionButton1 = new JButton("Wake Up");
	private JButton optionButton2 = new JButton("Continue To Sleep");
	private JButton skipButton = new JButton("Skip Story");
	private JPanel storyPanel = new JPanel();
	private JPanel buttonPanel = new JPanel();
	private JLabel imageLabel = new JLabel();
	private int countUpdate;
	private boolean finishedStory = false;
	private final int BEGINNER_LEVEL = 1;
	
	private Game game = new Game();
	private ImageClass image = new ImageClass();
	
	
	public BeginnerStory()
	{
		frame.setSize(900, 900);
	    frame.setTitle("Minesweeper Madness");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   
	    optionButton1.setPreferredSize(new Dimension(300, 50));
	    optionButton2.setPreferredSize(new Dimension(300, 50));
	    skipButton.setPreferredSize(new Dimension(300, 50));
	    
	    optionButton1.setBackground(Color.WHITE);
	    optionButton2.setBackground(Color.WHITE);
	    skipButton.setBackground(Color.WHITE);
	    
	    optionButton1.addActionListener(this);
	    optionButton2.addActionListener(this);
	    skipButton.addActionListener(this);
	    
	    storyPanel.setBackground(Color.BLACK);
	    buttonPanel.setBackground(Color.BLACK);
	    
	    countUpdate = 0;
	}
	
	public void beginnerStory()
	{
		Font font = new Font("Bell MT",Font.BOLD,20);
		
		label = new JLabel("<html>KNIGHT:<br/>HEY! WAKE UP!</html>");
		
		label.setFont(font);
		
		label.setForeground(Color.WHITE);
		
		imageLabel.setIcon(image.getKnightImage());
		
		storyPanel.add(imageLabel, BorderLayout.NORTH);
		storyPanel.add(label, BorderLayout.CENTER);
		
        buttonPanel.setLayout(new GridLayout(1,3, 2, 8));
        buttonPanel.add(optionButton1);
        buttonPanel.add(optionButton2);
        buttonPanel.add(skipButton);
        
        frame.add(storyPanel, BorderLayout.CENTER);
		frame.add(buttonPanel, BorderLayout.SOUTH);
		
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
	}
	
	
	public void startGame()
	{
		if(finishedStory != false)
		{
			frame.dispose();
			game.playGame(BEGINNER_LEVEL);
		}
	}
	
	
	private void updateLabel()
	{
		if(countUpdate == 0)
		{
			label.setText("<html>KNIGHT:<br/>"
					+ "Hey Come On! Get Up!<br/>Do You Want To Die Here!?!?</html>");
		}
		
		else if(countUpdate == 1)
		{
			label.setText("<html>KNIGHT:<br/>"
					+ "What's With That Look!?<br/>"
					+ "Ummm...You Don't Know Where We Are!?!<br/>"
					+ "WAIT...Do You Even Know Who You Are!?!<br/>"
					+ "....OH GOD...WE ARE SO SCREWED!!!</html>");
		}
		
		else if(countUpdate == 2)
		{
			label.setText("<html>KNIGHT:<br/>"
					+ "Okay, Okay! Geez...That Blast Must Have<br/>"
					+ "Knocked The Memories Right Out Of You...<br/>"
					+ "Oh Well...We Should Be Fine....<br/>"
					+ "I Think....</html>");
		}
		
		else if(countUpdate == 3)
		{
			label.setText("<html>KNIGHT:<br/>"
					+ "You Are The Great Minesweeper!!!!<br/>"
					+ "That's Right...You Are A Person Who is Legendary In This<br/>"
					+ "World For Being Able to Clear Mines On Any Battlefield,<br/>"
					+ "Dungeon, You Name It!</html>");
		}
		
		else if(countUpdate == 4)
		{
			label.setText("<html>KNIGHT:<br/>"
					+ "....HAHAHAHA YEAH RIGHT!!!<br/>"
					+ "How Could YOU Ever Be The GREAT MINESWEEPER!?<br/>"
					+ "Oh God! My Sides Hurt From Laughing So Much!<br/>"
					+ "Thanks For That Laugh!! I So Needed That Today!</html>");
		}
		
		else if(countUpdate == 5)
		{
			label.setText("<html>KNIGHT:<br/>"
					+ "You're Just The Great MineSweeper's Apprentice Who Was<br/>"
					+ "Sent To Deal With The Mines In This Tower.<br/>"
					+ "Though, I Guess You Are A Mediocre Apprentice <br/>"
					+ "Because You Completely Screwed Up and Ended Up<br/>"
					+ "Detonating A Mine And Almost Getting Us Killed!!</html>");
		}
		
		else if(countUpdate == 6)
		{
			label.setText("<html>KNIGHT:<br/>"
					+ "You Are Lucky That The Blast Didn't Hit<br/>"
					+ "You Fully But You Notified The Enemy Of Our Location!<br/>"
					+ "That Got Us Locked Up In Here!<br/>"
					+ "So Thanks For That...</html>");
		}
		
		else if(countUpdate == 7)
		{
			label.setText("<html>KNIGHT:<br/>"
					+ "*SIGH...<br/>"
					+ "We Have To Figure Out A Way To<br/>"
					+ "Get Back To The Rest of Our Team. I Broke Us Out<br/>"
					+ "Of Our Cell But the Dungeon Exit Has a Mine Puzzle<br/>"
					+ "Trap Blocking Us And I Have No Clue How To Solve It.</html>");
		}
		
		else if(countUpdate == 8)
		{
			label.setText("<html>KNIGHT:<br/>"
					+ "Are You Sure You Won't Blow Us Up Again!?<br/>"
					+ "Well...I Guess I Have No Choice But To Trust You...<br/>"
					+ "But I Am Going to Take Cover In Our Cell Lest You Do<br/>"
					+ "Detonate Another Mine!! Also, Stop Giving Me That Look!<br/>"
					+ "I Value My Life Okay!!</html>");
		}
		
		else if(countUpdate == 9)
		{
			label.setText("<html>KNIGHT:<br/>"
					+ "Okay I'm Going To Give You These Orbs.<br/>"
					+ "When You Think There Is A Mine Under A Certain Tile<br/>"
					+ "Place The Orb On The Tile So It Can Neutralize The Mine.<br/>"
					+ "All Tiles With Mines Have To Have An Orb On It Otherwise<br/>"
					+ "The Orb Magic Won't Work!!</html>");
		}
		
		else if(countUpdate == 10)
		{
			label.setText("<html>KNIGHT:<br/>"
					+ "Don't Look At Me Like That!!<br/>"
					+ "I Have No Idea What The Heck Orb Magic Is!!<br/>"
					+ "What Am I, A Wizard!?!<br/>"
					+ "OH! Almost Forgot! You Also Need To Clear All Surrounding Tiles<br/>"
					+ "In Order For The Orbs To Fully Work.<br/>"
					+ "When Clearing A Tile It Should Give You a Hint of How Many Mines<br/>"
					+ "Are Near That Tile.<br/>"
					+ "But You Knew That Since You Are the Apprentice of the Great MineSweeper!!<br/>"
					+ "Okay Good Luck! Don't Die!<br/>"
					+ "And Most Importantly Don't Let Me Be Trapped Down Here!</html>");
		}
		
		else 
		{
			finishedStory = true;
		}
	}
	
	private void updateButtonText()
	{
		if(countUpdate == 0)
		{
			optionButton1.setText("Get Up");
			optionButton2.setText("Get Up Reluctantly");
		}
		
		else if(countUpdate == 1)
		{
			optionButton1.setText("Ask Who You Are");
			optionButton2.setText("Stay Silent");
		}
		
		else if(countUpdate == 2)
		{
			optionButton1.setText("Ask Who You Are Again With Frustration");
			optionButton2.setText("Scrutinize Knight");
		}
		
		else if(countUpdate == 3)
		{
			optionButton1.setText("Exclaim How Amazing You Are");
			optionButton2.setText("Looks Suspiciously at Knight");
		}
		
		else if(countUpdate == 4)
		{
			optionButton1.setText("Criticize Knight For Being A Jerk");
			optionButton2.setText("Silently Ask God for Patience");
		}
		
		else if(countUpdate == 5)
		{
			optionButton1.setText("Apologize to Knight");
			optionButton2.setText("Question How You Did Not Die From Blast");
		}
		
		else if(countUpdate == 6)
		{
			optionButton1.setText("Apologize Half-Heartedly");
			optionButton2.setText("Proudly Accept Knight's Thanks");
		}
		
		else if(countUpdate == 7)
		{
			optionButton1.setText("Exclaim You Can Try");
			optionButton2.setText("Exclaim You Are A MineSweeper...");
		}
		
		else if(countUpdate == 8)
		{
			optionButton1.setText("Questions Internally How He Is A Knight");
			optionButton2.setText("Give A Thumbs Up And A Sarcastic Smile");
		}
		
		else if(countUpdate == 9)
		{
			optionButton1.setText("Thank Knight With A Confused Face");
			optionButton2.setText("Question Internally What Orb Magic Is");
		}
		
		else if(countUpdate == 10)
		{
			optionButton1.setText("Reluctantly Say You Will Try");
			optionButton2.setText("Swears To Self If You Die You Will Haunt Him");
		}
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == optionButton1)
		{
			updateLabel();
			updateButtonText();
			++countUpdate;
			startGame();
		}
		
		else if(e.getSource() == optionButton2)
		{
			updateLabel();
			updateButtonText();
			++countUpdate;
			startGame();
		}
		
		else if(e.getSource() == skipButton)
		{
			frame.dispose();
			game.playGame(BEGINNER_LEVEL);
		}
		
	}
	

}
