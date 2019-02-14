const Tag = require('mongoose').model('Tag');
const util = require('util');
const formidable = require('formidable');

module.exports = (req, res) => {
  if (req.pathname === '/generateTag' && req.method === 'POST') {
        const form = new formidable.IncomingForm();

        form.parse(req, (err, fields, files) => {
            res.writeHead(200, {
                'Content-Type': 'text/plain'
            });
            Tag.create({tagName: fields.tagName, images: []}).then(tag => {
                res.writeHead(302, {
                    location: '/'
                });
                res.end();
            }).catch(err => {
                res.writeHead(500, {
                    'content-type': 'text/plain'
                });
                res.write('500 Server Error');
                res.end()
            });
        })
  } else {
    return true
  }
}
