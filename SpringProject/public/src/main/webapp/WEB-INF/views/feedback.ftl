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
    <script type="text/javascript" src="../../resources/js/editAmountOfGoods.js"></script>
</head>
<body>

<#include "header.ftl"/>

<div id="contact-page" class="container">
    <div class="bg">
        <div class="row">
            <div class="col-sm-12">
                <h2 class="title text-center">Обратная <strong>Связь</strong></h2>

                <div id="gmap" class="contact-map">
                </div>
            </div>
        <#if add??>
        <div class="thanks">Ваш отзыв успешно отправлен. Спасибо за поддержку! Вернуться на <a href="/"> главную страницу</a>.</div>
        </#if>
        </div>
        <br/>
        <br/>

        <div class="row">
            <div class="col-sm-8">
                <div class="contact-form">
                    <h2 class="title text-center">Оставить отзыв</h2>

                    <div class="status alert alert-success" style="display: none"></div>


                <@form.form commandName="fbkForm" action="/feedback" acceptCharset="UTF-8" method="post" id="main-contact-form" class="contact-form row">


                    <div class="form-group col-md-6">
                        <@form.input path="login" type='text' placeholder="Имя" name='login' class="form-control" required="required"/>
                    </div>

                    <div class="form-group col-md-6">
                        <@form.input path="email" type='text' placeholder="E-mail" name='email' class="form-control" required="required"/>
                    </div>


                    <div class="form-group col-md-12">
                        <@form.input path="subject" type='text' placeholder="Тема" name='subject' class="form-control" required="required"/>
                    </div>

                    <div class="form-group col-md-12">
                        <@form.textarea path="message" type='text' placeholder="Текст сообщения" name='message' class="form-control" required="required" id="message" rows="8"/>
                    </div>

                    <@form.errors path="email" cssStyle="color: red; font-size: 9pt; margin-left: 20px;"/>
                    <br/>
                    <@form.errors path="message" cssStyle="color: red; font-size: 9pt; margin-left: 20px;" />

                    <div class="form-group col-md-12">
                        <input type="submit" class="btn btn-primary pull-right" value="Отправить">
                    </div>
                </@form.form>

                </div>
            </div>
            <div class="col-sm-4">
                <div class="contact-info">
                    <h2 class="title text-center">Контактная информация</h2>
                    <address>
                        <p>SportParadise</p>

                        <p>420010, Россия, г.Казань, ДУ, дом 7, офис 214</p>

                        <p>Россия, Казань</p>

                        <p>Телефон: +7-909-909-00-99</p>

                        <p>Факс: 1-714-252-0026</p>

                        <p>Email: grigorich.poker@yandex.ru</p>
                    </address>
                    <div class="social-networks">
                        <h2 class="title text-center">Социальные сети</h2>
                        <ul>
                            <li>
                                <a href="#"><i class="fa fa-facebook"></i></a>
                            </li>
                            <li>
                                <a href="#"><i class="fa fa-twitter"></i></a>
                            </li>
                            <li>
                                <a href="#"><i class="fa fa-google-plus"></i></a>
                            </li>
                            <li>
                                <a href="#"><i class="fa fa-youtube"></i></a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<#include "footer.ftl"/>

</body>
</html>