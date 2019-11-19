import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BeginnerStory implements ActionListener {
	
	private JFrame frame = new JFrame();
	private JLabel label;
	private JButton optionButton1 = new JButton("Wake Up!");
	private JButton optionButton2 = new JButton("Don't Wake Up!");
	private JPanel storyPanel = new JPanel();
	private JPanel imagePanel = new JPanel();
	private JPanel buttonPanel = new JPanel();
	private int countUpdate;
	private boolean finishedStory = false;
	
	private Game game = new Game();
	
	
	public BeginnerStory()
	{
		frame.setSize(700, 700);
	    frame.setTitle("Minesweeper Madness");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   
	    optionButton1.setPreferredSize(new Dimension(200, 50));
	    optionButton2.setPreferredSize(new Dimension(200, 50));
	    optionButton1.addActionListener(this);
	    optionButton2.addActionListener(this);
	    storyPanel.setBackground(Color.BLACK);
	    buttonPanel.setBackground(Color.BLACK);
	    
	    countUpdate = 0;
	}
	
	public void beginnerStory()
	{
		Font font = new Font("Bell MT",Font.BOLD,20);
		
		label = new JLabel("HEY! WAKE UP!");
		
		label.setFont(font);
		
		label.setForeground(Color.WHITE);
		
		storyPanel.add(label);
		
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.LINE_AXIS));
		
		buttonPanel.add(optionButton1);
		buttonPanel.add(Box.createHorizontalGlue());
        buttonPanel.add(optionButton2);
        
        frame.setVisible(true);
		
        
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
			game.playGame(1);
		}
	}
	
	
	private void updateLabel()
	{
		if(countUpdate == 0)
		{
			label.setText("<html>Hey Come On! Get Up!<br/>Do You Want to Die Here!?!?</html>");
		}
		
		else if(countUpdate == 1)
		{
			label.setText("<html>What's with that Look!?<br/>"
					+ "...You Don't Know Where We Are!?!<br/>"
					+ "WAIT...Do You Even Know Who You Are!?!<br/>"
					+ "....OH GOD...WE ARE SO SCREWED!!!</html>");
		}
		
		else if(countUpdate == 2)
		{
			label.setText("<html>Okay, Okay! Geez...That Blast Must Have<br/>"
					+ "Knocked the Memories Right Out of You...<br/>"
					+ "Oh Well...We Should Be Fine....<br/>"
					+ "I Think....</html>");
		}
		
		else if(countUpdate == 3)
		{
			label.setText("<html>You Are the Great Minesweeper!!!!<br/>"
					+ "That's Right...You Are the Person Who is Legendary In This<br/>"
					+ "World For Being Able to Clear Mines On Any Battlefield,<br/>"
					+ "Dungeon, You Name It!</html>");
		}
		
		else if(countUpdate == 4)
		{
			label.setText("<html>....HAHAHAHA YEAH RIGHT!!!<br/>"
					+ "How Could YOU Ever Be the GREAT MINESWEEPER!?<br/>"
					+ "Oh God My Side Hurts From Laughing So Much!<br/>"
					+ "Thanks For That Laugh Kid I So Needed That Today!</html>");
		}
		
		else if(countUpdate == 5)
		{
			label.setText("<html>You're Just Thier Apprentice Who Was<br/>"
					+ "Sent to Deal With the Mines In This Tower.<br/>"
					+ "Though, I Guess You Are a Mediocre Apprentice <br/>"
					+ "Because You Completely Screwed Up and Ended Up<br/>"
					+ "Detonating a Mine!!</html>");
		}
		
		else if(countUpdate == 6)
		{
			label.setText("<html>You Are Lucky That the Blast Didn't Hit<br/>"
					+ "You Fully But You Notified the Enemy of Our Location<br/>"
					+ "And Got Us Locked Up In Here!<br/>"
					+ "So Thanks For That...</html>");
		}
		
		else if(countUpdate == 7)
		{
			label.setText("<html>*Sigh...We Have to Figure Out A Way to<br/>"
					+ "Get Back to the Rest of Our Team. I Broke Us Out<br/>"
					+ "Of Our Cell But the Dungeon Exit Has a Mine Puzzle<br/>"
					+ "Trap Blocking Us And I Have No Clue How To Solve It.</html>");
		}
		
		else if(countUpdate == 8)
		{
			label.setText("<html>Are You Sure You Won't Blow Us Up Again!?<br/>"
					+ "Well...I Guess I Have No Choie But To Trust You...<br/>"
					+ "But I Am Going to Take Cover In Our Cell Lest You Do<br/>"
					+ "Detonate Another Mine!! Stop Giving Me That Look!<br/>"
					+ "I Value My Life Okay!!</html>");
		}
		
		else if(countUpdate == 9)
		{
			label.setText("<html>Okay I'm Going to Give You These Orbs.<br/>"
					+ "When You Think There Is A Mine Under A Certain Tile<br/>"
					+ "Place the Orb on the Tile So It Can Neutralize the Mine.<br/>"
					+ "All Tiles With Mines Have to Have An Orb On It OtherWise<br/>"
					+ "The Orb Magic Won't Work!!</html>");
		}
		
		else if(countUpdate == 10)
		{
			label.setText("<html>Don't Look At Me Like That I Have No Idea<br/>"
					+ "What the Heck the Orb Magic Is!!<br/>"
					+ " What Am I, A Wizard!?!<br/>"
					+ "OH! Almost Forgot! You Also Need To Clear All Tiles <br/>"
					+ "In Order for the Orbs to Fully Work. When Clearing A Tile<br/>"
					+ "It Should Give You a Hint of How Many Mines Are Near That Tile.<br/>"
					+ "But You Knew That Since You Are the Apprentice of the Great MineSweeper!<br/>"
					+ "Okay Good Luck! Don't Die!<br/>"
					+ " And Most Importantly Don't Let Me Be Trapped Down Here!</html>");
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
			optionButton1.setText("But Who Am I!?");
			optionButton2.setText("Stay Silent");
		}
		
		else if(countUpdate == 2)
		{
			optionButton1.setText("Okay But Who Am I!?");
			optionButton2.setText("Scrutinize Knight");
		}
		
		else if(countUpdate == 3)
		{
			optionButton1.setText("Wow, I'm That Amazing!?");
			optionButton2.setText("Looks Suspiciously at Knight");
		}
		
		else if(countUpdate == 4)
		{
			optionButton1.setText("Wow You Are a Jerk");
			optionButton2.setText("Silently Ask God for Patience");
		}
		
		else if(countUpdate == 5)
		{
			optionButton1.setText("...I'm Sorry");
			optionButton2.setText("Wait...How Did I Not Die!?!");
		}
		
		else if(countUpdate == 6)
		{
			optionButton1.setText("...I'm Really Sorry!!");
			optionButton2.setText("You're Very Welcome!");
		}
		
		else if(countUpdate == 7)
		{
			optionButton1.setText("I Can Try...");
			optionButton2.setText("Um I'm A Minesweeper...");
		}
		
		else if(countUpdate == 8)
		{
			optionButton1.setText("Questions Internally How He Is A Knight");
			optionButton2.setText("You're Very Courageous...");
		}
		
		else if(countUpdate == 9)
		{
			optionButton1.setText("Thank You...");
			optionButton2.setText("What The Heck is Orb Magic?");
		}
		
		else if(countUpdate == 10)
		{
			optionButton1.setText("I Can Try...");
			optionButton2.setText("Questions IQ of Knight");
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
		
	}
	
	
	
	
	
	

}
