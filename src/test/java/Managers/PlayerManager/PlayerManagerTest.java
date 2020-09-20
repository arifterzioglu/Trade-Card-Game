package Managers.PlayerManager;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import Constants.Constants;
import Managers.Interface.IPlayerManager;



public class PlayerManagerTest {

	IPlayerManager playerManager;
	@Before
	public void setUp() throws Exception {
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		playerManager = context.getBean("playerManager", IPlayerManager.class);
		playerManager.initializePlayers();
	}

	@Test
	public void PlayerInitializationTest() {
		int sizeOfInitialDeckPlayerOne = playerManager.getFirstPlayer().getCardDeck().getNumberOfCardsInTheList();
		int sizeOfInitialDeckPlayerTwo = playerManager.getSecondPlayer().getCardDeck().getNumberOfCardsInTheList();
		
		int sizeOfInitialManaPlayerOne = playerManager.getFirstPlayer().getManaSlots().getCurrentAmountOfSlots();
		int sizeOfInitialManaPlayerTwo =  playerManager.getSecondPlayer().getManaSlots().getCurrentAmountOfSlots();
				
		int sizeOfInitialHealthPlayerOne = playerManager.getFirstPlayer().getHealthSlots().getCurrentAmountOfSlots();
		int sizeOfInitialHealthPlayerTwo = playerManager.getSecondPlayer().getHealthSlots().getCurrentAmountOfSlots();
		
		assertEquals( Constants.NUMBER_OF_DAMAGE_CARDS, sizeOfInitialDeckPlayerOne);
		assertEquals( Constants.NUMBER_OF_DAMAGE_CARDS, sizeOfInitialDeckPlayerTwo);
		
		assertEquals( Constants.INITIAL_AMOUNT_OF_MANA_SLOTS, sizeOfInitialManaPlayerOne);
		assertEquals( Constants.INITIAL_AMOUNT_OF_MANA_SLOTS, sizeOfInitialManaPlayerTwo);
		
		assertEquals( Constants.INITIAL_AMOUNT_OF_HEALTH, sizeOfInitialHealthPlayerOne);
		assertEquals( Constants.INITIAL_AMOUNT_OF_HEALTH, sizeOfInitialHealthPlayerTwo);
		
	}


	@Test
	public void setNextTurnTest()
	{
		playerManager.setNextTurn();
		assertEquals(playerManager.getSecondPlayer(), playerManager.getCurrentPlayer());
		assertEquals(playerManager.getFirstPlayer(), playerManager.getOpponentPlayer());
	}
}
