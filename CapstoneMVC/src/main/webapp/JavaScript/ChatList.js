
$(function() {
  const input = document.querySelector('.mymsg');
  const options = document.querySelector('#searchOptions');
  let toggleBtn = document.querySelector('#toggleBtn');
  let isButtonCreated = false;
  options.style.display = 'none';

  input.addEventListener('input', function() {
    const value = input.value.toLowerCase();
   
    
    let foundMatch = 0;
    // 입력값과 일치하는 항목을 보여줍니다.
    for (let i = 0; i < options.children.length; i++) {
		const text = options.children[i].textContent;
   	    const regex = new RegExp(`(${value})`, 'gi');
     	const highlightedText = text.replace(regex, '<strong>$1</strong>');
    	options.children[i].innerHTML = highlightedText;	

      if (text.indexOf(value) !== -1) {
        options.children[i].style.display = 'block';
        foundMatch = 2;
      } else {
        options.children[i].style.display = 'none';         
      }
    }

    // 자동완성 목록을 보여줍니다.
    if (foundMatch>1 && value.length > 0) {
      options.style.display = 'block';
      createToggleButton();
      
    } else {
      options.style.display = 'none';
      if(toggleBtn){
      toggleBtn.style.display = 'none';
      }
    }
  });


  options.addEventListener('click', function(event) {
    const target = event.target;
    if (target.tagName === 'LI') {
      const selectedValue = target.textContent;
      const _var = target.getAttribute('value')
      
       var _tar = $(".chat_wrap .inner").append('<div class="item mymsg"><div class="box"><p class="msg">' + selectedValue + '</p><span class="time">' + currentTime() + '</span></div></div>');
    	var lastItem = $(".chat_wrap .inner").find(".item:last");
    	setTimeout(function() {
      	lastItem.addClass("on");
    	});

   		 var position = lastItem.position().top + $(".chat_wrap .inner").scrollTop();
  		  console.log(position);
  		  $(".chat_wrap .inner").stop().animate({
  		    scrollTop: position
 		   }, 500); 		   		   
   	  sendMessage(_var); 
      options.style.display = 'none';
      setTimeout(() => input.focus(), 100);  
      input.value = '';
       
    }
  });
  
  
  function createToggleButton() {
    if (!isButtonCreated) {
      toggleBtn = document.createElement('button');
      toggleBtn.id = 'toggleBtn';
      toggleBtn.innerText = '닫기';
      toggleBtn.addEventListener('click', function() {
        options.style.display = 'none';
        toggleBtn.style.display = 'none';
      });
      options.appendChild(toggleBtn);
      isButtonCreated = true;
    } else {
      toggleBtn.style.display = 'block';
    }
  }
});
