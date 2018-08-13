function attachEvents() {
    const URL = 'https://baas.kinvey.com/appdata/kid_S1k5_2trX/'
    const USERNAME = 'Peter';
    const PASSWORD = 'p';
    const BASE_64 = btoa(USERNAME + ":" + PASSWORD);
    const AUTH = {"Authorization": 'Basic ' + BASE_64};
    const SELECT = $('#posts');
    const TITLE = $('#post-title');
    const BODY = $('#post-body')
    const COMMENTS = $('#post-comments')

    $('#btnLoadPosts').on('click', loadEvents);
    $('#btnViewPost').on('click', viewEvents)

    function loadEvents() {
        $.ajax({
            method: "GET",
            url: URL + "posts",
            headers: AUTH
        }).then(function (res) {
            for (const post of res) {
                SELECT.append($(`<option body="${post.body}" id="${post._id}">${post.title}</option>`))
            }
        }).catch(function (err) {
            console.log(err);
        })
    }

    function viewEvents() {
        let selectedElement = SELECT.find(":selected");
        let postId = selectedElement.attr('id')

        $.ajax({
            method: "GET",
            url: URL + `comments/?query={"post_id":"${postId}"}` ,
            headers: AUTH
        }).then(function (res) {
            BODY.empty();
            let value = selectedElement.text();
            let body = selectedElement.attr('body');
            TITLE.text(value);
            BODY.append($(`<li>${body}</li>`))
            COMMENTS.empty();
            for (const comment of res) {
                COMMENTS.append($(`<li>${comment.text}</li>`))
            }
        })
    }
}