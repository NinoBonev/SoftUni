const formidable = require('formidable');
const fs = require('fs');
const util = require('util');

function addMeme(req, res) {
    let form = new formidable.IncomingForm();

    form.parse(req, (err, fields, files) => {
      if (err){
          console.log(err);
          return
      }

      // let file = files.upload;
      // let tempPath = file.path;
      // let fileName = file.name;

      // fs.rename(tempPath, './db/' + fileName, err => {
      //   if (err){
      //       console.log(err);
      //       return
      //   }
        console.log(files.upload);
        fs.writeFile('../db', files.upload)
        res.writeHead(302, {
          location: '/'
        })
        res.write('Thank you!');
        res.end()
      });
    //});
}

function viewAll(req, res){
    res.view('views/viewAll.html')
}

function viewAddMeme(req, res){
    res.view('views/addMeme.html')
}

function getDetails(req, res){
    res.view('views/details.html')
}

module.exports = (req, res) => {
  if (req.path === '/viewAllMemes' && req.method === 'GET') {
    viewAll(req, res);
  } else if (req.path === '/addMeme' && req.method === 'GET') {
    viewAddMeme(req, res);
  } else if (req.path === '/addMeme' && req.method === 'POST') {
    addMeme(req, res);
  } else if (req.path.startsWith('/getDetails') && req.method === 'GET') {
    getDetails(req, res)
  } else if (req.path.startsWith('public/memeStorage') && req.method === 'GET') {
    console.log('HERE')
  }
  else {
    return true
  }
}
