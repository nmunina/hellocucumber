# Selenium + cucumber project
Educational task to test registration form on Vimla forum with the BDD approach.

## Requirements for exercise
På forumet https://forumet.vimla.se/register kan man registrera sig som användare

Skriv testfall som testar denna registreringsfunktion

**Testfall**

- Skapa användare

- Skapa användare – långt användarnamn (mer än 16 tecken)

- Skapa användare – lösenord och bekräfta lösenord skiljer sig

- Skapa användare – E-postadress är redan använd

**Krav på testfall**

- Verifiering skall ske på varje testfall med minst en Junit assert. Verifieringen skall vara på ett sådant sätt att den även upptäcker när testfallet går fel

- Testfallen skall skapas genom en Scenario Outline ifrån en feature-fil

- Feature-filen skall vara skapad enligt BDD och innehålla en tydlig beskrivning

## Built With

* [IntelliJ IDEA](https://www.jetbrains.com/idea/)
* [Maven](https://maven.apache.org/)
* [JUnit](https://junit.org/)
* [Cucubmer](https://cucumber.io/)
* [Gherkin Syntax](https://cucumber.io/docs/gherkin/)
* [Selenium WebDriver](https://www.selenium.dev/)

## SetUp tips for development
https://www.youtube.com/watch?v=55vJUqHSbkQ

https://www.baeldung.com/cucumber-data-tables

https://www.axelerant.com/resources/team-blog/setup-for-selenium-with-cucumber-using-maven