var btn = document.getElementById('btn');


btn.addEventListener('click', function() {
	var result = window.confirm('ボタンをクリック!');
	
	if(result) {
		console.log('OKがクリックされました');
	}
	else{
		console.log('キャンセルされました');
	}
})