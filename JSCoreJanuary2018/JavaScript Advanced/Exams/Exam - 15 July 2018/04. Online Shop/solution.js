function onlineShop(selector) {
    let form = `<div id="header">Online Shop Inventory</div>
    <div class="block">
        <label class="field">Product details:</label>
        <br>
        <input placeholder="Enter product" class="custom-select">
        <input class="input1" id="price" type="number" min="1" max="999999" value="1"><label class="text">BGN</label>
        <input class="input1" id="quantity" type="number" min="1" value="1"><label class="text">Qty.</label>
        <button id="submit" class="button" disabled>Submit</button>
        <br><br>
        <label class="field">Inventory:</label>
        <br>
        <ul class="display">
        </ul>
        <br>
        <label class="field">Capacity:</label><input id="capacity" readonly>
        <label class="field">(maximum capacity is 150 items.)</label>
        <br>
        <label class="field">Price:</label><input id="sum" readonly>
        <label class="field">BGN</label>
    </div>`;
    $(selector).html(form);
    $('input[class = "custom-select"], textarea').on('keyup', function () {
        if ($(this).val() !== "" && $("textarea").val() !== "") {
            $("#submit").removeAttr("disabled");
        } else {
            $("#submit").attr("disabled", "disabled");
        }
    });
    $("#submit").on('click', function addItem() {
        let name = $('input[class = "custom-select"]');
        let price = $('#price');
        let quantity = $('#quantity');
        let newEntry = $(`<li>Product: ${name.val()} Price: ${Number(price.val())} Quantity: ${Number(quantity.val())}</li>`)
        $('.display').append(newEntry);
        let currentCapacity = $('#capacity');
        let currentSum = $('#sum');
        currentCapacity.val(Number(currentCapacity.val()) + Number(quantity.val()));
        currentSum.val(Number(currentSum.val()) + Number(price.val()));
        if (Number(currentCapacity.val()) >= 150) {
            $("#submit").attr("disabled", "disabled");
            name.attr("disabled", "disabled");
            price.attr("disabled", "disabled");
            quantity.attr("disabled", "disabled");
            currentCapacity.val("full");
            $('#capacity').attr('class', 'fullCapacity');

        }
        name.val('');
        price.val(1);
        quantity.val(1);
    })
}
