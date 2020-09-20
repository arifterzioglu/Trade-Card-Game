package Managers.GameManager;

import Managers.Interface.IGameManager;
import Managers.PlayerManager.PlayerManager;
import Validators.Validator;
import Constants.Constants;
import Entity.CardEntity.Abstract.BaseCard;

import java.util.logging.Logger;



public class GameManager implements IGameManager{
	private static final Logger LOGGER = Logger.getLogger(GameManager.class.getName());
	private PlayerManager playerManager;
	Validator validator;
	public GameManager(PlayerManager playerManager, Validator validator)
	{
		this.playerManager = playerManager;
		this.validator = validator;
	}
	
	public void initializeGame()
	{
		playerManager.initializePlayers();
	}
	
	public void startGame()
	{
		LOGGER.info("GameManager::startGame():: Entry ");
		drawCardsAtTheBeginnig();
		//TODO:Arif
		//.......
		LOGGER.info("GameManager::startGame():: Exit ");
	}
	
	private void drawCardsAtTheBeginnig()
	{
		LOGGER.info("GameManager::drawCardsAtTheBeginnig():: Entry ");
		for(int i = 0; i < Constants.NUMBER_OF_INITIAL_CARD_SELECTION; i++ )
		{
			BaseCard card = playerManager.getFirstPlayer().drawCard();
			playerManager.getFirstPlayer().addCardToCardsOnTheHand(card);
		}
		
		for(int i = 0; i < Constants.NUMBER_OF_INITIAL_CARD_SELECTION; i++ )
		{
			BaseCard card = playerManager.getSecondPlayer().drawCard();
			playerManager.getSecondPlayer().addCardToCardsOnTheHand(card);
		}
		LOGGER.info("GameManager::drawCardsAtTheBeginnig():: Exit ");
	}
	
	private void drawCardAction()
	{
		LOGGER.info("GameManager::drawCardAction():: Entry ");
		if(validator.validatePlayerHasCardInDeck())
		{
			BaseCard drawedCard = drawCardOnCurrentPlayer();
			if(validator.validateHandSizeExceedLimit())
			{
				LOGGER.info("GameManager::drawCardAction():: User: " + playerManager.getCurrentPlayer().getNameOfThePlayer() + "has maximum number of cards in hand");
				return;
			}
			addDrawedCardToPlayersHand(drawedCard);
		}
		LOGGER.info("GameManager::drawCardAction():: Exit ");
	}
	
	private void playCardAction(int selectedCardIndex)
	{
		LOGGER.info("GameManager::playCardAction():: Entry ");
		if(validator.validatePlayerHasCardInHand())
		{
			BaseCard selectedCard = playerManager.getCurrentPlayer().getCardsOnTheHand().getCard(selectedCardIndex);

			if(validator.validateIsManaEnoughForSelectedCard(selectedCard))
			{
				playerManager.getCurrentPlayer().playCard(selectedCardIndex);
				playerManager.getCurrentPlayer().getManaSlots().decreaseCurrentAmountOfSlots(selectedCard.getDamageAmount());
				playerManager.getOpponentPlayer().getHealthSlots().decreaseCurrentAmountOfSlots(selectedCard.getDamageAmount());
				LOGGER.info("GameManager::drawCardAction():: Drawed card damage: " + selectedCard.getDamageAmount() );
			}
		}
		LOGGER.info("GameManager::playCardAction():: Exit ");
	}

	private void addDrawedCardToPlayersHand(BaseCard drawedCard )
	{
		playerManager.getCurrentPlayer().addCardToCardsOnTheHand(drawedCard);
	}

	private BaseCard drawCardOnCurrentPlayer()
	{
		return playerManager.getCurrentPlayer().drawCard();
	}

	private void emptyCardDeckPenaltyAction()
	{
		if(!validator.validatePlayerHasCardInDeck())
		{
			playerManager.getCurrentPlayer().getHealthSlots().decreaseCurrentAmountOfSlots(Constants.AMOUNT_OF_DAMAGE_FOR_EMPTY_HAND);
		}
	}

	private void refillManaOfCurrentPlayer()
	{
		if(!validator.validateIsManaReachMaximum())
		{
			playerManager.getCurrentPlayer().getManaSlots().increaseCurrentAmountOfSlots(Constants.AMOUNT_OF_MANA_SLOT_UP);
		}
	}
}
