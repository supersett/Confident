// action 처리 함수
function sp_form_submit( form , action , method , target , msg )
{
	if( !is_null(msg) ) 
		if( !confirm(msg) )
			return false;

	if( !is_null(action) ) form.action = action;
	if( !is_null(method) ) form.method = method;
	if( !is_null(target) ) form.target = target;

	return( form.submit() );
    
}


// 두개의 폼에 입력된 값이 같은지 비교(비밀번호, 비밀번호 확인)
function isSame(obj1, obj2) {
	var str1 = obj1.value;
	var str2 = obj2.value;
	if(str1.length == 0 || str2.length == 0)
		return false;

	if(str1 == str2)
		return true;
	return false;
}


// 폼에 입력된 내용의 길이가 원하는 길이보다 짧은지의 여부 
function isShort(obj, len, msg) {
	var str = obj.value;
	if(str.length < len) {
		if(msg) {
			alert(msg);	
		}
		obj.focus();
		obj.select();
		return true;
	}
	return false;
}

// 영문으로 입력되었는지의 여부
function isAlphabet(obj) {
	var str = obj.value;
	if(str.length == 0)
		return false;

	str = str.toUpperCase();
	for(var i=0; i < str.length; i++) {
		if(!('A' <= str.charAt(i) && str.charAt(i) <= 'Z'))
			return false;
	}
	return true;
}

// 폼에 입력된 내용이 아이디로 적당한지의 여부..
function isID(obj) {
	var str = obj.value;
	if(str.length == 0)
		return false;

	str = str.toUpperCase();
	if(!('A' <= str.charAt(i) && str.charAt(i) <= 'Z'))
		return false;

	for(var i=1; i < str.length; i++) {
		if(!(('A' <= str.charAt(i) && str.charAt(i) <= 'Z') ||
			('0' <= str.charAt(i) && str.charAt(i) <= '9') ||
			(str.charAt(i) == '_')))
			return false;
	}
	return true;
}

// 폼에 입력된 내용이 이메일로 적당한지의 여부..
function isEmail(obj) {
	var str = obj.value;
	if(str == "")
		return false;

	var i = str.indexOf("@");
	if(i < 0)
		return false;

	i = str.indexOf(".");
	if(i < 0)
		return false;
	
	return true;
}

// 주민등록번호인지..
function isSSN(front, back) {
	var birthday = front.value;
	var num = back.value;

	if(birthday.length != 6) {
		return false;
	}
	if(num.length != 7) {
		return false;
	}
	var hap = 0;
	for(var i=0; i < 6; i++) {
		var temp = birthday.charAt(i) * (i+2);
		hap += temp;
	}

	var n1 = num.charAt(0);
	var n2 = num.charAt(1);
	var n3 = num.charAt(2);
	var n4 = num.charAt(3);
	var n5 = num.charAt(4);
	var n6 = num.charAt(5);
	var n7 = num.charAt(6);

	hap += n1*8+n2*9+n3*2+n4*3+n5*4+n6*5;
	hap %= 11;
	hap = 11 - hap;
	hap %= 10;
	if(hap != n7)
		return false;
	return true;
}


function sp_form_reset( form )
{
	form.reset();
}


var		openWin  = null;
function sp_window_open( url , name , option )
{
     var	opt = 'toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=auto,resizable=yes,left=0,top=0';
	 if( !is_null( option ) )
     	opt = opt + ',' + option;

     if( !openWin || openWin.closed )
     {
		openWin = window.open( url , name , opt );
		openWin.focus();
     }
     else
     {
		openWin = window.open( url , name , opt );
		openWin.focus();
     }
}


function sp_window_close()
{
     if( openWin && !openWin.closed )
     {
		self.window.focus();
		openWin.close();
     }
}

function is_null( obj )
{
    if( obj.value == "" )
        return  true;
    return  false;
}


function is_space( string )
{
	for( var i = 0; i < string.length; i++ )
		if( string.charAt( i ) != ' ' )
	        	return  false;
    	return  true;
}

function is_numeric( string )
{
	if( is_null( string ) )
		return false;

	for( var i = 0; i < string.length; i++ ) {
		if( string.charAt( i ) >= '0' && string.charAt( i ) <= '9' )
			continue;
		else
			return	false;
	}
	return	true;
}
