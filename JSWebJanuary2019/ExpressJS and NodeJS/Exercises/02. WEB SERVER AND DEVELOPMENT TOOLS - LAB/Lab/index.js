const http = require('http');
const url = require('url');
const fs = require('fs');
const qs = require('querystring');

const port = 8080;

http
    .createServer((req, res) => {
        const parsedUrl = url.parse(req.url);
        
        if (parsedUrl.pathname === '/login' && req.method === 'POST'){
            let formData = '';

            req.on('data', (chunk) => {
                formData += chunk;
            });

            req.on('end', () => {
                const body = qs.parse(formData);

                if (body.username === 'pesho'){
                    const index = fs.createReadStream('./models/pesho.html');

                    index.pipe(res);
                } else {
                    const index = fs.createReadStream('./models/none.html');

                    index.pipe(res);
                }
            });
            return;
        }
        if (parsedUrl.pathname === '/'){
            const index = fs.createReadStream('./models/test.html');

            index.pipe(res);
        }
    })
    .listen(port);

console.log(`Web server started at port: ${port}`);