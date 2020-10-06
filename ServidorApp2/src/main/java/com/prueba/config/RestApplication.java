package com.prueba.config;

import java.util.UUID;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Destroyed;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.ConfigProvider;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import com.ecwid.consul.v1.ConsulClient;
import com.ecwid.consul.v1.agent.model.NewService;


@ApplicationPath(value = "/")
public class RestApplication extends Application {

	@Inject
	 Config config;
	
	 Integer puerto = ConfigProvider.getConfig().getValue("payara.instance.http.port", Integer.class);
	 
	private String id=UUID.randomUUID().toString();
	
	@Inject
	@ConfigProperty(name="consult.host", defaultValue = "127.0.0.1")
	private String consulHost;
	
	@Inject
	@ConfigProperty(name="consult.port", defaultValue = "8500")
	private Integer consulPort;
	
	public void init(@Observes @Initialized(ApplicationScoped.class) Object init) {
		System.out.println("Inicializando");
		
		//se puede dejar por default o especificar el puerto
		ConsulClient client = new ConsulClient(consulHost,consulPort);
		
		NewService s = new NewService();
		
		s.setName("Orders-Table");
		s.setId(id);
		s.setAddress("127.0.0.1");
		s.setPort(puerto);
		
	   NewService.Check check = new NewService.Check();
	   
	   check.setMethod("GET");
	   check.setHttp("http://127.0.0.1:" + puerto +"/ServidorApp2/orders" +"/ping");
	  check.setInterval("10s");
	   check.setDeregisterCriticalServiceAfter("20s");
	   
	   s.setCheck(check);
	   
		client.agentServiceRegister(s);
		
		}
	
	public void destroy(@Observes @Destroyed(ApplicationScoped.class) Object init) {
		ConsulClient client = new ConsulClient();
		System.out.println("Deteniendo");
		client.agentServiceDeregister( id );
		}	
}
