var valid = validEmail('asdad@asdad');
console.log(valid);

function init(){

    



    // In the init function we do a GET request to a backend to get User Information.
    // I.e: http://localhost:8080/user?id=1
    // The backend sends the information in the form of a json string
    // json received from backend
    var json = `{
        "users": [
            {
                "id": "1",
                "name": "John Doe",
                "address": "Nieuwmarkt 34",
                "email": "john.doe@acme.org",
                "age": 34
            },
            {
                "id": "2",
                "name": "Jane Doe",
                "address": "Nieuwmarkt 34",
                "email": "jane.doe@acme.org",
                "age": 31
            },
            {
                "id": "3",
                "name": "Baby Doe",
                "address": "Nieuwmarkt 34",
                "email": "baby.doe@acme.org",
                "age": 1
            }
        ]
    }`;

    // We transform the json to a Javascript object
    var object = JSON.parse(json);

    console.log(object);

    // We get a reference to the input element with id="id"
    var elem = document.getElementById("id");

    // We set the value of the 'name' element to the value of the name in the object
    elem.value = object.users[1].id;

    // The same with 'name'
    elem = document.getElementById("name");
    elem.value = object.users[1].name;

    // The same with 'address'
    elem = document.getElementById("address");
    elem.value = object.users[1].address;

    // The same with 'email'
    elem = document.getElementById("email");
    elem.value = object.users[1].email;

    // The same with age
    elem = document.getElementById("age");
    elem.value = object.users[1].age;


}

function send(){

    var email = document.getElementById("email").value;

    if( ! validEmail(email)){
        alert('Email not valid: ' + email);
    }

    var object = {
        id: document.getElementById("id").value,
        name: document.getElementById("name").value,
        address: document.getElementById("address").value,
        email: document.getElementById("email").value,
        age: document.getElementById("age").value

    }

    var json = JSON.stringify(object);
    console.log(json);

// Send the json to the backend

}

function validEmail( email){
    return email.indexOf('@') > -1;
}


