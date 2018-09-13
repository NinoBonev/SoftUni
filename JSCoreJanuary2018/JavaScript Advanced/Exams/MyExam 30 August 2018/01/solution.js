function addDestination() {
    let city = $('#input input:eq(0)').val();
    let country = $('#input input:eq(1)').val();
    let season = $('#seasons').find(':selected').text();

    if (city !== '' && country !== '') {
        $('#destinationsList').append($('<tr>')
            .append($(`<td>${city}, ${country}</td>`))
            .append($(`<td>${season}</td>`)));

        switch (season){
            case "Summer" :
                let countSummer = Number($("#summer").val());
                $("#summer").val(countSummer + 1);
                break;
            case "Autumn" :
                let countAutumn = Number($("#autumn").val());
                $("#autumn").val(countAutumn + 1);
                break;
            case "Spring" :
                let countSpring = Number($("#spring").val());
                $("#spring").val(countSpring + 1);
                break;
            case "Winter" :
                let countWinter = Number($("#winter").val());
                $("#winter").val(countWinter + 1);
                break;
        }

        $('#input input:eq(0)').val('');
        $('#input input:eq(1)').val('');
        $('#seasons').val('summer');
    }
}