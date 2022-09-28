# Simple SOAP Service with Auth #

## Features 
- Supports Java EE 8
- Tested on JBoss WildFly 26
- Supports Oasis web service security standard headers
- Validates and authorize requests using the SOAP Header

### Sample SOAP request:

```xml
<soapenv:Envelope xmlns:soap="http://soap.fifthgen.org/" xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/">
   <soapenv:Header>
      <a:MessageID xmlns:a="http://www.w3.org/2005/05/addressing">uuid:93e0c133-f54b-47ab-bcce-4d7dfdd71f53</a:MessageID>
      <wsse:Security soapenv:mustUnderstand="1" xmlns:wsse="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd" xmlns:wsu="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd">
         <wsu:Timestamp wsu:Id="TS-F1E15E70ABC994EBAA16643972881662">
            <wsu:Created>2022-09-28T20:34:48.166Z</wsu:Created>
            <wsu:Expires>2022-09-28T21:34:48.166Z</wsu:Expires>
         </wsu:Timestamp>
         <wsse:UsernameToken wsu:Id="UsernameToken-1">
            <wsse:Username>admin</wsse:Username>
            <wsse:Password Type="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText">admin</wsse:Password>
         </wsse:UsernameToken>
      </wsse:Security>
   </soapenv:Header>
   <soapenv:Body>
      <soap:sayHello>
         <!--Optional:-->
         <userDetails>
            <!--Optional:-->
            <name>Jane Austin</name>
            <!--Optional:-->
            <dateOfBirth>1972-11-12</dateOfBirth>
            <!--Zero or more repetitions:-->
            <addresses>
               <!--Zero or more repetitions:-->
               <addressLine>S2 4DD</addressLine>
               <addressLine>Sheffield</addressLine>
               <addressLine>United Kingdom</addressLine>
            </addresses>
         </userDetails>
      </soap:sayHello>
   </soapenv:Body>
</soapenv:Envelope>
```

## Deployment

WildFly 26+ recommended. When deploying on servlet only containers like Tomcat, remove the provided tag from API dependencies and add an implementation library such as Eclipse Metro

```xml
<dependency>
    <groupId>org.glassfish.metro</groupId>
    <artifactId>webservices-rt</artifactId>
    <version>4.0.0</version>
</dependency>
```