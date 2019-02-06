package hello;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class GreetingPort {
	
	public static void main(String args[]) {
		System.out.println("Respuesta post:"+postGreetings(1,"Hola Pepe"));
		System.out.println("Respuesta post:"+postGreetings(2,"Hola Juan"));
		System.out.println("Respuesta post:"+postGreetings(3,"Hola Pedro"));
		System.out.println("Respuesta get_id:"+getGreetings(3));
		System.out.println("Respuesta put_id:"+putGreetings(3,"Hola pepito"));
		System.out.println("Respuesta get_id:"+getGreetings(3));
		System.out.println("Respuesta delete_id:"+deleteGreetings(1));
		
		System.out.println("RESPUESTA DE GETALL::");
		for(Greeting g: getAllGreetings()) {
			System.out.println(g);
		}
	}
	
	public static int postGreetings(long id, String content) {
		Greeting g=new Greeting(id,content);
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<Greeting> request = new HttpEntity<>(g);
		ResponseEntity<Greeting> response = restTemplate
		  .exchange("http://localhost:8080/greetings", HttpMethod.POST, request, Greeting.class);
		return response.getStatusCodeValue();
	}
	
	public static int putGreetings(long id, String content) {
		Greeting g=new Greeting(id,content);
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<Greeting> request = new HttpEntity<>(g);
		ResponseEntity<Greeting> response = restTemplate
		  .exchange("http://localhost:8080/greetings/"+id, HttpMethod.PUT, request, Greeting.class);
		return response.getStatusCodeValue();
	}
	
	public static int deleteGreetings(long id) {		
		RestTemplate restTemplate = new RestTemplate();		
		ResponseEntity<Greeting> response = restTemplate
		  .exchange("http://localhost:8080/greetings/"+id, HttpMethod.DELETE, null, Greeting.class);
		return response.getStatusCodeValue();
	}
	
	public static Greeting getGreetings(int id) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Greeting> response = restTemplate.getForEntity("http://localhost:8080/greetings/"+id, Greeting.class);
		return response.getBody();
	}
	
	public static List<Greeting> getAllGreetings() {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<List<Greeting>> response = restTemplate.exchange("http://localhost:8080/greetings/", HttpMethod.GET, null, new ParameterizedTypeReference<List<Greeting>>() {});
		return response.getBody();
	}
}
