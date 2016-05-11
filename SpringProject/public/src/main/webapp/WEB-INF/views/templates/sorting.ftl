<form action="/catalog/sort" method="post">
    <ul class="nav navbar-nav collapse navbar-collapse pull-right sorting">
        <li>
            Категории:
            <label>
                <select name="sport">
                    <option value="football" <#if filter.getSport()=="football">selected</#if>>Футбол</option>
                    <option value="hockey" <#if filter.getSport()=="hockey">selected</#if>>Хоккей</option>
                    <option value="basketball" <#if filter.getSport()=="basketball">selected</#if>>Баскетбол</option>
                    <option value="volleyball" <#if filter.getSport()=="volleyball">selected</#if>>Волейбол</option>
                    <option value="tennis" <#if filter.getSport()=="tennis">selected</#if>>Теннис</option>
                </select>
            </label>
        </li>

        <li>
            Цена по:
            <label>
                <select name="sorting">
                    <option value="asc" <#if filter.getSorting()=="asc">selected</#if>>Возрастанию</option>
                    <option value="desc" <#if filter.getSorting()=="desc">selected</#if>>Убыванию</option>
                </select>
            </label>
        <li>

        <li>
            <p>От: <input class="padding_input_from" type="text" name="from" size="4" <#if filter.getFrom()!=0>
                          value="${filter.getFrom()}"</#if>>
            </p>

            <p>До: <input class="padding_input_to" type="text" name="to" size="4"<#if filter.getTo()!=0>
                          value="${filter.getTo()}"</#if>>
            </p>
        </li>
        <li class="button_top">
            <p>
                <button type="submit" class="btn btn-primary search">Применить</button>
            </p>
        </li>
    </ul>
</form>