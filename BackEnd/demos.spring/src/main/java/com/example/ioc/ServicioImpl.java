package com.example.ioc;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Qualifier("despliegue") //para diferenciar este servicio
@Scope("prototype") //hace que cada instancia sea distinta, si no lo ponemos por defecto es Singleton
public class ServicioImpl implements Servicio{

	//private Dependencia dependencia;
	private String name;
	
	public ServicioImpl(Dependencia dep) {
		//dependencia = dep;
		name = dep.getNombre();
	}
	
	@Override
	public void run() {
		System.out.println("Soy el servicio de " + name);
	}

	@Override
	public void setName(String value) {
		name = value;
		
	}

}
