
package com.chickenbros.Controladores;

import com.chickenbros.Servicios.ServicioAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class ControladorAdmin {
    
    
	@Autowired
	private ServicioAdmin adminServ;
	
	@GetMapping("/lista")
	public String lista(ModelMap modelo) {
		
		//List<Admin> todos = adminServ.listarTodos();
		
		//modelo.addAttribute("admins", todos);
		
		return "list-admin";
	}
	
	@GetMapping("/registro")
	public String formulario() throws Exception {
            adminServ.guardar(); 
		return "form_admin";
	}
}
