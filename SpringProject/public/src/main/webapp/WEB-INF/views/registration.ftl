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
</head>

<body>
<#include "header.ftl" />

<section id="form">
    <div class="container">
        <div class="row">
            <div class="col-sm-5">
                <div class="signup-form">
                    <h2><b>Регистрация нового пользователя</b></h2>

                <@form.form commandName="regForm" action="/registration" acceptCharset="UTF-8" method="post">
                    <@form.errors path="fio" cssStyle="color: red; font-size: 9pt;" />
                    <br/>
                    *ФИО:
                    <br/>
                    <@form.input path="fio" placeholder="Фамилия Имя Отчество (полностью)" name='fio'/>


                    <#if message_login??>
                        <div class="error_message">${message_login}</div>
                    </#if>
                    <@form.errors path="login" cssStyle="color: red; font-size: 9pt;" />
                    <br/>
                    *Логин:
                    <br/>
                    <@form.input path="login" placeholder="Логин" name='nickname'/>


                    <#if message_email??>
                        <div class="error_message">${message_email}</div>
                    </#if>
                    <@form.errors path="email" cssStyle="color: red; font-size: 9pt;" />
                    <br/>
                    *E-mail:
                    <br/>
                    <@form.input path="email" placeholder="E-mail" name='email' />


                    <@form.errors path="password_one" cssStyle="color: red; font-size: 9pt;" />
                    <br/>
                    <#if message_password??>
                        <div class="error_message">${message_password}</div>
                    </#if>
                    *Пароль:
                    <@form.input path="password_one" type='password' placeholder="Пароль (от 4 до 20 символов)" name='password_one' />


                    <@form.errors path="password_two" cssStyle="color: red; font-size: 9pt;" />
                    <br/>
                    <#if message_password??>
                        <div class="error_message">${message_password}</div>
                    </#if>
                    *Подтвердите пароль:
                    <@form.input path="password_two" type='password' placeholder="Пароль (от 4 до 20 символов)" name='password_two' />

                    <br/>
                    * - поля, обязательные для заполнения
                    <br/>
                    <br/>
                    <br/>

                    <button type="submit" class="btn btn-default">Зарегистрироваться</button>
                </@form.form>

                </div>
            </div>
        </div>
    </div>
</section>

<#include  "footer.ftl"/>

</body>
</html>