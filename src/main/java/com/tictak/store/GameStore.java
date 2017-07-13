package com.tictak.store;

import com.tictak.exception.GameException;
import com.tictak.model.Game;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class GameStore {
	
	private Map<String, Game> idGameMap = new ConcurrentHashMap<String, Game>();
	
	public void saveGame(Game game) {
		idGameMap.put(game.getId(), game);
	}
	
	public Game findGameById(String gameId) throws GameException {		
		final Game game = idGameMap.get(gameId);
		if (game == null) {
			String message = String.format("Game not found in store, used id=%s ", gameId);
			throw new GameException(message);
		}
		return game;
	}

}
