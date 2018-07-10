function solve(rooms, guests) {
    let teaHouse = [];
    for (let room of rooms) {
        room['guests'] = [];
    }

    for (let obj of guests) {
        if (obj.first.gender === obj.second.gender) {
            let firstIsAccomodated = false;
            let secondIsAccomodated = false;
            rooms.filter(x => x.type === 'triple').forEach(z => {
                if (z.guests[0] === undefined || z.guests[0].gender === obj.first.gender) {
                    if (z.guests.length < 3 && !firstIsAccomodated) {
                        z.guests.push(obj.first);
                        firstIsAccomodated = true;
                    }
                    if (z.guests.length < 3 && !secondIsAccomodated) {
                        z.guests.push(obj.second);
                        secondIsAccomodated = true;
                    }
                }
            });

            if (!firstIsAccomodated) {
                teaHouse.push(obj.first);
                firstIsAccomodated = true;
            }
            if (!secondIsAccomodated) {
                teaHouse.push(obj.second);
                secondIsAccomodated = true;
            }
        } else if (obj.first.gender !== obj.second.gender) {
            let coupleIsAcomodated = false;
            rooms.filter(x => x.type === 'double-bedded').forEach(z => {
                if (z.guests.length === 0 && !coupleIsAcomodated) {
                    z.guests.push(obj.first);
                    z.guests.push(obj.second);
                    coupleIsAcomodated = true;
                }
            });

            if (!coupleIsAcomodated) {
                teaHouse.push(obj.first);
                teaHouse.push(obj.second);
            }
        }
    }

    rooms.sort((a, b) => a.number.localeCompare(b.number)).forEach(x => {
        console.log('Room number: ' + x.number);
        x.guests.sort((a, b) => a.name.localeCompare(b.name)).forEach(y => {
            console.log('--Guest Name: ' + y.name);
            console.log('--Guest Age: ' + y.age);
        });
        let emptyBeds;
        if (x.type === 'double-bedded') {
            emptyBeds = 2 - x.guests.length;
        } else {
            emptyBeds = 3 - x.guests.length;
        }
        console.log('Empty beds in the room: ' + emptyBeds);
    });
    console.log('Guests moved to the tea house: ' + teaHouse.length);
}

let rooms = [{number: '101A', type: 'double-bedded'},
    {number: '104', type: 'triple'},
    {number: '101B', type: 'double-bedded'},
    {number: '102', type: 'triple'}];
let guests = [{
    first: {name: 'Sushi & Chicken', gender: 'female', age: 15},
    second: {name: 'Salisa Debelisa', gender: 'female', age: 25}
},
    {
        first: {name: 'Daenerys Targaryen', gender: 'female', age: 20},
        second: {name: 'Jeko Snejev', gender: 'male', age: 18}
    },
    {
        first: {name: 'Pesho Goshov', gender: 'male', age: 20},
        second: {name: 'Gosho Peshov', gender: 'male', age: 18}
    },
    {
        first: {name: 'Conor McGregor', gender: 'male', age: 29},
        second: {name: 'Floyd Mayweather', gender: 'male', age: 40}
    }];

solve(rooms, guests);

