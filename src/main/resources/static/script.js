$(document).ready(function(){
    $("#btnrate").click(function(){
        $("#mdrate").modal();
    });

});
function TrangThaiHang() {

	var n = document.getElementById("trangthai").textContent;

	if (n > 0) {

		document.getElementById("trangthai").innerHTML = "Còn hàng";
	} else
		document.getElementById("trangthai").innerHTML = "Hết Hàng";


	 /* document.getElementById("btnrate").style.display = 'none';*/
	mOut();
};

function mOver1(){
	document.getElementById("sa1").innerHTML = '<img src="../image/rated.png" />';
	document.getElementById("sa2").innerHTML = '<img src="../image/none_rate.png" />';
	document.getElementById("sa3").innerHTML = '<img src="../image/none_rate.png" />';
	document.getElementById("sa4").innerHTML = '<img src="../image/none_rate.png" />';
	document.getElementById("sa5").innerHTML = '<img src="../image/none_rate.png" />';
	
	 document.getElementById("ratecustomer").value = "2"
};
function mOver2(){
	document.getElementById("sa1").innerHTML = '<img src="../image/rated.png" />';
	document.getElementById("sa2").innerHTML = '<img src="../image/rated.png" />';
	document.getElementById("sa3").innerHTML = '<img src="../image/none_rate.png" />';
	document.getElementById("sa4").innerHTML = '<img src="../image/none_rate.png" />';
	document.getElementById("sa5").innerHTML = '<img src="../image/none_rate.png" />';
	 
	 document.getElementById("ratecustomer").value = "4"
};
function mOver3(){
	document.getElementById("sa1").innerHTML = '<img src="../image/rated.png" />';
	document.getElementById("sa2").innerHTML = '<img src="../image/rated.png" />';
	document.getElementById("sa3").innerHTML = '<img src="../image/rated.png" />';
	document.getElementById("sa4").innerHTML = '<img src="../image/none_rate.png" />';
	document.getElementById("sa5").innerHTML = '<img src="../image/none_rate.png" />';

	 document.getElementById("ratecustomer").value = "6"
};
function mOver4(){
	document.getElementById("sa1").innerHTML = '<img src="../image/rated.png" />';
	document.getElementById("sa2").innerHTML = '<img src="../image/rated.png" />';
	document.getElementById("sa3").innerHTML = '<img src="../image/rated.png" />';
	document.getElementById("sa4").innerHTML = '<img src="../image/rated.png" />';
	document.getElementById("sa5").innerHTML = '<img src="../image/none_rate.png" />';

	 document.getElementById("ratecustomer").value = "8"
};
function mOver5(){
	document.getElementById("sa1").innerHTML = '<img src="../image/rated.png" />';
	document.getElementById("sa2").innerHTML = '<img src="../image/rated.png" />';
	document.getElementById("sa3").innerHTML = '<img src="../image/rated.png" />';
	document.getElementById("sa4").innerHTML = '<img src="../image/rated.png" />';
	document.getElementById("sa5").innerHTML = '<img src="../image/rated.png" />';
	
	 document.getElementById("ratecustomer").value = "10"
};


function mOut(){
	var dg = document.getElementById("danhgia").textContent;
switch(Number(dg)) {
	
	case 1:
		document.getElementById("s1").innerHTML = '<img src="../image/nua_rate.png" />';
	
		break;
	case 2:
		document.getElementById("s1").innerHTML = '<img src="../image/rated.png" />';
		break;
	case 3:
		document.getElementById("s1").innerHTML = '<img src="../image/rated.png" />';
		document.getElementById("s2").innerHTML = '<img src="../image/nua_rate.png" />';
		break;
	case 4:
		document.getElementById("s1").innerHTML = '<img src="../image/rated.png" />';
		document.getElementById("s2").innerHTML = '<img src="../image/rated.png" />';
		break;
	case 5:
		document.getElementById("s1").innerHTML = '<img src="../image/rated.png" />';
		document.getElementById("s2").innerHTML = '<img src="../image/rated.png" />';
		document.getElementById("s3").innerHTML = '<img src="../image/nua_rate.png" />';
		break;
	case 6:
		document.getElementById("s1").innerHTML = '<img src="../image/rated.png" />';
		document.getElementById("s2").innerHTML = '<img src="../image/rated.png" />';
		document.getElementById("s3").innerHTML = '<img src="../image/rated.png" />';
		break;
	case 7:
		document.getElementById("s1").innerHTML = '<img src="../image/rated.png" />';
		document.getElementById("s2").innerHTML = '<img src="../image/rated.png" />';
		document.getElementById("s3").innerHTML = '<img src="../image/rated.png" />';
		document.getElementById("s4").innerHTML = '<img src="../image/nua_rate.png" />';
		break;
	case 8:
		document.getElementById("s1").innerHTML = '<img src="../image/rated.png" />';
		document.getElementById("s2").innerHTML = '<img src="../image/rated.png" />';
		document.getElementById("s3").innerHTML = '<img src="../image/rated.png" />';
		document.getElementById("s4").innerHTML = '<img src="../image/rated.png" />';
		break;
	case 9:
		document.getElementById("s1").innerHTML = '<img src="../image/rated.png" />';
		document.getElementById("s2").innerHTML = '<img src="../image/rated.png" />';
		document.getElementById("s3").innerHTML = '<img src="../image/rated.png" />';
		document.getElementById("s4").innerHTML = '<img src="../image/rated.png" />';
		document.getElementById("s5").innerHTML = '<img src="../image/nua_rate.png" />';
		break;
	case 10:
		document.getElementById("s1").innerHTML = '<img src="../image/rated.png" />';
		document.getElementById("s2").innerHTML = '<img src="../image/rated.png" />';
		document.getElementById("s3").innerHTML = '<img src="../image/rated.png" />';
		document.getElementById("s4").innerHTML = '<img src="../image/rated.png" />';
		document.getElementById("s5").innerHTML = '<img src="../image/rated.png" />';
		break;
	default:
		/*document.getElementById("danhgia").innerHTML = "có lỗi khi load dữ liệu!";*/
	}
}

