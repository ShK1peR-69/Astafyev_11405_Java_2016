<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>SportParadise</title>
    <link href="../../resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="../../resources/css/font-awesome.min.css" rel="stylesheet">
    <link href="../../resources/css/prettyPhoto.css" rel="stylesheet">
    <link href="../../resources/css/price-range.css" rel="stylesheet">
    <link href="../../resources/css/animate.css" rel="stylesheet">
    <link href="../../resources/css/main.css" rel="stylesheet">
    <link href="../../resources/css/responsive.css" rel="stylesheet">

    <script type="text/javascript" src="../../resources/js/jquery.js"></script>
    <script type="text/javascript" src="../../resources/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="../../resources/js/jquery.scrollUp.min.js"></script>
    <script type="text/javascript" src="../../resources/js/price-range.js"></script>
    <script type="text/javascript" src="../../resources/js/jquery.prettyPhoto.js"></script>
    <script type="text/javascript" src="../../resources/js/main.js"></script>
    <script type="text/javascript" src="../../resources/js/editAmountOfGoods.js"></script>
</head>

<body>

<#include "templates/header.ftl"/>

<section id="cart_items">
    <div class="container">
        <div class="breadcrumbs">
            <ol class="breadcrumb">
                <li><a href="/">Главная</a></li>
                <li class="active">Корзина</li>
            </ol>
        </div>
    <#if authoring??||authoring?has_content>
        <div class="auth_erroring">Оформлять заказ могут только авторизованные пользователи.</div>
    </#if>
    <#if cart?has_content>
        <div class="table-responsive cart_info">
            <table class="table table-condensed">
                <thead>
                <tr class="cart_menu">
                    <td class="image">Товар</td>
                    <td class="description">Название</td>
                    <td class="price">Цена</td>
                    <td class="quantity">Количество</td>
                    <td class="total">Стоимость</td>
                    <td></td>
                </tr>
                </thead>
                <tbody>
                    <#list cart as c>
                    <tr>
                        <td class="cart_product">
                            <div class="coloumn_in_cart">
                                <div class="tovar_in_cart">
                                    <a href="/goods/info/${c.getGoods().getId()}"><img class="good_image"
                                                                                       src="${c.getGoods().getImage()}"
                                                                                       alt=""></a>
                                </div>
                            </div>
                        </td>
                        <td class="cart_description">
                            <h4>${c.getGoods().getName()}</h4>
                        </td>
                        <td class="cart_price">
                            <p>${c.getGoods().getPrice()} руб.</p>
                        </td>
                        <td class="cart_quantity">
                            <div class="cart_quantity_button">
                                <button class="btn btn-default" id="reduce" data-id="${(c.getGoods().getId())}"> -
                                </button>
                                &nbsp&nbsp
                                <span id="${(c.getGoods().getId())}"> ${c.getCount()}</span> шт. &nbsp
                                <button class="btn btn-default" id="add" data-id="${(c.getGoods().getId())}"> +</button>
                            </div>
                        </td>
                        <td class="cart_total">
                            <p class="cart_total_price">${c.getGoods().getPrice()*c.getCount()} руб.</p>
                        </td>
                        <td class="cart_delete">
                            <a href="/delete-from-cart/${c.getGoods().getId()}"><i
                                    class="fa fa-times"></i></a>
                        </td>
                    </tr>
                    </#list>
                </tbody>
            </table>
        </div>
        <a onclick="window.location.reload()" class="btn btn-default update-coast">Пересчитать</a>
        <br/>
        <br/>

        <section id="do_action">
            <div class="container">
                <div class="heading">
                    <h3>Пожалуйста, ознакомьтесь с информацией о заказе:</h3>

                    <p>После ознакомления со стоимостью заказа Вы можете отменить его, либо перейти к оплате.</p>
                </div>
                <div class="row">
                    <div class="col-sm-7">
                        <div class="total_area">
                            <ul>
                                <li>Общая стоимость заказа: <span>${itog?c} руб.</span></li>
                                <li>НДС: <span>100 руб.</span></li>
                                <li>Доставка: <span>200 руб.</span></li>
                                <li>Итого к оплате: <span>${itog+300} руб.</span></li>
                            </ul>
                            <a class="btn btn-default update" href="/order/cancel">Отменить заказ</a>
                            <a class="btn btn-default check_out pull-right" href="/checkout/address">Перейти к
                                оформлению</a>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    <#else>
        <div class="my_main">
            <div class="clear_cart">На данный момент Ваша корзина пуста!
                <br/>
                <br/>
                <a href="/catalog">Вернуться в каталог</a>
            </div>
        </div>
    </#if>
    </div>
</section>


<#include "templates/footer.ftl"/>

</body>
</html>