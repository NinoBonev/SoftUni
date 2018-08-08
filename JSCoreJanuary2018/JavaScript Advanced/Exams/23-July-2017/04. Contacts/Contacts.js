class Contact {
    constructor(firstName, lastName, phone, Email){
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = Email;
        this.element = this.createElement();
        this.online = false;
    }

    get online() {
        return this._online;
    }

    set online(bool) {
        this._online = bool;
        this.update();
    }

    update() {
        if(this._online){
            this.element.find('.title').addClass('online')
        } else {
            this.element.find('.title').removeClass('online')
        }
    }

    /*
    <article>
    <div class="title">{firstName lastName}<button>&#8505;</button></div>
    <div class="info">
        <span>&phone; {phone}</span>
        <span>&#9993; {email}</span>
    </div>
</article>

     */
    render(id){
        $(`#${id}`).append(this.element);
    }

    createElement() {
        return ($('<article>')
            .append($('<div class = "title">')
                .text(`${this.firstName} ${this.lastName}`)
                .append($('<button>&#8505;</button>')
                    .on('click', toggleInfo)))
            .append($('<div class="info">')
                .css("display", "none")
                .append($(`<span>&phone; ${this.phone}</span>`))
                .append($(`<span>&#9993; ${this.email}</span>`))))

        function toggleInfo() {
            let article = $(this).parent().parent()[0];
            let div = $(article).children(".info");
            if (div.css("display") === "none") {
                div.show()
            } else {
                div.hide()
            }
        }
    }
}