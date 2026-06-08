const modal =
	document.getElementById("modal");

const openBtn =
	document.getElementById("openBtn");

const closeBtn =
	document.getElementById("closeBtn");

/* 開く */

if (openBtn) {

	openBtn.addEventListener("click", function() {

		modal.style.display = "block";

	});

}

/* 閉じる */

if (closeBtn) {

	closeBtn.addEventListener("click", function() {

		modal.style.display = "none";

	});

}

/* 背景クリックで閉じる */

window.addEventListener("click", function(event) {

	if (event.target == modal) {

		modal.style.display = "none";

	}

});