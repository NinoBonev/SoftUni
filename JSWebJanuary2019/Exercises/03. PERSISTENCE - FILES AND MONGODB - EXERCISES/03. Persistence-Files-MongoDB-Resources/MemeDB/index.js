const http = require('http');
const url = require('url');
const handlers = require('./handlers/handlerBlender');
const db = require('./config/dataBase');

const attachedFileReader = require('./config/fileReader');
const postParser = require('./config/postParser');

const port = 2323;

db.load().then(() => {
    console.log('testing')
  http
    .createServer(mainController)
    .listen(port)
    console.log('Im listening on '+port)
}).catch(()=>{
    console.log('Failed to load DB')
});

function mainController(req, res) {

    req.path = url.parse(req.url).path;

    attachedFileReader(res);

    postParser(req, res).then(postData => {
        for (let handler of handlers) {
            if (handler(req, res) !== true) {
                break;
            }
        }
    })
}
