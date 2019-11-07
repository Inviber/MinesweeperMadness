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

public class Menu implements MouseListener {
	
	private JFrame frame = new JFrame();
	private JButton level1Button = new JButton("Beginner Level");
	private JButton level2Button = new JButton("Intermediate Level");
	private JButton level3Button = new JButton("Expert Level");
	
	private ImageClass image = new ImageClass();
	
	
	Game game = new Game();
	
	
	public Menu()
	{
		JPanel levelPanel = new JPanel();
		JPanel gameTitlePanel = new JPanel();
		JLabel imageLabel = new JLabel();
		JLabel tittleLabel = new JLabel("Minesweeper Madness");
		Font font = new Font("Bell MT",Font.BOLD,55);
		
		imageLabel.setIcon(image.getCrystalCaveImage());
		
		tittleLabel.setForeground(Color.WHITE);
		tittleLabel.setFont(font);
		
		frame.setSize(900, 900);
	    frame.setTitle("Minesweeper Madness");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    levelPanel.setLayout(new GridLayout(3,1, 2, 8));
	    
	    gameTitlePanel.setBackground(Color.BLACK);
	    levelPanel.setBackground(Color.BLACK);
	    
	    
	    level1Button.setPreferredSize(new Dimension(150, 60));
	    level2Button.setPreferredSize(new Dimension(150, 60));
	    level3Button.setPreferredSize(new Dimension(150, 60));
	    
	    level1Button.setBackground(Color.WHITE);
	    level2Button.setBackground(Color.WHITE);
	    level3Button.setBackground(Color.WHITE);
	    
	    level1Button.addMouseListener(this);
	    level2Button.addMouseListener(this);
	    level3Button.addMouseListener(this);
	    
	    levelPanel.add(level1Button);
	    levelPanel.add(level2Button);
	    levelPanel.add(level3Button);
	    
	    
	    gameTitlePanel.add(tittleLabel);
	    gameTitlePanel.add(imageLabel);
	    
	    frame.add(levelPanel, BorderLayout.SOUTH);
	    frame.add(gameTitlePanel, BorderLayout.CENTER);
	    
	    frame.setResizable(false);
	    frame.setLocationRelativeTo(null);
	    frame.setVisible(true);
	    
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == level1Button)
		{
			frame.dispose();
			game.playGame(1);
		}
		
		else if(e.getSource() == level2Button)
		{
			frame.dispose();
			game.playGame(2);
		}
		
		else if(e.getSource() == level3Button)
		{
			frame.dispose();
			game.playGame(3);
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
