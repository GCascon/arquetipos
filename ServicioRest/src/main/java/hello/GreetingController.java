package hello;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class GreetingController {

    List<Greeting> lista=new ArrayList<Greeting>();
    
    @GetMapping("/greetings")
    public List<Greeting> getAllGreetings() {
        return lista;
    }

    @PostMapping("/greetings")
    public Greeting createGreeting(@Valid @RequestBody Greeting greeting) {
        lista.add(greeting);
        return greeting;
    }
    
    @GetMapping(value="/greetings/{id}")
    public ResponseEntity<Greeting> getGreetingById(@PathVariable("id") int id) {
    	Greeting result=findById(id);
    	return ResponseEntity.ok().body(result);
    }
    
    @PutMapping(value="/greetings/{id}")
    public ResponseEntity<Greeting> updateGreeting(@PathVariable("id") int id,
                                           @Valid @RequestBody Greeting greeting) {
    	Greeting result=findById(id);
    	if(result!=null) {
    		result.setContent(greeting.getContent());
    		return ResponseEntity.ok().body(result);
    	}else {
    		return ResponseEntity.notFound().build();
    	}
    }

    @DeleteMapping(value="/greetings/{id}")
    public ResponseEntity<?> deleteGreeting(@PathVariable("id") int id) {
        try {
        	lista.remove(id-1);
        	return ResponseEntity.ok().build();
        }catch(Exception e) {
        	return ResponseEntity.notFound().build();
        }    	
    }
    
    private Greeting findById(int id) {
    	Greeting result=null;
    	for(Greeting g:lista) {
    		if(g.getId()==id) {
    			result=g;
    		}
    	}
    	return result;
    }
}
