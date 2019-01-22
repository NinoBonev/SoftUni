const fs = require('fs');

let storageFile = "storage.json";
let storage = {};

function validateKeyType(key) {
    if(typeof key !== 'string') {
        throw new Error('Key must be a string');
    }
}

function validateKeyExists(key) {
    return storage.hasOwnProperty(key);
}

function validateStorageSize() {
    if (Object.keys(storage).length === 0){
        throw new Error('The storage is empty!')
    }
}

let put = (key, value)=> {
    validateKeyType(key);
    if (validateKeyExists(key)){
        throw new Error('Key already exists!')
    }

    storage[key]=value;
};

let get = (key)=> {
    validateKeyType(key);
    if (!validateKeyExists(key)){
        throw new Error('The key does not exist!')
    }

    return storage[key];
};

let getAll = () => {
    validateStorageSize();
    return storage;

};

let update = (key, newValue) => {
    validateKeyType(key);

    if (!validateKeyExists(key)){
        throw new Error('The key does not exist!')
    }

        storage[key] = newValue;
};

let deleteItem =(key) => {
    validateKeyType(key);

    if (!validateKeyExists(key)){
        throw new Error('The key does not exist!')
    }

    delete storage[key];
};

let clear = () => {
    storage = {};
};

let save = () => {
    return new Promise((resolve, reject) => {
        let dataAsString = JSON.stringify(storage);

        fs.writeFile(storageFile, dataAsString, err => {
            if(err) {
                reject(err);
                return;
            }

            resolve();
        })
    })
};

let load = () => {
        return new Promise(((resolve, reject) => {
            fs.readFileSync(storageFile, (err, dataJason) => {
                if (err){
                    reject(err);
                    return;
                }

                storage = JSON.parse(dataJason);
                resolve();
            })
        }))
}

module.exports={
    put,
    get,
    getAll,
    update,
    deleteItem,
    clear,
    save,
    load,
};