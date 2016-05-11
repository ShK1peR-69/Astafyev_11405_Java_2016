<div class="col-sm-9 padding-right">
    <div class="features_items">
        <h2 class="title text-center">Каталог товаров</h2>

    <#if allGoods??>
        <#list allGoods as good>
            <div class="col-sm-4">
                <div class="product-image-wrapper">
                    <div class="single-products">
                        <div class="productinfo text-center">
                            <div class="coloumn">
                                <div class="tovar">
                                    <a class="good_image" href="/goods/info/${good.id}">
                                        <img src='${good.getImage()}'/>
                                    </a>
                                </div>
                            </div>
                            <h2>${good.getPrice()} руб.</h2>
                            <p>${good.getName()}</p>
                            <p>${good.getPopular()} <i class="fa fa-star"> &nbsp </i></p>
                            <button id="addingToCart" class="btn btn-default add-to-cart" data-id="${good.getId()}">
                                <i class="fa fa-shopping-cart"></i> Add to cart </button>
                        </div>
                    </div>
                </div>
            </div>
        </#list>




        <#--<#if limit < goodsCount >-->
            <#--<div id="showMore" class="show-more-button" data-id="${id}" data-page="${page+1}" data-limit="${limit}">-->
                <#--Показать еще (<span id="limit">${limit}</span>) из <span id="goodsCount">${goodsCount-limit}</span>-->
            <#--</div>-->
        <#--</#if>-->
    <#else>
        <div class="sorries">
            К сожалению, товары с таким названием на складе отсутствуют...
            <br/>
            <br/>
            Приносим свои извинения за предоставленные неудобства!
        </div>
    </#if>

    </div>
</div>