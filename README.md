## Calendarific Java Library 

This library uses the following :
* The public Calendarific API with documentation in this url : https://calendarific.com/api-documentation . 

* GSON - A Java library that can be used to convert Java Objects into their JSON representation. It can also be used to convert a JSON string to an equivalent Java object.
https://github.com/google/gson

* Reactive programming - The use of ```Observable<T>```
* Asynchronous Programming - The use of ```CompletableFuture<T>``` to control Asynchronous Requests.
  
* The use of the _AsyncHttpClient_ Library which gives us the possibility to 
  do Asynchronous Http Requests.

### How to use the Calendarific Java Library

You must create an instance of ```CalendarificService``` using the following constructor : 

```java
    public CalendarificService();
```



### The Calendarific Java Library provides a single method 

```java
    public Observable<Holiday> getHolidays(String country, String year);
    
    /*This method returns a Sequence of Holidays in the form of and Observable with the holiday information of the country and year.
    */


```