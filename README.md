Java HyperPublic API
=============

This is a quick description of the Java API. Note that there are some issues with the SSL that are kind of solved in the
WebClientHttpsWrapper class. This is based on some solution I found on the web. The doc is in the Javadoc.

It can get data from the Places API: http://developer.hyperpublic.com/places/find-places/
and the Categories API: http://developer.hyperpublic.com/categories/all-categories/

How to build it
-------------

You should be familiar with Maven. If you aren't don't worry too much. You can build the code by typing ```mvn install```. This will run some tests too. You can run the tests again by ```mvn test```. With Maven you can import in most IDE (Eclipse, IDEA) that offer Maven support.

How to use it
-------------
Take a look at the test classes in the src/test/java folder.
PlacesIntegrationTest and CategoriesIntegrationTest are probably a good place to start.

I wrote a simple client ```com.hyperpublic.Client``` which you can use like this:

```
   PlacesServiceImpl placesService = new PlacesServiceImpl();
   Place[] places = placesService.getPlaces("37.7777", "-122.4086");
   //The places array contains the "Place" object that you can use...

```

Disclaimer
----------
The level of quality and unit testing code coverage is definitely not up to standards, but this should get you going.

Feel free to contribute. For any questions, let me know and I'll try to help.
