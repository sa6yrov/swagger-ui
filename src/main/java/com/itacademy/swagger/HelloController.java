package com.itacademy.swagger;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/rest")
public class HelloController {
    Map<Integer, String> map = new HashMap<>();
    static Integer key = 0;


    @ApiOperation(value = "save 'Aidin'")
    @ApiResponses(value = {
            @ApiResponse(code = 100, message = "100 message"),
            @ApiResponse(code = 200, message = "OK")
    })
    @PostMapping
    public String create(@RequestBody String value){
        map.put(++key, value);
        return "Your value was successfully added";
    }

    @ApiOperation(value = "return Aidin")
    @ApiResponse(code = 200, message = "OK")
    @GetMapping("/key/{key}")
    public String getByKey(@PathVariable Integer key){
        return map.get(key);
    }
}
