
package com.chickenbros.Controladores;

import com.chickenbros.Servicios.ServicioDetallePedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/detallePedido")
public class ControladorDetallePedido {
    
     @Autowired
    private ServicioDetallePedido servDetPedido; 
    
    
    
   
}
