import ohtu.*
import ohtu.authentication.*
import org.openqa.selenium.*
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

description """A new user account can be created 
              if a proper unused username 
              and a proper password are given"""

scenario "creation succesfull with correct username and password", {
    given 'command new user is selected', {
       driver = new HtmlUnitDriver();
       driver.get("http://localhost:8090");
       element = driver.findElement(By.linkText("register new user"));       
       element.click();  
    }
 
    when 'a valid username and password are entered', {
        element = driver.findElement(By.name("username"));
        element.sendKeys("pihlat");
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkeadsasdp2");
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("akkeadsasdp2");
        element = driver.findElement(By.name("add"));
        element.submit();
    }

    then 'new user is registered to system', {
        driver.getPageSource().contains("continue to application mainpage").shouldBe true
    }
}

scenario "can login with succesfully generated account", {
    given 'command new user is selected', {
       driver = new HtmlUnitDriver();
       driver.get("http://localhost:8090");
       element = driver.findElement(By.linkText("register new user"));       
       element.click();  

    }
 
    when 'a valid username and password are entered', {
        element = driver.findElement(By.name("username"));
        element.sendKeys("pihlae");
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkeadsasdp2");
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("akkeadsasdp2");
        element = driver.findElement(By.name("add"));
        element.submit();

        element = driver.findElement(By.linkText("continue to application mainpage"));
        element.click();
        
    }

    then  'new credentials allow logging in to system', {
        driver.getPageSource().contains("Welcome to Ohtu Application!").shouldBe true
    }
}

scenario "creation fails with correct username and too short password", {
    given 'command new user is selected', {
       driver = new HtmlUnitDriver();
       driver.get("http://localhost:8090");
       element = driver.findElement(By.linkText("register new user"));       
       element.click(); 
    }
    when 'a valid username and too short password are entered', {
        element = driver.findElement(By.name("username"));
        element.sendKeys("pihlac");
        element = driver.findElement(By.name("password"));
        element.sendKeys("ak");
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("ak");
        element = driver.findElement(By.name("add"));
        element.submit();
    }
    then 'new user is not be registered to system', {
        driver.getPageSource().contains("length greater or equal to 8").shouldBe true
    }
}

scenario "creation fails with correct username and pasword consisting of letters", {
    given 'command new user is selected', {
       driver = new HtmlUnitDriver();
       driver.get("http://localhost:8090");
       element = driver.findElement(By.linkText("register new user"));       
       element.click(); 
    }
    when 'a valid username and password consisting of letters are entered', {
        element = driver.findElement(By.name("username"));
        element.sendKeys("pihlac");
        element = driver.findElement(By.name("password"));
        element.sendKeys("akssssssssss");
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("akssssssssss");
        element = driver.findElement(By.name("add"));
        element.submit();
    }
    then 'new user is not be registered to system', {
        driver.getPageSource().contains("must contain one character that is not a letter").shouldBe true
    }
}

scenario "creation fails with too short username and valid pasword", {
    given 'command new user is selected', {
        driver = new HtmlUnitDriver();
       driver.get("http://localhost:8090");
       element = driver.findElement(By.linkText("register new user"));       
       element.click(); 

    }
    when 'a too sort username and valid password are entered', {
        element = driver.findElement(By.name("username"));
        element.sendKeys("p");
        element = driver.findElement(By.name("password"));
        element.sendKeys("akssssssssss1");
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("akssssssssss1");
        element = driver.findElement(By.name("add"));
        element.submit();
    }
    then 'new user is not be registered to system', {
        driver.getPageSource().contains("length 5-10").shouldBe true
    }
}

scenario "creation fails with already taken username and valid pasword", {
    given 'command new user is selected', {
       driver = new HtmlUnitDriver();
       driver.get("http://localhost:8090");
       element = driver.findElement(By.linkText("register new user"));       
       element.click(); 
    }
    when 'a already taken username and valid password are entered', {
        element = driver.findElement(By.name("username"));
        element.sendKeys("pihlae");
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkeadsasdp2");
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("akkeadsasdp2");
        element = driver.findElement(By.name("add"));
        element.submit();
    }
    then 'new user is not be registered to system', {
        driver.getPageSource().contains("username or password invalid").shouldBe true
    }
}

scenario "can not login with account that is not succesfully created", {
    given 'command new user is selected', {
       driver = new HtmlUnitDriver();
       driver.get("http://localhost:8090");
       element = driver.findElement(By.linkText("register new user"));       
       element.click(); 
    }
    when 'a invalid username/password are entered', {
        element = driver.findElement(By.name("username"));
        element.sendKeys("x");
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkeadsasdp2");
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("akkeadsasdp2");
        element = driver.findElement(By.name("add"));
        element.submit();

        element = driver.findElement(By.linkText("back to home"));       
        element.click(); 
        
        element = driver.findElement(By.linkText("login"));       
        element.click(); 

        element = driver.findElement(By.name("username"));
        element.sendKeys("x");
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkeadsasdp2");
        element = driver.findElement(By.name("login"));
        element.submit();
    }
    then  'new credentials do not allow logging in to system', {
        driver.getPageSource().contains("Welcome to Ohtu Application!").shouldBe false
    }
}