$(document).ready(function () {
    newGame();
});

function newGame() {
    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/new_game",
        data: "Start new game",
        cache: false,
        timeout: 600000,
        success: function (data) {
            console.log("SUCCESS : ", data);
            drawEmptyBoard(data);
            //интервал
            // drawBoard(JSON.parse(data));
        },
        error: function (e) {
            console.log("ERROR : ", e);
        }
    });

}

// function loadBoard() {
//
//     var search = "search";
//
//     $.ajax({
//         type: "POST",
//         contentType: "application/json",
//         url: "/board",
//         data: search,
//         cache: false,
//         timeout: 600000,
//         success: function (data) {
//             console.log("SUCCESS : ", data);
//             drawBoard(JSON.parse(data).boardState);
//         },
//         error: function (e) {
//             console.log("ERROR : ", e);
//         }
//     });
//
// }

function drawEmptyBoard(data) {
    var board = '';
    for (var i = 0; i < 3; i++) {
        board += '<tr row="' + i + '">';
        for (var j = 0; j < 3; j++) {
            board += '<td class="tictak_cell" col="' + j + '"></td>';
        }
        board += '</tr>';
    }
    $('#tictak_table').append(board);
}

// function drawBoard(data) {
//     var board = '';
//     for (var i = 0; i < 3; i++) {
//         board += '<tr row="' + i + '">';
//         for (var j = 0; j < 3; j++) {
//             board += '<td class="tictak_cell" col="' + j + '">' + data[i][j] + '</td>';
//         }
//         board += '</tr>';
//     }
//
//     $('#tictak_table').append(board);
//
//     $('.tictak_cell').on('click', function (event) {
//         event.target.innerText = "o";
//     });
// }
