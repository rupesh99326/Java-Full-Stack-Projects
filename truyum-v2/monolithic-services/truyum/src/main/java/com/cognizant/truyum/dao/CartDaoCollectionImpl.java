//package com.cognizant.truyum.dao;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.List;
//
//import org.springframework.stereotype.Component;
//
//import com.cognizant.truyum.DTO.CartDTO;
//import com.cognizant.truyum.model.Cart;
//import com.cognizant.truyum.model.MenuItem;
//
//@Component
//public class CartDaoCollectionImpl implements CartDao {
//                private static HashMap<String, CartDTO> userCarts = new HashMap<String, CartDTO>();
//
//                public CartDaoCollectionImpl() {
//                                if (userCarts.isEmpty()) {
//                                                MenuItemDaoCollectionImpl menuItemDaoCollectionImpl = new MenuItemDaoCollectionImpl();
//                                                List<MenuItem> menuItemList = menuItemDaoCollectionImpl.getMenuItemListCustomer();
//                                                CartDTO cart = new CartDTO(menuItemList, 0.0);
//                                                userCarts.put(null, cart);
//                                }
//                }
//
//                public void addCartItem(String userName, long menuItemId) {
//                                MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
//                                ArrayList<MenuItem> menuItemList = new ArrayList<MenuItem>();
//                                menuItemList.add(menuItemDao.getMenuItem(menuItemId));
//                                CartDTO cart;
//                                if (userCarts.containsKey(userName)) {
//                                                cart = userCarts.get(userName);
//                                } else {
//                                                cart = new CartDTO(new ArrayList<MenuItem>(), 0.0);
//                                }
//                                Iterator<MenuItem> itr = cart.getMenuItemList().iterator();
//                                while (itr.hasNext()) {
//                                                menuItemList.add(itr.next());
//                                }
//                                cart.setMenuItemList(menuItemList);
//                                userCarts.put(userName, cart);
//
//                }
//
//                public CartDTO getAllCartItems(String userName){
//                                CartDTO cart = userCarts.get(userName);
//                                double grandTotal = 0.00;
//                                if (cart == null) {
//                                                cart = new CartDTO(new ArrayList<MenuItem>(), 0);
//                                } else if (cart.getMenuItemList().isEmpty()) {
//                                                cart.setMenuItemList(new ArrayList<MenuItem>());
//                                                cart.setTotal(0); 
//                                } else {
//                                                ArrayList<MenuItem> menuItemList = (ArrayList<MenuItem>) cart.getMenuItemList();
//                                                Iterator<MenuItem> itr = menuItemList.iterator();
//                                                while (itr.hasNext()) {
//                                                                MenuItem menuItem = itr.next();
//                                                                grandTotal += menuItem.getPrice();
//                                                }
//                                }
//                                cart.setTotal(grandTotal);
//                                return cart;
//                }
//
//                public void removeCartItem(String userName, long menuItemId) {
//                                CartDTO    cart = userCarts.get(userName);
//                                ArrayList<MenuItem> menuItemList = (ArrayList<MenuItem>) cart.getMenuItemList();
//                                Iterator<MenuItem> itr = menuItemList.iterator();
//                                while (itr.hasNext()) {
//                                                MenuItem menuItem = itr.next();
//                                                if (menuItem.getId() == menuItemId) {
//                                                                itr.remove();
//                                                                break;
//                                                }
//                                }
//                }
//}
