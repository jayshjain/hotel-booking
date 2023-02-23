# hotel-booking
This is Spring boot project build using Gradle-groovy and Java 19. The objective of the project is to allow room allotments in a banquet hotel with mainting the room life cycle, i.e. available->occupied->vacant->available or available->occupied->vacant->repair->available. 


Steps to launch the application: 
1. Import the gradle project in the IDE. 
2. Perform Gradle refresh, gradle clean and gradle build on the project. 
3. The start file is: hotel-booking\hotel\src\main\java\com\booking\room\HotelApplication.java. Run the start file and the application server would start at post 9096. 
4. Once the server is started, following API can be test:
      
| HTTP METHOD | API endpoint                                                | Description                                                               |
| ----------- | ----------------------------------------------------------  |-------------------------------------------------------------------------- |
| GET         | http://localhost:9096/hotel/floors                          | This API returns the total number of floors in the hotel.                 |
| GET         | http://localhost:9096/hotel/roomsPerFloor                   | This API returns the total number of rooms per floor in the hotel.        |
| GET         | http://localhost:9096/bookings/rooms                        | This API returns the list of all the available rooms in order of their proximity from the entrance gate, i.e ground floor.    |
| POST        | http://localhost:9096/bookings/book                         | This API books the next available room from the proximity to the entrance.| 
| POST        | http://localhost:9096/bookings/checkout/{roomNumber}        | This API is used to checkout the user from the room.                      |
| POST        | http://localhost:9096/bookings/makeRoom/{roomNumber}        | This API is used to make the room after checkout.                         |
| POST        | http://localhost:9096/bookings/makeForRepair/{roomNumber}   | This API is used to make the room for repair after the checkout.          |
| POST        | http://localhost:9096/bookings/repairRoom/{roomNumber}      | This API is used to repair the room if its marked for repair.             |
