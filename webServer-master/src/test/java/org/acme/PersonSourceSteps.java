package org.acme;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.acme.Controllers.PersonResouceController;
import org.acme.Models.Person;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.lu.a.as;

public class PersonSourceSteps {
List<Person> result;
//String string = "\"\\{\"name\":\"yingli\",\"address\":\"DTU\"}\"";
PersonResouceController service = new PersonResouceController();
@When("I call the person")
public void iCallTheHelloService() {
result = service.getPerson();
}

@Then("I get the answer {string}")
public void iGetTheAnswer(String r) {
    System.out.println(r+"\n"+result);
    // String actualName = result.stream().filter(t -> t.getName().equals()).findFirst().get();
    assertEquals(r,result);
}
}