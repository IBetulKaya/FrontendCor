var users = `[
    {
        "id": "1",
        "name": "John Doe",
        "address": "Nieuwmarkt 34",
        "email": "john.doe@acme.org",
        "age": 34,
        "disabled": true,
        "imageurl": "https://www.pngall.com/wp-content/uploads/10/Plus-Symbol-Vector-PNG-Cutout.png"
    },
    {
        "id": "2",
        "name": "Jane Doe",
        "address": "Nieuwmarkt 34",
        "email": "jane.doe@acme.org",
        "age": 31,
        "disabled": false,
        "imageurl": "https://www.pngall.com/wp-content/uploads/10/Plus-Symbol-Vector-PNG-Cutout.png"
    },
    {
        "id": "3",
        "name": "Baby Doe",
        "address": "Nieuwmarkt 34",
        "email": "baby.doe@acme.org",
        "age": 1,
        "disabled": false,
        "imageurl": "https://www.pngall.com/wp-content/uploads/10/Plus-Symbol-Vector-PNG-Cutout.png"
    },
    {
        "id": "4",
        "name": "Granny Doe",
        "address": "Nieuwmarkt 34",
        "email": "granny.doe@acme.org",
        "age": 71,
        "disabled": false,
        "imageurl": "https://www.pngall.com/wp-content/uploads/10/Plus-Symbol-Vector-PNG-Cutout.png"
    }
]
`;
function reset(){
    localStorage.setItem('users', users);
    localStorage.setItem("user.id", '4');
    getUserData();
}

class UserRepository{

    UserRepository(){
        // Storing a string in Local Storage
        if(localStorage.getItem('users') == undefined){
            alert('Persisting users ');
            localStorage.setItem('users', users);
            localStorage.setItem("user.id", '4');
        }
    }

    findAll(){
        console.log('inside findAll (user-repository)' );
        return JSON.parse(localStorage.getItem("users"));
    }

    save( user){
        console.log('inside save (user-repository)' );
        // get user from 'database'
        var users = JSON.parse(localStorage.getItem("users"));

        if( user.id === '0'){
            // create user
            var id = (parseInt( localStorage.getItem("user.id")) + 1).toString();
            user.id = id;
            localStorage.setItem("user.id", id);
            users.push( user);
        }else{
            // Update user
            var u = { id: user.id,
                      name: user.name,
                      address: user.address,
                      email: user.email,
                      age: user.age,
                      disabled: user.disabled,
                      imageurl: user.imageurl
                    }
            console.log( u);
            users = users.filter( user => user.id !==u.id);
            users.push( u);
        }

        // update user database
        localStorage.setItem("users", JSON.stringify(users));
        return user;
    }

    deleteById( id){
        console.log('inside deleteById (user-repository)' );
        var users = JSON.parse(localStorage.getItem("users"));
        users = users.filter( user => user.id !==id);
        localStorage.setItem("users", JSON.stringify(users));
        return 'ok';
    }
}

// create instance of class
var userRepository = new UserRepository();
