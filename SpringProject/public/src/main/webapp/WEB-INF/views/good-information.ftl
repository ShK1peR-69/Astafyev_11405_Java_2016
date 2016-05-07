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

<#include "header.ftl"/>

<section>
    <div class="container">
        <div class="row">

        <#include "left-catalog.ftl"/>

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

                            <p><b>Производитель: </b> In Stock</p>

                            <p><b>Категория: </b> New</p>

                            <p><b>Описание: </b> Л</p>
                        </div>
                    </div>
                </div>

                <div class="category-tab shop-details-tab">
                    <div class="col-sm-12">
                        <ul class="nav nav-tabs">
                            <li class="active"><a href="#all_comments" data-toggle="tab">Просмотреть все отзывы</a></li>
                            <li><a href="#add_review" data-toggle="tab">Оставить отзыв</a></li>
                        </ul>
                    </div>

                    <div class="tab-content">
                        <div class="media commnets tab-pane fade active in" id="all_comments">
                            <a class="pull-left" href="#">
                                <img class="media-object" src="../../resources/images/anon-man.png">
                            </a>

                            <div class="media-body">
                                <h4 class="media-heading">Annie Davis</h4>

                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor
                                    incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud
                                    exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
                            </div>
                        </div>


                        <div class="tab-pane fade in" id="add_review">
                            <div class="col-sm-12">
                                <a class="comment-inform" href="#"><i class="fa fa-user"></i> EUGEN</a>
                                <i class="fa fa-calendar-o comment-inform"> Сегодня: <span id="doc_date"></span>
                                    <script type="text/javascript">date();</script>
                                </i>
                                <i class="fa fa-clock-o comment-inform"> Сейчас: <span id="doc_time"></span>
                                    <script type="text/javascript">clock();</script>
                                </i>
                                <br/>
                                <br/>

                                <p><b>Оставить отзыв</b></p>

                                <form action="#">
                                    <textarea class="comment-area" name="text-message"
                                              placeholder="Введите текст сообщения" rows="3"></textarea>
                                    <button type="button" class="btn btn-default pull-left add-comment">
                                        Добавить
                                    </button>
                                </form>
                            </div>
                        </div>


                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<#include "footer.ftl"/>
</body>
</html>