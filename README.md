# userservice

The userservise application has 2 services.
1.  userRegistration API is a HTTP REST API (POST) 
2.  getUserDetails API is a HTTP REST API (GET)

Details Of service below

1.	userRegistration API is a HTTP REST API (POST) 
		userRegistration API is will allow to registered the adult French residents  to create an account.
URL : http://localhost:9024/userRegistration
Request Body with attributes
{
  "userName": "JohnSmith",  
  "birthdate": "2001-09-28",  
  "residenceCountry": "French",
	"phoneNumber": "1234567550",
	"gender": "male"
}

Response samples
{
    "Success": "Registration successful done"
}

2.	getUserDetails API is a HTTP REST API (GET) 
		getUserDetails API used to get the details of registered user.
	
	URL : http://localhost:9024/getUserDetails
  Response samples
[
    {
        "userName": " JohnSmith ",
        "residenceCountry": "French",
        "birthdate": "2001-09-28T00:00:00.000+00:00",
        "phoneNumber": "1234567550",
        "gender": "male"
    }
]
