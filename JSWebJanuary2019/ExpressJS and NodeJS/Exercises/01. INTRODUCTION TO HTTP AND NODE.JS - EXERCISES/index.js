const storage = require("./storage");

storage.put("First", "FirstPlayer");
storage.put("Second", "SecondPlayer");
storage.update("First", "NewFirstPlayer");
console.log(storage.getAll());
storage.save();
storage.load();
storage.put("Last", "LastPlayer");
storage.save();
storage.load();
console.log(storage.getAll());
storage.deleteItem("Second");
storage.save();
storage.load();
console.log(storage.getAll());

