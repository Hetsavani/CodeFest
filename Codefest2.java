import java.util.Scanner;
//for file IO
import java.io.File;
import java.io.FileWriter;

public class Codefest2 {

	public static void main(String[] args) throws Exception{
        //File object for creating input stream with scanner class
        File file = new File("C:/Users/hetsa/OneDrive/Desktop/Code_fest/TWSP_small.txt");
        Scanner sc = new Scanner(file);
		int noOfInput;
		// System.out.print("Enter No of Input: ");
		// Scanner sc = new Scanner(System.in);
		noOfInput = sc.nextInt();
        


		WebPage[] obj = new WebPage[noOfInput]; 
		for(int i=0;i<noOfInput;i++) {
			obj[i]=new WebPage();
			obj[i].textContent = sc.nextInt();
            obj[i].image = sc.nextInt();
            obj[i].form = sc.nextInt();
		}
		for(int i=0;i<noOfInput;i++) {
			for(int j=i+1;j<noOfInput;j++) {
				WebPage.sortObj(obj[i],obj[j]);
			}
		}
		System.out.println("--OUTPUT--");

        //filewriter for writing output
        FileWriter fWriter = new FileWriter("C:/Users/hetsa/OneDrive/Desktop/Code_fest/output.txt");
		for(int i=0;i<noOfInput;i++) {
			String str = obj[i].printDetails();
            fWriter.write(str);
		}
        //ending output stream , closing fwriter object
        fWriter.close();
	}   

}
class WebPage{
	int textContent;
	int image;
	int form;
	Scanner sc = new Scanner(System.in);
	public void scanValues() {
		System.out.print("Enter number of Text Content: ");
		textContent = sc.nextInt();
		System.out.print("Enter number of Image: ");
		image = sc.nextInt();
		System.out.print("Enter number of form: ");
		form = sc.nextInt();
	}
	public static void sortObj(WebPage o1,WebPage o2) {
		if(o1.textContent>o2.textContent) {
			int temp1 = o1.textContent;
			int temp2 = o1.image;
			int temp3 = o1.form;
			o1.textContent = o2.textContent;
			o1.image = o2.image;
			o1.form = o2.form;
			o2.textContent = temp1;
			o2.image = temp2;
			o2.form = temp3;
		}
		else if(o1.textContent==o2.textContent) {
			if(o1.image<o2.image) {
				int temp1 = o1.textContent;
				int temp2 = o1.image;
				int temp3 = o1.form;
				o1.textContent = o2.textContent;
				o1.image = o2.image;
				o1.form = o2.form;
				o2.textContent = temp1;
				o2.image = temp2;
				o2.form = temp3;
			}
		}
	}
	public String printDetails() {
		System.out.println(textContent+" , "+image+" , "+form);
        String str = textContent+" , "+image+" , "+form + "\n";
        return str;
	}
}