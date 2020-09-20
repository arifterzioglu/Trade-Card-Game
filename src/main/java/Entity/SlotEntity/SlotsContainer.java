package Entity.SlotEntity;

import Entity.SlotEntity.Abstract.BaseSlots;

public class SlotsContainer {
	
	private BaseSlots healthSlots;
	private BaseSlots manaSlots;
	
	public SlotsContainer( BaseSlots healthSlots, BaseSlots manaSlots)
	{
		this.healthSlots = healthSlots;
		this.manaSlots = manaSlots;
	}

	public BaseSlots getHealthSlots() {
		return healthSlots;
	}

	public BaseSlots getManaSlots() {
		return manaSlots;
	}
}
