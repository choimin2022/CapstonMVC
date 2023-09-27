//Indepart.js
function Indepart() {
  //계열 소개 버튼 생성
  var departBtn = document.createElement("button");
  departBtn.textContent = "계열 소개";
  departBtn.value = "계열안내";
  departBtn.addEventListener("click", function() {
    //계열 소개 텍스트 생성
    var departText = document.createElement("p");
    departText.textContent = "계열소개";
    //계열 소개 링크 생성
    var departLink = document.createElement("a");
    departLink.href = "/CapStonWeb/do/departListAction.do";
    departLink.textContent = "계열별 학과 및 모집인원 보기";
    //계열 소개 div 생성
    var departDiv = document.createElement("div");
    departDiv.appendChild(departText);
    departDiv.appendChild(departLink);
    //계열 소개 div 추가
    document.querySelector("#changebox").appendChild(departDiv);

    //로그인 여부 확인
    var userid = document.getElementById("userid").value;
    var pwd = document.getElementById("pwd").value;
    var member = checkLogin(userid, pwd);

    if (member) {
      //대화 내용을 JSON으로 변환
      var chatLog = {
        "userid": member.userid,
        "t_question": question,
        "t_answer": {
          "departBtns": JSON.stringify(departBtns)
        },
        "c_time": new Date()
      };

      //대화 내용을 JSON 파일로 저장
      var chatLogFile = new File("chatLog.json", JSON.stringify(chatLog), {
        type: "application/json"
      });
      chatLogFile.save();
    } else {
      //게스트 계정으로 처리
      var curDate = new Date();
      var yy = curDate.getFullYear();
      var mm = curDate.getMonth() + 1;
      var dd = curDate.getDate();
      var guestId = "G" + yy + mm + dd;

      var chatLog = {
        "userid": guestId,
        "t_question": question,
        "t_answer": {
          "departBtns": JSON.stringify(departBtns)
        },
        "c_time": new Date()
      };

      //대화 내용을 JSON 파일로 저장
      var chatLogFile = new File("chatLog.json", JSON.stringify(chatLog), {
        type: "application/json"
      });
      chatLogFile.save();
    }
  });

  //계열 소개 버튼을 화면에 추가
  for (var i = 0; i < departBtns.length; i++) {
    departBtns.push(departBtn);
  }
}

//checkLogin()
function checkLogin(userid, pwd) {
  //로그인 정보 조회
  var sql = "SELECT * FROM member WHERE userid = '" + userid + "' AND pwd = '" + pwd + "'";
  var result = db.query(sql);

  //로그인 정보가 존재하는지 확인
  if (result.length > 0) {
    return result[0];
  } else {
    return null;
  }
}
function getDepartInfo() {
  // DAO를 사용하여 계열 정보를 가져옵니다.
  var departDAO = new DepartDAO();
  var departInfo = departDAO.selectDepartInfo();

  // 계열 정보를 화면에 출력합니다.
  var html = "<ul>";
  for (var i = 0; i < departInfo.length; i++) {
    var depart = departInfo[i];
    html += "<li>" + depart.d_name + "</li>";
  }
  html += "</ul>";
  document.getElementById("depart").innerHTML = html;
}