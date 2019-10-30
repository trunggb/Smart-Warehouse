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

function showSuccessMessage(message){
	$.toast({
	    position: 'top-right',
	    text: message,
	    icon: 'success',
	    loader: false,        // Change it to false to disable loader
	    loaderBg: '#5dcd71',  // To change the background
	    hideAfter: 3000,
	    allowToastClose: false
	})
}
function showErrorMessage(message){
	$.toast({
	    position: 'top-right',
	    text: message,
	    icon: 'error',
	    loader: false,        // Change it to false to disable loader
	    loaderBg: '#bd382f',  // To change the background
	    hideAfter: 3000,
	    allowToastClose: false
	})
}