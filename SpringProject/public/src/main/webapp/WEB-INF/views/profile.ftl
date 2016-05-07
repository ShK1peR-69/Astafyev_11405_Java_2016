<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/html">
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
    <script type="text/javascript" src="../../resources/js/addingToCart.js"></script>
    <script type="text/javascript" src="../../resources/js/nowDate.js"></script>
    <script type="text/javascript" src="../../resources/js/nowTime.js"></script>
</head>

<body>

<#include "header.ftl"/>

<section>
    <div class="container">
        <div class="row">
        <#include "left-catalog.ftl"/>

            <div class="col-sm-9">
                <div class="blog-post-area">
                    <h2 class="title text-center">Профиль</h2>

                    <div class="single-blog-post">
                        <div class="post-meta">
                            <ul>
                                <li><a href="/profile"><i class="fa fa-user"></i> ${login}</li>
                                </a>
                                <li><i class="fa fa-calendar"></i> <span id="doc_date"></span>
                                    <script type="text/javascript">date();</script>
                                </li>
                                <li><i class="fa fa-clock-o"></i><span id="doc_time"></span>
                                    <script type="text/javascript">clock();</script>
                                </li>
                            </ul>
                        </div>

                        <h2 align="center">${fio}</h2>
                        <br/>
                        <h4>Ваш логин: ${login} </h4>
                        <br/>

                        <h4>Ваш e-mail: ${email} </h4>
                        <br/>
                        <br/>
                    <#if allOrders?has_content>
                        История ваших заказов:
                        <br/>
                        <br/>
                        <#list allOrders as order>
                            <div class="orders-history">
                                Номер заказа: ${order.getId()}<br/>
                                Покупатель: ${order.getUsers().getName()}<br/>
                                Товары: <#list order.getOrder_goods() as good> ${good.getGoods().getName()}; </#list>
                                <br/>
                                Общая стоимость: ${order.getTotal_sum()+300} рублей<br/>
                                Адрес доставки: ${order.getAddress().getIndex()}, ${order.getAddress().getArea()}
                                , ${order.getAddress().getCity()},
                                ул. ${order.getAddress().getStreet()}, дом ${order.getAddress().getHouse()}
                                <#if 0<order.getAddress().getFlat()>
                                    , кв. ${order.getAddress().getFlat()}
                                </#if>
                                <br/>
                                <br/>

                                <div class="delete-order"><a href="/delete-order/${order.getId()}">Удалить</a></div>
                            </div>
                            <br/>
                        </#list>
                        <br/>
                    <#else>
                        <div class="go-to-catalog">
                            <p>Вы еще не совершили ни одного заказа. Перейти в <a href="/catalog">каталог</a></p>
                        </div>
                        <br/>
                    </#if>
                        <br/>
                        <a href="/logout" class="logout"><img src="../../resources/images/logout.png"></a>
                    </div>

                </div>
            </div>

        </div>
    </div>
</section>

<#include "footer.ftl"/>

</body>
</html>