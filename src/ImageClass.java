
import javax.swing.ImageIcon;

public class ImageClass {
	
	
	private ImageIcon tiles; 
	private ImageIcon mine; 
	private ImageIcon orb; 
	
	private ImageIcon number0;
	private ImageIcon number1;
	private ImageIcon number2;
	private ImageIcon number3;
	private ImageIcon number4;
	private ImageIcon number5;
	private ImageIcon number6;
	private ImageIcon number7;
	private ImageIcon number8;
	
	
	
	public ImageClass()
	{
		tiles = new ImageIcon("Tile.png");
		mine = new ImageIcon("Mine.jpg");
		orb = new ImageIcon("Orb.png");
	
		number0 = new ImageIcon("Number0.png");
		number1 = new ImageIcon("Number1.png");
		number2 = new ImageIcon("Number2.png");
		number3 = new ImageIcon("Number3.png");
		number4 = new ImageIcon("Number4.png");
		number5 = new ImageIcon("Number5.png");
		number6 = new ImageIcon("Number6.png");
		number7 = new ImageIcon("Number7.png");
		number8 = new ImageIcon("Number8.png");	
	}
	
	
	public ImageIcon getTileImage()
	{
		return tiles;
	}
	
	
	public ImageIcon getMineImage()
	{
		return mine;
	}
	
	
	public ImageIcon getOrbImage()
	{
		return orb;
	}
	
	
	public ImageIcon getNumber0Image()
	{
		return number0;
	}
	
	
	public ImageIcon getNumber1Image()
	{
		return number1;
	}
	
	
	public ImageIcon getNumber2Image()
	{
		return number2;
	}
	
	
	public ImageIcon getNumber3Image()
	{
		return number3;
	}
	
	
	public ImageIcon getNumber4Image()
	{
		return number4;
	}
	
	
	public ImageIcon getNumber5Image()
	{
		return number5;
	}
	
	
	public ImageIcon getNumber6Image()
	{
		return number6;
	}
	
	
	public ImageIcon getNumber7Image()
	{
		return number7;
	}
	
	
	public ImageIcon getNumber8Image()
	{
		return number8;
	}
	

}
