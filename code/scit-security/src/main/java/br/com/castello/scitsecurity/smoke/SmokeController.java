package br.com.castello.scitsecurity.smoke;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SmokeController {

    @GetMapping(path = "smoke")
    public String smokeTest() {
        return "[OK]";
    }
}
