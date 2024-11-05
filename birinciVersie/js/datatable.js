var userTable;
 
function init(){
 
    console.log('inside init' );
 
    initUserTable();
}
 
function initUserTable() {
 
    console.log('inside initUserTable' );
 
    // Create columns (with titles) for datatable: id, name, address, age
    columns = [
        { "title":  "User ID",
            "data": "id" },
        { "title":  "Name",
            "data": "name" },
        { "title":  "Address",
            "data": "address" },
        { "title":  "Email",
            "data": "email" },
        { "title": "Age",
            "data": "age"},

        { "title" : "image",
            "data" :"imageurl",
            "render" : function(imageurl){
            return '<img src = '+ imageurl +' " width = 15px" > ';
                
            }
        }
        
 
        
    ];
 
    // Define new table with above columns
    userTable = $("#usertable").DataTable( {
        "order": [[ 0, "asc" ]],
        "columns": columns
    });
 
    getUserData();
 
}
 
function getUserData(){
 
    console.log('inside getUserData' );
 
    // Collection of users
    var users = `[
            {
                "id": "1",
                "name": "John Doe",
                "address": "Nieuwmarkt 34",
                "email": "john.doe@acme.org",
                "age": 34,
                "disabled": true,
                "imageurl" :"https://www.pngall.com/wp-content/uploads/10/Plus-Symbol-Vector-PNG-Cutout.png"

            },
            {
                "id": "2",
                "name": "Jane Doe",
                "address": "Nieuwmarkt 34",
                "email": "jane.doe@acme.org",
                "age": 31,
                "disabled": false,
                "imageurl" :"https://www.pngall.com/wp-content/uploads/10/Plus-Symbol-Vector-PNG-Cutout.png"
            },
            {
                "id": "3",
                "name": "Baby Doe",
                "address": "Nieuwmarkt 34",
                "email": "baby.doe@acme.org",
                "age": 1,
                "disabled": false,
                "imageurl" :"https://www.pngall.com/wp-content/uploads/10/Plus-Symbol-Vector-PNG-Cutout.png"
            }
        ]
    `;
 
    userTable.clear();
    userTable.rows.add(JSON.parse(users));
    userTable.columns.adjust().draw();
 
}