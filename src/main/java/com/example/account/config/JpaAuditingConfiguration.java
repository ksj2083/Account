package com.example.account.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration //이 클래스가 Application이 뜰 때, auto스캔되며,
@EnableJpaAuditing //스프링이 JpaAuditing이 켜진 상태로 뜬다
public class JpaAuditingConfiguration {
}
