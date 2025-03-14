# **API Endpoints**

---


`@POST /register`


Creates and stores a User with a username, password, and email.

    {
        "username": "username",
        "password": "password",
        "email": "email@email.com"
    }

**Username** is validated to ensure the field is not null, is between 2-25 characters long, and is not already in use.
**Password** is validated to ensure it is not null, and is between 10-25 characters long.
**Email** is validated to ensure it is not null, and contains an "@".

If all checks pass, the provided password is encrypted using 12 strength BCrypt, and the User object is stored in the database.

___

`@POST /login`

Authenticates User credentials (username and password), approving or denying based off database matching.

    {
        "username": "username",
        "password": "password",
    }

If the login request is approved, a JWT token is returned. Ex...

    eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiYWRtaW4iOnRydWUsImlhdCI6MTUxNjIzOTAyMn0.KMUFsIDTnFmyG3nMiGM6H9FNFUROf3wh7SmqJp-QV30

This token will act as an alternative authentication method, in place of username/password, and is set to expire after **[UPDATE THIS AFTER JWT LIFESPAN IS FINALIZED].**

Further documentation about the authentication process is available in `/docs/authentication-workflow`

___

`@POST /album`

Creates and stores an Album with ID, title, artist name, release year, and tracklist.

    {
        "albumID": "123",
        "title": "Album Name",
        "artist": "Artist Name",
        "year": 2925,
        "tracklist": "SongOne, SongTwo, SongThree"
    }

**UPDATE THIS IF NECESSARY - TRACKLIST FORMAT (CSV, List, etc..) MAY BE CHANGED**

___

`@DELETE /album`

Removes an Album from the database,

**THIS IS NOT CURRENTLY IN USE - REMOVE ENTIRELY IF NO USE IS FOUND - OTHERWISE UPDATE THIS** 

___

`@POST /user-album`

Creates and stores a UserAlbum with a composite key consisting of a username & album ID, status, tags, and notes.

    {
        "id": {
            "userID": "username",
            "albumID": "123"
        },
        "status": "Owned",
        "tags": ["Signed", "Mint"],
        "notes": "Best album ever!!!"
    }

"Tags" and "Notes" are optional fields.

UserAlbum objects represent the relation between Users and Albums. Anytime a User marks an Album as "Owned" or "Want" this endpoint is called. 

___

`@POST /status`

Updates the "status" field of a UserAlbum.

    {
        "userID": "username",
        "albumID": "123",
        "status": "Want"
    }

If the received status field is empty, then the UserObject will be removed from the database instead.
Additionally, `removeAlbumIfNoUsers` will be called , which will remove the Album itself from the database _if_ no other User has marked it as owned or wanted. 

___
        
`@PUT /tag`

Updates the "tags" field of a UserAlbum.

    {
        "userID": "username",
        "albumID": "123",
        "tags": ["Signed", "CD"] 
    }

___

`@PUT /notes`

Updates the "notes" field of a UserAlbum.


    {
        "userID": "username",
        "albumID": "123",
        "notes": "Second best album ever!!!"
    }

