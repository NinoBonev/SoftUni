module.exports = {
    movieTemplate: meme => `<div class="meme">
          <a href="/getDetails?id=${meme.id}">
          <img class="memePoster" src="${meme.memeSrc}"/>          
          </div>`,
    detailsTemplate: meme => `<div class="content">
    <img src="${targetedMeme.memeSrc}" alt=""/>
    <h3>Title ${targetedMeme.title}</h3>
    <p> ${targetedMeme.description}</p>
    </div>`,
    placeholderTemplate: `<div id="replaceMe">{{replaceMe}}</div>`,
    errorTemplate: `<div id="errBox"><h2 id="errMsg">Please fill all fields</h2></div>`,
    successTemplate: `<div id="succssesBox"><h2 id="succssesMsg">Movie Added</h2></div>`,
    cannotReadFileMsg: fileName => `Cannot read file ${fileName}`
};