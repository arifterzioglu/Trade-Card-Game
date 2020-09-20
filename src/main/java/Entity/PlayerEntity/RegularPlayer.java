package Entity.PlayerEntity;

import Entity.SlotEntity.SlotsContainer;
import Entity.CardContainerEntity.CardContainer;
import Entity.CardEntity.Abstract.BaseCard;
import Entity.PlayerEntity.Abstract.BasePlayer;


public class RegularPlayer extends BasePlayer {
	
	public RegularPlayer(CardContainer cardDeck, SlotsContainer slotsContainer)
	{
		super(cardDeck, slotsContainer);
	}
	
	@Override
	public BaseCard playCard(int selectedCardIndex)
	{
		return cardsOnTheHand.playCard(selectedCardIndex);
	}
	
	@Override
	public BaseCard drawCard()
	{
		return cardDeck.drawCard();
	}
}
