package br.com.contmatic.model.prova.empresa;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

public class TestOrdemDeExec {

	@TestMethodOrder(OrderAnnotation.class)
	public class OrderedTestsDemo {
		
		@Order(1)
	    @Test
	    public void nullValues() {
	        // perform assertions against null values
	    }
		
		@Order(2)
	    @Test
	    public void emptyValues() {
	        // perform assertions against empty values
	    }
		@Order(3)
	    @Test
	    void validValues() {
	        // perform assertions against valid values
	    }

	}

}
