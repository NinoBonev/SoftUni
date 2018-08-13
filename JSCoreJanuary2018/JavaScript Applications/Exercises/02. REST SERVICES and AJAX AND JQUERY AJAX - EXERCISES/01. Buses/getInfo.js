function getInfo() {
    let URL = 'https://judgetests.firebaseio.com/businfo/';

    let table = $('#buses');
    let stopName = $('#stopName')
    let busStop = $('#stopId').val();



    $.ajax({
        method: 'GET',
        url: URL + busStop + '.json'
    }).then(appendInfo)
        .catch(handleError);

    function appendInfo(stopId) {
        stopName.text(stopId.name);
        table.empty()
        for (const bus in stopId.buses) {
            let li = $(`<li>Bus ${bus} arrives in ${stopId.buses[bus]} minutes</li>`);
            $('#buses').append(li);
        }
    }

    function handleError() {
        stopName.text('Error');
        table.empty();
    }
}