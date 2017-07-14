package com.tictak.controller;

import com.google.gson.Gson;
import com.tictak.model.BoardMock;
import com.tictak.model.Game;
import com.tictak.model.factory.GameFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GameController {
    private Game game;

    @RequestMapping("/game")
    public void newGame(Model model) {
        model.addAttribute("name", "TicTak");
    }

    @PostMapping("/board")
    public ResponseEntity<?> getSearchResultViaAjax(@RequestBody String search, Errors errors) {
        BoardMock board = new BoardMock();
        Gson gson = new Gson();
        String result = gson.toJson(board);
        if (errors.hasErrors()) {
            result = "Something went wrong";
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
    }

    @PostMapping("/new_game")
    public ResponseEntity<?> createNewGame(@RequestBody String postAction, Errors errors) {
        game = GameFactory.newGameFactory(null, null).createGame();
        Gson gson = new Gson();
        String result = gson.toJson(game);
        if (errors.hasErrors()) {
            result = "Error on:" + postAction;
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
    }

}
