# Uppgift 5: Paketering och körning av Spring Boot-applikation

| Data            | Värde                                                                     |
| --------------- | ------------------------------------------------------------------------- |
| **Namn**        | Ali Rezai                                                                 |
| **Email**       | 00alirez01@gafe.molndal.se                                                |
| **GitHub-länk** | https://github.com/xmozaffary/api-webservices-final-assignment_00alirez01 |


---

## 1. Beskrivning av uppgiften

(Kortfattad beskrivning av vad uppgiften innebär och dess syfte.)

Denna uppgift går ut på att skapa en Spring Boot-applikation för att hantera röstning i en tävling.
Användare kan skicka in sina röster via ett API och sedan se aktuella röstresultat.
Syftet är att demonstrera hur man bygger och kör en fristående Spring Boot-applikation.

# Förklara skillnaden mellan en **fat JAR** (som inkluderar alla beroenden) och en vanlig JAR. (VG)

(dina tankar här)

### Beskriv olika sätt att distribuera en Spring Boot-applikation utan Docker. (VG)

(dina tankar här)

### Demonstrera hur miljövariabler kan användas för att hantera olika driftsmiljöer. (VG)

(dina tankar här)

## 2. Installation och körning

(Instruktioner för hur applikationen byggs och körs. Om externa verktyg krävs, beskriv hur dessa installeras och används.)

### Bygga och köra JAR-filen:


### Förberedelser
För att bygga och köra applikationen behöver du:
- Java (JDK 17 eller senare)
- Maven (om det inte är installerat, ladda ner från https://maven.apache.org/)
- Man behöver detta plugin för att skapa ett körbar JAR-fil.

```xml
<build>
    <plugins>
        <plugin>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-maven-plugin</artifactId>
        </plugin>
    </plugins>
</build>
```


### Bygga och köra JAR-filen
Bygg applikationen genom att köra följande kommando:
```sh
mvn clean package
```
Detta skapar en körbar JAR-fil i `target/`-mappen.

Starta applikationen genom att köra:
```sh
java -jar target/Uppgift_5-0.0.1-SNAPSHOT.jar
```
Applikationen körs nu på `http://localhost:8080/vote`.

## 3. Användning av API:et

(Beskrivning av API-endpoints och exempelanrop.)

### Exempel på endpoints:

-   **POST** /vote

    -   Beskrivning: Lägger till en röst
```json
    { "contestant": "Artist A" }
```
- Respons: `{ "message": "Röst registrerad" }`


-   **GET** /vote
    -   Beskrivning: Hämtar aktuella röstresultat
```json
    { "results": [{ "contestant": "Artist A", "votes": 1 }] }
```

För att rösta och hämte resulltatet använder man samma url ("http://localhost:8080/vote"), för att rösta använder man POST metoden och för att se resulltatet använder man GET metoden.


## 4. Felhantering

(Vilka typer av fel kan uppstå och hur de hanteras. Exempel på felmeddelanden och statuskoder som returneras.)

- **400 BAD REQUEST** används när användaren skickar ogiltig JSON eller saknar nödvändiga fält i förfrågan.
- **500 INTERNAL SERVER ERROR** returneras när servern inte svarar eller om ett internt fel inträffar.
## 5. Tester

(Beskriv hur API:et har testats. Om tester är automatiserade, förklara hur de körs och vad de testar.)

Jag har testat API:et manuellt genom att skicka både giltiga och ogiltiga förfrågningar. Jag har verifierat att röstregistrering fungerar korrekt, att resultaten hämtas som förväntat, och att felhantering fungerar genom att testa olika fel, såsom saknade parametrar och ogiltig JSON.


## 6. Reflektion

-   Vad har varit utmanande i uppgiften?
    - En utmanning var att veta att man gör uppgiften rätt, annars var det inte så utmannade.
-   Vad skulle kunna förbättras?
    - Man skulle kunna implementera säkerhet(JWT eller OAuth2).
    - Implementera bättre felmeddelande.
    - förbättra inputvaledering.
-   Eventuella lärdomar från implementationen.
    - Genom att använda ConcurrentHashMap för att hantera röster har jag fått bättre förståelse för hur man kan säkerställa trådsäkerhet i en applikation där flera användare kan göra ändringar samtidigt.
