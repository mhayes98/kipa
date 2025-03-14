# **Database Schema**

___

### Users

Table that contains all current users of Kipa with the following fields:
* id : _bigint_
* email : _char var (50)_
* password : _char var (255)_
* username : _char var (25)_

**ID** is an automatically generated, unique value that acts as the primary key for this table.

**Email** is provided by the user, cannot be null, is verified to be unique, must be between 6-50 characters long, and must contain a "@".

**Password** is provided by the user, cannot be null, and must be between 10-25 characters long. Passwords will be hashed by a 12 strength BCrypt encoder before being stored in the database. Password hashing is a critical security feature, and raw passwords will **NEVER** be stored in the database.

**Username** is provided by the user, cannot be null, is verified to be unique (case-insensitive), and must be between 2-25 characters long.

___

### Albums

Table that contains all Albums currently marked as "Owned" or "Wanted" by at least one user.

* albumid : _char var (255)_
* artist : _char var (255)_
* title : _char var (255)_
* tracklist : _char var (255)_
* year : _integer_

**AlbumID** acts as the primary key for this table.

All fields in this table are pulled from Spotify's / Discog's public API.

UPDATE THIS SECTION AS NEEDED

___

### User_Albums

Table that contains the relationship between User's and Album's. When a User marks an Album as "Owned" or "Wanted", a UserAlbum object is created to store that relationship, then input into this table.
* albumid : _var char (255)_
* userid : _var char (255)_
* notes : _var char (255)_
* status : _var char (255)_
* tags : _var char (255)_

**AlbumID** and **UserID** are each half of a composite key.

**Notes** and **Tags** are input by the user, and may be blank.

UPDATE THIS SECTION AS NEEDED