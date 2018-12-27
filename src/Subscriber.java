import java.math.BigInteger;
import java.util.Scanner;

class Subscriber {
    private String name;
    private static int A;
    private static int P;
    private int x;
    private BigInteger Y;
    private BigInteger Key;

    Subscriber(String name){
        this.name = name;
    }

    private void setA(int num) throws Exception{
        if(num>1&&num<P-1) {
            A = num;
        }
        else {
            throw new Exception("A > P-1 или А < 1!!!");
        }
    }

    private void setP(int p){
        P = p;
    }

    private void setX(int X) throws Exception{
        if(X<P) {
            this.x = X;
        }
        else {
            throw new Exception("X больше или равен P!!!");
        }
    }

    private int getX(){
        return this.x;
    }

    private void copmuteY(){
        this.Y = BigInteger.valueOf(A).modPow(BigInteger.valueOf(this.getX()),BigInteger.valueOf(P));
    }

    private BigInteger getY() {
        return this.Y;
    }

    private void computeKey(BigInteger y){
        this.Key = y.modPow(BigInteger.valueOf(this.getX()),BigInteger.valueOf(P));
    }
    private BigInteger getKey(){
        return this.Key;
    }

    void Diffie(Subscriber subscriber){
        try {
            Scanner scan = new Scanner(System.in);
            System.out.println("Введите P: ");
            setP(scan.nextInt());
            System.out.println("P = " + P);
            System.out.println("Введите А: ");
            setA(scan.nextInt());
            System.out.println("A = " + A);
            this.setX((int)(Math.random()*(P-1)));//(int)(Math.random()*(P-1))
            subscriber.setX((int)(Math.random()*(P-1)));
            this.copmuteY();
            System.out.println(this.name+" Y = " + this.getY());
            subscriber.copmuteY();
            System.out.println(subscriber.name+" Y = " + subscriber.getY());
            this.computeKey(subscriber.getY());
            subscriber.computeKey(this.getY());
            System.out.println(subscriber.name + " : " + subscriber.getKey() + " - " + this.name + " : " + this.getKey());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
