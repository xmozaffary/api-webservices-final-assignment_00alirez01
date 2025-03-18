# Uppgift 2: API-testning: strategier och bästa praxis

| Data            | Värde                                                                     |
| --------------- | ------------------------------------------------------------------------- |
| **Namn**        | Ali Rezai                                                                 |
| **Email**       | 00alirez01@gafe.molndal.se                                                |
| **GitHub-länk** | https://github.com/xmozaffary/api-webservices-final-assignment_00alirez01 |

---

## 1. Beskrivning av uppgiften

(Kortfattad beskrivning av vad uppgiften innebär och dess syfte.)

Uppgiften innebär att skapa en REST API med spring boot som fungerar som en enkelt kalkylator. Den har en kontroller med 3 endpoints add, subract, multiply och divide som tar emot två heltal via POST metod i JSON format och returnerar resultatet av den angivna operationer.

### Beskriv skillnaden mellan enhetstestning, integrationstestning och end-to-end-testning. (VG)

(dina tankar här)

### Diskutera varför felhantering och statuskoder är avgörande för robusta API:er. (VG)

(dina tankar här)

## 2. Installation och körning

(Instruktioner för hur applikationen byggs och körs. Om externa verktyg krävs, beskriv hur dessa installeras och används.)

#### Färutsättningar

    - Java development kit 21
    - Maven - för att bygga och hantera beroendet

#### Bygga och köra applikation

    - Skriva mvn clean package för att bygga applikationen
    - mvn spring-boot:run för att köra applikationen

## 3. Användning av API:et

(Beskrivning av API-endpoints med exempelanrop: HTTP-metoder, URL:er och exempel-payloads.)

Beskrivning ac API:ets endpoints och metoder.

### Addera 2 heltal

    - Metod: POST
    - URL: http://localhost:8080/calculator/add

#### Example anrop:

    curl -X POST http://localhost:8080/calculator/add \
    -H "Content-Type: application/json" \
    -H "Accept: application/json" \
    -d '{"num1": 5, "num2": 10}'

#### Response(200 ok)

    - {"result": 15}

### subtrahera 2 heltal

    - Metod: POST
    - URL: http://localhost:8080/calculator/subtract

#### Example anrop:

    curl -X POST http://localhost:8080/calculator/add \
    -H "Content-Type: application/json" \
    -H "Accept: application/json" \
    -d '{"num1": 10, "num2": 10}'

#### Response(200 ok)

    - {"result": 10}

### multiplicera 2 heltal

    - Metod: POST
    - URL: http://localhost:8080/calculator/multiply

#### Example anrop:

    curl -X POST http://localhost:8080/calculator/add \
    -H "Content-Type: application/json" \
    -H "Accept: application/json" \
    -d '{"num1": 4, "num2": 6}'

#### Response(200 ok)

    - {"result": 24}

### dividera 2 heltal

    - Metod: POST
    - URL: http://localhost:8080/calculator/divide

#### Example anrop:

    curl -X POST http://localhost:8080/calculator/add \
    -H "Content-Type: application/json" \
    -H "Accept: application/json" \
    -d '{"num1": 15, "num2": 3}'

#### Response(200 ok)

    - {"result": 5}

Om man försöker dividera ett tal me noll får man detta error: "Error: Division by zero is not allowed."

## 4. Felhantering

(Vilka typer av fel kan uppstå och hur de hanteras. Exempel på felmeddelanden och statuskoder som returneras.)

    Ett fel som man uppstå är att man skickar ogiltig JSON, och man man gör det får man status koden 400 bad request.

    Ett annan fel som kan uppstå är att om man använder fel typ av http metod, till example GET istället för POST.

## 5. Tester

(Beskriv hur API:et har testats. Om tester är automatiserade, förklara hur de körs och vad de testar.)

## 6. Reflektion

- Vad har varit utmanande i uppgiften?
  - Att definera och hantera alla potentiella fel, som division med noll eller ogiltig inmatning.
- Vad skulle kunna förbättras?
  - Man kan lägga till validering för att validera @RequestBody, och en annan förbättring som man kan göra att implementera exception.
  - Man kan också optimera koden så att det blir kortare, snabbare och kätt att förstå.
- Eventuella lärdomar från implementationen.
  - Att använda separata endpoints för varje operation fungerar, men man kan bli opraktiskt som flera operationer läggs till.
