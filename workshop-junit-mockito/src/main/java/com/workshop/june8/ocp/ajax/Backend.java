

public class Backend {

    public static int endpointReturnStatus( String url) {
        if( url.contains("user")){
            return 500;
        }else{
            return 200;
        }
    }
}
