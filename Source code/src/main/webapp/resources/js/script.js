/**
 * 
 */

function redirectTo(page) {
    setTimeout(function () {
        window.top.location.href = "/SmartWarehouse/" + page;
    }, 1000);
}

function reloadPage(){
	setTimeout(function () {
		location.reload(true);
    }, 1000);
}