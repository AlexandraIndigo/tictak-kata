var board = '';
for (var i = 0; i < 3; i++) {
    board += '<tr row="' + i + '">';
    for (var j = 0; j < 3; j++) {
        board += '<td class="tictak_cell" col="' + j + '"></td>';
    }
    board += '</tr>';
}

$('#tictak_table').append(board);

$('.tictak_cell').on('click', function (event) {
    event.target.innerText = 'x';
});



