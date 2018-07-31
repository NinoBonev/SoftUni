function addSticker() {
    let title = $('input[class="title"]').val();
    let content = $('input[class="content"]').val();
    if (title.length > 0 && content.length > 0) {
        let newLi = $('<li class="note-content"></li>');
        let a = $('<a class="button">x</a>');
        newLi.append(a);
        newLi.append(`<h2>${title}</h2>`);
        newLi.append('<hr>');
        newLi.append(`<p>${content}</p>`);
        $('#sticker-list').append(newLi);

        $('#sticker-list a.button').on('click', function f() {
            $(this).parent().remove();
        });
        $('input[class="title"]').val('');
        $('input[class="content"]').val('');
    }
}
