/**
 * @author Astafyev Igor
 *         11-405
 *         for SemWork
 */

$(document).ready(function () {
    $(document).on("click", "#addingToCart", function () {
        event.preventDefault();
        var $this = $(this);
        $.ajax({
            type: "POST",
            url: "/goods/add-to-cart/" + $this.data("id"),
            data: {id: $this.data("id")},
            success: function (data) {
                if (data == 'added') {
                    alert("Товар успешно добавлен в корзину.")
                }
            },
            error: function () {
                alert("На сервере произошла ошибка. Попробуйте повторить попытку позже.");
            }
        });
    });
});