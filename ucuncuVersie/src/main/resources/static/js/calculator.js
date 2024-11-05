function init(){

$("#add-button").click( function () {
    var number1= Number($("#number-1").val());
    var number2= Number($("#number-2").val());
    addNumbers(number1,number2);
 });

$("#subtract-button").click( function () {
    var number1= Number($("#number-1").val());
    var number2= Number($("#number-2").val());
    subtractNumbers(number1,number2);
    });


$("#multiply-button").click( function () {
    var number1= Number($("#number-1").val());
    var number2= Number($("#number-2").val());
    multiplyNumbers(number1,number2);
    });

$("#divide-button").click( function () {
    var number1= Number($("#number-1").val());
    var number2= Number($("#number-2").val());
    divideNumbers(number1,number2);
    });
}

function addNumbers(number1,number2){
   $("#result").val(String(number1 + number2));
}

function subtractNumbers(number1,number2){
    $("#result").val(String(number1 - number2));
}

function divideNumbers(number1,number2){
    $("#result").val(String(number1 / number2));
}

function multiplyNumbers(number1,number2){
    $("#result").val(String(number1 * number2));
}



