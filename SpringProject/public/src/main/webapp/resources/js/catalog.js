/**
 * @author Astafyev Igor
 *         11-405
 *         for SemWork
 */

$(document).ready(function () {

    $(document).on('click', '#showMore', function () {
        var $this = $(this);
        var page = $this.data('page'),
            limit = $this.data('limit');
        $.ajax({
            type: "POST",
            url: "/catalog/show-more-goods",
            data: {
                id: $this.data('id'),
                page: page,
                limit: limit
            }
        }).done(function (data) {
            if (data != '') {
                $("#goodList").append(data);
                updateCounter();
            } else {
                $this.hide();
            }
        }).fail(function () {
            $this.hide();
        });

        function updateCounter() {
            $this.data('page', page + 1);
            var $goodsCount = $('#goodsCount');
            var goodsCount = parseInt($goodsCount.text());
            if (goodsCount > limit) {
                $goodsCount.text(goodsCount - limit);
                $('#limit').text(Math.min(limit, goodsCount - limit))
            } else {
                $this.hide();
            }
        }
    });
});