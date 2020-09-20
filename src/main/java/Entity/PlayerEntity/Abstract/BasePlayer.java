package  Entity.PlayerEntity.Abstract;

import Entity.CardContainerEntity.CardContainer;
import Entity.CardContainerEntity.CardsOnHand;
import Entity.CardEntity.Abstract.BaseCard;
import Entity.SlotEntity.Abstract.BaseSlots;
import Entity.SlotEntity.SlotsContainer;

public abstract class BasePlayer {

	protected String nameOfThePlayer;
	
	protected CardContainer cardDeck;
	
	protected CardContainer cardsOnTheHand;
	
	protected SlotsContainer slotsContainer;
	
	public BasePlayer(CardContainer cardDeck, SlotsContainer slotsContainer )	{
		this.cardDeck = cardDeck;
		this.slotsContainer = slotsContainer;
		this.cardsOnTheHand = new CardsOnHand();
	}

	public CardContainer getCardDeck() {
		return cardDeck;
	}
	public CardContainer getCardsOnTheHand() {
		return cardsOnTheHand;
	}
	public SlotsContainer getSlotsContainer() {
		return slotsContainer;
	}
	public BaseSlots getManaSlots() {
		return slotsContainer.getManaSlots();
	}
	public BaseSlots getHealthSlots() {
		return slotsContainer.getHealthSlots();
	}
	public String getNameOfThePlayer() {
		return nameOfThePlayer;
	}
	public void addCardToCardsOnTheHand(BaseCard card)
	{
		cardsOnTheHand.addCardToContainer(card);
	}
	public abstract BaseCard playCard(int selectedCardIndex);
	public abstract BaseCard drawCard();
}
