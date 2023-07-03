
$(document).ready(function(){
    fButtonClickEvent();
})

function fButtonClickEvent(){

    $('button[name=btn]').click(function (e){
        e.preventDefault();
        const btnId = $(this).attr('id');

        switch (btnId){
            case 'btnSingUp' :
                fSingUp();
                break;

        }
    })
}

/*
function fSingUp(){
    const email = $("#email").val();
    const password = $("#password").val();
    const name = $("#name").val();
    const nickname = $("#nickname").val();
    const mfCode = $("#mfCode").val();
    const cellNo = $("#cellNo").val();

    const param ={
        email : email,
        password : password,
        name : name,
        nickname : nickname,
        mfCode : mfCode,
        cellNo : cellNo
    }

    //returndata : controller에서 보낸 ResponseEntity 값 -> 메시지, 상태코드
    const resultcallback = function (returndata){
        console.log("sign up return data: "+ returndata);
        alert(returndata.body);

    }

    callAjax("/join","post","json",true,param,resultcallback)




}*/
