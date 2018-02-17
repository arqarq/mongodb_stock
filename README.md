# Stock - projekt na zajęcia z MongoDB Java Driver
## Wprowadzenie
Niniejszy projekt modeluje bazę danych inwentarza sklepu z płytami/filmami/książkami. Używamy bazy i kolekcji o nazwie products
do przechowywania informacji na temat dostępnych produktów. Zakładamy, że będziemy przechowywali następujące informacje dla
każdego dokumentu:
1. title - tytuł produktu (każdy z produktów w naszym sklepi ma tytuł, zakładamy, że nie sprzedajemy niczego poza 
książkami/płytami/filmami)
2. type - typ produktu ("album", "movie", "book")
3. stockCount - ilość sztuk produktu na stanie
4. authors - tablica (lista) autorów dla danego produktu.

Oprócz tego każdy z produktów posiada osadzony dokument details, którego zawartość różni się w zależności od typu:
1. Dla książek dokument details zawiera pola publisher i edition oznaczające odpowiednio wydawcę i edycję książki.
2. Dla filmów dokument details zawiera pola genre z gatunkiem filmu, media z typem nośnika oraz starring z tablicą najważniejszych
aktorów występujących w filmie
2. Albumy w dokumencie details posiadają pola genre i media.

Baza tworzona przez skrypt PrefillDB posiada tekstowy indeks na pola title, authors i details.starring.

## Instrukcja obsługi
Aby korzystać z przykładowych programów z zapytaniami wykonujemy następujące czynności:
1. Edytujemy metodę connection klasy Utils zależnie od swoich potrzeb.
2. Uruchamiamy (raz!) klasę PrefillDB.
3. Powinniśmy mieć gotową bazę (zawierającą takie rekordy jak w pliku src/resouces/data.json), co możemy zweryfikować w konsoli
Mongo.

*Uwaga:* plik data.json nie zawiera poprawnie sformatowanego JSONa, natomiast każdy jego pojedynczy wiersz - już tak. Klasa
PrefillDB jest wykorzystywana do odczytania zawartości tego pliku linia po linii i wstawienia jej do bazy.

## Zadania
W poniższych zadaniach przez "program" mamy oczywiście na myśli klasę implementującą statyczną metodę main wykonującą dane
zadanie.
1. Zmodyfikować metodę displayDoc klasy Utils tak, aby wypisywała w rózny sposób książki/albumy/filmy uwzględniając informacje
specyficzne dla tych produktów.
2. Napisać program wyszukujący wszystkie produkty których jest na stanie nie mniej niż 8, ale nie więcej niż 12.
3. Napisać program wyszukujący wszystkie filmy, które posiadają w tablicy starring co najmniej dwóch aktorów.
4. Napisać program wyszukujący wszystkie produkty których nośnikiem jest CD lub DVD.
5. Napisać interaktywny program pozwalający użytkownikowi na wyszukiwanie w sklepie. Wyszukiwanie ogólne powinno się odbywać
względem tekstowego interfejsu, program powinien móc mieć również możliwość wyszukiwania zaawansowanego przez podanie wartości
do wyszukania w konkretnych polach.
