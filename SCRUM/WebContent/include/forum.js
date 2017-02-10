$("#send_message").live('click', function() {

	$.post('/ForumTP/forum', {
		send_message : $("#message").val(),
		objet_message : $("#objet_message").val()

	},

	function() {

		$("#container").load('/ForumTP/forum' + " #container", function() {
			initScroll();
		});

	});

});
function initScroll() {
	$('#chat-box-main').animate({
		"scrollTop" : $('#chat-box-main')[0].scrollHeight
	}, "fast");
}
$(document).ready(function() {
	initScroll();
});