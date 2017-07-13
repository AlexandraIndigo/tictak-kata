package com.tictak.service;

import com.tictak.exception.GameException;
import com.tictak.model.Game;
import com.tictak.model.Player;
import com.tictak.model.Turn;

public interface GameService {

    public Game createGame(Player creator);

    public void saveGame(Game game);

    public Game findGameById(String gameId) throws GameException;

    public void makeTurn(Game game, Turn turn) throws GameException;

}