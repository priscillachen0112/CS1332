public class StringOperations {

    //TODO: Start your code after this line
    public static void main(String[] args){
        String my_name = new String("Minzhe Chen");
        System.out.println(my_name);
        String new_name = 'A' + my_name.substring(1,11);
        new_name = new_name.substring(0,10) + 'Z';
        System.out.println(new_name);
        String web_address = new String("www.gatech.edu");
        System.out.println(web_address);
        String new_string = web_address.substring(web_address.indexOf(".") + 1);
        new_string = new_string.substring(0, new_string.indexOf(".")) + "1331";
        System.out.println(new_string);
    }
}
