package com.rlalsa8843.hikari.demo;

import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private final DemoMapper demoMapper;

    public DemoController(DemoMapper demoMapper) {
        this.demoMapper = demoMapper;
    }

    @GetMapping("/get/{key}")
    public ResponseEntity<String> getValue(@PathVariable("key") String key) {
        String value = demoMapper.select(key);
        return ResponseEntity.ok(value);
    }

    @PostMapping("/set")
    public ResponseEntity<String> setValue(@RequestBody DemoModel model) {
        demoMapper.insert(model);
        return ResponseEntity.ok("success");
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateValue(@RequestBody AliasModel model) {
        demoMapper.update(model);
        return ResponseEntity.ok("success");
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteKey(@RequestBody Map<String, String> param) {
        demoMapper.delete(param);
        return ResponseEntity.ok("success");
    }
}
