/**
 * @author Astafyev Igor
 *         11-405
 *         for DZ-labs
 */


$(document).ready(function () {

    $(document).on("click", "#reduce", function () {
        event.preventDefault();
        var $this = $(this);
        $.ajax({
            type: "POST",
            url: "/subOneGood/" + $this.data("id"),
            data: {id: $this.data('id')},
            success: function (data) {
                if (data == "decreased") {
                    var $amountOfGood = $("#" + $this.data("id"));
                    var amountOfGood = parseInt($amountOfGood.text());
                    if (amountOfGood > 1) {
                        $amountOfGood.text(amountOfGood - 1);
                    } else {
                        alert("Для удаления товара из корзины воспользуйтесь крестиком справа.")
                    }

                }
            },
            error: function () {
                alert("На сервере произошла ошибка. Попробуйте повторить попытку позже.");
            }
        });
    });

    $(document).on("click", "#add", function () {
        event.preventDefault();
        var $this = $(this);
        $.ajax({
            type: "POST",
            url: "/addAgainGood/" + $this.data("id"),
            data: {id: $this.data("id")},
            success: function (data) {
                if (data == "added") {
                    var $amountOfGood = $("#" + $this.data("id"));
                    var amountOfGood = parseInt($amountOfGood.text());
                    $amountOfGood.text(amountOfGood + 1);
                }
            },
            error: function () {
                alert("На сервере произошла ошибка. Попробуйте повторить попытку позже.");
            }
        });
    });
});