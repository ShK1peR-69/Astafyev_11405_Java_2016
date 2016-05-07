package com.springapp.mvc.controllers;

import com.springapp.mvc.aspects.annotation.IncludeSessionParameters;
import com.springapp.mvc.common.*;
import com.springapp.mvc.form.AddressInformationFormBean;
import com.springapp.mvc.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author Astafyev Igor
 *         11-405
 *         for DZ-labs
 */

@Controller
@RequestMapping(value = "/checkout/address")
public class AddressController {

    final static String ATTR_ADDRESS_FORM = "addressForm";

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private AddressService addressService;
    @Autowired
    private CartService cartService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private UsersService usersService;
    @Autowired
    private Order_GoodsService order_goodsService;

    /*
     * Генерирование формы для заполнения нового адреса
     */
    @IncludeSessionParameters
    @RequestMapping(method = RequestMethod.GET)
    public String renderAddressPage(ModelMap model) {
        String login = (String) request.getSession().getAttribute("login");
        if (login == null) {
            model.put("authoring", "none");
            return "redirect:/login";
        } else {
            if(cartService.getCartsByUserID(usersService.getUserByLogin(login).getId()).isEmpty()){
                model.put("clear-cart", "none");
                return "redirect:/login";
            }
            request.setAttribute(ATTR_ADDRESS_FORM, new AddressInformationFormBean());
            return "address";
        }
    }


    /*
     * Добавление нового адреса для заказа
     */
    @IncludeSessionParameters
    @RequestMapping(method = RequestMethod.POST)
    public String addAddressForm(
            @Valid @ModelAttribute(ATTR_ADDRESS_FORM) AddressInformationFormBean addressInformationFormBean,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "address";
        }
//        MyUserDetail u = (MyUserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        Users user = u.getUser();

        Users user = usersService.getUserByLogin((String) request.getSession().getAttribute("login"));

        Integer index = new Integer(request.getParameter("index"));
        String area = request.getParameter("area");
        String city = request.getParameter("city");
        String street = request.getParameter("street");
        Integer house = new Integer(request.getParameter("house"));
        String flat = request.getParameter("flat");
        Address address;
        if (!flat.equals("")) {
            address = new Address(area, city, street, house, new Integer(flat), index, user);
            addressService.addNewAddress(address);
        } else {
            address = new Address(area, city, street, house, -1, index, user);
            addressService.addNewAddress(address);
        }

        double price = 0;
        int count = 0;
        Order order = new Order(new Date(), null, 0, "Заказ отправлен", "Наличными, при получении", user, address);
        List<Cart> allCarts = cartService.getCartsByUserID(user.getId());
        for (Cart c : allCarts) {
            Double a = new Double(String.valueOf(c.getGoods().getPrice()));
            price = price + (a * c.getCount());
            count = count + c.getCount();
            order.setTotal_count(c.getCount());
            order.setTotal_sum(BigDecimal.valueOf(a * c.getCount()));
            orderService.addNewOrder(order);
            order_goodsService.addNewOrder_Goods(new Order_Goods(c.getCount(), c.getGoods(), order));
            System.out.println("!!!!!!!!!!          "+c.getGoods().getName());
        }
        order.setTotal_sum(BigDecimal.valueOf(price));
        order.setTotal_count(count);
        orderService.addNewOrder(order);
        cartService.deleteCartAfterOrder(user.getId());

        return "redirect:/profile";
    }
}
