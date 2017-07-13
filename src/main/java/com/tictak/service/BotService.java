package com.tictak.service;

import com.tictak.model.Game;
import com.tictak.model.Turn;

public interface BotService {

    Turn generateRandomTurn(Game game);

}