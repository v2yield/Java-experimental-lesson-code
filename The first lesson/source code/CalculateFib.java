public class CalculateFib{
  public static void main(String args[]){
    int a = 1;
    int b = 1;
    System.out.printf("%d %d ",a,b);
    int count = 2;
    while(true){
     if(count > 21){
        break;
     }
     int tmp;
     tmp=a;
     a+=b;
     b=tmp;
     System.out.printf("%d ",a);
     count++;
    }
    System.out.println();
  }
}
