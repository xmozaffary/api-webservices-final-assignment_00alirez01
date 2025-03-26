## 1. Beskrivning av uppgiften

(Kortfattad beskrivning av vad uppgiften innebär och dess syfte.)


Uppgiften innebär att skapa en enkel GraphQL-server som hanterar sportresultat, där du implementerar funktioner för att hantera matcher och resultat. Målet är att använda GraphQL för att skapa en API som tillåter CRUD-operationer (Create, Read, Update, Delete) för sportresultat.
Syftet med uppgiften är att ge praktisk erfarenhet av att arbeta med GraphQL i en Spring Boot-applikation, samt att jämföra fördelarna med GraphQL över REST.

### Förklara skillnaden mellan GraphQL och REST. (VG)

(dina tankar här)

### Demonstrera hur man kan optimera queries för att minska onödig datalast. (VG)

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

(Beskrivning av GraphQL-endpoints och exempelanrop.)

### Exempel på GraphQL-anrop:

#### Hämta alla matcher:

```graphql
{
  "query": "query { matches { id teamA teamB scoreA scoreB } }"
}

```

#### Svar:

```json
{
  "data": {
    "matches": [
      {
        "id": "1",
        "teamA": "Team Red",
        "teamB": "Team Blue",
        "scoreA": 4,
        "scoreB": 2
      },
      {
        "id": "2",
        "teamA": "Team Green",
        "teamB": "Team Yellow",
        "scoreA": 3,
        "scoreB": 3
      }
    ]
  }
}
```

#### Lägga till en ny match:

```graphql
{
  "query": "mutation { addMatch(teamA: \"team red\", teamB: \"Team Blue\", scoreA: 3, scoreB: 2) { id teamA teamB scoreA scoreB } }"
}
```

#### Svar:

```json
{
  "data": {
    "addMatch": {
      "id": "3",
      "teamA": "Team red",
      "teamB": "Team Blue",
      "scoreA": 3,
      "scoreB": 2
    }
  }
}
```

#### Ta bort en match:

```graphql
{
  "query": "mutation { deleteMatch(id: \"3\") }"
}


```

#### Svar:

```json
{
  "data": {
    "deleteMatch": "Match with id 3 deleted."
  }
}
```

#### Uppdatera en match:

```graphql
{
  "query": "mutation { updateMatch(id: \"1\", scoreA: 4, scoreB: 2) { id teamA teamB scoreA scoreB } }"
}



```

#### Svar:

```json
{
  "data": {
    "updateMatch": {
      "id": "1",
      "teamA": "Team Red",
      "teamB": "Team Blue",
      "scoreA": 4,
      "scoreB": 2
    }
  }
}

```

## 4. Felhantering

(Vilka typer av fel kan uppstå och hur de hanteras. Exempel på felmeddelanden och statuskoder som returneras.)

Flera fel kan uppstå eftersom användaren kan göra komplexa förfrågningar.

#### Fel i fråga:
```graphql
{
"query": "query { match { id teamA teamB scoreA scoreB } }"
}
```
Det ska vara matches istället för match om man vill anropa flera match. man får null om man skriver fel syntax.

En annan fel som kan uppstå är att om man skickar ett ogiltig arument.



## 5. Tester

(Beskriv hur GraphQL API:et har testats. Om tester är automatiserade, förklara hur de körs och vad de testar.)
För att säkerställa att GraphQL API:et fungerar korrekt och uppfyller de krav som ställs på det gjorde jag manuella tester med Postman.


## 6. Reflektion

-   Vad har varit utmanande i uppgiften?
    - Utmaningen var att konfiguera och använda GraphQL för att definera muntationer och frågor en annan tankegång än traditionella REST API:er som va förvirande.
  -   Vad skulle kunna förbättras?
      - Felhantering kan förbättras genom att implementera mer detaljerade felinformation för varje GraphDL operationer.
-   Eventuella lärdomar från implementationen.
    - Ett viktig lärdom från den här uppgiften är att GraphQL ger mycket flexibillitet genom att låta användaren definera exakt vilken data de vill hämta eller maipulera.

---

# Uppgift 5: Paketering och körning av Spring Boot-applikation

| Data            | Värde |
| --------------- | ----- |
| **Namn**        |       |
| **Email**       |       |
| **GitHub-länk** |       |

---

## 1. Beskrivning av uppgiften

(Kortfattad beskrivning av vad uppgiften innebär och dess syfte.)

## 2. Installation och körning

(Instruktioner för hur applikationen byggs och körs. Om externa verktyg krävs, beskriv hur dessa installeras och används.)

### Bygga och köra JAR-filen:

```sh
mvn clean package
java -jar target/melloomrostning-1.0.jar
```

## 3. Användning av API:et

(Beskrivning av API-endpoints och exempelanrop.)

### Exempel på endpoints:

-   **POST** /vote

    -   Beskrivning: Lägger till en röst
    -   Payload: `{ "contestant": "Artist A" }`
    -   Respons: `{ "message": "Röst registrerad" }`

-   **GET** /results
    -   Beskrivning: Hämtar aktuella röstresultat
    -   Respons: `{ "results": [{ "contestant": "Artist A", "votes": 120 }] }`

## 4. Felhantering

(Vilka typer av fel kan uppstå och hur de hanteras. Exempel på felmeddelanden och statuskoder som returneras.)

## 5. Tester

(Beskriv hur API:et har testats. Om tester är automatiserade, förklara hur de körs och vad de testar.)

## 6. Reflektion

-   Vad har varit utmanande i uppgiften?
-   Vad skulle kunna förbättras?
-   Eventuella lärdomar från implementationen.
