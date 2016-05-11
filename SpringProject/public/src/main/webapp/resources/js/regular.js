/**
 * @author Astafyev Igor
 *         11-405
 *         for SemWork
 */


$(document).ready(function () {

    $('#password').blur(function () {
        if ($(this).val() != '') {
            var pattern = /(?=^.{4,}$)(.*\w).*$/;
            if (pattern.test($(this).val())) {
                $(this).css({'border': '1px solid #569b44'});
                $('#validpassword').text('');
            } else {
                $(this).css({'border': '1px solid #ff0000'});
                $('#validpassword').text('Пароль должен содержать от 4 до 20 символов');
            }
        } else {
            $(this).css({'border': '1px solid #ff0000'});
            $('#validpassword').text('Поле не заполнено');
        }
    });

    $('#username').blur(function () {
        if ($(this).val() != '') {
            var pattern = /^([A-z0-9])/i;
            if (pattern.test($(this).val())) {
                $(this).css({'border': '1px solid #569b44'});
                $('#validmail').text('');
            } else {
                $(this).css({'border': '1px solid #ff0000'});
                $('#validmail').text('Некорректное имя пользователя');
            }
        } else {
            $(this).css({'border': '1px solid #ff0000'});
            $('#validmail').text('Поле не заполнено');
        }
    });
});