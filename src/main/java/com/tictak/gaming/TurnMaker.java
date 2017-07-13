package com.tictak.gaming;

import com.tictak.exception.GameException;
import com.tictak.model.*;

public class TurnMaker {

    public void makeTurn(Game game, Turn turn) throws GameException {
        final BoardCell turnCell = turn.getCell();
        final Player turnTaker = turn.getTaker();
        updateBoardCell(game, turnCell);
        updateTurnTaker(game, turnTaker);
        updateRemainingTurns(game);

        if (game.getRemainingTurns() == 0) {

        }
    }

    private void updateRemainingTurns(Game game) {
        int remainingTurns = game.getRemainingTurns();
        remainingTurns--;
        game.setRemainingTurns(remainingTurns);
    }

    private void updateBoardCell(Game game, BoardCell cell) {
        Board board = game.getBoard();
        board.updateWithCell(cell);
    }

    private void updateTurnTaker(Game game, Player turnTaker) throws GameException {
        Player nextTurnPlayer = resolveNextTurnTaker(game, turnTaker);
        game.setTurnTaker(nextTurnPlayer);
    }

    private Player resolveNextTurnTaker(Game game, Player turnTaker) throws GameException {
        if (PlayerMark.CROSS.equals(turnTaker.getMark())) {
            return game.getNoughtPlayer();
        }
        return game.getCrossPlayer();
    }

}
