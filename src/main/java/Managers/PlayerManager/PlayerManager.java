package Managers.PlayerManager;

import DataAccessLayer.Interface.ICardDeckManaCostsDAL;
import Entity.CardContainerEntity.CardContainer;
import Entity.CardEntity.Abstract.BaseCard;
import Entity.PlayerEntity.Abstract.*;
import Managers.Interface.IPlayerManager;

import java.util.logging.Logger;

public class PlayerManager implements IPlayerManager{
	private static final Logger LOGGER = Logger.getLogger(PlayerManager.class.getName());
	private ICardDeckManaCostsDAL<BaseCard> cardDeckDAL;
	private BasePlayer firstPlayer = null;
	private BasePlayer secondPlayer = null;
	private BasePlayer currentPlayer = null;
	private BasePlayer opponentPlayer = null;
	public PlayerManager(BasePlayer firstPlayer, BasePlayer secondPlayer, ICardDeckManaCostsDAL<BaseCard> cardDeckDAL)
	{
		this.firstPlayer = firstPlayer;
		this.secondPlayer = secondPlayer;
		this.cardDeckDAL = cardDeckDAL;
	}
	
	public void initializePlayers()
	{
		LOGGER.info("PlayerManager::initializePlayers():: Entry");
		currentPlayer = firstPlayer;
		SetDefaultCardDeckToGivenList(firstPlayer.getCardDeck());
		SetDefaultCardDeckToGivenList(secondPlayer.getCardDeck());
		LOGGER.info("PlayerManager::initializePlayers():: Exit");
	}
	
	private void SetDefaultCardDeckToGivenList(CardContainer cardDeck)
	{
		cardDeck.setCardList(cardDeckDAL.getCardDeck());
	}
	
	public void setNextTurn()
	{
		LOGGER.info("PlayerManager::setNextTurn():: Entry" );
		if (currentPlayer == firstPlayer)
		{
		    currentPlayer = secondPlayer;
		    opponentPlayer = firstPlayer;
		}
		else if (currentPlayer == secondPlayer)
		{
		    currentPlayer = firstPlayer;
		    opponentPlayer = secondPlayer;
		}
		LOGGER.info("PlayerManager::setNextTurn():: Current Player : " + currentPlayer.getNameOfThePlayer() );
		LOGGER.info("PlayerManager::setNextTurn():: Opponent Player : " + opponentPlayer.getNameOfThePlayer() );
		LOGGER.info("PlayerManager::setNextTurn():: Exit" );
	}

	public BasePlayer getFirstPlayer() {
		return firstPlayer;
	}

	public BasePlayer getSecondPlayer() {
		return secondPlayer;
	}
	
	public BasePlayer getCurrentPlayer()
	{
		return currentPlayer;
	}
	
	public BasePlayer getOpponentPlayer()
	{
		return opponentPlayer;
	}
}
