package cn.sdadgz.oauth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

import javax.annotation.Resource;

/**
 * 令牌配置
 *
 * <p>
 * 废物本物
 * </p>
 *
 * @author sdadgz
 * @since 2023/3/8 18:47:58
 */
@Configuration
public class TokenConfig {

    @Bean
    public TokenStore tokenStore(){
        return new InMemoryTokenStore();
    }

}
