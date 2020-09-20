package Managers.Interface;

import Entity.PlayerEntity.Abstract.BasePlayer;

public interface IPlayerManager {

	public void initializePlayers();
	public BasePlayer getCurrentPlayer();
	public BasePlayer getOpponentPlayer();
	public BasePlayer getFirstPlayer();
	public BasePlayer getSecondPlayer();
	public void setNextTurn();
	
}
