const BASE_URL = 'https://phonebook-b0631.firebaseio.com/phonebook';
const TABLE = $('#phonebook');

$('#btnLoad').on('click', loadContacts);
$('#btnCreate').on('click', createContact);

function loadContacts() {
    $.ajax({
        method: "GET",
        url: BASE_URL + '.json'
    }).then(appendContacts)
        .catch(handleError)
}

function createContact() {
    let person = $('#person').val();
    let phone = $('#phone').val();

    if (person.trim() !== '' && phone.trim() !== '') {
        $.ajax({
            method: "POST",
            url: BASE_URL + '.json',
            data: JSON.stringify({
                name: person,
                phone: phone
            })
        }).then(function () {
            $('#person').val('');
            $('#phone').val('')
        }).catch(handleError)
    }
}

function handleError(err) {
    console.log(err);
}

function appendContacts(result) {
    TABLE.empty();
    for (const key in result) {
        let li = $('<li>');
        li.text(`${result[key].name}: ${result[key].phone}`)
        TABLE.append(li)
    }
}


