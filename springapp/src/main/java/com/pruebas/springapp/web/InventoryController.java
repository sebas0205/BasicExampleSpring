package com.pruebas.springapp.web;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pruebas.springapp.domain.Product;
import com.pruebas.springapp.service.ProductManager;
import com.pruebas.springapp.service.SimpleProductManager;

@Controller
public class InventoryController {

    protected final Log logger = LogFactory.getLog(getClass());

    @Autowired
    private   ProductManager productManager;
    
    

	@RequestMapping(value="/hello.htm")
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    	String now = (new Date()).toString();
        logger.info("Returning hello view with " + now);

        Map<String, Object> myModel = new HashMap<String, Object>();
        myModel.put("now", now);
        myModel.put("products", this.productManager.getProducts());

        return new ModelAndView("hello", "model", myModel);
    }

	public ProductManager getProductManager() {
			return this.productManager;
	}

	public void setProductManager(ProductManager productManager) {		
		this.productManager = productManager;
	}


  
    
}