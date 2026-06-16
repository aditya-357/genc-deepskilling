class Logger{

    private static Logger  instance;

    private Logger(){
        System.out.println("object created ");
        
    }
    static Logger getinstance(){
        if(instance == null){
            instance = new Logger();
            return instance;
        }
        else{
            return instance;
        }
    }

    public static void main(String[] args){

    
        Logger obj = Logger.getinstance();
        
        Logger obj2 = Logger.getinstance();
        
    

        if( obj == obj2){
            System.out.println("same");
        }
        else{
            System.out.println("diff");
        }
    }


}

