var stompClient = null;

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    }
    else {
        $("#conversation").hide();
    }
    $("#greetings").html("");
}

function connect() {
    var socket = new SockJS('/gs-guide-websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/greetings', function (greeting) {
            showGreeting(JSON.parse(greeting.body).content);
        });
    });
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

// function sendName() {
//     stompClient.send("/app/hello", {}, JSON.stringify({'name': $("#name").val()}));
// }
function sendName() {
    const name = $("#name").val();
    const message = $("#message").val();
    stompClient.send("/app/hello", {}, JSON.stringify({'name': name, 'message': message}));
}

function showGreeting(message) {
    $("#greetings").append("<tr><td>" + message + "</td></tr>");
}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault(); // 기본 폼 제출 방지
    });

    $("#connect").click(function() { connect(); });
    $("#disconnect").click(function() { disconnect(); });
    
    $("#send").click(function() { sendMessage(); });

    // 메시지 입력 필드에서 엔터 키 감지
    $("#message").keypress(function(e) {
        if (e.which === 13) { // 엔터 키 코드
            e.preventDefault(); // 기본 동작 방지
            sendMessage(); // 메시지 전송
        }
    });
});

function sendMessage() {
    const message = $("#message").val();
    const name = $("#name").val();
    
    // 메시지 전송 로직 (예: stompClient.send 등)
    stompClient.send("/app/hello", {}, JSON.stringify({'name': name, 'message': message}));
    
    $("#message").val(''); // 입력 필드 초기화
}