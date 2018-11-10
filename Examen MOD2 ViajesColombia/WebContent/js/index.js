/**
 * 
 */


document.getElementById("user").addEventListener("blur", function(e) {
	var patt = new RegExp(/^[a-z]{2,30}$/);
	var res = patt.test(this.value);
	if (!res) {
		this.value = "";
		this.placeholder = "Formato incorrecto";
		this.focus();
	}
	
})