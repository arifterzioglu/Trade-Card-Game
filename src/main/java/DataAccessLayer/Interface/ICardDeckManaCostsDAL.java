package DataAccessLayer.Interface;

import java.util.List;

public interface ICardDeckManaCostsDAL<T> {
	
	public abstract List<T> getCardDeck();

}
