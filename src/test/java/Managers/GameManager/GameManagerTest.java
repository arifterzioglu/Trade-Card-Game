package Managers.GameManager;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class GameManagerTest {
	
	GameManager gameManager;
	@Before
	public void setUp() throws Exception {
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		gameManager = context.getBean("gameManager", GameManager.class);
		gameManager.initializeGame();
	}

	@Test
	public void drawCardsAtTheBeginnigTest()
	{
		//TODO:Arif
	}
	
	@Test
	public void drawCardActionTest()
	{
		//TODO:Arif
	}
	
	@Test
	public void playCardActionTest(int selectedCardIndex)
	{
		//TODO:Arif
	}
	
	@Test
	public void emptyCardDeckPenaltyActionTest()
	{
		//TODO:Arif
	}
	
	@Test
	public void refillManaOfCurrentPlayerTest()
	{
		//TODO:Arif
	}

}
