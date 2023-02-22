package com.example.extendwebtech;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class Bankspringbootproject12ApplicationTests {
	@Mock
	com.extend.bank.Bankspringbootproject12Application tobankspringbootproject12application;

	@Test
	void contextLoads() {
		Assertions.assertThat(tobankspringbootproject12application).isNotNull();

	}

}
