import com.example.demo.AbstractArt.Painting;
import com.example.demo.AbstractArt.Sculpture;

public class Test {

	public static void main(String[] args) {
		Painting paint1=new Painting("aaaaaa");
		Painting paint2=new Painting("bbbbbb");
		Painting paint3=new Painting("cccc");
		paint1.viewArt();
		paint2.viewArt();
		paint3.viewArt();
		
		Sculpture sculpture1=new Sculpture("aaa");
		Sculpture sculpture2=new Sculpture("bbbb");
		sculpture1.viewArt();
		sculpture2.viewArt();
	}

}