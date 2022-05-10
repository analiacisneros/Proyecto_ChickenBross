
package com.chickenbros.Servicios;

import com.chickenbros.Entidades.Administrador;
import com.chickenbros.Repositorios.RepositorioAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ServicioAdmin {
    
    @Autowired
	private RepositorioAdmin adminRepo;

	@Transactional
	public void guardar() throws Exception {
            //String nombre, String apellido, String email, String clave
            Administrador admin = new Administrador();   

             admin.setNombre("Leonardo");
             admin.setEmail("admin.com");
             admin.setClave("1111");
             adminRepo.save(admin);
	
}

}
