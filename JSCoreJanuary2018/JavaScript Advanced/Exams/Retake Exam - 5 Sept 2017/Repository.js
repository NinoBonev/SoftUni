class Repository {

    constructor(props) {
        this.props = props;
        this.data = new Map();

        let id = 0;
        this.nextId = function () {
            return id++;
        }
    }

    add(entity){
        this.validateEntity(entity);
        let id = this.nextId();
        this.data.set(id, entity);
        return id;
    }

    get(id){
        if (!this.data.has(id)){
            throw new Error(`Entity with id: ${id} does not exist!`)
        }
        return this.data.get(id);
    }

    update(id, newEntity){
        if (!this.data.has(id)){
            throw new Error(`Entity with id: ${id} does not exist!`)
        }
        this.validateEntity(newEntity);
        this.data.set(id, newEntity);
    }

    del(id){
        if (!this.data.has(id)){
            throw new Error(`Entity with id: ${id} does not exist!`)
        }
        this.data.delete(id)
    }

    get count(){
        return this.data.size;
    }

    validateEntity(entity){
        for (let key in this.props) {
            let value = this.props[key];
            if (!entity.hasOwnProperty(key)){
                throw new Error(`Property ${key} is missing from the entity!`)
            } else {
                if (typeof entity[key] !== value){
                    throw new Error(`Property ${key} is of incorrect type!`)
                }
            }
        }
    }
}

let properties = {
    name: "string",
    age: "number",
    birthday: "object"
};
//Initialize the repository
let repository = new Repository(properties);
// Add two entities
let entity = {
    name: "Kiril",
    age: 19,
    birthday: new Date(1998, 0, 7)
};
repository.add(entity); // Returns 0
repository.add(entity); // Returns 1
console.log(repository.get(0));
// {"name":"Kiril","age":19,"birthday":"1998-01-06T22:00:00.000Z"}
console.log(repository.get(1));

entity = {
    name: 'Valio',
    age: 19,
    birthday: new Date(1998, 0, 7)
};
repository.update(1, entity);
console.log(repository.get(1));
repository.del(0);
console.log(repository.count);

anotherEntity = {
    name: 'Nakov',
    age: 26,
    birthday: new Date(1998, 0, 7)
};

repository.add(anotherEntity);
console.log(repository);
