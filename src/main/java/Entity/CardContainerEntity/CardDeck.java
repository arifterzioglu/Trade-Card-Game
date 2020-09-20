package Entity.CardContainerEntity;

import Entity.CardEntity.Abstract.BaseCard;
import Managers.PlayerManager.PlayerManager;

import java.util.Random;
import java.util.logging.Logger;


public class CardDeck extends CardContainer {
	private static final Logger LOGGER = Logger.getLogger(CardDeck.class.getName());
	private Random random;
	public CardDeck()
	{
		super();
		random = new Random();
	}	
	
	@Override
	public BaseCard drawCard() {
		LOGGER.info("CardDeck::drawCard():: Enter" );
		int selectedCardIndex = random.nextInt(getNumberOfCardsInTheList());
		BaseCard drawedCard = getCard(selectedCardIndex);
		removeCardFromContainer(selectedCardIndex);
		LOGGER.info("CardDeck::drawCard():: Exit with drawedCard Damage: " +  drawedCard.getDamageAmount());
		return drawedCard;
	}
}
