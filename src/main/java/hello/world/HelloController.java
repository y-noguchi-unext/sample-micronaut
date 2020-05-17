/*
 * Copyright(c) u-next.
 */
package hello.world;


import java.util.ArrayList;
import java.util.List;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.reactivex.Single;

@Controller("/hello") 
public class HelloController {
	
	private static Person person = new Person();
	private static List<Person> people = new ArrayList<>();

    @Get 
    public HttpResponse<Person> index() {
        return HttpResponse.ok(person); 
    }
    
    @Get("/list")
    public HttpResponse<List<Person>> getList(){
    	return HttpResponse.ok(people);
    }
    
    @Post
    public HttpResponse<Person> postIndex(@Body Person body) {
    	people.add(body);
		return HttpResponse.created(body);
	}
    
    public static class Person {
    	public String name;
    	public Integer age;
    	
    	public Person() {
    		this.name = "野口";
    		this.age = 28;
		}
    }
}