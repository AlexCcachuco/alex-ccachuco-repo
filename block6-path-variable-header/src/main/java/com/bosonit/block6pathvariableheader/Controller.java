package com.bosonit.block6pathvariableheader;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class Controller {

    @PostMapping(value = "/addGreeting")
    public Greeting createGreeting(@RequestBody Greeting greeting){
     return greeting;
    }

    @GetMapping(value = "/user/{id}")
    public String userId(@PathVariable String id){
        return id;
    }

    @PutMapping(value = "/post")
    public HashMap<String,String> getValues(@RequestParam String var1, @RequestParam String var2){
        HashMap<String,String> hashMap= new HashMap<String,String>();
        hashMap.put("saludo", var1);
        hashMap.put("despedida", var2);
        return hashMap;
    }
}
