package com.zap.desafio;

import com.zap.desafio.business.ImmobileBusiness;
import com.zap.desafio.dto.ImmobileDto;
import com.zap.desafio.exception.BusinessException;
import com.zap.desafio.service.ImmobileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class DesafioApplication {

	@Autowired
	private ImmobileBusiness immobileBusiness;

	public static void main(String[] args) throws BusinessException {

		ConfigurableApplicationContext context = SpringApplication.run(DesafioApplication.class, args);

		ImmobileBusiness immobileBusiness = new ImmobileBusiness();

		AutowireCapableBeanFactory autowireCapableBeanFactory = context.getAutowireCapableBeanFactory();
		autowireCapableBeanFactory.autowireBean(immobileBusiness);
		autowireCapableBeanFactory.initializeBean(immobileBusiness, "immobileBusiness");

		immobileBusiness.elect();

	}

}
