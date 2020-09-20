package  Entity.CardEntity.Abstract;

public abstract class BaseCard {
	
	private int damageAmount;
	
	public BaseCard(int damageAmount)
	{
		this.damageAmount = damageAmount;
	}
	
	public int getDamageAmount()
	{
		return damageAmount;
	}
	
}
