# Uppgift 1: Implementera Swagger i ett Spring Boot-projekt

| Data            | Värde                                                                     |
| --------------- | ------------------------------------------------------------------------- |
| **Namn**        | Ali Rezai                                                                 |
| **Email**       | 00alirez01@gafe.molndal.se                                                |
| **GitHub-länk** | https://github.com/xmozaffary/api-webservices-final-assignment_00alirez01 |

---

## 1. Beskrivning av uppgiften

(Kortfattad beskrivning av vad uppgiften innebär och dess syfte.)

Denna uppgift går ut på att utveckla en enkel REST API-applikation med Spring boot som hanterar en lista med böcker.
Applikationen har 2 endpoints för att hämta och lägga till böcker och använder Swagger(Openapi) för att dekummentera API:et.

#### Syftet:

    - Få praktisk erfarenhet av att bygga REST API:et med Spring Boot
    - Lära sig att använda Swagger för att dokummnetera API:er
    - Färstå hur man hanterar HTTP-request och JSON-data

### Förklara varför API-dokumentation är viktig för både utvecklare och beställare. (VG)

(dina tankar här)

### Reflektera över hur Swagger kan integreras i en CI/CD-pipeline. (VG)

(dina tankar här)

### Beskriv hur dokumentationen kan hållas uppdaterad vid API-förändringar. (VG)

(dina tankar här)

## 2. Installation och körning

(Instruktioner för hur applikationen byggs och körs. Om externa verktyg krävs, beskriv hur dessa installeras och används.)

#### Färutsättningar

    - Java development kit 21
    - Maven - för att bygga och hantera beroendet

#### Bygga och köra applikation

    - Skriva mvn clean package för att bygga applikationen
    - mvn spring-boot:run för att köra applikationen

Efter att man har byggt applikationen kan man använda Get metod för att hämta alla böcker och post för att lägga till en bök.
Båda för Get och post kan man använda detta url: localhost:8080/book

## 3. Användning av API:et

(Beskrivning av API-endpoints med exempelanrop: HTTP-metoder, URL:er och exempel-payloads.)

Beskrivning av API:ets endpoints och HTTP-metoder.

#### Hämta alla böcker:

    - Metod:GET
    - URL: /book
    - Hämtar en lista med alla böcker.

#### Exampelanrop:

    - Curl -X GET "http://localhost:8080/book" -H "accept:  application/json"

#### Response(200 ok)

```javascript
[
  {
    name: "To Kill a Mockingbird",
    year: 1960,
    author: "Harper Lee",
  },
  {
    name: "1984",
    year: 1949,
    author: "George Orwell",
  },
  {
    name: "The Great Gatsby",
    year: 1925,
    author: "F. Scott Fitzgerald",
  },
];
```

#### Lägga till en ny bok

    - Metod: POST
    - URL: /book
    - lägger till en ny bok

#### Exampelanrop:

    curl -X POST "http://localhost:8080/book" \
     -H "Content-Type: application/json" \
     -d '{
          "name": "Test Book",
          "author": "Author Name",
          "year": 2024
         }'

#### Request body(json)

```javascript
    {
        "name": "Test Book",
        "author": "Author Name",
        "year": 2024
    }
```

#### Response(201 Created)

```javascript
{
    "message": "Book added"
}
```

#### Swagger

    - Du kan testa dessa endpoints via Swagger UI genom att gå till:
    - http:// localhost:8080/swagger-ui.html

## 4. Felhantering

(Vilka typer av fel kan uppstå och hur de hanteras. Exempel på felmeddelanden och statuskoder som returneras.)

#### Vid användning av API:et kan olika fel uppstå.

- Ogiltig request(400 bad request)
  - Om klient skickar en ogiltig JSON-payload får man status kode 400 som står för bad request.
- Server fel(500 internal server error)
  - om ett öväntad fel uppstår i systemet får man error 500
- Fel metod
  - Om man skickar ett request med fel metod t.ex DELETE får man status kode 405 "Method not allowed"

## 5. Tester

(Beskriv hur API:et har testats. Om tester är automatiserade, förklara hur de körs och vad de testar.)

    - För att testa API:et manuell kan man använda posteman för att skicka GET och POST request för att verifera svaren.

#### Ecampel på manuell testning i postman:

    - GET: localhost:8080/book -> en liste med böcker ska returneras.
    - POST: localhost:8080/book -> med rätt JSON, Bekräftar att en ny bok läggas till
    - POST: localhost:8080/book -> med fel json, testar hur API:et hanterar felaktiga förfrågningar.

## 6. Reflektion

- Vad har varit utmanande i uppgiften?
  - Att förstå hur implementerar swagger och förstå hur Openapi annoteringar fungerar och hur kan man använda på bästa sätt för att dokumenterar API:et på ett tydligt sätt.
- Vad skulle kunna förbättras?
  - Man kan lagra böckere i databas för att bok listan ska inte försvinna efter varje gång man kör applikationen.
  - Man kan ha flera endpoint för att uppdatera och ta bort böcker.
  - Man kan felhantera med try-catch och exception
- Eventuella lärdomar från implementationen.
  - Swagger gör det lättare att förstå och testa API:et, särskilt för andra utvecklare.
