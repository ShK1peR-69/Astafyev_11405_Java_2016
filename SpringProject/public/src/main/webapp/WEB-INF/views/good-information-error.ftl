<#assign form=JspTaglibs["http://www.springframework.org/tags/form"]>
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
    <script type="text/javascript" src="../../resources/js/addingToCart.js"></script>
    <script type="text/javascript" src="../../resources/js/nowTime.js"></script>
    <script type="text/javascript" src="../../resources/js/nowDate.js"></script>
</head>
<body>

<#include "templates/header.ftl"/>

<section>
    <div class="container">
        <div class="row">

        <#include "templates/left-catalog.ftl"/>

            <div class="col-sm-9 padding-right">
                <div class="product-details">
                    <div class="col-sm-5">
                        <div class="coloumn_information">
                            <div class="tovar_information">
                                <img class="good_image_information" src='${tovar.getImage()}'/>
                            </div>
                        </div>
                    </div>

                    <div class="col-sm-7">
                        <div class="product-information">
                            <h3>${tovar.getName()}</h3>

                            <p>Resource-ID: ${tovar.getId()}</p>
								<span>
									<span>Цена: ${tovar.getPrice()} руб.</span>
									<br/>
									<button id="addingToCart" class="btn btn-default add-to-cart"
                                            data-id="${tovar.getId()}"><i
                                            class="fa fa-shopping-cart"></i>Add to cart
                                    </button>
								</span>

                            <p><b>Производитель: </b> ${tovar.getBrand()}</p>
                            <p><b>Вид спорта: </b> ${tovar.getSport()}</p>
                            <p><b>Размер: </b> ${tovar.getSize()}</p>
                            <p><b>Описание: </b> ${tovar.getDescribe()}</p>
                        </div>
                    </div>
                </div>

                <div class="category-tab shop-details-tab">
                    <div class="col-sm-12">
                        <ul class="nav nav-tabs">
                            <li><a href="#all_comments" data-toggle="tab">Просмотреть все отзывы</a></li>
                            <li class="active"><a href="#add_review" data-toggle="tab">Оставить отзыв</a></li>
                        </ul>
                    </div>

                    <div class="tab-content">
                        <div class="tab-pane fade in" id="all_comments">
                        <#if comments??>
                            <#list comments as comment>
                                <div class="media commnets">
                                    <div class="pull-left">
                                        <img class="media-object pull-left" src="../../resources/images/anon-man.png">
                                    </div>

                                    <div class="media-body">
                                        <h4 class="media-heading">${comment.getUsers().getUsername()}</h4>

                                        <p>${comment.getMessage()}</p>
                                    </div>
                                    <#if login??>
                                        <#if login == (comment.getUsers().getUsername())>
                                            <div class="delete-comment pull-right">
                                                <a href="/delete-comment/${tovar.getId()}/${comment.getId()}"><i
                                                        class="fa fa-times"></i></a>
                                            </div>
                                        </#if>
                                    </#if>
                                </div>
                            </#list>
                        <#else>
                            <div class="tab-pane fade in" id="all_comments">
                                <div class="media commnets">
                                    <div class="for-comment">
                                        О данном товаре пока нет ни одонго отзыва.
                                    </div>
                                </div>
                            </div>
                        </#if>
                        </div>

                    <#if login??>
                        <div class="tab-pane active fade in" id="add_review">
                            <div class="col-sm-12">
                                <a class="comment-inform" href="/profile"><i class="fa fa-user"></i> ${login}</a>
                                <i class="fa fa-calendar-o comment-inform"> Сегодня: <span id="doc_date"></span>
                                    <script type="text/javascript">date();</script>
                                </i>
                                <i class="fa fa-clock-o comment-inform"> Сейчас: <span id="doc_time"></span>
                                    <script type="text/javascript">clock();</script>
                                </i>
                                <br/>
                                <br/>

                                <p><b>Оставить отзыв</b></p>
                                <@form.form commandName="commentForm" action="/goods/info/${tovar.getId()}" acceptCharset="UTF-8" method="post">
                                    <@form.errors path="message" cssStyle="color: red; font-size: 9pt;" />
                                    <@form.textarea path="message" type='text' placeholder="Введите текст сообщения" name='message' class="comment-area" rows="3"/>
                                    <button type="submit" class="btn btn-default pull-left add-comment">
                                        Добавить
                                    </button>
                                </@form.form>
                            </div>
                        </div>
                    <#else>
                        <div class="tab-pane fade active in" id="add_review">
                            <div class="for-comment">
                                Комментари могут оставлять только авторизованные пользователи.
                            </div>
                        </div>
                    </#if>


                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<#include "templates/footer.ftl"/>
</body>
</html>