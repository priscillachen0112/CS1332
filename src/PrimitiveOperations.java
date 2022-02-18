public class PrimitiveOperations {

    //TODO: Start your code after this line
    public static void main(String[] args){
        int my_int = 3;
        double my_double = 9.0;
        System.out.println(my_int);
        System.out.println(my_double);
        double new_var = my_int * my_double;
        System.out.println(new_var);
        double new_int = (double)my_int;
        System.out.println(new_int);
        int new_float = (int)my_double;
        System.out.println(new_float);
        char my_char = 'A';
        System.out.println(my_char);
        int small_char = (int)my_char + 32;
        char result_char = (char)small_char;
        System.out.println(result_char);
    }
}