package sdet21.GenericUtils;

import java.util.Random;

/**
 * This class has generic methods related java library
 * @author Chaitra M
 *
 */
public class JavaUtility {
	
	/**
	 * Return the random number to the caller
	 * @return
	 */
	public int getRandomNumber()
	{
	  Random ran = new Random();
	  int random = ran.nextInt(100);
	  return random;
	}
	

}
