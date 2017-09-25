package hello;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController // resource controller
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting") // make sures /greeting are mapped to the greeting() method
    public Greeting greeting(@RequestParam(value="name", defaultValue="fellow Earthlings") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
}
