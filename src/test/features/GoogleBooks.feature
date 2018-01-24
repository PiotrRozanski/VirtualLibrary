Feature: Pobieranie szczegółowych informacji o książkach elektronicznych z Google Books API

    Scenario Outline: Pobranie szczegółowych informacji o posiadanych książkach elektroniczncych
        Given Użytkownik posiada następujące książki:
            | title   | <TITLE>   |
            | authors | <AUTHORS> |

        When Użytkownik pobierze szegółowe informacje o posiadanych książkach
        Then Otrzyma następujące informacje:
            | title         | <TITLE>          |
            | authors       | <AUTHORS>        |
            | publishedDate | <PUBLISHED_DATE> |
            | pageCount     | <PAGE_COUNT>     |

        Examples:
            | TITLE                             | AUTHORS          | PUBLISHED_DATE | PAGE_COUNT |
            | Spring Microservices in Action    | John Carnell     | 2017-07        | 384        |
            | Core Java for the Impatient       | Cay S. Horstmann | 2015-01-30     | 512        |
            | Mastering Microservices with Java | Sourabh Sharma   | 2016-06-29     | 258        |
