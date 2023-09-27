function applyGptJavaScript() {
  // 학교 정보를 수집합니다.
  const schoolInfo = getSchoolInfoFromWebsite("https://www.example.edu/");
  getSchoolInfoFromNews("학교 이름");
  getSchoolInfoFromCommunity("https://www.example.edu/community/");

  // 학교 정보를 기반으로 응답을 생성합니다.
  function gpt(message) {
    const prompt = message + schoolInfo;
    const model = "text-davinci-003";
    const headers = {
      "Content-Type": "application/json",
      "Authorization": "Bearer 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"
    };
    const body = JSON.stringify({ prompt, max_tokens: 500, temperature: 0, top_p: 1.0 });

    fetch("https://api.openai.com/v1/engines/" + model + "/completions", {
      method: "POST",
      headers,
      body
    })
      .then(function(response) {
        if (response.ok) {
          return response.json();
        } else {
          throw new Error("Error " + response.status + ": " + response.statusText);
        }
      })
      .then(function(json) {
        const completions = json.choices;
        const text = completions[0].text;
        gptMessage(text);
      })
      .catch(function(error) {
        console.error(error);
      });
  }

  // 입력 필드 띄우는 함수
  $(function() {
    $("input[type='text']").keypress(function(e) {
      if (e.keyCode == 13 && $(this).val().length) {
        var _val = $(this).val();
        var _class = $(this).attr("class");
        $(this).val("");
        var _tar = $(".chat_wrap .g_inner").append(
          '<div class="item '+_class+'"><div class="box"><p class="msg">' + _val + '</p><span class="time">' + currentTime() + '</span></div></div>'
        );
        var lastItem = $(".chat_wrap .g_inner").find(".item:last");
        setTimeout(function() {
          lastItem.addClass("on");
        });

        var position = lastItem.position().top + $(".chat_wrap .g_inner").scrollTop();
        console.log(position);
        $(".chat_wrap .g_inner").stop().animate({
          scrollTop: position
        }, 500);

        if (_val == "상담 종료" || _val == "상담종료") {
          gptbox.style.display = "none";
        }

        gpt(_val);
      }
    });
  });
}