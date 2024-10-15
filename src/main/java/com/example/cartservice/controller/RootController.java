package com.example.cartservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Abstract class that centralizes the path prefix "/user-service/v1"
 * for controller classes that extend RootController.
 */
@RequestMapping(path = "/cart-service/v1")
public class RootController {
}
