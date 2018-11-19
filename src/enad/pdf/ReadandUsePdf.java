/**
 * 
 */
package enad.pdf;

import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * @author Admin
 *
 */
public class ReadandUsePdf {

	private static String INPUTFILE = "C:\\Users\\Admin\\OneDrive\\Documents\\Formation personnelle\\BIBLIOTHEQUE PERSONNELLE\\Lecture en cours\\JAVA\\pdf\\FirstPdf.pdf";
	private static String OUTPUTFILE = "C:\\Users\\Admin\\OneDrive\\Documents\\Formation personnelle\\BIBLIOTHEQUE PERSONNELLE\\Lecture en cours\\JAVA\\pdf\\ReadPdf.pdf";

	/**
	 * @param args
	 */
	public static void main(String[] args) throws DocumentException, IOException {
		// TODO Auto-generated method stub

		Document document = new Document();
		PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(OUTPUTFILE));
		document.open();
		PdfReader reader = new PdfReader(INPUTFILE);
		int n = reader.getNumberOfPages();
		PdfImportedPage page;
		// Go through all pages
		for (int i = 1; i <= n; i++) {
			// Only page 2 will be included
			if (i == 2) {
				page = writer.getImportedPage(reader, i);
				Image instance = Image.getInstance(page);
				document.add(instance);
			}
		}

		document.close();

	}

}
