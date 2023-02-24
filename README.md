
# Spring Mail Sender

Spring Mail Sender is a Java library developed with the Spring Boot framework that allows for simple and configurable email sending. The library uses the JavaMail API to send emails via SMTP (Simple Mail Transfer Protocol).



## How it works

The project contains a main class EmailService that is responsible for sending the email based on the provided configurations. The class uses the JavaMailSender class from the JavaMail API to send emails via SMTP.

The user can customize the email message by providing the body content and subject of the email. Additionally, it is possible to send attachments with the email through a list of MultipartFile objects.

The project provides an example of usage in a Spring MVC controller that uses the EmailService class to send an email with an attachment.


## How to use

To use the library, simply include the dependency in your project's pom.xml file:

```xml
<dependency>
  <groupId>com.github.luanozn</groupId>
  <artifactId>spring-mail-sender</artifactId>
  <version>1.0.0</version>
</dependency>

```

Next, configure the email sending in your project's application.properties or application.yml file. You must provide the configuration information for your SMTP server, such as host, port, username, and password:

```properties
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=<your-email>
spring.mail.password=<your-password>
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true

```

Finally, use the EmailService class to send emails in your Java code:

```java
@Autowired
private EmailService emailService;

public void sendEmail() {
  String to = "recipient@example.com";
  String subject = "Email subject";
  String body = "Email body";
  
  List<MultipartFile> attachments = new ArrayList<>();
  // Add attachments here, if any
  
  emailService.sendEmail(to, subject, body, attachments);
}

```
## Autores

- [@luanozn](https://www.github.com/luanozn)

