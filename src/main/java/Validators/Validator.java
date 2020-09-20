package Validators;

import Constants.Constants;
import Entity.CardEntity.Abstract.BaseCard;
import Managers.Interface.IPlayerManager;

import java.util.logging.Logger;

public class Validator {
	
	private IPlayerManager playerManager;
	private static final Logger LOGGER = Logger.getLogger(Validator.class.getName());
	public Validator(IPlayerManager playerManager)
	{
		this.playerManager = playerManager;
	}
	
	public boolean validateIsGameOver()
	{
		if(playerManager.getFirstPlayer().getSlotsContainer().getHealthSlots().getCurrentAmountOfSlots() <= 0 || 
				playerManager.getSecondPlayer().getSlotsContainer().getHealthSlots().getCurrentAmountOfSlots() <= 0	)
		{
			LOGGER.info("Validator::validateIsGameOver() Exit: Game is over" );
			return true;
		}

		LOGGER.info("Validator::validateIsGameOver() Exit with false value");
		return false;
	}
	
	public boolean  validateHandSizeExceedLimit() {
		
		if(playerManager.getCurrentPlayer().getCardsOnTheHand().getNumberOfCardsInTheList() == Constants.MAXIMUM_NUMBER_OF_ALLOWED_HAND_SIZE)
		{
			LOGGER.info("Validator::validateHandSizeExceedLimit() \"You already have\" + Constants.MAXIMUM_NUMBER_OF_ALLOWED_HAND_SIZE + \"card in your hand.\"" );
			System.out.println("You already have" + Constants.MAXIMUM_NUMBER_OF_ALLOWED_HAND_SIZE + "card in your hand.");
			return true;
		}
		return false;
	}
	
	public boolean validatePlayerHasCardInDeck()
	{
		if(playerManager.getCurrentPlayer().getCardDeck().getNumberOfCardsInTheList() == 0)
		{
			LOGGER.info("Validator::validatePlayerHasCardInDeck():: " + playerManager.getCurrentPlayer().getNameOfThePlayer() + "has no card in the deck." );
			return false;
		}
		return true;
	}
	
	public boolean validatePlayerHasCardInHand()
	{
		if(playerManager.getCurrentPlayer().getCardsOnTheHand().getNumberOfCardsInTheList() == 0)
		{

			LOGGER.info("Validator::validatePlayerHasCardInHand():: " + playerManager.getCurrentPlayer().getNameOfThePlayer() + "has no card in the hand." );
			return false;
		}
		return true;
	}
	
	public boolean validateActivePlayerCanMove()
	{
		boolean result = true;
		if(!validatePlayerHasCardInHand() && !validatePlayerHasCardInDeck()  )
		{
			result =  false;
		}
		else if(validateHandSizeExceedLimit() && validateManaSlotsEnoughForMove())
		{
			result =  false;
		}
		if(!result)
		{
			LOGGER.info("Validator::validateActivePlayerCanMove():: " + playerManager.getCurrentPlayer().getNameOfThePlayer() + "has no move." );
		}
		return result;
	}
	
	public boolean validateManaSlotsEnoughForMove()
	{
		int size = playerManager.getCurrentPlayer().getCardsOnTheHand().getNumberOfCardsInTheList();
		int manaAmount = playerManager.getCurrentPlayer().getSlotsContainer().getManaSlots().getCurrentAmountOfSlots();
		boolean result = false;
		for(int i = 0; i < size; i++)
		{
			result = result || (playerManager.getCurrentPlayer().getCardsOnTheHand().getCard(i).getDamageAmount() < manaAmount);
		}
		if(!result)
		{
			LOGGER.info("Validator::validateManaSlotsEnoughForMove():: " + playerManager.getCurrentPlayer().getNameOfThePlayer() + "has no enough mana." );
		}
		return result;
	}
	
	public boolean validateIsManaEnoughForSelectedCard(BaseCard card)
	{
		int manaAmount = playerManager.getCurrentPlayer().getManaSlots().getCurrentAmountOfSlots();
		boolean result =  manaAmount >= card.getDamageAmount();
		if(!result)
		{
			LOGGER.info("Validator::validateIsManaEnoughForSelectedCard():: " + playerManager.getCurrentPlayer().getNameOfThePlayer() + "has no enough mana for damage : " + card.getDamageAmount());
		}
		return result;
	}
	
	public boolean validateIsManaReachMaximum()
	{
		int manaAmount = playerManager.getCurrentPlayer().getManaSlots().getCurrentAmountOfSlots();
		boolean result =  manaAmount == Constants.MAXIMUM_NUMBER_OF_MANA_SLOTS;
		if(result)
		{
			LOGGER.info("Validator::validateIsManaReachMaximum():: " + playerManager.getCurrentPlayer().getNameOfThePlayer() + " has reached maximum possible mana amount.");
		}
		return result;
	}

}
