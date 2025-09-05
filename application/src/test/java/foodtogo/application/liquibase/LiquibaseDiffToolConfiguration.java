package foodtogo.application.liquibase;

import foodtogo.application.requestcontext.RequestContextManager;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties({HibernateProperties.class, LiquibaseProperties.class})
public class LiquibaseDiffToolConfiguration {

    @Bean
    RequestContextManager requestContextManager() {
        return new RequestContextManager();
    }


}
