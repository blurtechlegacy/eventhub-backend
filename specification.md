# Eventhub
**Objective**: Provide a convenient platform for finding entertainment with different people.  
**Solution**: Create a platform where everyone can create an event and subscribe to other.  

The product can be technically divided into 3 parts: an android application, a web application, a server (backend).  

## Functional Description  
The main functions are divided into several categories:  
**P0** - required in the basic version  
**P1** - ready to implement features  
**P2** - the function is planned, but it is not clear in what form  
**P3** - offer or idea for the future  

## Server (backend)  
**P0:**  
1. Authentification with login and password.  
    1. Comparison of the login password set with the existing data.
    2. If the account is not found, return a message about the need to register.  
2. Return `tags` table  
    1. *GET* `/api/v000/tags`
    ```json5
    [
        {
            "id":1, // Primary key
            "name":"forest", // tag name
            "event_count": 12 // how many events used this tag. DEFAULT IS ZERO, FUCK!!!
        }
    ]
    ```
3. Return `events` table
    1. *GET* `/api/v000/events/{id}`
    ```json5
    [
        {
            "id":1, // Primary key
            "host": 1, // id from table `users`
            "name": "Party in the forest", // Event name
            "description": "Party in the forest with guitar music 🎸, campfire 🔥. We might be spending the night in tents ⛺." // Event description
            "place": "54.8437876,83.0718511", // Geo coordinates
            "tags": [1,5,2], // ids from table `tags`
            "guests": [1,4,2,6], // ids from table `users`
            "start": "2018-07-03 19:00:00", // Datetime format YYYY-MM-DD HH:MM:SS of event start
            "end": "2018-07-04 12:00:00" // Datetime format YYYY-MM-DD HH:MM:SS of event end
        }
    ]
    ```
    2. *GET* `/api/v000/events/`  
    Return all rows from table `events`

4. Convert `id` primary key from *Int* to *Char*. Separate data and status label.
5. Add new event to `events` table.
    1. *POST* `/api/v000/events/create?host=1&name=Party+in+the+forest&description=blah+blah&place=54.8437876,83.0718511&tags=1,5,2&start=blah&end=blah`  
    Or *POST* `/api/v000/events/create` with JSON body:
    ```json5
    [
        {
            "host": 1, // id from table `users`
            "name": "Party in the forest", // Event name
            "description": "Party in the forest with guitar music 🎸, campfire 🔥. We might be spending the night in tents ⛺." // Event description
            "place": "54.8437876,83.0718511", // Geo coordinates
            "tags": [1,5,2], // ids from table `tags`
            "start": "2018-07-03 19:00:00", // Datetime format YYYY-MM-DD HH:MM:SS of event start
            "end": "2018-07-04 12:00:00" // Datetime format YYYY-MM-DD HH:MM:SS of event end
        }
    ]
    ```
    2. Increase `event_count` in `tags` table by "tags" ids used in *POST* method.
6. Return personal data to the account  
   1. *GET* `/api/v000/users/{id}`  
   ```json5
    [
        {
            "id":1, // Primary key
            "login":"MacOSO",
            "password":"8e9db293fc276e414522e0e0994cfe4e", // bcrypt hash with salt
            "name":"Alexandr",
            "birthday":"1999-10-26", // Date format YYYY-MM-DD
            "sex":"1" // 0 - female (without sexism), 1 - male, NULL - I DON`T KNOW, BITCH
        }
    ]
   ```
   2. *GET* `/api/v000/users/`  
    Return all rows from table `users`
