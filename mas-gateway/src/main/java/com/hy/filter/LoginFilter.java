package com.hy.filter;

import com.hy.config.utils.JwtUtil;
import com.hy.result.ContentResult;
import com.hy.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.HashSet;

@Order(-1)
@Component
public class LoginFilter implements GlobalFilter {

    @Autowired
    private JwtUtil jwtUtil;

    @Value("#{'${ex.url}'.empty?null:'${ex.url}'.split(',')}")
    private HashSet<String> urls;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //获取请求对象
        ServerHttpRequest request = exchange.getRequest();
        //获取请求头对象
        HttpHeaders headers = request.getHeaders();
       //从请求头中获取token
        String token = headers.getFirst("token");
        //匹配路径 放行登录请求
        AntPathMatcher ant = new AntPathMatcher();
        for(String url:urls){
            String path = request.getURI().getPath();
            if(ant.match(url,path)){
                return chain.filter(exchange);
            }
        }
        //判断token是否为空
        if(token==null){
            return getMono(exchange);
        }
        try {
            jwtUtil.parseJwt(token);
            return chain.filter(exchange);

        } catch (Exception e) {
            e.printStackTrace();
            return getMono(exchange);
        }
    }

    private static Mono<Void> getMono(ServerWebExchange exchange) {
        //获取响应对象
        ServerHttpResponse response = exchange.getResponse();
        //设置响应头 向前端传递中文响应
        response.setStatusCode(HttpStatus.UNAUTHORIZED);
        response.getHeaders().add("Content-Type","application/json;charset=UTF-8");
        //设置响应内容
        Result result = new Result(ContentResult.TOKEN_NOT_NULL_CODE, ContentResult.TOKEN_NOT_NULL_MSG);
        return response.writeWith(Mono.just(response.bufferFactory().wrap(result.toString().getBytes())));
    }
}
