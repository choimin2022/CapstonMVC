function sendMessage() {
  var message = document.getElementById("message").value;
  if (message === "") {
    alert("메시지를 입력하세요.");
    return;
  }

  var xhr = new XMLHttpRequest();
  xhr.open("POST", "/chat/chat.do", true);
  xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
  xhr.send("message=" + message);

  xhr.onload = function() {
    if (xhr.status === 200) {
      var response = JSON.parse(xhr.responseText);
      var ul = document.querySelector(".message");
      var li = document.createElement("li");
      li.className = response.type;
      li.textContent = response.message;
      ul.appendChild(li);
    } else {
      alert(xhr.status);
    }
  };
}

function scrollToBottom() {
  var messageContainer = document.querySelector(".message-container");
  messageContainer.scrollTop = messageContainer.scrollHeight;
}

window.onload = function() {
  scrollToBottom();
};