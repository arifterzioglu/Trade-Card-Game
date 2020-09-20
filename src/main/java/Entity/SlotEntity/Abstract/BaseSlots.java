package  Entity.SlotEntity.Abstract;

public abstract class BaseSlots {
	
	private int currentAmountOfSlots;

	public BaseSlots( int currentAmountOfSlots )
	{
		this.currentAmountOfSlots = currentAmountOfSlots;
	}

	public int getCurrentAmountOfSlots()
	{
		return currentAmountOfSlots;
	}
	
	public void setCurrentAmountOfSlots(int currentAmountOfSlots)
	{
		this.currentAmountOfSlots = currentAmountOfSlots;
	}

	public void increaseCurrentAmountOfSlots(int amountOfSlotsToBeIncreased)
	{
		this.currentAmountOfSlots -= amountOfSlotsToBeIncreased;
	}
	
	public void decreaseCurrentAmountOfSlots(int amountOfSlotsToBeDecreased)
	{
		this.currentAmountOfSlots -= amountOfSlotsToBeDecreased;
	}

}
