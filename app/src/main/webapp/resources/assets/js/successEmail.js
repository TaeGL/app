

window.onload = function() {
	var em = document.querySelector('#email').value;
	alert('email = ' + em);
	console.log('em = ' +em);
    const f = document.createElement('form');
    f.setAttribute('method', 'post');
    f.setAttribute('action', '/member/join/successEmail');
    const obj = document.createElement('input');
    obj.setAttribute('type', 'hidden');
    obj.setAttribute('name', 'email');
    obj.setAttribute('value', em);

    document.body.appendChild(f);
    f.submit();
}
