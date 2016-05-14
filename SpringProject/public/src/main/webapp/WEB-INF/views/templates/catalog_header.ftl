<header id="header">
    <div class="header-middle">
        <div class="container">
            <div class="row">
                <div class="col-sm-8">
                    <div class="logo pull-left">
                        <a href="/"><img src="../../resources/images/logo.png" alt=""/></a>
                    </div>
                    <div class="btn-group pull-right">

                        <div class="btn-group">
                            <form action="/catalog/search" method="get">
                                <div class="col-sm-4">
                                    <div class="search_box">
                                        <input type="text" placeholder="Найти товар" name="word"/>
                                    </div>
                                </div>
                            </form>
                        </div>

                    </div>
                </div>
                <div class="col-sm-4">
                    <div class="shop-menu pull-right">
                        <ul class="nav navbar-nav">
                            <li><a href="/cart"><i class="fa fa-shopping-cart"></i> Корзина</a></li>
                        <@sec.authorize ifAnyGranted="ROLE_ANONYMOUS">
                            <li><a href="/profile"><i class="fa fa-lock"></i> Войти</a></li>
                        </@sec.authorize>
                        <@sec.authorize access="isAuthenticated()">
                            <li><a href="/profile"><i class="fa fa-user"></i> Профиль</a></li>
                        </@sec.authorize>
                        <@sec.authorize ifAnyGranted="ROLE_ADMIN">
                            <li><a href="/admin"><i class="fa fa-cog fa-fw"></i> Админ</a></li>
                        </@sec.authorize>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="header-bottom">
        <div class="container">
            <div class="row">
                <div class="col-sm-9">
                    <div class="mainmenu pull-left">
                        <ul class="nav navbar-nav collapse navbar-collapse">
                            <li><a href="/" class="active">Главная</a></li>
                            <li><a href="/catalog/goods/profitably">Выгодно</a></li>
                            <li><a href="/catalog/goods/best-goods">Лучшее</a></li>
                            <li class="dropdown"><a href="/catalog">Каталог<i class="fa fa-angle-down"></i></a>
                                <ul role="menu" class="sub-menu">
                                    <li><a href="/catalog/sport/football">Футбол</a></li>
                                    <li><a href="/catalog/sport/hockey">Хоккей</a></li>
                                    <li><a href="/catalog/sport/basketball">Баскетбол</a></li>
                                    <li><a href="/catalog/sport/volleyball">Волейбол</a></li>
                                    <li><a href="/catalog/sport/tennis">Теннис</a></li>
                                </ul>
                            </li>
                            <li>
                            <#include "sorting.ftl"/>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</header>