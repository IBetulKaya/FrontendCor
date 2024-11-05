
// FAKE JQuery class with method FAKE 'ajax' method
// We can prepare our code as if we have a functional backend.
// A call to $$.ajax(...);
// will look the same as the call to the real JQuery:
// $.ajax(...);
class MyJquery{

    ajax( obj){

        if( "get".toUpperCase() === obj.type.toUpperCase()){

            // Get data as a JAVASCRIPT object for this url
            var data = this.findAll( obj.url)

            // If data != null call success method and pass the data
            if(data){
                obj.success(data);
            }else{
                // call the fail function and pass a message
                obj.fail("No data available");
            }

            return;
        }

        if( "post".toUpperCase() === obj.type.toUpperCase()){
            
            // We save or update user to 'database'
            var user = JSON.parse(obj.data);

            user = this.save( obj.url, user);

            // If data != null call success method and pass the data
            if( user.id !== 0 ){
                obj.success(user);
            }else{
                // call the fail function and pass a message
                obj.fail("User not saved");
            }

            return;
        }

        if( "delete".toUpperCase() === obj.type.toUpperCase()){
            
            // We remove user from 'database'
            var id = obj.url.substring(obj.url.lastIndexOf("/") + 1);
            
            var message = this.deletById(obj.url, id);

            // If message is 'ok' call success method and pass the data
            if( message === 'ok' ){
                obj.success("User is deleted");
            }else{
                // call the fail function and pass a message
                obj.fail("User not deleted");
            }

            return;
        }
    }

    findAll(url){
        console.log('inside findAll (myjquery)' );
        // if url contains string 'users', then return users
        if(url.indexOf('user') > -1){

            var users = userRepository.findAll();
            // users a JAVASCRIPT object!!!!
            return (users);
        }
        return;
    }

    save( url, data){
        console.log('inside save (myjquery)' );
        if(url.indexOf('user') > -1){
            user = userRepository.save( data);
            return user;
        }
        return {};
    }

    deletById( url, id){
        console.log('inside deleteById (myjquery)' );
        if(url.indexOf('user') > -1){
            var message = userRepository.deleteById( id);
            return message;
        }
        return 'Not deleted!!!';
    }
}
// Create instance of FAKE JQuery
var $$ = new MyJquery();