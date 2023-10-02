// 버튼 목록을 가져옵니다.
var buttonList = ["학사일정", "교수진소개", "기숙사", "전체"];

// 버튼을 생성합니다.
for (var i = 0; i < buttonList.length; i++) {
  var button = document.createElement("button");
  button.textContent = buttonList[i];
  button.addEventListener("click", function() {
    // 버튼에 따라 원하는 작업을 수행합니다.
    switch (this.textContent) {
      case "학사일정":
        // 학사일정 조회
        webDAO.getWebList();
        break;
      case "교수진소개":
        // 교수진 조회
        proDAO.getProList();
        break;
      case "기숙사":
        // 기숙사 조회
        departDAO.getDepartList();
        break;
      case "전체":
        // 모든 데이터를 조회
        webDAO.getWebList(function(data) {

          // 데이터를 페이지당 9개씩 나눕니다.
          var pages = Math.ceil(data.length / 9);

          // 현재 페이지에 해당하는 데이터를 가져옵니다.
          var items = data.slice(pageNum * 9, (pageNum + 1) * 9);

          // 데이터를 화면에 표시합니다.
          // ...
        });
        break;
    }
  });

  // 버튼을 컨테이너에 추가합니다.
  document.querySelector(".button_area").appendChild(button);
}