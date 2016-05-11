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
<#include "templates/header.ftl" />

<section id="form">
    <div class="container">
        <div class="row">
            <div class="col-sm-5">
                <div class="signup-form">
                    <h2><b>Регистрация нового пользователя</b></h2>

                <@form.form commandName="addressForm" action="/checkout/address" acceptCharset="UTF-8" method="post">
                    <@form.errors path="index" cssStyle="color: red; font-size: 9pt;" />
                    <br/>
                    *Индекс:
                    <br/>
                    <@form.input path="index" placeholder="423236" name='index'/>


                    <@form.errors path="area" cssStyle="color: red; font-size: 9pt;" />
                    <br/>
                    *Республика/край/область:
                    <br/>
                    <@form.input path="area" placeholder="Республика Татарстан" name='area'/>


                    <@form.errors path="city" cssStyle="color: red; font-size: 9pt;" />
                    <br/>
                    *Город/село/посёлок:
                    <br/>
                    <@form.input path="city" placeholder="Бугульма" name='city' />


                    <@form.errors path="street" cssStyle="color: red; font-size: 9pt;" />
                    <br/>
                    *Улица:
                    <br/>
                    <@form.input path="street" type='text' placeholder="Гафиатуллина" name='street' />


                    <@form.errors path="house" cssStyle="color: red; font-size: 9pt;" />
                    <br/>
                    *Номер дома:
                    <br/>
                    <@form.input path="house" type='text' placeholder="31" name='house' />

                    <@form.errors path="flat" cssStyle="color: red; font-size: 9pt;" />
                    <br/>
                    Номер квартиры:
                    <br/>
                    <@form.input path="flat" type='text' placeholder="28" name='flat' />

                    <br/>
                    * - поля, обязательные для заполнения
                    <br/>
                    <br/>
                    <br/>

                    <button type="submit" class="btn btn-default">Завершить оформление</button>
                </@form.form>

                </div>
            </div>
        </div>
    </div>
</section>

<#include  "templates/footer.ftl"/>

</body>
</html>