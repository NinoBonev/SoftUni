const fs = require('fs')
const filePath = '/public/'

const typeChecker = {
      css: 'text/css',
      html: 'text/html',
      js: 'text/javascript',
      png: 'image/png',
      jpg: 'image/jpg',
        ico: 'image/x-icon'
    }

function staticFileHandler(req, res){
    const resPath = req.path;
    const extension = resPath.split(".").pop();

    let isInContentFolder = resPath.startsWith(filePath);
    let hasValidExtension = typeChecker.hasOwnProperty(extension);

    if (!isInContentFolder || !hasValidExtension){
      return true;
    }

    res.writeHead(200, {
        'Content-Type': typeChecker[extension]
    });

    try {
        const read = fs.createReadStream("." + req.path);
        read.pipe(res);
    } catch (e) {
        console.log(e);
        return true;
    }
}

module.exports = staticFileHandler;
