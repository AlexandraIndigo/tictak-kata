package com.tictak.service.impl;

import com.tictak.exception.GameException;
import com.tictak.gaming.TurnMaker;
import com.tictak.model.Game;
import com.tictak.model.Player;
import com.tictak.model.Turn;
import com.tictak.model.factory.GameFactory;
import com.tictak.service.GameService;
import com.tictak.store.GameStore;
import org.springframework.beans.factory.annotation.Autowired;

public class GameServiceImpl implements GameService {

    @Autowired
    private GameStore store;

    public Game createGame(Player creator) {
        // TODO:
        GameFactory gameFactory = GameFactory.newGameFactory(null, null);
        return gameFactory.createGame();
    }

    public void saveGame(Game game) {
        store.saveGame(game);
    }

    public Game findGameById(String gameId) throws GameException {
        return store.findGameById(gameId);
    }

    public void makeTurn(Game game, Turn turn) throws GameException {
        TurnMaker turnMaker = new TurnMaker();
        turnMaker.makeTurn(game, turn);
    }

}
