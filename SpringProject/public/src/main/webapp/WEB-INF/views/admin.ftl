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

            <a href="D:\Program Files (x86)\Java\Apache Tomcat 8.0.27\bin\users.pdf" download>Скачать</a>
            иформацию о всех пользователях сайта
            <br/>
            <br/>
            <div class="admin pull-left">
                <p><b><i>Информация о пользователях</i></b></p>
            <#list allUsers as user>
                <div class="admin-menu">
                    <p>ID: ${user.getId()}</p>
                    <#if user.getChecking()==true>
                        <p><b>Активный</b> пользователь
                            <a class="pull-right" href="/admin/block-user/${user.getId()}">Заблокировать
                                пользователя</a>
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
                                    href="/admin/delete-user-order/${order.getId()}"><i
                                    class="fa fa-times">&nbsp&nbsp</i>
                            </a>${order_index+1}). <i>${order.getId()}</i>:
                                <#list order.getOrder_goods() as good>
                                    <br/>
                                ${good.getGoods().getName()};
                                </#list>
                            </p>
                            <br/>
                        </#list>
                    </#if>
                </div>
            </#list>
            </div>
            <div class="pull-right adding-good">
            <#if okay?has_content>
                <div class="error_message">Товар успешно добавлен!</div>
            </#if>
                <div class="pull-left">
                    <p><b><i>Добавление нового товара</i></b></p>
                </div>
                <br/>

                <div class="add-new-good">
                    <form method="post" action="/admin/add-new-good">
                        <input class="new-good" type="text" name="name" placeholder="Название"/>
                        <input class="new-good" type="text" name="image" placeholder="URL изображения"/>
                        <input class="new-good" type="text" name="price" placeholder="Цена (в рублях)"/>
                        <input class="new-good" type="text" name="size" placeholder="Размер"/>
                        <label>
                            Вид спорта:
                            <select name="sport" class="new-good-select">
                                <option value="football">Футбол</option>
                                <option value="hockey">Хоккей</option>
                                <option value="basketball">Баскетбол</option>
                                <option value="volleyball">Волейбол</option>
                                <option value="tennis">Теннис</option>
                            </select>
                        </label>
                        <label>
                            Брэнд:
                            <select name="brand" class="new-good-select">
                                <option value="Adidas">Adidas</option>
                                <option value="Nike">Nike</option>
                                <option value="Puma">Puma</option>
                                <option value="Demix">Demix</option>
                                <option value="Joma">Joma</option>
                            </select>
                        </label>
                        <label>
                            Категория:
                            <select name="category" class="new-good-select">
                                <option value="man">Мужское</option>
                                <option value="woman">Женское</option>
                                <option value="child">Десткое</option>
                                <option value="different">Разное</option>
                            </select>
                        </label>
                        <textarea class="new-good" name="describe" placeholder="Описание" rows="3"></textarea>
                        <br/>
                        <button id="adding" type="submit" class="btn btn-default new-good-button">Добавить</button>
                    </form>
                </div>
            </div>
            <br/>
        </div>
    </div>
</section>

<#include "templates/footer.ftl"/>

</body>
</html>