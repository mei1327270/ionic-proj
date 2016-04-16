
var exec = require('cordova/exec');

var JsNotification = function() {};



JsNotification.prototype.exec=function(arg0, success, error) {
    exec(success, error, "JsNotification", "notification", [arg0]);
}

var jsNotification=new JsNotification();
module.exports=jsNotification;

