package com.example.flow;


import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class TestController {

    private final ReactiveRedisTemplate<String, String> reactiveRedisTemplate;


    @GetMapping()
    @RequestMapping("/test")
    public Mono<String> test() {
        return reactiveRedisTemplate.opsForValue()
                .set("testkey", "testvalue")
                .doOnSuccess(result -> {
                    // Redis 작업이 성공적으로 완료되었을 때 수행할 동작
                    System.out.println("Redis 작업이 완료되었습니다.");
                })
                .thenReturn("ok");
    }
}
