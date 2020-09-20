package Entity.CardContainerEntity;

import java.util.List;
import java.util.ArrayList;


import Entity.CardEntity.Abstract.BaseCard;

public abstract class CardContainer {
	
	protected List<BaseCard> cardList;
	
	protected CardContainer()
	{
		cardList = new ArrayList<BaseCard>();
	}
	
	public BaseCard getCard(int cardIndex)
	{
		return cardList.get(cardIndex);
	}
	
	public void setCardList(List<BaseCard> cardList)
	{
		this.cardList = cardList;
	}
	
	protected void removeCardFromContainer(int selectedIndex)
	{
		cardList.remove(selectedIndex);
	}
	
	public void addCardToContainer(BaseCard card)
	{
		cardList.add(card);
	}
	
	public int getNumberOfCardsInTheList()
	{
		return cardList.size();
	}
	
	public BaseCard playCard(int selectedCardIndex)
	{
		return null;
	}
	
	public BaseCard drawCard(){
		return null;
	}

	@Override
	public String toString()
	{
		String str = "";
		for(int i = 0; i < getNumberOfCardsInTheList(); i++)
		{
			str = str + " " + cardList.get(i).getDamageAmount();
		}
		return str;
	}
}

