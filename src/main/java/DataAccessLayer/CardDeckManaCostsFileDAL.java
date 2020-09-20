package DataAccessLayer;

import java.util.List;

import DataAccessLayer.Interface.ICardDeckManaCostsDAL;
import Entity.CardEntity.DamageCard;
import Entity.CardEntity.Abstract.BaseCard;
import Constants.Constants;
import Validators.Validator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;

public class CardDeckManaCostsFileDAL implements ICardDeckManaCostsDAL<BaseCard>{
	
	List<BaseCard> cardDeck;
	private static final Logger LOGGER = Logger.getLogger(CardDeckManaCostsFileDAL.class.getName());
	public CardDeckManaCostsFileDAL()
	{
		cardDeck =  new ArrayList<BaseCard>();
	}

	public List<BaseCard> getCardDeck()
	{
		LOGGER.info("CardDeckManaCostsFileDAL::getCardDeck():: Enter" );
		if(cardDeck.size() == 0)
		{
			cardDeck = readCardDeckManaCostsData();
		}
		LOGGER.info("CardDeckManaCostsFileDAL::getCardDeck():: Exit with deck size: " +  cardDeck.size());
		return new ArrayList<BaseCard>(cardDeck);
	}

	private List<BaseCard> readCardDeckManaCostsData() 
	{
		LOGGER.info("CardDeckManaCostsFileDAL::readCardDeckManaCostsData():: Entry" );
		List<BaseCard> cardDeckList =  new ArrayList<BaseCard>();
		try 
		{
			ClassLoader classLoader = getClass().getClassLoader();
			File file = new File(classLoader.getResource(Constants.filePath).getFile());
	        BufferedReader in = new BufferedReader(new FileReader(file));
	        String str;

	        while ((str = in.readLine())!= null) 
	        {
	            String[] cards=str.split(",");
	            for(String card: cards)
	            {
	            	BaseCard currentCard = new DamageCard(Integer.parseInt(card));
	            	cardDeckList.add(currentCard);
	            }
	        }
	        in.close();
	    } 
		catch (IOException e) 
		{
	        System.out.println("File Read Error");
	    }
		LOGGER.info("CardDeckManaCostsFileDAL::readCardDeckManaCostsData():: Exit" );
		return cardDeckList;
	}
}
