function saveChatLog(question, answer) {
  //대화 내용을 JSON으로 변환
  var chatLog = {
    "userid": "비회원",
    "t_question": question,
    "t_answer": {
      "departBtns": JSON.stringify(answer)
    },
    "c_time": new Date()
  };

  //JSON으로 변환된 대화 내용을 데이터베이스에 저장
  $.ajax({
    type: "post",
    url: "/CapStonWeb/do/chatLogSaveAction.do",
    data: JSON.stringify(chatLog),
    dataType: "json",
    success: function(res) {
      console.log(res);
    },
    error: function(err) {
      console.log(err);
    }
  });
}
