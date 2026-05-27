public class punto8 {
    public static int pIter(int x, int n){
        int p;
        if (n == 0)
            p = 1;
        else {
            if (n == 1)
                p = x;
            else{
                p = x;
                for (int i = 2 ; i <= n ; i++) {
                    p *= x ;
                }
            }
        }
        return p;
    }
    public static int pRec( int x, int n){
        if( n == 0 )
            return 1;
        else{
            if( n == 1)
                return x;
            else{
                if ( (n % 2 ) == 0)
                    return pRec (x * x, n / 2 );
                else
                    return pRec (x * x, n / 2) * x;
            }
        }
    }
    public static void main(String[] args) {
        System.out.println("Iterativo: " + pIter(3,3));
        System.out.println("Recurisvo: " + pRec(3, 3));
    }
}
