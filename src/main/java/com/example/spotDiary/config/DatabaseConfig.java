package com.example.spotDiary.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:/application.properties")
public class DatabaseConfig {

//    private final MemberRepository memberRepository;
//
//    @Autowired
//    public DatabaseConfig(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }
//    @Bean
//    public MemberService memberService() {
//        return new MemberService(memberRepository);
//    }


    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.hikari")
    public HikariConfig hikariConfig() {
        return new HikariConfig();
    }

    @Bean
    public DataSource dataSource() {
        return new HikariDataSource(hikariConfig());
    }

}
