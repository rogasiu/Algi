import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Kol {

	public static void main(String[] args) {
		
		Queue<String> kolejka = new LinkedList<>(); 
		
		kolejka.add("1");
		kolejka.add("2");
		kolejka.add("3");
		
		System.out.println("Wyœwietlenie elementu: "+kolejka.peek());
		System.out.println("Wyœwietlenie i usuniêcie elementu z kolejkai: "+kolejka.remove());
		System.out.println("Wyœwietlenie i usuniêcie kolejnego elementu z kolejki: "+kolejka.remove());
		System.out.println("Wyœwietlenie ostatniego elementu: "+kolejka.peek());
		
		Comparator<String> komparator = new Comparator<String>() {
			@Override
			public int compare(String arg0, String arg1) {
				return arg0.length()-arg1.length();
			}
		};	
		
		Queue<String> kolejkaPrio = new PriorityQueue<String>(komparator);
		
		kolejkaPrio.add("Micha³");
		kolejkaPrio.add("Weronika");
		kolejkaPrio.add("Adam");
		kolejkaPrio.add("Rados³aw");
		kolejkaPrio.add("Mi³osz");
		
		while (!kolejkaPrio.isEmpty()) {
            System.out.println(kolejkaPrio.remove());
        }

	}

}
