
# VIDEOPROJEKT

### Indholdsfortegnelse:

#####  - Links

   - Video 1
   - Video 2
   - Video 3
 
#####  - Ordliste

   - Annoteringer
   - Andre ord


### **Links**

- Link til Ressourcer:          https://github.com/JannickHansen/VideoProjektVideo1
- Link til færdige projekt:     https://github.com/JannickHansen/VideoprojektMain

##### Video 1
-   Video link:                 https://youtu.be/_SEtJOwCbM8

##### Video 2
-   Video link:                 https://youtu.be/llU4Pq2z2as

##### Video 3
-   Video link:                  
-   Link til SQL Script:                 

##### Video 4

### **Annoteringer**

**@GetMapping**
-   Håndterer HTTP GET-anmodninger.
    Bruges til at hente data uden at ændre servertilstanden.

**@PostMapping**
-   Håndterer HTTP POST-anmodninger.
    Bruges til at sende data til serveren, typisk til oprettelse af ressourcer.

**@Autowired:**
-   Tilfører afhængigheder automatisk.
    Vi bruger denne på konstruktøren, og derigennem får adgang til klassen.

**@Controller**
-   Definerer en webcontroller i MVC.
    Den håndterer HTTP-requests.

**@Repository**
-   Håndterer dataadgang og exception-håndtering af databaseoperationer.

**@Service**
-   Bruges til at udfører tjenestemetoder, beregningsmetoder og andre hjælpemetoder.

**@Component**
-   Marker en generisk komponent, der skal administreres af Spring.
    Bruges, når klassen ikke passer ind i andre specifikke annoteringer.

**@Entity**
-   Markerer en klasse som en JPA entity (Database tabel)

**@Table**
-   Specificerer database-tabellen, som en entity skal kortlægges til.

##### **Andre ord**

**Interface**
-   Et interface er en opskrift, som beskriver hvilke funktioner og metoder en klasse skal have.
    Det indeholder dog ikke selv nogen kode eller data.
    Når du bruger interfacet i Spring, anvender Spring automatisk en skjult klasse, som indeholder koden og attributterne.
    Interfacet selv indeholder kun metodernes navne og parametre.

**Endpoint**
-   Et specifikt URL, hvor en applikation kan modtage HTTP-anmodninger og returnere svar.
    De defineres typisk i en controller-klasse ved hjælp af annoteringer som @GetMapping, @PostMapping og lignende.





















VIDEOPROJEKT
VIDEO 1

1. Opret Projekt + dependencies
2. Lav folder struktur (MVC)
3. Opret model "Car"
4. Opret forside + controller
5. InitData + thymeleaf

VORES BIL MODEL

- brand
- modelår
- type
- farve
- nummerplade
- billede

VORES FORSIDE

- index.html
- visning af vores biler


NOTE:

Noget html, css, billeder og initData er lavet på forhånd. Dette kan altsammen findes på github-linket.



VIDEOPROJEKT
VIDEO 2


CRUD

1. Read
2. Delete
3. Create
4. Update

NOTE:
Denne video tager udgangspunkt i Video 1.
Noget html, css, billeder og initData er lavet på forhånd. Dette kan altsammen findes på github-linket.





I forhold til strukturen af videoerne, gik det op for mig da jeg arbejdede med det, at det hele hænger lidt sammen. Men evt. ville det være noget i stil af:

1. opret projekt, lav folder struktur, opret forside controller + config data til at lave et bil objekt (evt. også thymeleaf her til at vise objektet på index.html)

2. tilkobling af database + repository metode til getAllCars og koble den til index.html

3. CRUD med database + html sider som tilhører (da jeg gennemgår thymeleaf i index, kopiere jeg bare disse sider ind og forklare dem i stedet, da de virker på samme måde ift. html)

(note: jeg overvejer at opdele CRUD i 2, da det jo både er html, controller, repository, lidt service, og det er meget til 1 video)


Hvis du gerne vil have det, kan jeg i stedet for denne opdeling, lave CRUD som video 2, bruge den stud vi laver i del 1, og så det vil se således ud:

1. opret projekt ...

2. CRUD (med stud) ...

3. tilkobling af database ...

4. CRUD (med database) ...