<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>SportParadiseAdmin</title>
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
</head>

<body>

<#include "templates/header.ftl"/>

<section>
    <div class="container">
        <div class="row">

        <#list allUsers as user>
            <div class="admin-menu">
                <p>ID: ${user.getId()}</p>
                <#if user.getChecking()==true>
                    <p><b>Активный</b> пользователь
                        <a class="pull-right" href="/admin/block-user/${user.getId()}">Заблокировать пользователя</a>
                    </p>
                <#else >
                    <p>Пользователь <b>забанен!</b>
                        <a class="pull-right" href="/admin/unblocking-user/${user.getId()}">Разблокировать
                            пользователя</a>

                    </p>
                </#if>

                <p><b>Имя пользователя:</b> ${user.getName()}
                    <a class="pull-right" href="/admin/delete-user/${user.getId()}">Удалить пользователя</a>
                </p>

                <p><b>Логин:</b> ${user.getUsername()}
                </p>

                <p><b>Почта:</b> ${user.getEmail()}</p>
                <#if user.getComments()?has_content>
                    <b>Все комментари пользователя:</b><br/>
                    <#list user.getComments() as comment>
                        <p>${comment_index+1}). ${comment.getMessage()} &nbsp&nbsp<a
                                href="/admin/delete-user-comment/${comment.getId()}"> <--- &nbsp удалить</a></p>
                    </#list>
                </#if>
                <#if user.getOrder()?has_content>
                    <b>Заказы пользователя:</b><br/>
                    <#list user.getOrder() as order>
                        <p>
                            &nbsp<a
                                href="/admin/delete-user-order/${order.getId()}"><i class="fa fa-times">&nbsp&nbsp</i>
                        </a>${order_index+1}). <i>${order.getId()}</i>:
                            <#list order.getOrder_goods() as good>
                                <br/>
                            ${good.getGoods().getName()};
                            </#list>
                        </p>
                    </#list>
                </#if>
            </div>
            <br/>
        </#list>

        </div>
    </div>
</section>

<#include "templates/footer.ftl"/>

</body>
</html>