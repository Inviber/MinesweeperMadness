
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

public class IntermediateStory implements ActionListener {
	
	private JFrame frame = new JFrame();
	private JLabel label;
	private JButton optionButton1 = new JButton("Look Around");
	private JButton optionButton2 = new JButton("Walk Around");
	private JButton skipButton = new JButton("Skip Story");
	private JPanel storyPanel = new JPanel();
	private JPanel buttonPanel = new JPanel();
	private JLabel imageLabel = new JLabel();
	private int countUpdate;
	private boolean finishedStory = false;
	private final int INTERMEDIATE_LEVEL = 2;
	
	private Game game = new Game();
	private ImageClass image = new ImageClass();
	
	
	public IntermediateStory()
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
	
	public void intermediateStory()
	{
		Font font = new Font("Bell MT",Font.BOLD,20);
		
		label = new JLabel("<html>WIZARD CAT:<br/>HEY! OVER HERE MEOW!</html>");
		
		label.setFont(font);
		label.setForeground(Color.WHITE);
		
		imageLabel.setIcon(image.getWizardImage());
		
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
			game.playGame(INTERMEDIATE_LEVEL);
		}
	}
	
	
	private void updateLabel()
	{
		if(countUpdate == 0)
		{
			label.setText("<html>WIZARD CAT:<br/>"
					+ "You're Late!!<br/>What Took You So Long Meow??</html>");
		}
		
		else if(countUpdate == 1)
		{
			label.setText("<html>WIZARD CAT:<br/>"
					+ "Where Are You Looking!?<br/>"
					+ "I'm Down Here For Crying Out Loud Meow!!<br/>"
					+ "How Can You Miss The SUPER SHINY Sword I'm Holding!?!<br/>"
					+ "Or Miss My Glow In The Dark Sceptar That's Powered By An<br/>"
					+ "Eco Freindly Fariy!!!</html>");
		}
		
		else if(countUpdate == 2)
		{
			label.setText("<html>WIZARD CAT:<br/>"
					+ " What's With That Look You Are Giving Me Meow??<br/>"
					+ "Are You Questioning The SUPER SHININESS OF MY SWORD?!?<br/>"
					+ "Or Maybe...Are You Questioning If My Fairy is ECO FRIENDLY?!?<br/>"
					+ "Try Me Human!! I'll See How Long You Can Last Againt The Great Me MEOW!!</html>");
		}
		
		else if(countUpdate == 3)
		{
			label.setText("<html>WIZARD CAT:<br/>"
					+ "Wait...Are You Confused With My Identity??<br/>"
					+ "Have You Never Seen A Wizard Cat Before Meow??<br/>"
					+ "Well That's Just Sad Human!<br/>"
					+ "Us Wizard Cats Are Both POWERFUL AND ADORABLE MEOW MEOW!</html>");
		}
		
		else if(countUpdate == 4)
		{
			label.setText("<html>WIZARD CAT:<br/>"
					+ "I Know You Must Be Awestruck With My Great Self Meow!!<br/>"
					+ "But We Are Not Here To Admire My Amazing Self Meow!<br/>"
					+ "We Have Business To Get Down To! Yes Very Important Business Meow!!<br/>"
					+ "Hello?? Are You Listening Human??</html>");
		}
		
		else if(countUpdate == 5)
		{
			label.setText("<html>WIZARD CAT:<br/>"
					+ "*HISS <br/>"
					+ "DON'T TRY TO PET ME HUMAN!!<br/>"
					+ "I May Be Abosultely Adorable and Awe-Inspiringly Powerful BUT!!!<br/>"
					+ "I HAVE STANDARDS MEOW!!!!<br/>"
					+ "Not Just ANYONE Can Pet Me! You Must Be Worthy First!!</html>");
		}
		
		else if(countUpdate == 6)
		{
			label.setText("<html>WIZARD CAT:<br/>"
					+ "To Be Worthy You Must Become A Great MineSweeper Meow!!<br/>"
					+ "You're Still Just An Apprentice But...<br/>"
					+ "I'm Sure One Day...<br/>"
					+ "You'll Be Just As Great As Your Master Meow!!<br/>"
					+ "Maybe If You Work Hard Enough You Might Even Surpass Them!</html>");
		}
		
		else if(countUpdate == 7)
		{
			label.setText("<html>WIZARD CAT:<br/>"
					+ "I Know You Don't Have To Say It Meow!<br/>"
					+ "I'm A Very Kind Hearted, Encouraging, And Super Awesome Wizard Cat MEOW!!<br/>"
					+ "What's That....OH I ALMOST FORGOT WHY WE ARE HERE!!!<br/>"
					+ "My Eco Friendly Fairy Has Reminded Me To Get Back to Business Meow!!<br/>"
					+ "Some Unnecessary Comments Were Made About How Narcissistic I Am BUT<br/>"
					+ "I Believe That I'm Just Expressing Positivity...About Myself MEOW!! </html>");
		}
		
		else if(countUpdate == 8)
		{
			label.setText("<html>WIZARD CAT:<br/>"
					+ "*SIGH<br/>"
					+ "Maybe I'll Just Upgrade To An Even More Eco Friendly Fairy Meow!!<br/>"
					+ "One That Does Not Have Any Disparaging Comments About Cute Wizard Cats!!<br/>"
					+ "Anyway!! Where Is The Cowardly Kni...I Mean Super Brave Knight??<br/>"
					+ "Wasn't He With You Down In The Dungeons Meow??</html>");
		}
		
		else if(countUpdate == 9)
		{
			label.setText("<html>WIZARD CAT:<br/>"
					+ "OH! He Decided To Stay Behind Meow...<br/>"
					+ "Well That's Not A Surprise...<br/>"
					+ "He's Probably Waiting For You To Clear The Entire Tower<br/>"
					+ "So That He Won't Encounter Any Danger While He's Escaping Meow...<br/>"
					+ "Whelp Guess It's Just Going To Be You And Me Meow!</html>");
		}
		
		else if(countUpdate == 10)
		{
			label.setText("<html>WIZARD CAT:<br/>"
					+ "Okay It's Really Just Going To Be You Clearing The Mines Meow!<br/>"
					+ "But I Will Provide You With Moral Support From Fifty Meters Away!<br/>"
					+ "What?? I May Be A Wizard Cat But I'm An ADORABLE WIZARD CAT MEOW!!<br/>"
					+ "I Am Not Good With Figuring Out Where Mines Are Hidden!<br/>"
					+ "Plus My Magic Is Not Suited To Dealing With Highly Sensitive Mines That<br/>"
					+ "Could Potentailly Explode If I Use Too Much Magic Or Too Little Magic Meow!!</html>");
		}
		
		else if(countUpdate == 11)
		{
			label.setText("<html>WIZARD CAT:<br/>"
					+ "Anyway Your Job Desciption Is Literally To Sweep Mines Okay Meow!!<br/>"
					+ "Now Get To It!! I Also Want To Leave This Tower As Soon As Possible!!<br/>"
					+ "Oh And Here Are Some Upgraded Orbs Meow!<br/>"
					+ "These Can Handle And Stabalize More Hidden Mines!<br/>"
					+ "Good Luck Meow Meow!!</html>");
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
			optionButton1.setText("Look Around Confusedly");
			optionButton2.setText("Wonder If Ghosts Exist");
		}
		
		else if(countUpdate == 1)
		{
			optionButton1.setText("Stare At Talking Cat In Confusion");
			optionButton2.setText("Ponder If You Are Going Slightly Insane");
		}
		
		else if(countUpdate == 2)
		{
			optionButton1.setText("Continue To Look Confusedly At Talking Cat");
			optionButton2.setText("Internally Square Up");
		}
		
		else if(countUpdate == 3)
		{
			optionButton1.setText("Internally Agree That Wizard Cat Is Adorable");
			optionButton2.setText("Have Urge To Pet Wizard Cat");
		}
		
		else if(countUpdate == 4)
		{
			optionButton1.setText("Reach Out To Pet Powerful Wizard Cat");
			optionButton2.setText("Reach Out To Pet Adorable Wizard Cat");
		}
		
		else if(countUpdate == 5)
		{
			optionButton1.setText("Stares Sadly At Wizard Cat");
			optionButton2.setText("Ask How To Be Worthy So You Can Pet");
		}
		
		else if(countUpdate == 6)
		{
			optionButton1.setText("Feel Encouraged From Wizard Cat's Words");
			optionButton2.setText("Urge Intensifies To Pet Wizard Cat");
		}
		
		else if(countUpdate == 7)
		{
			optionButton1.setText("Internally Agree With Positive Wizard Cat");
			optionButton2.setText("Internally Agree With Eco-Friendly Fairy");
		}
		
		else if(countUpdate == 8)
		{
			optionButton1.setText("Say How He Bravely Devided To Stay Behind");
			optionButton2.setText("Say How He Corageously Stayed Behind");
		}
		
		else if(countUpdate == 9)
		{
			optionButton1.setText("Scrutinize The Wizard Cat");
			optionButton2.setText("Cheer Internally About Knight Staying Behind");
		}
		
		else if(countUpdate == 10)
		{
			optionButton1.setText("Questions Internally Wizard Cat's Abilities");
			optionButton2.setText("Agrees With Wizard Cat And Has Urge To Pet");
		}
		
		else if(countUpdate == 11)
		{
			optionButton1.setText("Give Wizard Cat Thumbs Up And Head Out");
			optionButton2.setText("Give Wizard Cat Flying Kiss And Head Out");
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
			game.playGame(INTERMEDIATE_LEVEL);
		}
		
	}
	
	

}