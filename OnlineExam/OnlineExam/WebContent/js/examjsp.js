
			//失去焦点后调用的函数
			function clo(){
				window.close();
			}
			//为窗口注册失去焦点事件
			window.onblur = clo;
			
			
			
			
		
			//屏蔽鼠标右键   
			document.oncontextmenu= function(){   
				event.returnValue=false;   
		 	}   
		 	//屏蔽F1帮助   
		 	window.onhelp=function (){   
				return false;   
		 	}   
		 	//屏蔽其他功能键
		 	document.onkeydown=function (){   
	         	var k  =  window.event.keyCode;
	         	//屏蔽 F5 刷新键      
	         	if(k  ==  116){   
	               window.event.keyCode  =  0;   
	               window.event.returnValue =  false;   
	         	}   
	        	//Ctrl + R  
	         	if(window.event.ctrlKey && k == 82){
	         		window.event.returnValue=   false;  
	         	} 
	              //屏蔽Ctrl+n       
	         	if(window.event.ctrlKey && k == 78){
	         		window.event.returnValue =  false;   
	         	}
	               //屏蔽Ctrl+w  
	         	if(window.event.ctrlKey && k == 87){
	           	   window.event.returnValue =  false;
	         	}   
	               //屏蔽 shift+F10      
	         	if(event.shiftKey && k==121){
	         	   window.event.returnValue = false;   
	         	}
	               //屏蔽 shift 加鼠标左键新开一网页      
	         	if(window.event.srcElement.tagName == "A" && window.event.shiftKey){
	         		window.event.returnValue  =  false;
	         	}     
	              //屏蔽Alt+F4 
	         	if(window.event.altKey && k == 115){	
				   window.showModelessDialog("about:blank","","dialogWidth:1px;dialogheight:1px"); 
	               return   false;   
	         	}  
	         	//屏蔽 Alt+方向键 ←  屏蔽 Alt+ 方向键→   
	         	if(window.event.altKey && (k==37|| k ==39)){   
	              alert("不准你使用ALT+方向键前进或后退网页！");   
	              event.returnValue=false;   
	         	}      
			}
