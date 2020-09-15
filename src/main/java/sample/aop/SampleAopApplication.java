/*
 * Copyright 2012-2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package sample.aop;

import sample.aop.domain.bank.Account;
import sample.aop.domain.bank.Bank;
import sample.aop.domain.bank.IAccount;
import sample.aop.domain.bank.IBank;
import sample.aop.domain.client.Client;
import sample.aop.domain.client.IClient;
import sample.aop.domain.provider.IProvider;
import sample.aop.domain.provider.Provider;
import sample.aop.domain.store.IStore;
import sample.aop.domain.store.Store;
import sample.aop.service.HelloWorldService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SampleAopApplication implements CommandLineRunner {

	// Simple example shows how an application can spy on itself with AOP

	@Autowired
	private HelloWorldService helloWorldService;

	@Autowired
	private IClient client;

	public void run(String... args) {
		Thread th = new Thread((Client) this.client);
		th.start();

		System.out.println(helloWorldService.getHelloMessage());
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(SampleAopApplication.class, args);
	}

	@Bean(name = "storeAccount")
	public IAccount storeAccount() {
		return new Account();
	}

	@Bean(name = "clientAccount")
	public IAccount clientAccount() {
		return new Account();
	}

}
