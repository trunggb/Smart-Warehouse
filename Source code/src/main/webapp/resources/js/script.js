/**
 * 
 */

function redirectTo(page) {
    setTimeout(function () {
        window.top.location.href = "/SmartWarehouse/" + page;
    }, 1000);
}
function showSuccessMessage(message) {
	$.toast({
		text : '' + message + '',
		heading : 'Success',
		icon : 'success',
		// showHideTransition : 'slide',
		// allowToastClose : true,
		hideAfter : 2000,
		position : 'top-center',
		textAlign : 'left',
		loader : false,
		loaderBg : 'white',
		bgColor : '#02a9f7',
		stack: 1
	});
}

function showWarningMessage(message) {
	$.toast({
		text: message,
		heading: 'Warning',
		icon: 'warning',
		showHideTransition: 'slide',
		allowToastClose: true,
		hideAfter: 3000,
		position: 'top-center',
		textAlign: 'left',
		loader: false,
		loaderBg: 'white',
		bgColor: '#f9a938'
	});
}

function showErrorMessage(message) {
	$.toast({
		text : '' + message + '',
		heading : 'Error',
		icon : 'error',
		showHideTransition : 'slide',
		allowToastClose : true,
		hideAfter : 4000,
		position : 'top-center',
		textAlign : 'left',
		loader : false,
		loaderBg : 'white',
		bgColor : '#fc4a1a',
		stack: 1
	});
}
