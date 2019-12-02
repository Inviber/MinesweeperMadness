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

public class ExpertStory implements ActionListener {
	
	private JFrame frame = new JFrame();
	private JLabel label;
	private JButton optionButton1 = new JButton("Walk Over");
	private JButton optionButton2 = new JButton("Sprint Over");
	private JButton skipButton = new JButton("Skip Story");
	private JPanel storyPanel = new JPanel();
	private JPanel buttonPanel = new JPanel();
	private JLabel imageLabel = new JLabel();
	private int countUpdate;
	private boolean finishedStory = false;
	private final int EXPERT_LEVEL = 3;
	
	private Game game = new Game();
	private ImageClass image = new ImageClass();
	
	
	public ExpertStory()
	{
		frame.setSize(900, 950);
	    frame.setTitle("Minesweeper Madness");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   
	    optionButton1.setPreferredSize(new Dimension(350, 50));
	    optionButton2.setPreferredSize(new Dimension(350, 50));
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
	
	public void expertStory()
	{
		Font font = new Font("Bell MT",Font.BOLD,20);
		
		label = new JLabel("<html>SORCERESS:<br/>Hey Over Here!</html>");
		
		label.setFont(font);
		label.setForeground(Color.WHITE);
		
		imageLabel.setIcon(image.getWarriorMageImage());
		
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
			game.playGame(EXPERT_LEVEL);
		}
	}
	
	
	private void updateLabel()
	{
		if(countUpdate == 0)
		{
			label.setText("<html>SORCERESS:<br/>"
					+ "You Finally Made It!<br/>"
					+ "I Thought Something Might Have Happened Along The Way!<br/>"
					+ "You Don't Look To Good Though?<br/>"
					+ "Do You Want To Rest For A Bit??</html>");
		}
		
		else if(countUpdate == 1)
		{
			label.setText("<html>WARRIOR:<br/>"
					+ "What Are You Talking About?!<br/>"
					+ "We Don't Have Time To Rest!!<br/>"
					+ "We Are Almost Out Of This Forsaken Place!!<br/>"
					+ "The Dragon Up Ahead Is Already On Edge!<br/>"
					+ "The Longer We Take The More Risk We Have Of It Finding Us<br/>"
					+ "And FLAYING US ALIVE!!!</html>");
		}
		
		else if(countUpdate == 2)
		{
			label.setText("<html>SORCERESS:<br/>"
					+ "Oh Stop Being Overdramatic!<br/>"
					+ "We Are Going To Be Just Fine!!<br/>"
					+ "I Mean Okay Two Of Our Group Members<br/>"
					+ "Have Alreayd Been Flayed Alive And Eaten<br/>"
					+ "BUT!!.................................................................<br/>"
					+ "Anyway We Will Be Fine!! I Think!!</html>");
		}
		
		else if(countUpdate == 3)
		{
			label.setText("<html>WARRIOR:<br/>"
					+ "YOU THINK!?!<br/>"
					+ "We've Got Two Men Down!!<br/>"
					+ "Our Survival Depends Soley On Them Not Screwing Up!<br/>"
					+ "They Are Not Even A Full Fledged MineSweeper!!!<br/>"
					+ "They're Still Just An Apprentice!! </html>");
		}
		
		else if(countUpdate == 4)
		{
			label.setText("<html>SORCERESS:<br/>"
					+ "*SIGH<br/>"
					+ "I Know That But We Have To Be OPTIMISTIC!!<br/>"
					+ "I Believe In Them Even If They Are Still Just An Apprentice!<br/>"
					+ "Everybody's Gotta Start Somewhere!</html>");
		}
		
		else if(countUpdate == 5)
		{
			label.setText("<html>WARRIOR:<br/>"
					+ "I Know I'm Just A Bit Tense.<br/>"
					+ "I Am A Pessimist By Nature Okay!<br/>"
					+ "Anyway You Do Realize If One Mine Explodes<br/>"
					+ "That Dragon Will Come Flying At Us With No Hesitation.<br/>"
					+ "Even If They Die In The Blast We Will Still Have To Deal<br/>"
					+ "With A Ticked Off Dragon!!!</html>");
		}
		
		else if(countUpdate == 6)
		{
			label.setText("<html>SORCERESS:<br/>"
					+ "Yes I Understand That But I'm Sure It'll Be Fine!<br/>"
					+ "All We Can Do Now Is Hope That Nothing Goes Wrong!!<br/>"
					+ "Hey Apprentice! Are You Up For This??<br/>"
					+ "This Will Deinitly Be The Hardest Mine Sweep<br/>"
					+ "And Lives Are On The Line!!<br/>"
					+ "One Wrong Move Can Send That Dragon Flying Our Way!</html>");
		}
		
		else if(countUpdate == 7)
		{
			label.setText("<html>SORCERESS:<br/>"
					+ "I Know You'll Do Great!<br/>"
					+ "I Mean Look How Far You've Come!!<br/>"
					+ "Don't Sweat The Hard Stuff And Just Take Your Time.<br/>"
					+ "No Matter What We've Got Your Back So We Are Trusting You<br/>"
					+ "To Successfully Clear The Mine Puzzle!!</html>");
		}
		
		else if(countUpdate == 8)
		{
			label.setText("<html>WARRIOR:<br/>"
					+ "*SIGH<br/>"
					+ "Whelp I Guess The Only Thing I Can Do Is Believe In You!<br/>"
					+ "I Mean You Have Screwed Up Before But I'm Sure You'll Do Fine...<br/>"
					+ "I Hope....<br/>"
					+ "Anyway Like She Said We Got Your Back So We Are Trusting You.</html>");
		}
		
		else if(countUpdate == 9)
		{
			label.setText("<html>WARRIOR:<br/>"
					+ "OH! By The Way, Where Is That Cowardly Knight And<br/>"
					+ "Weird Cat Wizard Thing???<br/>"
					+ "I Bet That Knight Stayed Behind And Is Waiting For Us To Get<br/>"
					+ "Past The Dragon So He Can Make His Escape.<br/>"
					+ "I Hope His Luck Is Bad And Runs Directly Into The Dragon<br/>"
					+ "When Trying To Make His Cowardly Escape!!</html>");
		}
		
		else if(countUpdate == 10)
		{
			label.setText("<html>SORCERESS:<br/>"
					+ "Hey Don't Say That!!<br/>"
					+ "Well Don't Say It Out Loud!<br/>"
					+ "You Might Have Jinxed Him To Not Run Into The Dragon!!<br/>"
					+ "The Cat Wizard Probably Got Distracted By<br/>"
					+ "Searching For More Eco-Friendly Fairies To Complement Itself With!<br/>"
					+ "Anyway We Should Get Going If We Want To Get Ahead Of The Dragon!</html>");
		}
		
		else if(countUpdate == 11)
		{
			label.setText("<html>WARRIOR:<br/>"
					+ "Okay Let's Get Going Then!<br/>"
					+ "Here Are Some Upgraded Orbs Which Should Be Able To Handle<br/>"
					+ "And Stabalize More Hidden Mines.<br/>"
					+ "Remember One Wrong Move And We Are All Dead!!<br/>"
					+ "We Are Almost To The Exit So Don't Screw Up!<br/>"
					+ "No Pressure Though!<br/>"
					+ "Good Luck! And Please Don't Mess Up!</html>");
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
			optionButton1.setText("Look Fatigued");
			optionButton2.setText("Look Around For A Comfortable Spot To Rest");
		}
		
		else if(countUpdate == 1)
		{
			optionButton1.setText("Prays That The Dragon Does Not Actually Exist");
			optionButton2.setText("Feel The Urge To Run Away");
		}
		
		else if(countUpdate == 2)
		{
			optionButton1.setText("Questions Optimism Of Sorceress");
			optionButton2.setText("Feel The Urge To Run Away Intensify");
		}
		
		else if(countUpdate == 3)
		{
			optionButton1.setText("Silently Agree With Warrior");
			optionButton2.setText("Judge Warrior While Believing You Are Awesome");
		}
		
		else if(countUpdate == 4)
		{
			optionButton1.setText("Looks Appreciatively At Sorceress");
			optionButton2.setText("Smile And Give A Thumbs Up To The Sorceress");
		}
		
		else if(countUpdate == 5)
		{
			optionButton1.setText("Feel The Urge To Run Away Again");
			optionButton2.setText("Pray That You Won't Mess Up");
		}
		
		else if(countUpdate == 6)
		{
			optionButton1.setText("Tries To Look Optimistically At Sorceress");
			optionButton2.setText("Agress Whole Heartedly You Can Do This");
		}
		
		else if(countUpdate == 7)
		{
			optionButton1.setText("Feel A Bit Of Pressure To Succeed");
			optionButton2.setText("Believe That You Can Do This");
		}
		
		else if(countUpdate == 8)
		{
			optionButton1.setText("Feel A Lot Of Pressure To Succeed");
			optionButton2.setText("Give A Thumbs Up To The Warrior");
		}
		
		else if(countUpdate == 9)
		{
			optionButton1.setText("Internally Hope The Cowardly Knight Meets The Dragon");
			optionButton2.setText("Wonder Where Wizard Cat Went To");
		}
		
		else if(countUpdate == 10)
		{
			optionButton1.setText("Mentally Prepare Yourself To Do This");
			optionButton2.setText("Reminiscing How Adorable Wizard Cat Is");
		}
		
		else if(countUpdate == 11)
		{
			optionButton1.setText("Give Both A Thumbs Up And Head Out");
			optionButton2.setText("Give Both A Nervous Smile And Head Out");
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
			game.playGame(EXPERT_LEVEL);
		}
		
	}
	
}
