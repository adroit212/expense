Technologies used
1. Spring boot 3.2.3
2. JDK 21
3. PostgreSQL 16.2

Endpoints: 

1. Get a list of saved expenses = localhost:8080/expense/U2
  Note: "U2" is a pathvariable. It accepts USERID of the user trying to get expense list.

2. User create and save a new expense = localhost:8080/expense
  Note: Accepts RequestBode with the following structure:
    {
    "expenseDate":"2023-02-23",
    "expenseReason":"To test code",
    "expenseValue":"35000000",
    "userId":"U2"
    }

   All fields in the request body are required except for "expenseReason" which is an optional field.

Important Key Notes.
1. In order to be able to run this application, you need to have the database created. Tables will be created automatically.
2. Default port is 8080, this can be changed in the application's "application.property" file.
3. Database credentials (username, password and connection URL which has the database name at the end) should be changed from the "application.property" file to suit your postgreSQL database credentials on your local machine.
4. Please take note of the database name, which must exist in your local database server.
5. Test are made available on controller level and can be executed.

Thank you!
