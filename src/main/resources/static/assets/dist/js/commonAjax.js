
function callAjax(url, method, dataType, async, param, callback){


    $.ajax({
        url : url,
        method: method,
        dataType : dataType,
        contentType: 'application/json',
        async : async,
        data : JSON.stringify(param),
        success : function (resp){ //컨트롤러에서 반환해준 값.
            callback(resp);
        },
        error: function (xhr,status,err){
            console.log("xhr : " + xhr);
            console.log("status : " + status);
            console.log("err : " + err);
        }
    })

}