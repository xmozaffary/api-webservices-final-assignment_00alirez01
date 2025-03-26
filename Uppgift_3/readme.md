# Uppgift 3: Implementera en enkel SOAP-webservice


| Data            | Värde                                                                                             |
|-----------------|---------------------------------------------------------------------------------------------------|
| **Namn**        | David Andreasson                                                                                  |
| **Email**       | 79davand@gafe.molndal.se                                                                          |
| **GitHub-länk** | https://github.com/david-andreasson/api-webservices-final-assignment_79davand/tree/main/Uppgift_3 |
---

## 1. Beskrivning av uppgiften

Uppgiften innebär att skapa en SOAP-wenntjänst för att hantera en lista av telefonmodeller med CRUD-operationer i en spring boot applikation.
Syftet är att lära sig bygga och testa en SOAP-webbtjänst för att hantera data via XML-baserade förfågningar och svar.

(Kortfattad beskrivning av vad uppgiften innebär och dess syfte.)


## Förklara skillnaden mellan SOAP och REST samt när SOAP fortfarande är relevant. (VG)

(dina tankar här)

### Beskriv hur en klient skulle anropa tjänsten med XML-baserade anrop. (VG)

(dina tankar här)

## 2. Installation och körning

(Instruktioner för hur applikationen byggs och körs. Om externa verktyg krävs, beskriv hur dessa installeras och används.)

#### Färutsättningar

    - Java development kit 21
    - Maven - för att bygga och hantera beroendet

#### Bygga och köra applikation

    - Skriva mvn clean install för att bygga applikationen
    - mvn spring-boot:run för att köra applikationen


## 3. Användning av API:et

(Beskrivning av SOAP-tjänstens funktionalitet och XML-struktur för anrop.)

### Exempel på SOAP-anrop:

 För att hämta information om en telefon baserat på dess phoneId :
#### Exempel på SOAP-anrop (GetPhoneRequest):

```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:pho="http://example.org/phones">
    <soapenv:Header/>
    <soapenv:Body>
        <pho:GetPhoneRequest>
            <pho:phoneId>1</pho:phoneId>
        </pho:GetPhoneRequest>
    </soapenv:Body>
</soapenv:Envelope>
```

#### Exempel på SOAP-svar (GetPhoneResponse)::

```xml
<SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
    <SOAP-ENV:Header/>
    <SOAP-ENV:Body>
        <ns2:GetPhoneResponse xmlns:ns2="http://example.org/phones">
            <ns2:name>Galaxy S21</ns2:name>
            <ns2:brand>Samsung</ns2:brand>
            <ns2:year>2021</ns2:year>
        </ns2:GetPhoneResponse>
    </SOAP-ENV:Body>
</SOAP-ENV:Envelope>
```

## 4. Felhantering

Flera fel kan uppstå via olika tillfällen.
(Vilka typer av fel kan uppstå och hur de hanteras. Exempel på felmeddelanden och statuskoder som returneras.)

### Typer av fel:
#### Ogiltig ohoneID
    Om ett ogiltig ohoneOd skickas(t.ex. om ett negativ nummer som inte finns i databasen)
#### Fel i XML-struktur:
    Om det inte går att skapa en ny telefon pgv fel body(ogiltig xml struktur)


## 5. Tester

(Beskriv hur SOAP-tjänsten har testats. Om tester är automatiserade, förklara hur de körs och vad de testar.)
- Jag har testat applikationen via postman för att säkerställa att CRUP-operationer fungerar korrekt.
## 6. Reflektion

-   Vad har varit utmanande i uppgiften?
    - Att konfiguera och hantera SOAP-webbtjänsten korrekt.
    - Hantera fel på ett bra sätt
-   Vad skulle kunna förbättras?
    - Automatisera alla tester för en mer robust testning
-   Eventuella lärdomar från implementationen.
    - jag har förståt bättre hur man använder XML-schema för att definera struktur.
