package  Entity.SlotEntity;

import Constants.Constants;
import Entity.SlotEntity.Abstract.BaseSlots;

public class ManaSlots extends BaseSlots {
	
	private int maximumAmountOfSlots;
	
	public ManaSlots()
	{
		super( Constants.INITIAL_AMOUNT_OF_MANA_SLOTS);
		this.maximumAmountOfSlots = Constants.MAXIMUM_NUMBER_OF_MANA_SLOTS;
	}
	
	public int getMaximumAmountofSlots()
	{
		return maximumAmountOfSlots;
	}
}
