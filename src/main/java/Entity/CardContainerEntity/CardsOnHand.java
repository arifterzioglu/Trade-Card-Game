package Entity.CardContainerEntity;
import Entity.CardEntity.Abstract.BaseCard;
import Managers.PlayerManager.PlayerManager;

import java.util.logging.Logger;


public class CardsOnHand extends CardContainer {

	private static final Logger LOGGER = Logger.getLogger(CardsOnHand.class.getName());
	public CardsOnHand()
	{
		super();
	}

	@Override
	public BaseCard playCard(int selectedCardIndex)
	{
		LOGGER.info("CardsOnHand::playCard():: Enter " );
		BaseCard selectedCard = getCard(selectedCardIndex);
		removeCardFromContainer(selectedCardIndex);
		LOGGER.info("CardsOnHand::playCard():: Exit with selected card damage:  " + selectedCard.getDamageAmount() );
		return selectedCard;
	}
}
