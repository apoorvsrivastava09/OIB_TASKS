import java.util.*;
public class RESERVATION_SYSTEM
{
    public static boolean seat[]=new boolean[10]; //initializing the array of seats
    
    public static void main()
    {
        Scanner in=new Scanner(System.in);
        System.out.println("WELCOME TO TRAIN RESERVATION SYSTEM");
        
        while(true)
        {
            System.out.println("\nSelect the options from below");
            System.out.println("1-: View Seat Map");
            System.out.println("2-: BOOK A SEAT");
            System.out.println("3-:CANCEL RESERVATION");
            System.out.println("4-:EXIT FROM WINDOW");
            int opt=in.nextInt();
            switch(opt)
            {
                case 1:
                    ViewSeat();
                    break;
                    case 2:
                        ReserveSeat();
                        break;
                        case 3:
                            CancelReservation();
                            break;
                            case 4:
                                System.exit(0);
                                default:
                                    System.out.println("INVALID OPTION CHECKED");
                                    break;
                                    
            }
        }
    }
    public static void ReserveSeat()
    {
        Scanner in=new Scanner(System.in);
        System.out.println("ENTER SEAT NUMBER(1-10)");
        int seatNo=in.nextInt();
        if(seatNo<1||seatNo>10)
        System.out.println("INVALID SEAT NUMBER");
        else if(seat[seatNo-1]){
        System.out.println("SORRY");
        System.out.println("SEAT UNAVAILABLE");}
        else
        {
            seat[seatNo-1]=true;
            System.out.println("YOUR SEAT HAS BEEN RESERVED");
        }
        
    }
    public static void CancelReservation()
    {
        Scanner in=new Scanner(System.in);
        System.out.println("ENTER YOUR SEAT NUMBER YOU WANT TO CANCEL");
        int seatNo=in.nextInt();
         if(seatNo<1||seatNo>10)
        System.out.println("INVALID SEAT NUMBER");
        else if(!seat[seatNo-1])
    {
        System.out.println("THIS IS AN UNRESERVED SEAT");
        
    }
    else{
      seat[seatNo-1]=false;
      System.out.println("RESEVATION HAS BEEN CANCELLED");
    }
   
    }
    
    public static void ViewSeat()
    {
        System.out.println("SEATS AVAILBLE SHOWS 0");
        System.out.println("SEATS UNAVAILABLE SHOWS X");
        System.out.println(" 1  2  3  4  5  6  7  8  9  10 ");
        for(boolean x:seat)
        {
            if(x)
            System.out.print(" X ");
            else
            System.out.print(" 0 ");
            
        }
        //System.exit(0);
    }
}
