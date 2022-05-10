
package com.chickenbros.Servicios;

import com.chickenbros.Entidades.Cliente;
import com.chickenbros.Repositorios.RepositorioCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ServicioCliente {
    
    @Autowired
	private RepositorioCliente clienteRepo;

	//@Transactional
	public void guardarCliente(String nombre, String apellido, String email, String clave, String direccion, Long telefono, String claveRep) throws Exception {

                validar(nombre, apellido, email, clave, direccion,telefono,claveRep);
                
                Cliente cliente = new Cliente();
                    
                cliente.setNombre(nombre);
		cliente.setApellido(apellido);
                cliente.setEmail(email);
		cliente.setClave(clave); 
                cliente.setDireccion(direccion);
                cliente.setTelefono(telefono);
                
                 clienteRepo.save(cliente);
	}
        
        public void validar(String nombre, String apellido, String email, String clave, String direccion, Long telefono, String claveRep) throws Exception
        {
          if (nombre == null || nombre.isEmpty()) {
        throw new Exception("Es necesario colocar el nombre");
        } 
         if (apellido == null || apellido.isEmpty()) {
        throw new Exception("Es necesario colocar el apellido");
        }
          if (email == null || email.isEmpty()) {
        throw new Exception("Es necesario colocar el email ");
        }
           if (clave == null || clave.isEmpty()) {
        throw new Exception("Es necesario colocar una contrasenia");
        }
          if (direccion == null || direccion.isEmpty()) {
        throw new Exception("Es necesario colocar una contrasenia");
        }
          if (telefono == null || telefono>9999999999L) {
        throw new Exception("El telefono es invalido");
        }
           if (!clave.equals(claveRep)) {
        throw new Exception("La contrasnia no coincide");
        }
        }
}
