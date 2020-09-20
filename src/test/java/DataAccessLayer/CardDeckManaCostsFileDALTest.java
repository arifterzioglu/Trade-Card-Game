package DataAccessLayer;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import DataAccessLayer.Interface.ICardDeckManaCostsDAL;
import Entity.CardEntity.Abstract.BaseCard;

public class CardDeckManaCostsFileDALTest {

	@Test
	public void CardDeckManaCostsTest() {
		Integer[] expected = new Integer[]{
			0,0,1,1,2,2,2,3,3,3,3,4,4,4,5,5,6,6,7,8 
		};
		
		ICardDeckManaCostsDAL<BaseCard> cardDeckManaCostDal = new CardDeckManaCostsFileDAL();
		List<Integer> actual = new ArrayList<Integer>();
		for(BaseCard card: cardDeckManaCostDal.getCardDeck())
		{
			actual.add(card.getDamageAmount());			
		}
		
		assertArrayEquals(expected, actual.toArray());
	}

}
