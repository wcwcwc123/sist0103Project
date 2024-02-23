function randomColor(){
    //rgb색상얻기
    var r = parseInt(Math.random()*256); //0~255
    var g = parseInt(Math.random()*256); //0~255
    var b = parseInt(Math.random()*256); //0~255

    var color = `rgb(${r},${g},${b})`;

    return color;
}

function reverseColor(color){
    oriColor = color.match(/\d+/g);
    var color = `rgb(${255-oriColor[0]},${255-oriColor[1]},${255-oriColor[2]})`;

    return color;

}