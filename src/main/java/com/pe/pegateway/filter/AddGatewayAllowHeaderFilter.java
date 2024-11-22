package com.pe.pegateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import util.JwtUtil;

@Component
public class AddGatewayAllowHeaderFilter extends AbstractGatewayFilterFactory<AddGatewayAllowHeaderFilter.Config> {

    public AddGatewayAllowHeaderFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            // Отримання ключа підпису через JwtUtil
            String signInKey = JwtUtil.getSignInKey().toString();

            // Додаємо заголовок до запиту
            ServerWebExchange modifiedExchange = exchange.mutate()
                    .request(r -> r.header("X-Gateway-Allow", signInKey))
                    .build();

            return chain.filter(modifiedExchange);
        };

    }

    public static class Config {
        // Налаштування конфігурації (за потреби)
    }
}
