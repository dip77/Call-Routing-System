
$('.dialer').click(function() {
  var handler = $('#textbox');
  var pressedNumber = $(this).attr("value");
  var previousVal = handler.val();
  $('#textbox').val($('#textbox').val() + pressedNumber);
});
