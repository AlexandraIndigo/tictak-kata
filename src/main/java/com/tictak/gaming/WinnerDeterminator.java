package com.tictak.gaming;

import com.tictak.model.*;

public class WinnerDeterminator {

    private interface CellsInLineProvider {
        BoardCell getCell(int cellIndex);
    }

    public Player determineWinner(Game game) {
        Player winner = null;
        Board board = game.getBoard();
        for (int j = 0; j < Board.SIZE; j++) {
            final int coord = j;
            winner = findWinnerByLine(game, i -> board.getCell(coord, i));
            if (winner != null)
                break;
            winner = findWinnerByLine(game, i -> board.getCell(i, coord));
            if (winner != null)
                break;
            winner = findWinnerByLine(game, i -> board.getCell(i, i));
            if (winner != null)
                break;
            winner = findWinnerByLine(game, i -> board.getCell(Board.SIZE - i, i));
            if (winner != null)
                break;
        }
        return winner;
    }

    private Player findWinnerByLine(Game game, CellsInLineProvider cellProvider) {
        int crossCount = 0;
        int noughtCount = 0;
        for (int i = 0; i < Board.SIZE; i++) {
            BoardCell cell = cellProvider.getCell(i);
            BoardCellState cellState = cell.getState();
            if (BoardCellState.CROSS.equals(cellState)) {
                crossCount++;
            } else if (BoardCellState.NOUGHT.equals(cellState)) {
                noughtCount++;
            }
            if (crossCount == Board.SIZE) {
                return game.getCrossPlayer();
            }
            if (noughtCount == Board.SIZE) {
                return game.getNoughtPlayer();
            }
        }
        return null;
    }

}
