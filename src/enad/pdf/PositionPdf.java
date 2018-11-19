/**
 * 
 */
package enad.pdf;

import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * @author Admin
 *
 */
public class PositionPdf {

	private static String FILE = "C:\\Users\\Admin\\OneDrive\\Documents\\Formation personnelle\\BIBLIOTHEQUE PERSONNELLE\\Lecture en cours\\JAVA\\pdf\\PositionPdf.pdf";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			Document document = new Document();
			PdfWriter.getInstance(document, new FileOutputStream(FILE));
			document.open();
			// right
			Paragraph paragraph = new Paragraph("This is right aligned text");
			paragraph.setAlignment(Element.ALIGN_RIGHT);
			document.add(paragraph);
			// centered
			paragraph = new Paragraph("This is centered text");
			paragraph.setAlignment(Element.ALIGN_CENTER);
			document.add(paragraph);
			// left
			paragraph = new Paragraph("This is left aligned text");
			paragraph.setAlignment(Element.ALIGN_LEFT);
			document.add(paragraph);
			// left with indentation
			paragraph = new Paragraph("This is left aligned text with indentation");
			paragraph.setAlignment(Element.ALIGN_LEFT);
			paragraph.setIndentationLeft(50);
			document.add(paragraph);

			document.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
