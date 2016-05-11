<#assign sec=JspTaglibs["http://www.springframework.org/security/tags"]>
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
</head>

<body>
<#include "templates/header.ftl" />

<section id="form">
    <div class="container">
        <div class="row">
            <div class="col-sm-4 col-sm-offset-1">
                <div class="login-form">
                    <h2><b>Войти в личный кабинет</b></h2>

                <#if error?has_content>
                    <div class="erroring">Неверное имя пользователя или пароль !</div>
                </#if>

                    <form method="post" action="/j_spring_security_check" name="authForm" id="authForm">
                        <input type="text" placeholder="Логин" name="j_username"/>
                        <input type="password" placeholder="Пароль" name="j_password"/>
							<span>
								<input name="_spring_security_remember_me" type="checkbox"
                                       class="checkbox"/>Запомнить меня
							</span>

                        <div class="reg-log">
                            <button type="submit" class="btn btn-default log">Войти</button>
                            <a href="/registration">
                                <div class="btn btn-default reg-btn reg">Зарегистрироваться</div>
                            </a>
                            <div class="ili"><b><i>или</i></b></div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</section>

<#include  "templates/footer.ftl"/>
</body>
</html>