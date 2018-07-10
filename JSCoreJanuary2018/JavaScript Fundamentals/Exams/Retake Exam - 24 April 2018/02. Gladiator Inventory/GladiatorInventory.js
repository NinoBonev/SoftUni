function inventory(input) {
    let inventory = input[0].split(' ');
    for (let i = 1; i < input.length; i++) {
        if (input[i] !== "Fight!") {
            let command = input[i].split(' ')[0];
            let equipment = input[i].split([' '])[1];
            switch (command) {
                case 'Buy' :
                    let isBought = inventory.indexOf(equipment)
                    if (isBought === -1) {
                        inventory.push(equipment);
                    }
                    break;
                case "Trash" :
                    let index = inventory.indexOf(equipment);
                    if (index !== -1) {
                        delete inventory[index];
                    }
                    break;
                case "Repair" :
                    let ind = inventory.indexOf(equipment);
                    if (ind !== -1) {
                        delete inventory[ind];
                    }
                    inventory.push(equipment);
                    break;
                case "Upgrade" :
                    let upgrade = equipment.split(['-'])[1];
                    let eq = equipment.split('-')[0];
                    let inde = inventory.indexOf(eq);
                    if (inde !== -1) {
                        let newEquipment = eq + ':' + upgrade;
                        inventory.splice(inde + 1, 0, newEquipment);
                    }
                    break;
            }
        } else {
            break;
        }
    }

    inventory = inventory.filter(x => x !== '');
    console.log(inventory.join(" "));
}

inventory(['SWORD Shield Spear', 'Buy Bag', 'Trash Shield', 'Repair Spear', 'Upgrade SWORD-Steel', 'Fight!']);
inventory(['SWORD Shield Spear', 'Trash Bow', 'Repair Shield', 'Upgrade Helmet-V', 'Fight!']);