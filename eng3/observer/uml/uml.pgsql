         +------------------+
         |   <<interface>>  |
         |     Observer     |
         +------------------+
         | +update(news: String): void |
         +------------------+
                  ▲
                  |
      +----------------------+
      |     NewsChannel      |
      +----------------------+
      | -news: String        |
      +----------------------+
      | +update(news: String): void |
      +----------------------+

         +------------------+
         |  <<interface>>   |
         |     Subject      |
         +------------------+
         | +addObserver(o: Observer): void   |
         | +removeObserver(o: Observer): void|
         | +notifyObservers(): void          |
         +------------------+
                  ▲
                  |
         +----------------------+
         |     NewsAgency       |
         +----------------------+
         | -news: String        |
         | -observers: List<Observer> |
         +----------------------+
         | +setNews(news: String): void    |
         | +addObserver(o: Observer): void |
         | +removeObserver(o: Observer): void |
         | +notifyObservers(): void         |
         +----------------------+
