module.exports = (req, res) => {
  if (req.path === '/' && req.method === 'GET') {
    res.view('views/home.html')
  }else{
      return true
  }
}
