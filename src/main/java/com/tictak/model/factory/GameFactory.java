package com.tictak.model.factory;

import com.tictak.model.*;
import com.tictak.model.helper.GameBoardHelper;

public class GameFactory {
	
	private Player crossPlayer;
	
	private Player noughtPlayer;
	
	private GameFactory(Player crossPlayer, Player noughtPlayer) {
		this.crossPlayer = crossPlayer;
		this.noughtPlayer = noughtPlayer;
	}
	
	public static GameFactory newGameFactory(Player crossPlayer, Player noughtPlayer) {
		return new GameFactory(crossPlayer, noughtPlayer);
	}
	
	public Game createGame() {
		BoardCell[][] cells = GameBoardHelper.buildEmptyBoardCells(); 
		return new Game(crossPlayer, noughtPlayer, new Board(cells));
	}

}
