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
                        <#if login??>
                            <li><a href="/profile"><i class="fa fa-user"></i> Профиль</a></li>
                        <#else>
                            <li><a href="/login"><i class="fa fa-lock"></i> Войти</a></li>
                        </#if>
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
                            <li><a href="#">Выгодно</a></li>
                            <li><a href="#">Лучшее</a></li>
                            <li class="dropdown"><a href="/catalog">Каталог<i class="fa fa-angle-down"></i></a>
                                <ul role="menu" class="sub-menu">
                                    <li><a href="#">Футбол</a></li>
                                    <li><a href="#">Хоккей</a></li>
                                    <li><a href="#">Баскетбол</a></li>
                                    <li><a href="#">Волейбол</a></li>
                                    <li><a href="#">Теннис</a></li>
                                </ul>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</header>